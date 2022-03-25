package com.company.example.ch04_thread.return_thread2_polling;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ReturnDigest extends Thread{
    private String pwd;
    private byte[] digest;

    public ReturnDigest(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public void run() {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(pwd.getBytes());
            digest = md.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public byte[] getDigest() {
        return digest;
    }
}