/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author bram
 */
public abstract class IOptionsPanel extends JPanel {

    public IOptionsPanel()
    {
        this.setPreferredSize(new Dimension(200,250));
        this.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, Color.LIGHT_GRAY));
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setBackground(new java.awt.Color(32, 104, 37));
    }

    public HashMap<String,String> getOptionValues()
    {
        return new HashMap<String, String>();
    }

    public String validateOptions()
    {
        return "";
    }
}
