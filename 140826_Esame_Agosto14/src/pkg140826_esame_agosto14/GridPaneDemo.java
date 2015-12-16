/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg140826_esame_agosto14;

import com.sun.glass.events.MouseEvent;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author ronchet
 */
public class GridPaneDemo extends Application {

    @Override
    public void start(Stage primaryStage) {
        final GridPane root = new GridPane();
        root.setHgap(10);
        root.setVgap(10);
        root.setAlignment(Pos.CENTER);
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                Circle c = new Circle(0, 0, 30);
                c.addEventHandler(Event.ANY, new EventHandler() {
                    @Override
                    public void handle(Event t) {
                        if (t.getEventType().getName().equals("MOUSE_CLICKED")) {
                        Node n = (Node) t.getTarget();
                        int r=GridPane.getRowIndex(n);
                        int c=GridPane.getColumnIndex(n);
                        root.getChildren().remove(n);
                        Rectangle rect=new Rectangle(0,0,60,60);
                        GridPane.setHalignment(rect, HPos.CENTER);
                        GridPane.setValignment(rect, VPos.CENTER);
                        root.add(rect, c, r);
                        }
                    }
                ;
                });
                root.add(c, i, j);
            }
        }

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
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
