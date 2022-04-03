package com.company.example.ch06_url.udp.exam2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClientExam2 {

    public static void main(String[] args) throws IOException {
        while(true) {
            //사용자 입력
            System.out.print("보낼 메시지 : ");
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String msg = in.readLine();

            //보낼 메시지 패킷 포장
            DatagramPacket dp = new DatagramPacket(msg.getBytes(),
                    msg.getBytes().length,
                    InetAddress.getByName("127.0.0.1"),
                    3000);

            //메시지 보내기
            DatagramSocket ds = new DatagramSocket();
            ds.send(dp);
        }
    }
}
