package Sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable{
    private Socket client;
    private BufferedReader in;
    private PrintWriter out;
    private ArrayList<ClientHandler> clients;

    public ClientHandler(Socket client, ArrayList<ClientHandler> clients) throws IOException {
        this.client = client;
        in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        out = new PrintWriter(client.getOutputStream(), true);
        this.clients = clients;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String request = in.readLine();
                if (request == null){

                } else if (request.contains("name")) {
                    out.println(Server.getRandomName());
                } else if (request.startsWith("say")){
                    int firstSpace = request.indexOf(" ");
                    outToAll(request.substring(firstSpace + 1));
                } else {
                    out.println("Type 'tell me a name' to get a random name");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.close();
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void outToAll(String message) {
        for (ClientHandler client : clients) {
            client.out.println(message);
        }
    }
}
