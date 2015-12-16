/*
 * Creare un'applicazione che mostri una finestra
 * (che all'inizio deve avere dimensioni 
 * 500*300) contenente tre controlli scorrevoli,
 * un'area colorata, un pulsante e descrizioni opportune. 
 * I tre selettori devono essere associati ai tre valori
 * rosso, verde e blu del modello di colori RGB.
 * L'area colorata deve visualizzare in ogni momento il
 * colore determinato dalla combinazione dei tre valori. 
 * Un clik sul pulsante deve riportare la finestra allo
 * stato corrispondente al colore nero
 */

package areacolorata;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.*;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author sofia.chimirri
 */
public class AreaColorata extends Application {
   //variabili associati a rgb
   int rossoVal = 0;
   int bluVal = 0;
   int verdeVal = 0;
    
    @Override
    public void start(Stage primaryStage) {
        //scatolone
        BorderPane bp = new BorderPane();
        HBox parteSopra = new HBox();
        GridPane selettori = new GridPane();
        VBox parteBassa = new VBox();
        
        //tre slider
        final mySlider rosso = new mySlider();
        ((mySlider) rosso).setId("rosso");
        final Label rossoCaption = new Label("Rosso:");
                
        final mySlider blu = new mySlider();
        ((mySlider) blu).setId("blu");
        final Label bluCaption = new Label("Blu:");
        
        final mySlider verde = new mySlider();
        ((mySlider) verde).setId("verde");
        final Label verdeCaption = new Label("Verde:");
        
        //rettangolo da colorare
        final Rectangle rec = new Rectangle(100,100,Color.BLACK);
        
        //inserimento nelle sctaole
        selettori.add(rossoCaption,0,0);
        selettori.add(rosso,1,0);
        selettori.add(bluCaption,0,1);
        selettori.add(blu,1,1);
        selettori.add(verdeCaption,0,2);
        selettori.add(verde,1,2);
        ColumnConstraints column1 = new ColumnConstraints(100);
        ColumnConstraints column2 = new ColumnConstraints(150);
        selettori.getColumnConstraints().addAll(column1,column2);
        
        selettori.setPadding(new Insets(20,20,20,20));
        
        parteSopra.getChildren().addAll(selettori,rec);
        parteSopra.setSpacing(20);
        parteSopra.setPadding(new Insets(20,20,20,20));
       
        Button nera = new Button();
        nera.setText("Riporta a colore nero");
        parteBassa.getChildren().add(nera);
        parteBassa.setSpacing(20);
        parteBassa.setPadding(new Insets(20,20,20,20));
        
        bp.setCenter(parteSopra);
        bp.setBottom(parteBassa);
        BorderPane.setAlignment(parteSopra, Pos.CENTER);
        BorderPane.setAlignment(parteBassa, Pos.TOP_CENTER);
        
        //Slider Listener
        ChangeListener<Number> qq = new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable,
                                Number old_val, Number new_val)
            {    
               verdeVal = (int) verde.getValue();
               rossoVal = (int) rosso.getValue();
               bluVal = (int) blu.getValue();
               rec.setFill(Color.rgb(rossoVal, verdeVal, bluVal));
            }
        };
        
        rosso.valueProperty().addListener(qq);
        blu.valueProperty().addListener(qq);
        verde.valueProperty().addListener(qq);
        
        //Button EventHandler        
        EventHandler eH = new EventHandler(){           
           @Override
           public void handle(Event event) {
               Object causante = event.getSource();
               if(causante instanceof Button){
                   rec.setFill(BLUE);
                   rosso.adjustValue(0);
                   blu.adjustValue(0);
                   verde.adjustValue(0);
               }
               else {
                 System.err.println("Errore");
                 System.exit(1);
               }
           }
           
        };
        nera.addEventHandler(ActionEvent.ACTION,eH);
        
        //Mostro finestra
        StackPane root = new StackPane();
        root.getChildren().add(bp);
        Scene scene = new Scene(root, 500, 300);
        primaryStage.setTitle("Combinazione colori rosso, blu, verde");
        primaryStage.setScene(scene);
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
