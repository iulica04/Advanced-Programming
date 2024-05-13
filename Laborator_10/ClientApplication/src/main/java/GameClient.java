import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class GameClient {
    private String host;
    private int port;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public GameClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void start() {
        try {
            socket = new Socket(host, port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            System.out.println("Connected to server at " + host + ":" + port);
            System.out.println("Commands: \n" + "   -> 'exit' to quit\n" + "   -> 'stop' to stop the server\n" + "   -> create game \n" + "   -> join game \n" + "   -> submit move\n");


            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                System.out.print("Enter command: ");
                String input = keyboard.readLine();
                if (input == null || input.equalsIgnoreCase("exit")) {
                    System.out.println("Goodbye!");
                    break;
                }
                out.println(input);
                String response = in.readLine();
                System.out.println(response);
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        GameClient gameClient = new GameClient("localhost", 2024);
        gameClient.start();
    }
}
