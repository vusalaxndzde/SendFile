package org.main;

import org.Util.FileUtil;
import org.Util.TCPClient;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Surname: ");
        String surname = sc.nextLine();
        System.out.println("Welcome, " + name + " " + surname);

        System.out.print("File directory: ");
        String dir = sc.nextLine();

        byte[] data = FileUtil.readFile(dir);

        System.out.print("Send to (IP:port): ");
        String[] sendTo = sc.nextLine().split(":");
        String ip = sendTo[0];
        int port = Integer.parseInt(sendTo[1]);

        TCPClient.sendFile(ip, port, data);
        System.out.println("Successfully sent");

    }
}