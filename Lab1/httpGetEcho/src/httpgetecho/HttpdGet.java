package httpgetecho;

import java.net.*;
import java.io.*;
//import java.util.*;


/**
 * Creates a socket server and manages the 
 * incoming requests 
 *
 * @author maurizio
 */  
public class HttpdGet {
  public static void main( String args[] ) throws IOException {
      
      if(args.length!=1){
        System.out.println("Usage: java HttpdGet <port>");
        return;
      }         
      
      // We open the socket, on the current machine and associated
      // to the input port
      //ServerSocket ss = new ServerSocket(Integer.parseInt(argv[0]));
      ServerSocket ss = new ServerSocket(Integer.parseInt(args[0]));
      System.out.println(ss.getInetAddress().getLocalHost());
      System.out.println(ss.getLocalPort());
      
      // We inform the client how to test the http get inspector
      System.out.println("Perform an HTTP GET request to: " + ss.getInetAddress().getLocalHost() + ":" + ss.getLocalPort());

      // Here we listen indefinetely to the incoming requests
      // The HttpdConnection class processess all the requests
      while ( true )
          new HttpdConnection( ss.accept() );
      }
}
