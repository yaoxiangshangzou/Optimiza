package com.coroutine.bod.optimiza;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

public class Aes {


    void encode(String context,String password) throws NoSuchAlgorithmException {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        //用户的密码作为随机数
        kgen.init(128,new SecureRandom(password.getBytes()));


    }
}
