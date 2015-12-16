/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package figurageometrica;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author sofia.chimirri
 */
public class FiguraGeometrica extends Application {
    float larghezzaVal = 0;
    float spessorePerimetroVal = 0;
    List storicoList = new LinkedList();
    
    @Override
    public void start(Stage primaryStage) {
        //scatolone
        final BorderPane bp = new BorderPane();
        GridPane parteSopra = new GridPane();
        
        //annulla e storico
        Button annulla = new Button();
        annulla.setText("Annulla");
        annulla.setId("annulla");
        Button storico = new Button();
        storico.setText("Storico");
        storico.setId("storico");
        
        //quadrato o cerchio
        Button scegliQuadrato = new Button();
        scegliQuadrato.setText("Disegna Quadrato");
        scegliQuadrato.setId("scegliQuadrato");
        Button scegliCerchio = new Button();
        scegliCerchio.setText("Disegna Cerchio");
        scegliCerchio.setId("scegliCerchio");
        
        Label larghezzaLabel = new Label("Larghezza");
        final TextField larghezza = new TextField();
        Label spessorePerimetroLabel = new Label("Spessore Perimetro");
        final TextField spessorePerimetro = new TextField();
        
        //inserimento nelle sctaole
        parteSopra.add(annulla,0,0);
        parteSopra.add(storico,1,0);
        parteSopra.add(scegliQuadrato,0,1);
        parteSopra.add(scegliCerchio,1,1);
        parteSopra.add(larghezzaLabel,0,2);
        parteSopra.add(larghezza,1,2);
        parteSopra.add(spessorePerimetroLabel,0,3);
        parteSopra.add(spessorePerimetro,1,3);
        ColumnConstraints column1 = new ColumnConstraints(180);
        ColumnConstraints column2 = new ColumnConstraints(180);
        parteSopra.getColumnConstraints().addAll(column1,column2);
        RowConstraints row1 = new RowConstraints(25);
        RowConstraints row2 = new RowConstraints(25);
        RowConstraints row3 = new RowConstraints(25);
        RowConstraints row4 = new RowConstraints(25);
        parteSopra.getRowConstraints().addAll(row1,row2,row3,row4);
       
        Circle nera = new Circle();
        
        bp.setTop(parteSopra);
        bp.setCenter(nera);
        BorderPane.setAlignment(nera, Pos.CENTER);
        
        //Button EventHandler        
        EventHandler eH = new EventHandler(){           
           @Override
           public void handle(Event event) {
               String causante = ((Button) event.getTarget()).getId();
               try{
                   spessorePerimetroVal = Float.parseFloat(spessorePerimetro.getText());
                   larghezzaVal = Float.parseFloat(larghezza.getText());
               }
               catch(NumberFormatException e){
                   mostraErrore();
               }
               if(causante.equals("scegliQuadrato")){
                   Quadrato q = new Quadrato(larghezzaVal,spessorePerimetroVal);
                   Rectangle rec = q.disegnaQuadrato();
                   bp.setCenter(rec);
                   Dati dati = new Dati("quadrato",larghezzaVal,spessorePerimetroVal);
                   storicoList.add(dati);
               }
               else {
                   if(causante.equals("scegliCerchio")){
                       Cerchio q = new Cerchio(larghezzaVal,spessorePerimetroVal);
                       Circle rec = q.disegnaCerchio();
                       bp.setCenter(rec);
                       Dati dati = new Dati("cerchio",larghezzaVal,spessorePerimetroVal);
                       storicoList.add(dati);
                   }
                   else{
                       if(causante.equals("storico")){
                           mostraStorico();
                       }
                       else{
                           if(causante.equals("annulla")){
                               cancellaStorico();
                           }
                       }
                   }
               }
           }
           
        };
        scegliQuadrato.addEventHandler(ActionEvent.ACTION,eH);
        scegliCerchio.addEventHandler(ActionEvent.ACTION,eH);
        storico.addEventHandler(ActionEvent.ACTION,eH);
        annulla.addEventHandler(ActionEvent.ACTION,eH);
        
        //Mostro finestra
        StackPane root = new StackPane();
        root.getChildren().add(bp);
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setTitle("Disegnatore figura geometrica");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
        //Eventchain
        /*EventHandler filter=new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                EventTarget target=t.getTarget();
                Object source=t.getSource(); 
                String id=null;
                if (source instanceof Node) { 
                    id=((Node)source).getId(); 
                } else if (source instanceof Stage) {
                    id="STAGE";
                } else if (source instanceof Scene) {
                    id="SCENE"; 
                } else { 
                    System.out.println("Unrecognized Object"+source); 
                } 
                System.out.println("FILTER:"+id+" "+source+" ==> "+target);
            } 
        }; 
        scene.addEventFilter(ActionEvent.ACTION,filter); 
        primaryStage.addEventFilter(ActionEvent.ACTION,filter);  
        larghezza.addEventFilter(ActionEvent.ACTION,filter);*/
    }
    
    /**
     * Mostra una finestra con il messaggio di errore
     *
     * @author sofia.chimirri
     */
    public void mostraErrore() {
                   Text erroreFormato = new Text();
                   erroreFormato.setText("Specificare spessore perimetro e larghezza come numeri");
                   erroreFormato.setWrappingWidth(200);
                   HBox hb = new HBox();
                   hb.getChildren().add(erroreFormato);
                   Group rootErr = new Group();
                   rootErr.getChildren().add(hb);
                   Scene sceneErr = new Scene(rootErr, 200, 200);
                   Stage stageErr = new Stage();
                   stageErr.setTitle("Errore");
                   stageErr.setScene(sceneErr);
                   stageErr.show();
    }
    /**
     * Mostra una finestra con lo storico operazioni
     *
     * @author sofia.chimirri
     */
    public void mostraStorico() {
                   Iterator i = storicoList.iterator();
                   VBox hb = new VBox();
                   while(i.hasNext()){
                       Text erroreFormato = new Text();
                       String s = i.next().toString();
                       erroreFormato.setText(s);
                       erroreFormato.setWrappingWidth(200);
                       hb.getChildren().add(erroreFormato);
                   }
                   Group rootErr = new Group();
                   rootErr.getChildren().add(hb);
                   Scene sceneErr = new Scene(rootErr, 200, 200);
                   Stage stageErr = new Stage();
                   stageErr.setTitle("Storico");
                   stageErr.setScene(sceneErr);
                   stageErr.show();
    }
    /**
     * Cancella lo storico operazioni
     *
     * @author sofia.chimirri
     */
    public void cancellaStorico() {
                   storicoList.clear();
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
