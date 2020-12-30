package Sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private static final String serverIP = "127.0.0.1";
    private static final int serverPort = 9898;

    public static void main(String[] args) throws IOException {
        Socket conn = new Socket(serverIP, serverPort);

        ServerHandler serverConnection = new ServerHandler(conn);
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

        PrintWriter out = new PrintWriter(conn.getOutputStream(), true);

        new Thread(serverConnection).start();

        while (true) {
            System.out.println("> ");
            String command = keyboard.readLine();

            if (command.equals("quit")) break;

            out.println(command);
        }
        conn.close();
        System.exit(0);
    }
}
