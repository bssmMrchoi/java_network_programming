package com.company.example.ch04_thread.return_thread1;

public class ReturnDigestUserInterface {
    public static void main(String[] args) {
        ReturnDigest[] digests = new ReturnDigest[10];
        for (int i=0; i<10; i++) {
            digests[i] = new ReturnDigest("password");
            digests[i].start();
        }
        //Thread.sleep(500);
        for (int i=0; i<10; i++) {
            StringBuilder result = new StringBuilder("password");
            result.append(": ");
            byte[] digest = digests[i].getDigest();
            for (int j = 0; j < digest.length; j++) {
                result.append(Integer.toHexString(0xff & digest[j]));
            }
            System.out.println(result);
        }
    }
}