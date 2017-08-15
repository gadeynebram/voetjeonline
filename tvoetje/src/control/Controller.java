/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package control;

import java.util.HashMap;
import model.ICoder;
import view.VoetjeApplet;

/**
 *
 * @author bram
 */
public class Controller {
    private static Controller controller;
    private CoderFactory factory;
    private ICoder coder;

    private Controller()
    {
        factory=CoderFactory.getInstance();
    }

    public static Controller getInstance()
    {
        if(controller==null)
        {
            controller=new Controller();
        }
        return controller;
    }

    public void setCoder(String name, VoetjeApplet applet) throws Exception
    {
        coder = factory.getCoder(name);             //set the selected coder
        applet.setFontType(FontFactory.getInstance().getFont(coder.getFont()));
        applet.setOptionPanel(name);  //construct the optionspanel in the view
    }

    public String doCode(HashMap<String, String> options,String text)
    {
        coder.setOptions(options); //first set the options required for a coder.
        return coder.code(text);   //code the text and return it.
    }

    public String doDecode(HashMap<String, String> options, String text)
    {
        coder.setOptions(options);
        return coder.decode(text);
    }

}
