package tinyHttpServer;

import java.net.*; 
import java.io.*; 
import java.util.*;


/**
 * Processess http get requests, serving requested files
 *
 * @author maurizio
 */  
class TinyHttpConnection extends Thread {
  private Socket sock;

  /**
  * Constructor 
  * @param s an open socket
  */ 
  TinyHttpConnection ( Socket s ) {
    sock = s; 
    setPriority( NORM_PRIORITY - 1 ); 

    // we start the thread
    start(); 
  }

 /** 
  * Implements the run method of the Thread interface
  * it's called automatically when starting the thread
  */
  public void run() {
    try { 
      
      OutputStream out = sock.getOutputStream();
      BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
      
      // we read the first line of the request, it should be:
      // GET /path/to/file
      String req =in.readLine();

      // we printout the request for debugging purposes
      System.out.println( "Request: "+req );

      // we separate request in tokens 
      StringTokenizer st = new StringTokenizer( req ); 

      // we expect the GET verb and at least 
      if ( (st.countTokens() >= 2) && st.nextToken().equals("GET") ) { 
        // we extract the path file, turning it into a local relative path
        if ( (req = st.nextToken()).startsWith("/") ) 
          req = req.substring( 1 ); 
        
        // if it's a directory, then by default we get the index.html
        if ( req.endsWith("/") || req.equals("") ) 
          req = req + "index.html"; 

        try { 
          FileInputStream fis = new FileInputStream ( req ); 
          byte [] data = new byte [ fis.available() ]; 
          fis.read( data ); 
          out.write( data ); 
        } catch ( FileNotFoundException e ){ 
          new PrintStream( out ).println("404 Not Found"); 
        }
      } else {
        new PrintStream( out ).println( "400 Bad Request" );
      }
      
    } catch ( IOException e ) {
      System.out.println( "I/O error " + e );
    }  finally {
        try {
            // we make sure the socket is closed, no matter what
            sock.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
  }
}
