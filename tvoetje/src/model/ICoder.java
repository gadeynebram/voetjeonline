/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import control.FontFactory.Fonts;
import java.util.HashMap;

/**
 * this interface declares a Coder. every coder must be able to code and decode a String message.
 * Some require additional options or Fonts.
 * @author Bram Gadeyne
 */
public abstract class ICoder {
    /**
     * This method codes the String to its new representation
     * @param s an inputString
     * @return  The coded version of inputString
     */
    public String code(String s)
    {
        return "Not yet supported";
    }

    /**
     * This method decodes a coded String
     * @param d A coded String
     * @return  The decoded String
     */
    public String decode(String d){
        return "Not yet supported";
    }

    /**
     * Additional options may be set by a HashMap.
     * By Default this method does nothing.
     * @param options   additional options
     */
    public void setOptions(HashMap<String,String> options){
    }

    /**
     * Some different default Font can be chosen for this coding method
     * @return The default font.
     */
    public Fonts getFont()
    {
        return Fonts.DEFAULT;
    }
}
