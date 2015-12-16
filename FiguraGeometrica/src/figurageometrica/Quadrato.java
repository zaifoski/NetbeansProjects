/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package figurageometrica;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author sofia.chimirri
 */
public class Quadrato{
    float spessorePerimetroVal;
    float larghezzaVal;
    Rectangle rec = new Rectangle();
    
    public Quadrato(){
        System.out.println("Disegno quadrato");
    }
    public Quadrato(float larghezzaVal,float spessorePerimetroVal){
        this.spessorePerimetroVal = spessorePerimetroVal;
        this.larghezzaVal = larghezzaVal;
        rec.setFill(Color.GREEN);
        rec.setStroke(Color.RED);
        rec.setHeight(larghezzaVal);
        rec.setWidth(larghezzaVal);
        rec.setStrokeWidth(spessorePerimetroVal);
    }
    public Rectangle disegnaQuadrato(){
        return rec;
    }
    
}
