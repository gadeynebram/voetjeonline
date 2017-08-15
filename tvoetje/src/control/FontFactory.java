/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bram Gadeyne
 */
public class FontFactory {
    private static FontFactory factory;
    public enum Fonts{
        DEFAULT, RAAMSCHRIFT, HEADER
    }

    private FontFactory()
    {
    }

    public static FontFactory getInstance()
    {
        if(factory==null)
        {
            factory=new FontFactory();
        }
        return factory;
    }

    public Font getFont(Fonts fontname)
    {
        Font font = Font.decode(Font.DIALOG + "-" + Font.PLAIN);
        try {
            switch (fontname) {
                case RAAMSCHRIFT:
                    font = Font.createFont(Font.TRUETYPE_FONT, this.getClass().getResourceAsStream("/resources/VRaam.TTF")).deriveFont(14f);
                    break;
                case HEADER:
                    font=font.deriveFont(24f);
                    break;
            }
            
        } catch (FontFormatException ex) {
            Logger.getLogger(FontFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FontFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return font;
    }
}
