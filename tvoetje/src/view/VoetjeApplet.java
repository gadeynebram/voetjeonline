/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.Iterator;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import control.CoderFactory;
import control.Controller;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.ScrollPane;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JTextArea;
import model.PDFCreator;
import model.SecretKeeper;
import view.textoverview.TextOverviewPanel;

/**
 *
 * @author Bram Gadeyne
 */
public class VoetjeApplet extends JApplet {

    /**
     * Initialization method that will be called after the applet is loaded
     * into the browser.
     */

    private CoderFactory factory;
    private Controller controller;

    public static final String NORMALFONT="";


    private JPanel head;
    private JPanel left;
    private JPanel center;
    private TextOverviewPanel right;

    private JPanel choisePanel;
    private JPanel optionsPanel;

    private JPanel invoerPanel;
    private JPanel uitvoerPanel;

    private JButton codeerButton;
    private JButton decodeerButton;
    private JButton pdfButton;

    private JTextArea codedTextField;
    private JTextArea uncodedTextField;

    private JComboBox codeCombobox;

    @Override
    public void init() {
        factory=CoderFactory.getInstance();
        controller=Controller.getInstance();
        initComponents();
        setComboboxItems();
    }

    private void initComponents()
    {
        //init headpanel met image of label
        Image img=null;
        this.setSize(new Dimension(700,500));
        try {
            img = ImageIO.read(this.getClass().getResource("/resources/geheimschrijverhead.jpg"));
        } catch (IOException ioex) {
            //headimage niet geladen.
        }
        if(img!=null)
        {
            head=new ImagePanel(img);
            
        }else{
            head=new JPanel();
            head.setLayout(new FlowLayout(FlowLayout.LEFT));
            head.setBackground(new java.awt.Color(32, 104, 37));
            JLabel headLabel=new JLabel("geheimschrijver");
            headLabel.setFont(new java.awt.Font(null, 0, 48));
            headLabel.setForeground(new java.awt.Color(254, 254, 254));
            head.add(headLabel);
        }
        head.setPreferredSize(new Dimension(700,100));
        head.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.LIGHT_GRAY));
        
        right=new TextOverviewPanel();

        left=new JPanel();
        left.setLayout(new BorderLayout());
        left.setPreferredSize(new Dimension(200,400));
        left.setBackground(new java.awt.Color(32, 104, 37));

        codeerButton=new JButton("codeer");
        codeerButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                codeButtonActionPerformed(e);
            }
        });

        decodeerButton=new JButton("decodeer");
        decodeerButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                decodeButtonActionPerformed(e);
            }
        });
        
        codeCombobox=new JComboBox();
        codeCombobox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                codeComboboxActionPerformed(e);
            }
        });

        pdfButton=new JButton("PDF");
        pdfButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pdfButtonActionPerformed(e);
            }
        });

        choisePanel=new JPanel();
        choisePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        choisePanel.setBackground(new java.awt.Color(32, 104, 37));
        JLabel codeerLabel=new JLabel("codeermethode");
        codeerLabel.setForeground(Color.WHITE);
        choisePanel.add(codeerLabel);
        choisePanel.add(codeCombobox);
        choisePanel.add(codeerButton);
        choisePanel.add(decodeerButton);
        choisePanel.add(pdfButton);


        optionsPanel=new NoOptionsPanel();

        left.add(choisePanel,BorderLayout.CENTER);
        left.add(optionsPanel, BorderLayout.PAGE_END);

        codedTextField=new JTextArea();
        uncodedTextField=new JTextArea();
        
        invoerPanel=new JPanel();
        invoerPanel.setBackground(new java.awt.Color(32, 104, 37));
        invoerPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "invoer", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(254, 254, 254)));
        invoerPanel.setLayout(new GridLayout(1,0));
        ScrollPane scrollpane=new ScrollPane();
        scrollpane.add(uncodedTextField);
        invoerPanel.add(scrollpane);


        uitvoerPanel=new JPanel();
        uitvoerPanel.setBackground(new java.awt.Color(32, 104, 37));
        uitvoerPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "uitvoer", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(254, 254, 254)));
        uitvoerPanel.setLayout(new GridLayout(1,0));
        scrollpane=new ScrollPane();
        scrollpane.add(codedTextField);
        uitvoerPanel.add(scrollpane);


        center=new JPanel();
        center.setPreferredSize(new Dimension(500,400));
        center.setBackground(new java.awt.Color(32, 104, 37));
        center.setBorder(BorderFactory.createMatteBorder(0, 2, 0, 0, Color.LIGHT_GRAY));
        center.setLayout(new GridLayout(2,1));

        center.add(invoerPanel);
        center.add(uitvoerPanel);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(head, BorderLayout.PAGE_START);
        getContentPane().add(left, BorderLayout.LINE_START);
        getContentPane().add(center,BorderLayout.CENTER);
        getContentPane().add(right, BorderLayout.LINE_END);
    }

    private void setComboboxItems() {
        codeCombobox.removeAllItems();
        Iterator<String> it=factory.getCodernames().iterator();
        while(it.hasNext())
        {
            codeCombobox.addItem(it.next());
        }
        try {
            controller.setCoder((String) codeCombobox.getItemAt(0),this);
        } catch (Exception ex) {
            uncodedTextField.setText(ex.getMessage());
        }
    }

    public void setOptionPanel(String name) {
        left.remove(optionsPanel);
        optionsPanel=factory.getOptionsPanelByName(name);
        optionsPanel.setVisible(true);
        left.add(optionsPanel,BorderLayout.PAGE_END);
        getContentPane().validate();
        getContentPane().repaint();
    }

    private void codeComboboxActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            //codedTextField.setText("");
            //uncodedTextField.setText("");
            controller.setCoder((String) codeCombobox.getSelectedItem(),this);
            //uncodedTextField.setText("changed panel to " + optionsPanel.getClass().toString());
        } catch (Exception ex) {
            uncodedTextField.setText(ex.getMessage());
        }
    }

    private void codeButtonActionPerformed(java.awt.event.ActionEvent evt) {
        IOptionsPanel optionsPanelImpl=(IOptionsPanel)optionsPanel;
        String error=optionsPanelImpl.validateOptions();
        
        if(error.equals(""))
        {
            String uncoded=uncodedTextField.getText();
            String coder=(String) codeCombobox.getSelectedItem();
            SecretKeeper keeper=new SecretKeeper(uncoded, coder);
            if(optionsPanelImpl.getOptionValues()!=null){
                keeper.setOptions(optionsPanelImpl.getOptionValues());
            }
            right.addSecret(keeper);
            right.renewSecrets();
            
            try
            {
                String codedText=controller.doCode(((IOptionsPanel)optionsPanel).getOptionValues(),uncoded);

                codedTextField.setText(codedText);
                //codedTextField.setText(String.valueOf(codedTextField.getFont().getSize()));
            }catch(Exception e)
            {
                codedTextField.setText(e.getMessage());
            }
        }else{
            codedTextField.setText("An error occured: "+error);
        }
       

    }

    private void decodeButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String uncoded=uncodedTextField.getText();
        try
        {
            codedTextField.setText(controller.doDecode(((IOptionsPanel)optionsPanel).getOptionValues(),uncoded));
        }catch(Exception e)
        {
            codedTextField.setText(e.getMessage());
        }
    }

    private void pdfButtonActionPerformed(ActionEvent evt){
        //Frame parent=new Frame();
        //FileDialog dialog=new FileDialog(parent,"select file location", FileDialog.SAVE);
        //dialog.setVisible(true);
        //String location=dialog.getDirectory()+File.separator+dialog.getFile();
        PDFCreator.getInstance().createPDF("/home/bram/Bureaublad/test.pdf", right.getSecrets());
    }

    public void setFontType(Font font)
    {
        codedTextField.setText("");
        codedTextField.setFont(font);
    }

    @Override
    public void start() {
        super.start();
    }

    @Override
    public void stop() {
        super.stop();
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
