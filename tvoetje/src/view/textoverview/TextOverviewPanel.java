/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package view.textoverview;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.SecretKeeper;

/**
 *
 * @author bram
 */
public class TextOverviewPanel extends JPanel{

    private JLabel title;

    List<SecretKeeper> secretList;

    public TextOverviewPanel() {
        this.setLayout(new FlowLayout());
        this.setPreferredSize(new Dimension(200,400));
        this.setBackground(new java.awt.Color(32, 104, 37));
        title=new JLabel("texts:");
        this.add(title);
        secretList = new ArrayList<SecretKeeper>();
    }

    public List<SecretKeeper> getSecrets(){
        return secretList;
    }

    public void clearList(){
        secretList.clear();
    }

    public void addSecret(SecretKeeper secret){
        secretList.add(secret);
    }

    public void renewSecrets(){
        this.removeAll();
        this.add(title);
        for(SecretKeeper keeper:secretList){
            JButton button=new JButton(keeper.toString());
            this.add(button);
        }
    }



}
