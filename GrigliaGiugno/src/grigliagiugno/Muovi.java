/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package grigliagiugno;

import javafx.scene.shape.Circle;

/**
 *
 * @author sofia.chimirri
 */
public class Muovi {  
    
    private int dimgriglia;
    private Circle mat[][];
    
    public Muovi(){}
    
    public Muovi(int dimgriglia,Circle mat[][]){
        this.dimgriglia = dimgriglia;
        this.mat = mat;
    }
    
    public void muovi(int algScelto){
        switch(algScelto){
            case 1 : muoviDefault(); break;
            case 2 : muoviSx(); break;
            case 3 : muoviBasso(); break;
        }                           
    }
    
    public void muoviDefault(){
        for(int i = 0; i<dimgriglia; i++){
            for(int j = 0; j<dimgriglia; j++){
                if((mat[j][i].getOpacity()) == 1){
                    mat[j][i].setOpacity(0);
                    if(((j+1)<dimgriglia)&&((i-1)>=0)){
                        mat[j+1][i-1].setOpacity(1);
                    }
                }
            }
        }
    }
    
    public void muoviSx(){
        for(int i = 0; i<dimgriglia; i++){
            for(int j = 0; j<dimgriglia; j++){
                if((mat[j][i].getOpacity()) == 1){
                    mat[j][i].setOpacity(0);
                    if((j-1)>=0){
                        mat[j-1][i].setOpacity(1);
                    }
                }
            }
        }
    }
    
    public void muoviBasso(){
        for(int i = (dimgriglia-1); i>=0; i--){
            for(int j = 0; j<dimgriglia; j++){
                if((mat[j][i].getOpacity()) == 1){
                    mat[j][i].setOpacity(0);
                    if((i+1)<dimgriglia){
                        mat[j][i+1].setOpacity(1);
                    }
                }
            }
        }
    }
    
    
}
