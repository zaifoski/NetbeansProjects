/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package grigliagiugno;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author sofia.chimirri
 */
public class PartePrincipale {
    
    int algScelto = 1;
    List elems = new LinkedList();
    Circle mat[][];
    int dimgriglia;
    
    public PartePrincipale(int dimgriglia){
        this.dimgriglia = dimgriglia;
        partePrincipale();
    }
    
    private void partePrincipale(){
        mat = new Circle[dimgriglia][dimgriglia];
        
        Stage primaryStage = new Stage();
        
        //Buttons
        Button alg1 = new Button();
        alg1.setText("Alg.1");
        alg1.setId("alg1");
        Button alg2 = new Button();
        alg2.setText("Alg.2");
        alg2.setId("alg2");
        Button alg3 = new Button();
        alg3.setText("Alg.3");
        alg3.setId("alg3");
        Button print = new Button();
        print.setText("Print");
        print.setId("print");
        Button clear = new Button();
        clear.setText("Clear");
        clear.setId("clear");
        Button step = new Button();
        step.setText("Step");
        step.setId("step");
        Button start = new Button();
        start.setText("Start");
        start.setId("start");
        Button stop = new Button();
        stop.setText("Stop");
        stop.setId("stop");
        //Scatole bottoni
        HBox top = new HBox();
        HBox bottom = new HBox();
        top.getChildren().addAll(alg1,alg2,alg3);
        bottom.getChildren().addAll(print,clear,step,start,stop);
        //griglia
        final GridPane gp = new GridPane();
        gp.setGridLinesVisible(true);
        
        for(int i = 0; i<dimgriglia; i++){
            for(int j = 0; j<dimgriglia; j++){
                Circle circ = new Circle(20,20,20);
                circ.setFill(Color.GREEN);
                circ.setOpacity(0d);
                circ.addEventHandler(Event.ANY, new EventHandler() {
                    @Override
                    public void handle(Event t) {
                        new CambiaOpacita().cambiaOpacita(t);                                                                                                
                    }
                });
                gp.add(circ,i,j);
                elems.add(circ);
                mat[i][j] = circ;
            }
        }
        
        //totale layputs
        BorderPane bp = new BorderPane();
        bp.setTop(top);
        bp.setCenter(gp);
        bp.setBottom(bottom);
        BorderPane.setAlignment(top, Pos.CENTER);
        BorderPane.setAlignment(bottom, Pos.CENTER);
        BorderPane.setAlignment(gp, Pos.CENTER);
        
        //Animazione 1
        /*final Animation animation = new Transition() { 
            {
                setCycleDuration(Duration.millis(1000));
            } 
            @Override
            protected void interpolate(double frac) { 
                muovi(algScelto); 
                System.out.println(frac);
            } 
        }; */
        
        //Animazione 2
        final Timeline animation = new Timeline();
        animation.setCycleCount(100);//Animation.INDEFINITE);
        KeyFrame moveBall = new KeyFrame(Duration.seconds(1.00), new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        new Muovi(dimgriglia,mat).muovi(algScelto); 
                    }
                });
        animation.getKeyFrames().add(moveBall);
        
        //Buttons EventHandler        
        EventHandler eH = new EventHandler(){           
           @Override
           public void handle(Event event) {
               Object causante = event.getTarget();
               if(causante instanceof Button){
                   switch (((Button) causante).getId()) {
                       case "clear":
                           Iterator iter = elems.iterator();
                           while(iter.hasNext()){
                               Circle c = (Circle) iter.next();
                               c.setOpacity(0);
                           }   break;
                       case "print":
                           new StampaMatrice(dimgriglia,mat).stampaMatrice();
                           break;
                       case "alg1":
                           algScelto = 1;
                           break;
                       case "alg2":
                           algScelto = 2;
                           break;
                       case "alg3":
                           algScelto = 3;
                           break;
                       case "step":
                           new Muovi(dimgriglia,mat).muovi(algScelto);
                           break;
                       case "start":
                           animation.play();
                           break;
                       case "stop":
                           animation.stop();
                           break;
                   }
               }
               else {
                 System.err.println("Errore");
                 System.exit(1);
               }
           }
           
        };
        clear.addEventHandler(ActionEvent.ACTION,eH);
        print.addEventHandler(ActionEvent.ACTION,eH);
        step.addEventHandler(ActionEvent.ACTION,eH);
        alg1.addEventHandler(ActionEvent.ACTION,eH);
        alg2.addEventHandler(ActionEvent.ACTION,eH);
        alg3.addEventHandler(ActionEvent.ACTION,eH);
        start.addEventHandler(ActionEvent.ACTION,eH);
        stop.addEventHandler(ActionEvent.ACTION,eH);
        
        //mostro
        StackPane root = new StackPane();
        root.getChildren().add(bp);        
        //Scene scene = new Scene(root, 400, 470);
        Scene scene = new Scene(root);
        primaryStage.setTitle("Griglia");
        primaryStage.setScene(scene);
        
        primaryStage.show();
        
    }
}