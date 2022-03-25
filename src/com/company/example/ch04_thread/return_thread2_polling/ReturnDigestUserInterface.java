package com.company.example.ch04_thread.return_thread2_polling;

public class ReturnDigestUserInterface {
    public static void main(String[] args) {
        ReturnDigest[] digests = new ReturnDigest[10];
        for (int i=0; i<10; i++) {
            digests[i] = new ReturnDigest("password");
            digests[i].start();
        }
        for (int i=0; i<10; i++) {
            while (true) {
                System.out.print(i+"번째 스레드-");
                byte[] digest = digests[i].getDigest();
                if (digest != null) {
                    StringBuilder result = new StringBuilder("password");
                    result.append(": ");
                    for (int j = 0; j < digest.length; j++) {
                        result.append(Integer.toHexString(0xff & digest[j]));
                    }
                    System.out.println(result);
                    break;
                }
            }
        }
    }
}
