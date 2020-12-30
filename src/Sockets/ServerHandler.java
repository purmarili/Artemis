package Sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerHandler implements Runnable {
    private Socket server;
    private BufferedReader in;

    public ServerHandler(Socket server) throws IOException {
        this.server = server;
        in = new BufferedReader(new InputStreamReader(server.getInputStream()));
    }

    @Override
    public void run() {
        String serverResponse = null;
        try {
            while (true) {
                serverResponse = in.readLine();
                if (serverResponse == null) break;
                System.out.println("Server says: " + serverResponse);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
