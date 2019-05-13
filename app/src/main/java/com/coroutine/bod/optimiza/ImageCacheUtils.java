//package com.coroutine.bod.optimiza;
//
//import android.graphics.Bitmap;
//import android.util.LruCache;
//
//import java.io.IOException;
//import java.security.PublicKey;
//
//import okhttp3.internal.cache.DiskLruCache;
//
///**
// * 复用池
// * 可以理解成为四级缓存
// * 内存->放不下的时候放入到复用池->磁盘缓存->网络
// */
//public class ImageCacheUtils {
//
//
//    LruCache<String, Bitmap> mLruCache;
//
//    /**
//     * 压缩并且存入到缓存中
//     *
//     * @param key
//     * @param bitmap
//     */
//    public void put(String key, Bitmap bitmap) {
//        //从磁盘缓存中获取数据
//        DiskLruCache diskLruCache = DiskLruCache.create();
//
//        DiskLruCache.Snapshot diskSnapShot = new DiskLruCache().Snapshot;
//        try {
//            DiskLruCache.Editor edit = diskLruCache.edit(key);
//            //如果从来没有使用过，就压缩这个文件,然后放置到磁盘缓存中
//            //通过二进制的流进行放入
//            bitmap.compress(Bitmap.CompressFormat.JPEG, 50, null);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    public Bitmap getBitmapFromDisk(String key, Bitmap resource) {
//
//        DiskLruCache.Snapshot snapshot = null;
//
//
//    }
//
//
//}
