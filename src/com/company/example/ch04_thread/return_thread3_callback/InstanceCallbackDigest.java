package com.company.example.ch04_thread.return_thread3_callback;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class InstanceCallbackDigest implements Runnable{
    private String pwd;
    private InstanceCallbackDigestInterface callback;
    public InstanceCallbackDigest(String pwd, InstanceCallbackDigestInterface callback) {
        this.pwd = pwd;
        this.callback = callback;
    }

    @Override
    public void run() {
        try {
            MessageDigest sha = MessageDigest.getInstance("SHA-256");
            byte[] digest = sha.digest();
            callback.receiveDigest(digest);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
