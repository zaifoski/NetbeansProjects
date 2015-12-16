/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package figurageometrica;

/**
 *
 * @author sofia.chimirri
 */
public class Dati {
    protected String tipo;
    protected float larghezzaVal;
    protected float spessorePerimetroVal;
    
    public Dati(){
    }
    
    public Dati(String tipo,float larghezzaVal,float spessorePerimetroVal){
        this.tipo=tipo;
        this.larghezzaVal=larghezzaVal;
        this.spessorePerimetroVal=spessorePerimetroVal;
    }
    @Override
    public String toString(){
        return "Disegnato un " + tipo + " largo " + larghezzaVal + " con perimetro spesso " + spessorePerimetroVal;
    }
    
}
