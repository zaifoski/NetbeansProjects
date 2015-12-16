/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package grigliagiugno;

import javafx.event.Event;
import javafx.scene.shape.Circle;

/**
 *
 * @author sofia.chimirri
 */
public class CambiaOpacita {

    /**
     * @param t
     */
    
    public void cambiaOpacita(Event t){
        if (t.getEventType().getName().equals("MOUSE_CLICKED")) {
            Circle n = (Circle) t.getTarget();
            if(n.getOpacity()==0)
                n.setOpacity(1);
            else
                n.setOpacity(0);
                            /*Node n = (Node) t.getTarget();
                            int r=GridPane.getRowIndex(n);
                            int c=GridPane.getColumnIndex(n);
                            gp.getChildren().remove(n);
                            Circle cir = new Circle(0,0,30);
                            GridPane.setHalignment(cir, HPos.CENTER);
                            GridPane.setValignment(cir, VPos.CENTER);
                            gp.add(circ, c, r);*/
        }
    }
    
}
