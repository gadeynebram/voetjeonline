/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author bram
 */
public class JaartalCoder extends ICoder {
    private int[] jaartal;
    private int maxnumb;
    //private int totalsum;
    private ArrayList<ArrayList<Character> > codedlist;
    public static String JAARTAL="jaartal";

    public JaartalCoder() {
    }

    @Override
    public String code(String s) {
        s=s.replace(" ", "");
        codedlist=new ArrayList<ArrayList<Character>>();
        char[] karakters=s.toCharArray();
        int i=0;
        int k=0;
        while(i<karakters.length)
        {
            ArrayList<Character> kl=new ArrayList<Character>();
            int j=0;
            while(j<jaartal[k] && i<karakters.length)
            {
                kl.add(karakters[i]);
                i++;
                j++;
            }
            codedlist.add(kl);
            k++;
            k=k%jaartal.length;
        }
        String coded="";
        for(i=0; i<maxnumb;i++)
        {
            int j=0;
            while(j<codedlist.size())
            {
                ArrayList<Character> charlist=codedlist.get(j);
                if(i<charlist.size())
                {
                    coded+=charlist.get(i);
                }
                j++;
            }
        }
        return coded;
    }

    @Override
    public String decode(String d) {
        return super.decode(d);
    }

    /**
     * set jaartal integer array with jaartal value from view.
     * No check is needed for syntax of jaartal. JaartalPanel has done that for us.
     * @param options
     */
    @Override
    public void setOptions(HashMap<String, String> options) {
        if(options.containsKey(JAARTAL))
        {
            //totalsum=0;
            maxnumb=0;
            jaartal=new int[options.get(JAARTAL).length()];
            int getal=Integer.parseInt(options.get(JAARTAL));
            for(int i=jaartal.length-1;i>=0;i--)
            {
                jaartal[i]=getal%10;
                //totalsum+=jaartal[i];
                getal=getal/10;
                if(maxnumb<jaartal[i])
                    maxnumb=jaartal[i];
            }
        }
    }
}
