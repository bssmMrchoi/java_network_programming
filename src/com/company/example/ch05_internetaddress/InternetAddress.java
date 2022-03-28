package com.company.example.ch05_internetaddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InternetAddress {
    public static void main(String[] args) {
        try {
            InetAddress local = InetAddress.getLocalHost();
            System.out.println("---local---");
            System.out.println(local);
            System.out.println(local.getHostName());
            System.out.println(local.getHostAddress());

            InetAddress address = InetAddress.getByName("www.google.com");
            System.out.println("---google---");
            System.out.println(address);
            System.out.println(address.getHostName());
            System.out.println(address.getHostAddress());

            InetAddress[] address2 = InetAddress.getAllByName("www.naver.com");
            System.out.println("---naver---");
            for(InetAddress adr : address2) {
                System.out.println("> "+adr);
            }

            InetAddress add = InetAddress.getByName("142.250.199.100");
            System.out.println(add.getCanonicalHostName());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
