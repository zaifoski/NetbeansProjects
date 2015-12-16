import java.net.*;
import java.io.*;

/**
 *
 * @author maurizio
 */
  class HttpdConnection extends Thread {
    private Socket sock;

    /**
    * Constructor 
    * @param s an open socket
    */ 
    HttpdConnection ( Socket s ) {
      sock = s;

      // we start the thread 
      start(); 
    }

    /* Implements the run method of the Thread interface
     * it's called automatically when starting the thread
     */
    public void run() {
      try { 
        // Creates a reader to consume the socket stream
        BufferedReader i=new BufferedReader(new InputStreamReader(sock.getInputStream()));

        // the output strem will allow us to write a response
        DataOutputStream o=new DataOutputStream(sock.getOutputStream());

        // here essentially we echo what we have read 
        while( i.ready() ) {   
          String s=i.readLine();
          System.out.println("Received "+ s); 
        }

      } catch(Exception ex){
        // you can be nice and inform in case of expections
      } finally {
          try {
              // let's make sure we close the socket  
              sock.close();
          } catch (IOException ex) {
              System.out.println(ex.getMessage());
          }
      }
    }
  }