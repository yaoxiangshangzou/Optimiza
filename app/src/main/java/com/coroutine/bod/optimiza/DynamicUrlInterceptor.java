package com.coroutine.bod.optimiza;

import java.io.IOException;
import java.util.List;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class DynamicUrlInterceptor implements Interceptor {

    private
    static final String BASE_URL_USER = "https://www.222.com";

    private
    static final String BASE_URL_DYNAMIC = "https://api.douban.com/";

    private static final String DOMAIN_NAME = "dynamic-url";

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder builder = request.newBuilder();
        List<String> headerList = request.headers(DOMAIN_NAME);
        if (headerList != null && headerList.size() > 0) {
            //这里仅仅是从头中进行了移除
            builder.removeHeader(DOMAIN_NAME);

            String headerValue = headerList.get(0);
            HttpUrl newBaseUrl = null;
            //动态的url
            if (headerValue.equals("test")) {
                //替换
                newBaseUrl = HttpUrl.parse(BASE_URL_DYNAMIC);
            } else {
                //使用原来的
                newBaseUrl = HttpUrl.parse(BASE_URL_USER);
            }

            //这里获取解析之后的结果
            //比如 Http://localhost:8080/hello
            //protocal 就是http
            //主机就是localhost
            //端口号就是8080

            HttpUrl oldHttpurl = request.url();
            assert newBaseUrl != null;
            //获取新的Http请求完整的路径之后，覆盖原来请求的 scheme,host,port
            //http默认端口80 https端口 443
            String scheme = newBaseUrl.scheme();
            String host = newBaseUrl.host();
            int port = newBaseUrl.port();

            HttpUrl newFullUrl = oldHttpurl
                    .newBuilder()
                    .scheme(scheme)
                    .host(host)
                    .port(port)
                    .build();

            return chain.proceed(builder.url(newFullUrl).build());
        }
        //如果没有匹配到，就按照正常的逻辑走
        return chain.proceed(request);
    }
}
