/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package figurageometrica;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author sofia.chimirri
 */
public class Cerchio{
    float spessorePerimetroVal;
    float larghezzaVal;
    Circle rec = new Circle();
    
    public Cerchio(){
        System.out.println("Disegno Cerchio");
    }
    public Cerchio(float larghezzaVal,float spessorePerimetroVal){
        rec.setFill(Color.GREEN);
        rec.setStroke(Color.RED);
        this.spessorePerimetroVal = spessorePerimetroVal;
        this.larghezzaVal = larghezzaVal;
        rec.setRadius(larghezzaVal/2);
        rec.setStrokeWidth(spessorePerimetroVal);
    }
    public Circle disegnaCerchio(){
        return rec;
    }
    
}
