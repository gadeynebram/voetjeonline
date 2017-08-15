/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.awt.Color;
import java.util.HashMap;
import javax.swing.JLabel;
import javax.swing.JTextField;
import model.JaartalCoder;

/**
 *
 * @author bram
 */
public class JaartalOptionsPanel extends IOptionsPanel {

    JTextField jaartalField;

    public JaartalOptionsPanel() {
        super();
        addControls();
    }

     private void addControls()
    {
        JLabel label=new JLabel(JaartalCoder.JAARTAL);
        label.setForeground(Color.WHITE);

        this.add(label);

        jaartalField=new JTextField();
        jaartalField.setColumns(13);
        this.add(jaartalField);
        this.revalidate();
        this.validate();
    }

    @Override
    public HashMap<String, String> getOptionValues() {
        HashMap<String, String> options=new HashMap<String, String>();
        options.put(JaartalCoder.JAARTAL, jaartalField.getText());
        return options;
    }

    @Override
    public String validateOptions() {
         String error=super.validateOptions();
         try{
             Integer.parseInt(jaartalField.getText());
             if(jaartalField.getText().contains("0"))
             {
                 error+="Het jaartal mag geen nullen bevatten.\n";
             }
             if(jaartalField.getText().length()==0)
             {
                 error+="Gelieve een jaartal in te vullen op het linker paneel.\n";
             }
         }catch(NumberFormatException nfex)
         {
             error+="Het ingevulde jaartal moet een nummer zijn \n";
         }

         return error;
    }

    



}
