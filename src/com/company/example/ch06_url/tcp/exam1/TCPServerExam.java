package com.company.example.ch06_url.tcp.exam1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerExam {
    public static void main(String[] args) throws IOException {
        //서버 준비
        ServerSocket ss = new ServerSocket(5000);
        System.out.println("TCP 서버 대기중...");

        //클라이언트 접속 대기
        Socket so = ss.accept();

        //메시지 수신 스트림 생성
        BufferedReader br = new BufferedReader(new InputStreamReader(so.getInputStream()));
        String msg = br.readLine();

        //메시지 분석
        System.out.println("보낸 주소 : "+so.getInetAddress());
        System.out.println("보낸 내용 : "+msg);
        so.close();
    }
}
