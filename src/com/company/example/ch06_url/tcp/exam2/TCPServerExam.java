package com.company.example.ch06_url.tcp.exam2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerExam {
    public static void main(String[] args) throws IOException {
        //서버 준비
        ServerSocket ss = new ServerSocket(5000);
        System.out.println("TCP 서버 대기중...");

        //클라이언트 접속 대기
        Socket so = ss.accept();

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(so.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(so.getOutputStream()));

        while(true) {
            System.out.println("------클라이언트의 메시지를 기다리는 중------");
            String getMsg = br.readLine();

            System.out.println("보낸 주소 : "+so.getInetAddress());
            System.out.println("보낸 내용 : "+getMsg);

            System.out.print("보낼 메시지 : ");
            String sendMsg = in.readLine();
            bw.write(sendMsg + "\n");
            bw.flush();


            if(getMsg.equals("exit")) {
                so.close();
                bw.close();
                System.exit(0);
            }
        }
    }
}
