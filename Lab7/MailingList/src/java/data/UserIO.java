/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import business.User;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;



public class UserIO {

    public synchronized static void addRecord(User user,
            String filename)
            throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter(filename, true));
        out.println(user.getEmailAddress()+ "|"+ user.getFirstName() + "|"+ user.getLastName());
        out.println("ciao");
        out.close();
    }

}
