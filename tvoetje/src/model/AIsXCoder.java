/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.HashMap;

/**
 *
 * @author bram
 */
public class AIsXCoder extends ICoder {
    public final static String X="x";
    int x;
    char[] charArr;

    public AIsXCoder() {
        x=0; 
    }

    /**
     * Generates the charArr character array with the positions for the new characters.
     * index 0 is the location of a in the normal alfabeth. charArray[i] is the new corresponding
     * character. for instance for a=3 charArr[0] would be c.
     * @param plus for coding this has to be true, for decoding this has to be false.
     */
    private void prepareCharArr(boolean plus)
    {
        charArr=new char[26];
        int index;
        if(plus)
            index=x;
        else
            index= ((26-x) % 26);

        char a='a';
        for(int i=0;i<26;i++)
        {

            charArr[i]=(char)((a + index));
            index=(++index % 26);
        }
    }

    /**
     * This method switches the characters [a-z] with the corresponding characters of the charArr.
     * First it changes the inputString to its lowercase representation. non-alfabethic characters will be
     * replaced by themselves.
     * @param s         the inputstring
     * @param forward   for coding this is true, for decoding this is false.
     * @return          returns the coded (of decoded) String.
     */
    private String rotate(String s, boolean forward)
    {
       prepareCharArr(forward);
        s=s.toLowerCase();
        char a='a';
        char[] uncoded=s.toCharArray();
        char[] coded=new char[s.length()];
        for(int i=0; i< uncoded.length; i++)
        {
            char uncodedc=uncoded[i];
            int index=uncodedc-a;
            if(index>=0 && index <=25)
            {
                //voer codering uit
                coded[i]=charArr[index];
            }else{
                //behoud karakter;
                coded[i]=uncodedc;
            }
        }
        return new String(coded);
    }

    @Override
    public String code(String s) {
        return rotate(s, true);
    }

    @Override
    public String decode(String d) {
        return rotate(d, false);
    }

    @Override
    public void setOptions(HashMap<String, String> options) {
        try{
            if(options.containsKey(X))
                x=Integer.valueOf(options.get(X))-1;
        }
        catch(NumberFormatException ex){
            x=0;
        }
    }
}
