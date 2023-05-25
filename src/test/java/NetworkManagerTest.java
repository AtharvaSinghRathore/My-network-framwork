import org.junit.Test;
import static org.junit.Assert.*;

public class NetworkManagerTest {

    @Test
    public void testConnect() {
        NetworkManager networkManager = new NetworkManager();
        boolean isConnected = networkManager.connect("localhost", 8080);
        assertTrue(isConnected);
    }

    @Test
    public void testDisconnect() {
        NetworkManager networkManager = new NetworkManager();
        boolean isConnected = networkManager.connect("localhost", 8080);
        assertTrue(isConnected);

        boolean isDisconnected = networkManager.disconnect();
        assertTrue(isDisconnected);
    }
}
