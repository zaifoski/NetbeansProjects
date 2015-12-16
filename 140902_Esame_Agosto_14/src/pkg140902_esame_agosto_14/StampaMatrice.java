/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkg140819_esame_giugno14;

import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author sofia.chimirri
 */
public class StampaMatrice {
    
    private int dimgriglia;
    private Circle mat[][];
    
    public StampaMatrice(){}
    
    public StampaMatrice(int dimgriglia, Circle mat[][]){
        this.dimgriglia = dimgriglia;
        this.mat = mat;
    }
    
    public void stampaMatrice(){
        //stampa a finestra
        String s="";
        for(int i = 0; i<dimgriglia; i++){
            for(int j = 0; j<dimgriglia; j++){
                if((mat[j][i].getOpacity()) == 0)
                    s+="0";
                else
                    s+="1";
            }
            s+="\n";
        }
        Text t = new Text();
        t.setText(s);
        HBox root = new HBox();
        root.getChildren().add(t);  
        Stage matriceStage = new Stage();
        matriceStage.setTitle("Matrice");
        matriceStage.setScene(new Scene(root, 400, 470));
        matriceStage.show();
    }
}
