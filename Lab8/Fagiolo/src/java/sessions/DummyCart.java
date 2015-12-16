/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import java.util.Vector;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author sofia
 */
public class DummyCart {

    private Vector v = new Vector();
    private String submit = null;
    private String item = null;

    public void processRequest(HttpServletRequest request) {

// null value for submit - user hit enter instead of clicking on
// "add" or "remove"
        if (getSubmit() == null) {
            v.add(getItem());
            //addItem(getItem());
        }
        if (getSubmit().equals("add")) {
            v.add(getItem());
            //addItem(getItem());
        } else if (getSubmit().equals("remove")) {
            v.remove(getItem());
            //removeItem(getItem());
        }

// reset at the end of the request 
        //reset();
    }

    /**
     * @return the v
     */
    public Vector getV() {
        return v;
    }

    /**
     * @param v the v to set
     */
    public void setV(Vector v) {
        this.v = v;
    }

    /**
     * @return the submit
     */
    public String getSubmit() {
        return submit;
    }

    /**
     * @param submit the submit to set
     */
    public void setSubmit(String submit) {
        this.submit = submit;
    }

    /**
     * @return the item
     */
    public String getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(String item) {
        this.item = item;
    }
}
