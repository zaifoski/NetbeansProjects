/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es1;

import java.net.*;
import java.io.*;
import java.util.*;

/**
 *
 * @author sofia
 */
public class TinyHttpd {
  
  public static void main(String[] args) throws IOException {
  
      if(args.length!=1){
        System.out.println("Usage: java TinyHttpd port");
        return;
      }         
      
      // We open the socket, on the current machine and associated
      // to the input port
      ServerSocket ss = new ServerSocket(Integer.parseInt(args[0]));

      System.out.println(ss.getInetAddress().getLocalHost());
      System.out.println(ss.getLocalPort());
      
      // We inform the client how to test our tiny server 
      System.out.println("Request a file request to: " + ss.getInetAddress().getLocalHost() + ":" + ss.getLocalPort());

      // Here we listen indefinetely to the incoming requests
      // The HttpdConnection class processess all the requests
      while ( true ) {
          new TinyHttpdConnection2( ss.accept() ); 
      }  
  
  }

    
}
