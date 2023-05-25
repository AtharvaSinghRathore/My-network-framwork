import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Server server = new Server(8080, new EchoHandler());
        server.start();
        
        Client client = new Client("localhost", 8080);
        client.send("Hello, server!");
    }
}
