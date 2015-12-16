/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkg140902_esame_agosto_14;

import java.util.Iterator;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author Berta
 */
public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn1 = new Button();
        btn1.setText("Nuova partita");
        btn1.setId("NuovaPartita");
        Button btn2 = new Button();
        btn2.setText("Stampa");
        btn2.setId("Stampa");
        Button btn3 = new Button();
        btn3.setText("Spostamento");
        btn3.setId("Spost/Dissol");
        TextField totale= new TextField();
        totale.setText("TOTALE");
        TextField punteggio = new TextField();
        punteggio.setText("PUNTEGGIO");
        //Scatole bottoni
        HBox top = new HBox();
        HBox bottom = new HBox();
        top.getChildren().addAll(btn1,btn2,btn3);
        bottom.getChildren().addAll(totale, punteggio);
        //griglia
        final GridPane gp = new GridPane();
        gp.setMaxSize(300, 300);
        gp.setMinSize(300, 300);
        gp.setOpacity(0);
        gp.setGridLinesVisible(true);
        gp.setHgap(3);
        gp.setVgap(3);
        BorderPane bp = new BorderPane();
        bp.setTop(top);
        bp.setCenter(gp);
        bp.setBottom(bottom);
        BorderPane.setAlignment(top, Pos.CENTER);
        BorderPane.setAlignment(bottom, Pos.CENTER);
        BorderPane.setAlignment(gp, Pos.CENTER);
        
        
        btn3.setOnAction(new EventHandler<ActionEvent>() {
            
          @Override
         public void handle(ActionEvent event) {
               if (btn3.getText()=="Spostamento" )
                       btn3.setText("Dissolvimento");
               else btn3.setText("Spostamento");
           }
        });
        
        StackPane root = new StackPane();
        root.getChildren().addAll(bp);
        
        Scene scene = new Scene(root, 400, 400, Color.PINK);
        
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
    
}
