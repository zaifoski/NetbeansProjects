/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package areacolorata;

/**
 *
 * @author sofia.chimirri
 */
public class mySlider extends javafx.scene.control.Slider {
    public mySlider(){    
        super(0,255,0);
        setShowTickMarks(true);
        setShowTickLabels(true);
        setSnapToTicks(true);
        setBlockIncrement(1f);
        setMajorTickUnit(100);
        setMinorTickCount(5);
    }
        
}
