package org.util;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class TCPClient {

    public static void sendFile(String ip, int port, byte[] data) {
        try (Socket socket = new Socket(ip, port)) {
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.write(data);
        } catch (IOException e) {
            System.out.println("Error occurred while sending!");
            System.exit(0);
        }
    }

}
