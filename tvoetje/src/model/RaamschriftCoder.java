/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import control.FontFactory.Fonts;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bram
 */
public class RaamschriftCoder extends ICoder {
    //HashMap<Character, String> charToStringMap;
//    Font raamFont;

    public RaamschriftCoder() {
//        InputStream is=this.getClass().getResourceAsStream("/resources/VRaam.TTF");
//        try {
//            raamFont = Font.createFont(Font.TRUETYPE_FONT, is);
//        } catch (FontFormatException ex) {
//            Logger.getLogger(RaamschriftCoder.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(RaamschriftCoder.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    @Override
    public String code(String s) {
        return s;
    }

    @Override
    public String decode(String d) {
        return super.decode(d);
    }

    @Override
    public Fonts getFont() {
        return Fonts.RAAMSCHRIFT;
    }



    private void initMaps()
    {
        /*charToStringMap = new HashMap<Character, String>();
        charToStringMap.put('a', "_|");
        charToStringMap.put('b', "_|*");
        charToStringMap.put('c', "|_|");
        charToStringMap.put('d', "|_|*");
        charToStringMap.put('e', "|_");
        charToStringMap.put('f', "|_*");
        charToStringMap.put('g', "]");
        charToStringMap.put('h', "]*");
        charToStringMap.put('i', "[]");
        charToStringMap.put('j', "[]*");
        charToStringMap.put('k', "[");
        charToStringMap.put('l', "[*");
        charToStringMap.put('m', "-|");
        charToStringMap.put('n', "-|*");
        charToStringMap.put('o', "|-|");
        charToStringMap.put('p', "|-|*");
        charToStringMap.put('q', "|-");
        charToStringMap.put('r', "|-*");
        charToStringMap.put('s', "\\/");
        charToStringMap.put('t', "\\/*");
        charToStringMap.put('u', "<");
        charToStringMap.put('v', "<*");
        charToStringMap.put('w', "/\\");
        charToStringMap.put('x', "/\\*");
        charToStringMap.put('y', ">");
        charToStringMap.put('z', ">*");*/
    }

}
