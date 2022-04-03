package com.company.example.ch06_url.udp.exam1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServerExam {
    public static void main(String[] args) throws IOException {
        //메시지 받을 포트 열고 준비
        DatagramSocket ds = new DatagramSocket(3000);
        byte[] data = new byte[65535];

        DatagramPacket dp = new DatagramPacket(data, data.length);
        System.out.println("UDP 서버 대기중...");

        ds.receive(dp);
        String msg = new String(dp.getData()).trim();

        System.out.println("보낸 주소 : "+dp.getAddress());
        System.out.println("보낸 메시지 : "+msg);
    }
}
