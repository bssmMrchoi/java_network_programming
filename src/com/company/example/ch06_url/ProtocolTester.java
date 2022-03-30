package com.company.example.ch06_url;

import java.net.MalformedURLException;
import java.net.URL;

/*
    가상 머신이 지원하는 프로토콜은?
 */
public class ProtocolTester {
    public static void main(String[] args) {
        //하이퍼텍스트 전송 프로토콜
        testProtocol("http://www.abc.org");
        //보안 http
        testProtocol("https://www.amazon.com/exec/obidos/order2/");
        //파일 전송 프로토콜
        testProtocol("ftp://ibiblio.org/pub/lanuages/java/javafaq/");
        //로컬 파일 접근
        testProtocol("file://C:");
        //jdbc -> 자바에서 지원하는데 url에서 지원하는게 아니라 java.sql 등에서 지원함
        testProtocol("jdbc:oracle:thin:@localhost:1521:xe");
    }
    public static void testProtocol(String url) {
        try {
            URL u = new URL(url);
            System.out.println(u.getProtocol() + " is supported");
        } catch (MalformedURLException e) {
            String protocol = url.substring(0, url.indexOf(':'));
            System.out.println(protocol + " is not supported");
        }
    }
}
