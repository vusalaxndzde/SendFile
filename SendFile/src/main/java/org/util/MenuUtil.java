package org.util;

import org.bean.Config;

import java.util.Scanner;

public class MenuUtil {

    public static void showMenu() {

        getInfo();

        byte[] data = getData();

        send(data);
        System.out.println("Successfully sent");

    }

    public static void getInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Surname: ");
        String surname = sc.nextLine();

        String from = name + " " + surname;
        Config.setFrom(from);
        System.out.println("Welcome, " + from);
    }

    public static String getDir() {
        Scanner sc = new Scanner(System.in);
        System.out.print("File directory: ");
        return sc.nextLine();
    }

    public static byte[] getData() {
        String dir = getDir();
        byte[] data = FileUtil.readFile(dir);
        if (data == null) {
            return getData();
        } else {
            Config.setFileDir(dir);
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
