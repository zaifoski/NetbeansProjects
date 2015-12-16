/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es1;

import java.net.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author sofia
 */
public class TinyHttpdConnection2 extends Thread {
  private Socket sock;

  /**
  * Constructor 
  * @param s an open socket
  */ 
  TinyHttpdConnection2 ( Socket s ) {
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
      /*for(int i=0; i<10; i++){
          System.out.println(req);
          req=st.nextToken();
      }*/
      // we expect the GET verb and at least 
      if ( (st.countTokens() >= 2) && st.nextToken().equals("GET") ) { 
        // we extract the path file, turning it into a local relative path
        if ( (req = st.nextToken()).startsWith("/") ) 
          req = req.substring( 1 ); 
        
        // if it's a directory, then by default we get the index.html
        if ( req.endsWith("/") || req.equals("") ) {
          //req = req + "index.html"; 
            File folder = new File("C:/Users/sofia/Documents/NetBeansProjects/es1/" +req);
            File[] listOfFiles = folder.listFiles();

            for (int i = 0; i < listOfFiles.length; i++) {
                if (listOfFiles[i].isFile()) {
                    new PrintStream( out ).println("File\t" + listOfFiles[i].getName());
                } else if (listOfFiles[i].isDirectory()) {
                    new PrintStream( out ).println("Directory\t" + listOfFiles[i].getName());
                }
            }
        }
        try {
          //FileSystemManager fsManager = VFS.getManager();
          //FileObject directory = fsManager.resolveFile("c:\dir\somefile.html");
          FileInputStream fis = new FileInputStream( "C:/Users/sofia/Documents/NetBeansProjects/es1/" +req );
          //File f = new File(req);
          //System.out.println(f.getAbsolutePath());
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
            Logger.getLogger(TinyHttpdConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  }
}
