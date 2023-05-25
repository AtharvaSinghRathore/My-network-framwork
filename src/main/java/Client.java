import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    private String host;
    private int port;
    
    public Client(String host, int port) {
        this.host = host;
        this.port = port;
    }
    
    public void send(String message) throws IOException {
        try (Socket socket = new Socket(host, port);
             InputStream in = socket.getInputStream();
             OutputStream out = socket.getOutputStream()) {
            out.write(message.getBytes());
            byte[] buffer = new byte[1024];
            int bytesRead = in.read(buffer);
            String response = new String(buffer, 0, bytesRead);
            System.out.println("Server response: " + response);
        }
    }
}
