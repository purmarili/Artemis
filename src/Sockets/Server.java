package Sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private static final String[] names = {"Tony", "Sonny", "Johnny", "Balony", "Bony"};
    private static final String[] descr = {"Almighty", "Silly", "Buffed", "Weirdo"};

    private static final int port = 9898;

    private static ArrayList<ClientHandler> clients = new ArrayList<>();
    private static ExecutorService pool = Executors.newFixedThreadPool(4);

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(port);

        while (true) {
            System.out.println("[SERVER] Waiting for client...");
            Socket client = server.accept();
            System.out.println("[SERVER] Connected to client...");
            ClientHandler clientThread = new ClientHandler(client, clients);
            clients.add(clientThread);

            pool.execute(clientThread);
        }

    }

    public static String getRandomName() {
        String name = names[(int) (Math.random() * names.length)];
        String desc = descr[(int) (Math.random() * names.length)];
        return desc + " " + name;
    }

}
