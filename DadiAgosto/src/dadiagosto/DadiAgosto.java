/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dadiagosto;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javafx.animation.Animation;
import javafx.animation.Transition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author sofia
 */
public class DadiAgosto extends Application {
    
    List numeroDadi = new LinkedList();
    List tuttiDadi = new LinkedList();
    int tot = 0;
    int punt = 30;
    final TextField totale= new TextField();
    final TextField punteggio = new TextField();
    final Button spostDissol = new Button();
    final GridPane gp = new GridPane();
    int r = 0;
    int c = 0;
    Button nuovaPartita = new Button();
    Button stampa = new Button();
    
    @Override
    public void start(Stage primaryStage) {
        
        nuovaPartita.setText("Nuova partita");
        nuovaPartita.setId("NuovaPartita");
        stampa.setText("Stampa");
        stampa.setId("Stampa");
        spostDissol.setText("Spostamento");
        spostDissol.setId("Spost/Dissol");
        totale.setText("TOTALE: "+tot);
        punteggio.setText("PUNTEGGIO: "+punt);
        //Scatole bottoni
        HBox top = new HBox();
        HBox bottom = new HBox();
        top.getChildren().addAll(nuovaPartita,stampa,spostDissol);
        bottom.getChildren().addAll(totale, punteggio);
        //griglia
        gp.setMinSize(300, 300);
        gp.setMaxSize(300, 300);
        gp.setOpacity(1);
        gp.setStyle("-fx-background-color: #00ff00;");
        //gp.setGridLinesVisible(true);
        
        nuovaPartita();        
        
        BorderPane bp = new BorderPane();
        bp.setTop(top);
        bp.setCenter(gp);
        bp.setBottom(bottom);
        BorderPane.setAlignment(top, Pos.CENTER);
        BorderPane.setAlignment(bottom, Pos.CENTER);
        BorderPane.setAlignment(gp, Pos.CENTER);
        
        
        spostDissol.setOnAction(new EventHandler<ActionEvent>() {
          @Override
         public void handle(ActionEvent event) {
               if ("Spostamento".equals(spostDissol.getText()) )
                       spostDissol.setText("Dissolvimento");
               else spostDissol.setText("Spostamento");
           }
        });
        
        //Buttons EventHandler        
        EventHandler eH = new EventHandler(){           
           @Override
           public void handle(Event event) {
               Object causante = event.getTarget();
               if(causante instanceof Button){
                   switch (((Button) causante).getId()) {
                       case "NuovaPartita":
                           nuovaPartita();   
                       break;
                       case "Stampa":
                           stampa(numeroDadi,tot,punt);
                       break;
                   }
               }
               else {
                 System.err.println("Errore");
                 System.exit(1);
               }
           }
           
        };
        nuovaPartita.addEventHandler(ActionEvent.ACTION,eH);
        stampa.addEventHandler(ActionEvent.ACTION,eH);
        
        //keyeventhandler        
        EventHandler<KeyEvent> eHTastiera = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode() == KeyCode.N) {
                    nuovaPartita.fireEvent(new ActionEvent());
                    System.out.println(keyEvent.getSource()
                            +" => "+keyEvent.getTarget());
                }
                else if (keyEvent.getCode() == KeyCode.S){
                    stampa.fireEvent(new ActionEvent());
                    System.out.println(keyEvent.getSource()
                            +" => "+keyEvent.getTarget());
                }
            }
        };
        
        StackPane root = new StackPane();
        root.getChildren().addAll(bp);  
        Scene scene = new Scene(root, 400, 400);
        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, eHTastiera); 
        primaryStage.setTitle("Esame Agosto con i dadi");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    void vittoria(int punt){
        Text messaggioVittoria = new Text();
        messaggioVittoria.setText("Hai vinto - Hai ottenuto " + punt + " punti");
        StackPane root = new StackPane();
        root.getChildren().addAll(messaggioVittoria);
        Scene scene = new Scene(root, 250, 100);
        Stage stageVittoria = new Stage();
        stageVittoria.setTitle("Vittoria");
        stageVittoria.setScene(scene);
        stageVittoria.show();
    }
    
    void stampa(List numeroDadi,int tot, int punt){
        TextArea testo = new TextArea();
        Iterator iter = numeroDadi.iterator();
        int i = 0;
        while(iter.hasNext()){
            Dado d = (Dado) iter.next();
            testo.appendText("\nDado " + ++i + ": " + d.getValue());
        }
        testo.appendText("\nTotale: " + tot);
        testo.appendText("\nPunteggio: " + punt);
        StackPane root = new StackPane();
        root.getChildren().addAll(testo);
        Scene scene = new Scene(root, 250, 200);
        Stage stageVittoria = new Stage();
        stageVittoria.setTitle("Riepilogo");
        stageVittoria.setScene(scene);
        stageVittoria.show();
    }
    void nuovaPartita(){
        if (!(gp.getChildren().isEmpty())){
            final Iterator iter = numeroDadi.iterator();
            while(iter.hasNext()){
                final Dado dado = (Dado) iter.next();
                
                final int randomX = (int) (Math.random()*10)-5;
                final int randomY = (int) (Math.random()*10)-5;
                
                //animazione...
                final Animation animation = new Transition() { 
                    { setCycleDuration(Duration.millis(2000)); } 
                    @Override
                    protected void interpolate(double frac) {
                        if (spostDissol.getText().equals("Dissolvimento")){
                            dado.setOpacity(1-frac); 
                        }
                        else{
                            int dx = 2;
                            int dy = 2;
                            dado.setTranslateX(dado.getTranslateX() + randomX*dx);
                            dado.setTranslateY(dado.getTranslateY() + randomY*dy);
                        }
                    }
                };
                animation.setOnFinished(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent t) {
                            riempiGridPane();
                        }
                });
                animation.play();
            }
        }
        else{
            riempiGridPane();
        }
    }
    
    void riempiGridPane(){
        if (!(gp.getChildren().isEmpty())){
            gp.getChildren().removeAll(tuttiDadi);
            tuttiDadi.clear();
            numeroDadi.clear();
            punt = 30;
            tot = 0;
            totale.setText("TOTALE: "+tot);
            punteggio.setText("PUNTEGGIO: "+punt);
        }
        //////////Riempio gridpane***********************************************
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                int random = (int) ((Math.random()*100)%6)+1;
                Dado d = new Dado(random);
                tuttiDadi.add(d);
                d.setOpacity(0);
                d.addEventFilter(Event.ANY, new EventHandler() {
                    @Override
                    public void handle(Event t) {
                        if (t.getEventType().getName().equals("MOUSE_CLICKED")) {
                            
                            Dado n = (Dado) t.getSource();
                            if(n.getOpacity()==1) {
                                tot = tot - n.getValue();
                                n.cambia((int) ((Math.random()*100)%6)+1);
                                tot = tot + n.getValue();
                                punt = punt - 1;
                            }
                            else if (numeroDadi.size() < 5){
                                numeroDadi.add(n);
                                n.setOpacity(1);
                                n.cambia((int) ((Math.random()*100)%6)+1);
                                tot = tot + n.getValue();
                                punt = punt - 3;
                            }
                            
                            totale.setText("TOTALE: "+tot);
                            punteggio.setText("PUNTEGGIO: "+punt);
                            if(tot==15)
                                vittoria(punt);
                            
                        }
                    };
                });
                gp.add(d, i, j);
            }
        }
        //////////Riempio gridpane***********************************************
    }   

}
