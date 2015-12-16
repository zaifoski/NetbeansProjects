/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dadiagosto;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.shape.Circle;

/**
 *
 * @author sofia
 */
public class Dado extends GridPane {
    
    //GridPane dadino = new GridPane();
    int DIMCERCHIO = 5;
    private int val;
    
    public Dado(){}
    
    Dado(int val){
        
        this.val = val;
        for (int i = 0; i < 3; i++) {
            ColumnConstraints column = new ColumnConstraints(9);
            RowConstraints row = new RowConstraints(9);
            this.getColumnConstraints().add(column);
            this.getRowConstraints().add(row);
        }        
        
        this.setStyle("-fx-border: 1px solid #000000;");
        this.setMinSize(30, 30);
        this.setMaxSize(30, 30);
        nuovoValore(val);
        
    }
    
    int getValue(){
        return val;
    }
    
    void cambia(int val){
        this.getChildren().clear();
        nuovoValore(val);
    }
    
    private void nuovoValore(int val){
        
        this.val=val;
        
        //if(!(this.getChildren().isEmpty()))
        //    this.getChildren().clear();
        
        this.setStyle("-fx-background-color: #ffffff;"
                + "-fx-border-width: 1px;"
                + "-fx-border-style: solid;"
                + "-fx-border-color: #000000;");
        
        switch(val){
                    case 1: 
                        this.add(new Circle(DIMCERCHIO/2,DIMCERCHIO,DIMCERCHIO),1,1);
                        break;
                    case 2: 
                        this.add(new Circle(DIMCERCHIO/2,DIMCERCHIO,DIMCERCHIO),0,0);
                        this.add(new Circle(DIMCERCHIO/2,DIMCERCHIO,DIMCERCHIO),2,2);
                        break;
                    case 3: 
                        this.add(new Circle(DIMCERCHIO/2,DIMCERCHIO,DIMCERCHIO),0,0);
                        this.add(new Circle(DIMCERCHIO/2,DIMCERCHIO,DIMCERCHIO),2,2);
                        this.add(new Circle(DIMCERCHIO/2,DIMCERCHIO,DIMCERCHIO),1,1);
                        break;
                    case 4: 
                        this.add(new Circle(DIMCERCHIO/2,DIMCERCHIO,DIMCERCHIO),0,0);
                        this.add(new Circle(DIMCERCHIO/2,DIMCERCHIO,DIMCERCHIO),2,2);
                        this.add(new Circle(DIMCERCHIO/2,DIMCERCHIO,DIMCERCHIO),2,0);
                        this.add(new Circle(DIMCERCHIO/2,DIMCERCHIO,DIMCERCHIO),0,2);
                        break;
                    case 5: 
                        this.add(new Circle(DIMCERCHIO/2,DIMCERCHIO,DIMCERCHIO),1,1);
                        this.add(new Circle(DIMCERCHIO/2,DIMCERCHIO,DIMCERCHIO),0,0);
                        this.add(new Circle(DIMCERCHIO/2,DIMCERCHIO,DIMCERCHIO),2,2);
                        this.add(new Circle(DIMCERCHIO/2,DIMCERCHIO,DIMCERCHIO),2,0);
                        this.add(new Circle(DIMCERCHIO/2,DIMCERCHIO,DIMCERCHIO),0,2);
                        break;
                    case 6: 
                        this.add(new Circle(DIMCERCHIO/2,DIMCERCHIO,DIMCERCHIO),0,0);
                        this.add(new Circle(DIMCERCHIO/2,DIMCERCHIO,DIMCERCHIO),1,0);
                        this.add(new Circle(DIMCERCHIO/2,DIMCERCHIO,DIMCERCHIO),2,0);
                        this.add(new Circle(DIMCERCHIO/2,DIMCERCHIO,DIMCERCHIO),2,2);
                        this.add(new Circle(DIMCERCHIO/2,DIMCERCHIO,DIMCERCHIO),1,2);
                        this.add(new Circle(DIMCERCHIO/2,DIMCERCHIO,DIMCERCHIO),0,2);
                        break;
                    default: System.out.println(val);break;
        }
    }
    
}
