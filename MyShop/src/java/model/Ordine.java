/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author sofia
 */
public class Ordine {
    
    private int progressivo = -1;
    private String descrizione = null;

    /**
     * @return the progressivo
     */
    public int getProgressivo() {
        return progressivo;
    }

    /**
     * @param progressivo the progressivo to set
     */
    public void setProgressivo(int progressivo) {
        this.progressivo = progressivo;
    }

    /**
     * @return the descrizione
     */
    public String getDescrizione() {
        return descrizione;
    }

    /**
     * @param descrizione the descrizione to set
     */
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
    
}
