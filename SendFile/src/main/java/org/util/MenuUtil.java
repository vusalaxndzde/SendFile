package org.util;

import java.util.Scanner;

public class MenuUtil {

    public static void showMenu() {

        Scanner sc = new Scanner(System.in);
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Surname: ");
        String surname = sc.nextLine();
        System.out.println("Welcome, " + name + " " + surname);

        byte[] data = getData();

        send(data);
        System.out.println("Successfully sent");

    }

    public static byte[] getData() {
        Scanner sc = new Scanner(System.in);
        System.out.print("File directory: ");
        String dir = sc.nextLine();
        byte[] data = FileUtil.readFile(dir);
        if (data == null) {
            return getData();
        } else {
            return data;
        }
    }

    public static void send(byte[] data) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Send to (IP:port): ");
        String[] sendTo = sc.nextLine().split(":");
        String ip = sendTo[0];
        int port = Integer.parseInt(sendTo[1]);

        TCPClient.sendFile(ip, port, data);
    }

}
