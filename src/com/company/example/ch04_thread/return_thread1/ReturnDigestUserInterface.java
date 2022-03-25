package com.company.example.ch04_thread.return_thread1;

public class ReturnDigestUserInterface {
    public static void main(String[] args) {
        for (int i=0; i<10; i++) {
            ReturnDigest dr = new ReturnDigest("password");
            dr.start();

            StringBuilder result = new StringBuilder("password");
            result.append(": ");
            byte[] digest = dr.getDigest();
            result.append(Integer.toHexString(0xff & digest[i]));
        }
    }
}
