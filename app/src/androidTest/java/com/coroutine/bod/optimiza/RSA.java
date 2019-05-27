package com.coroutine.bod.optimiza;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;

public class RSA {


    private static final String PUBLICK_KEY_FILE = "PUBLIC_KEY_FILE";
    //指定key的位数
    public static int KEYSIZE = 1024;

    //公钥存放的文件

    public static String ALGORITHM = "ALGORITHM";

    static void generatekeyPair() throws NoSuchAlgorithmException {
        //生成钥对
        SecureRandom secureRandom = new SecureRandom();
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(ALGORITHM);
        keyPairGenerator.initialize(KEYSIZE, secureRandom);


        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PrivateKey priKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();


    }


    //加密

    public static String encrypt(String source) throws NoSuchAlgorithmException, FileNotFoundException, ClassNotFoundException {
        generatekeyPair();
        //取出公钥
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(PUBLICK_KEY_FILE));
            Key key = (Key) objectInputStream.readObject();

            //base64的 encode 得到编码以后的结果
            //拿到公钥之后 对这些信息的解密过程


        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }


}
