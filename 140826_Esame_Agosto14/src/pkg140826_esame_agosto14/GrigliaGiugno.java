/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkg140826_esame_agosto14;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author sofia.chimirri
 */
public class GrigliaGiugno extends Application {
    
    int dimgriglia;
    final int DIMGRIGLIA = 10;
    
    @Override
    public void start(final Stage zeroStage) {
            VBox vb = new VBox();
            Text text = new Text(10, 20, "Scegli la dimenzione della griglia");
            final TextArea textArea = new TextArea();
            textArea.setMaxSize(80, 80);
            textArea.setMinSize(80, 80);
            Button conferma = new Button();
            conferma.setText("Conferma");
            conferma.setId("conferma");
            EventHandler ehZ = new EventHandler() {
                @Override
                public void handle(Event t) {
                    try{
                        dimgriglia = Integer.parseInt(textArea.getText());
                    }
                    catch(NumberFormatException e){
                        dimgriglia = DIMGRIGLIA;
                    }
                    finally{
                        PartePrincipale pp = new PartePrincipale(dimgriglia);
                        zeroStage.close();
                    }
                }
            };
            conferma.addEventHandler(ActionEvent.ACTION, ehZ);
            vb.getChildren().addAll(text,textArea,conferma);
            zeroStage.setTitle("Dimensione Griglia");
            zeroStage.setScene(new Scene(vb, 300, 250, Color.CORNFLOWERBLUE));
            zeroStage.show();
    }
    
    


    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}