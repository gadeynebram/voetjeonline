/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

/**
 *
 * @author bram
 */
public class WindroosCoder extends ICoder {

    HashMap<Character,String> charToCode;
    HashMap<String,Character> codeToChar;

    public WindroosCoder() {
        initMaps();
    }

    private void initMaps()
    {
        charToCode=new HashMap<Character, String>();
        charToCode.put('a',"NNNO");
        charToCode.put('b',"NONNO");
        charToCode.put('c',"NOONO");
        charToCode.put('d',"OONO");
        charToCode.put('e',"OOZO");
        charToCode.put('f',"ZOOZO");
        charToCode.put('g',"ZOZZO");
        charToCode.put('h',"ZZZO");
        charToCode.put('i',"ZZZW");
        charToCode.put('j',"ZWZZW");
        charToCode.put('k',"ZWWZW");
        charToCode.put('l',"WWZW");
        charToCode.put('m',"WWNW");
        charToCode.put('n',"NWWNW");
        charToCode.put('o',"NWNNW");
        charToCode.put('p',"NNNW");
        charToCode.put('q',"NNN0*");
        charToCode.put('r',"NONNO*");
        charToCode.put('s',"NOONO*");
        charToCode.put('t',"OONO*");
        charToCode.put('u',"OOZO*");
        charToCode.put('v',"ZOOZO*");
        charToCode.put('w',"ZOZZO*");
        charToCode.put('x',"ZZZO*");
        charToCode.put('y',"ZZZW*");
        charToCode.put('z',"ZWZZW*");

        int aval=(int)'a';
        int i=0;
        codeToChar=new HashMap<String, Character>();
        while(i<26)
        {
            codeToChar.put(charToCode.get((char)(aval+i)), (char)(aval+i));
            i++;
        }
    }

    @Override
    public String code(String s) {
        char[] input=s.toLowerCase().toCharArray();
        String output="";
        for(int i=0;i<input.length;i++)
        {
            if(charToCode.containsKey(input[i]))
            {
                output+=charToCode.get(input[i])+"/";
            }else{
                output+=input[i]+"/";
            }
        }
        return output;
    }

    @Override
    public String decode(String d) {
        String[] parts=d.split("/");
        String output="";
        for(int i=0;i<parts.length;i++)
        {
            if(codeToChar.containsKey(parts[i]))
            {
                output+=codeToChar.get(parts[i]);
            }else{
                output+=parts[i];
            }
            //output+=parts[i]+":";
        }
        return output;
    }
}
