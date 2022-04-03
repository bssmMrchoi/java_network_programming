package com.company.example.ch06_url.tcp.exam2;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class TCPClientExam2 {
    public static void main(String[] args) throws IOException {
        InetAddress ia = InetAddress.getByName("127.0.0.1");
        //서버 접속
        Socket so = new Socket(ia, 5000);

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(so.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(so.getOutputStream()));

        while(true) {
            System.out.print("보낼 메시지 : ");
            String sendMsg = in.readLine();
            bw.write(sendMsg + "\n");
            bw.flush();

            System.out.println("------서버의 메시지를 기다리는 중------");
            String getMsg = br.readLine();

            System.out.println("보낸 주소 : "+so.getInetAddress());
            System.out.println("보낸 내용 : "+getMsg);
            if(getMsg.equals("exit")) {
                so.close();
                bw.close();
                System.exit(0);
            }
        }
    }
}
