import java.net.*;

/**
 * Test della classe InetAddress
 * @author maurizio
 */
public class InetAddressTest{

    /* Use the InetAddress class to return the host name of the local host. */
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();
        System.out.println(address);
        System.out.println(address.getHostName());
   }
 }