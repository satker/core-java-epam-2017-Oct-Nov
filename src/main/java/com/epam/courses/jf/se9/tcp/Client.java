package com.epam.courses.jf.se9.tcp;

import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        try {
            try (Socket socket = new Socket("localhost", 10_000);
                 BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                out.write("Hello, server!\n");
                out.flush();
                System.out.println("From server: " + in.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
