/*
 * Creare un'applicazione che mostri una finestra (di 
 * dimensioni 400*400) contenente tre pulsanti, un 
 * testo e un’area disegnabile (canvas). 
 * I tre pulsanti devono essere associati ai tre valori 
 * rosso, blu e giallo. 
 * Il click su un pulsante deve disegnare un cerchio 
 * nell’area disegnabile del colore associato al pulsante 
 * stesso. La posizione del cerchio deve essere 
 * casuale. 
 * Il testo deve riportare, in ogni momento, il numero 
 * totale di cerchi disegnati.
 * Aggiungere un controllo che riporti, in ogni 
 * momento, il numero di cerchi sovrapposti. 
 * PIù VEDI LINKS!!!!!!!!!!!!
 */

package cerchicolorati;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import static java.lang.Math.random;
import java.util.*;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
 *
 * @author sofia.chimirri
 */
public class CerchiColorati extends Application {
    //Setto le variabili
    
    final int DIMCERCHIO = 65;
    final int RAGGIO = DIMCERCHIO/2;
    final int DIMCANVAS = 400;
    
    //Contatore cerchi
    Text t = new Text("0 cerchi disegnati");
    
    //Contatore cerchi sovrapposti
    Text t2 = new Text("0 cerchi sovrapposti");
    
    //Contenitore per totale cerchi aggiugnti e totale cerchi già sovrapposti
    Set mieiCerchi = new HashSet();
    Set sovrapposti = new HashSet();
    
    /**
     * Scrive il numero aggiornato di cerchi disegnati
     * Controlla se il nuovo cerchio è sovrapposto  ad uno dei precedenti
     * Scrive il numero aggiornato di cerchi sovrapposti
     * Aggiunge il nuovo cerchio alla Map dei cerchi da controllare
     *
     * @author sofia.chimirri
     * @param x double la componente x del nuovo cerchio disegnato
     * @param y double la componente y del nuovo cerchio disegnato
     */
    
    public void aggiornaContatori(double x, double y){
        Cerchio c = new Cerchio(x,y);
        Iterator i = mieiCerchi.iterator();
        while(i.hasNext()){
            Cerchio altroCerchio = (Cerchio) i.next();
            double altroX = altroCerchio.getX();
            double altroY = altroCerchio.getY();
            double CentroX = x + RAGGIO;
            double CentroY = y + RAGGIO;
            double altroCentroX = altroX + RAGGIO;
            double altroCentroY = altroY + RAGGIO;
            double distanzaCentri = Math.sqrt((Math.pow((altroCentroX-CentroX),2.0))
                                    +(Math.pow((altroCentroY-CentroY),2.0)));
            if(distanzaCentri<DIMCERCHIO){
                sovrapposti.add(c);
                sovrapposti.add(altroCerchio);
            }
        }
        t2.setText(sovrapposti.size() +" cerchi sovrapposti");
        mieiCerchi.add(c);
        t.setText(mieiCerchi.size() +" cerchi disegnati");
    }
    
    @Override
    public void start(Stage primaryStage) {
        Canvas canvas = new Canvas(DIMCANVAS, DIMCANVAS);
        final GraphicsContext gc = canvas.getGraphicsContext2D();
        
        //Yellow Button
        Button yellowBtn = new Button("Yellow Button");
        yellowBtn.setId("Y");
        //Red Button
        Button redBtn = new Button("Red Button");
        redBtn.setId("R");
        //Blue Button
        Button blueBtn = new Button("Blue Button");
        blueBtn.setId("B");
        
        //Creo EventHandler
        EventHandler eh = new EventHandler(){

            @Override
            public void handle(Event event) {
                
                //Setta il colore del cerchio in base al bottone premuto
                String colore = ((Button) event.getTarget()).getId();
                if (colore.equals("Y"))
                    gc.setFill(Color.YELLOW);
                else {
                    if (colore.equals("R"))
                        gc.setFill(Color.RED);
                    else
                        gc.setFill(Color.BLUE);
                }
                
                //Disegna cerchio in poizione casuale
                double x = random()*(DIMCANVAS-DIMCERCHIO);
                double y = random()*(DIMCANVAS-DIMCERCHIO);
                gc.fillOval(x, y, DIMCERCHIO, DIMCERCHIO);
                //Aggiorna contatore e contatore cerchi sovrapposti se è il caso
                aggiornaContatori(x,y);       
            }
        };
        
        //Associo Eventhandler ai bottoni
        yellowBtn.addEventHandler(ActionEvent.ACTION,eh);
        redBtn.addEventHandler(ActionEvent.ACTION,eh);
        blueBtn.addEventHandler(ActionEvent.ACTION,eh);
        
        //Inserisco nei layouts
        Pane layoutButtons=new HBox();
        layoutButtons.setPadding(new Insets(0, 10, 0, 10));
        ((HBox) layoutButtons).setSpacing(10);
        layoutButtons.getChildren().add(blueBtn);
        layoutButtons.getChildren().add(redBtn);
        layoutButtons.getChildren().add(yellowBtn);
        
        Pane layout=new VBox();
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.getChildren().add(layoutButtons);
        layout.getChildren().add(t);
        layout.getChildren().add(t2);
        layout.getChildren().add(canvas);

        //Preparo la scena e la mostro
        primaryStage.setTitle("Cerchi Colorati Es. 4");
        Group root = new Group(layout);
        primaryStage.setScene(new Scene(root,Color.BLANCHEDALMOND));
        primaryStage.show();
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

class Cerchio {
    protected double x;
    protected double y;
    protected boolean sovrapposto = false;
    Cerchio(){
    }
    Cerchio(double x, double y){
        this.x = x;
        this.y = y;
    }
    void issovrapposto(){
        this.sovrapposto = true;
    }
    double getX(){
        return x;
    }
    double getY(){
        return y;
    }
}
