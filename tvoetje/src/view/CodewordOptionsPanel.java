/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.awt.Color;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JLabel;
import javax.swing.JTextField;
import model.CodewordCoder;

/**
 *
 * @author bram
 */
public class CodewordOptionsPanel extends IOptionsPanel {
    
    JTextField codewordField;

    public CodewordOptionsPanel() {
        super();
        codewordField=new JTextField();
        addControls();
    }

    private void addControls()
    {
        JLabel label=new JLabel(CodewordCoder.codeword);
        label.setForeground(Color.WHITE);

        this.add(label);

        codewordField.setColumns(13);
        this.add(codewordField);
        this.revalidate();
        this.validate();
    }

    @Override
    public HashMap<String, String> getOptionValues() {
        HashMap<String, String> hm=new HashMap<String, String>();
        hm.put(CodewordCoder.codeword, codewordField.getText());
        return hm;
    }

    @Override
    public String validateOptions() {
        String error= super.validateOptions();
        String codewoord=codewordField.getText();
        HashSet<Character> set=new HashSet<Character>();
        boolean found=false;
        for(char x: codewoord.toCharArray())
        {
            if(!set.contains(x))
            {
                set.add(x);
            }else{
                found=true;
            }
        }
        if(found)
            error+="Het codewoord moet uit unieke karakters bestaan.\n";
        if(codewoord.length()>13 || found)
            error+="Het codewoord mag maximum uit 13 karakters bestaan.\n";
        if(codewoord.length()==0)
            error+="Gelieve een codewoord in te vullen.\n";

        return error;
    }

    


}
