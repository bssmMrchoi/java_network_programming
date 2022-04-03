package com.company.example.ch06_url.tcp.exam1;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class TCPClientExam {
    public static void main(String[] args) throws IOException {
        InetAddress ia = InetAddress.getByName("127.0.0.1");
        //서버 접속
        Socket so = new Socket(ia, 5000);
        System.out.print("보낼 메시지 : ");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String msg = in.readLine();

        //메시지 전송 스트림 생성
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(so.getOutputStream()));

        //메시지 전송
        bw.write(msg+"\n");
        bw.flush();
        bw.close();
    }
}
