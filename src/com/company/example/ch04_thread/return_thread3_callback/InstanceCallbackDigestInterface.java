package com.company.example.ch04_thread.return_thread3_callback;

public class InstanceCallbackDigestInterface {
    private String pwd;
    private byte[] digest;

    public InstanceCallbackDigestInterface(String pwd) {
        this.pwd = pwd;
    }

    public void calculateDigest() {
        InstanceCallbackDigest cb = new InstanceCallbackDigest(pwd, this);
        Thread t = new Thread(cb);
        t.start();
    }

    public void receiveDigest(byte[] digest) {
        this.digest = digest;
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < digest.length; i++) {
            result.append(Integer.toHexString(0xff & digest[i]));
        }
        System.out.println(this + ": " + result.toString());
    }

    public static void main(String[] args) {
        for (int i=0; i<10; i++) {
            InstanceCallbackDigestInterface cdi = new InstanceCallbackDigestInterface("password");
            cdi.calculateDigest();
        }
    }
}
