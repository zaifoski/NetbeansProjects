/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NsLookup;

import java.net.*;

/**
 * Test of NSLookup features
 * @author maurizio
 */
public class NSLookupApp{

    /* Use the InetAddress class to return the host name and IP address of 
     * o a given hostName
     */
    public static void main(String[] args) {        
      
      if(args.length < 1){
        System.out.println("Usage: java NSLookupApp hostName");
        return;
      }      
      
      try {
          InetAddress host = InetAddress.getByName(args[0]);
          String hostName = host.getHostName();

          System.out.println("Host name: "+hostName);
          System.out.println("IP address: "+host.getHostAddress());

      }catch(UnknownHostException ex) {
          System.out.println("Unknown host");
          return;
      }
    }
 }