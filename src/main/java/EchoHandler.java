import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class EchoHandler implements Handler {
    @Override
    public void handleRequest(Socket socket) throws IOException {
        try (InputStream in = socket.getInputStream();
             OutputStream out = socket.getOutputStream()) {
            byte[] buffer = new byte[1024];
            int bytesRead = in.read(buffer);
            out.write(buffer, 0, bytesRead);
        }
    }
}
