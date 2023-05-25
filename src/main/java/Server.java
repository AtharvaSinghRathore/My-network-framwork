import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private int port;
    private Handler handler;
    
    public Server(int port, Handler handler) {
        this.port = port;
        this.handler = handler;
    }
    
    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server listening on port " + port);
        
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected: " + socket);
            new Thread(() -> {
                try {
                    handler.handleRequest(socket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
    
    public void stop() {
        // TODO: Implement
    }
}
