/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkg140826_esame_agosto14;

import static java.lang.System.gc;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author Berta
 */
public class Dado extends Canvas {
        GraphicsContext gc;

    public Dado() {
        this.gc = getGraphicsContext2D();
    }
        public void drawDado(GraphicsContext gc){
        gc.setFill(Color.PINK);
        gc.setStroke(Color.RED);
        gc.setLineWidth(4);
        gc.fillOval(5, 5, 10, 10);
        gc.fillOval(25, 25, 10, 10);
        gc.strokeRoundRect(0, 0, 60, 60, 8, 8);
        };
    
}
