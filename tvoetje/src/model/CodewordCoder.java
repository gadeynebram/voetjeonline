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
public class CodewordCoder extends ICoder {

    String codewoord;
    HashMap<Character,Character> codermap;
    public static final String codeword="codewoord";

    public CodewordCoder()
    {
        codewoord="";
        codermap=new HashMap<Character, Character>();
    }

    @Override
    public void setOptions(HashMap<String, String> options) {
        codewoord=options.get(codeword).toLowerCase();
        //create hash to indicate used characters.
        HashMap<Character,Boolean> used=new HashMap<Character, Boolean>();
        int aval=(int)'a';
        //initiate hashmap with values false for each char from the alfabeth.
        for(int i=0; i<26;i++)
        {
            used.put((char)(aval+i),false);
        }
        //construct a codetable who contains the characterpairs.
        char[] codetable=new char[26];
        int i=0;
        //insert the characters from the codeword.
        while(i<codewoord.length())
        {
            used.put(codewoord.toCharArray()[i], Boolean.TRUE);
            codetable[i]=codewoord.toCharArray()[i];
            i++;
        }
        int j=0;
        //insert the remaining unused characters from the alfabeth.
        while(j<26 && i<26)
        {
            char kar=(char)(aval+j);
            if(!used.get(kar))
            {
                used.put(kar, Boolean.TRUE);
                codetable[i]=kar;
                i++;
            }
            j++;
        }
        //insert the characterpairs in a hashmap to code and decode messages.
        for(int k=0;k<13;k++)
        {
            codermap.put(codetable[k], codetable[k+13]);
            codermap.put(codetable[k+13], codetable[k]);
        }
    }

    @Override
    public String code(String s) {
        return processString(s);
    }



    @Override
    public String decode(String d) {
        return processString(d);
    }

    private String processString(String s)
    {
        char[] answer=new char[s.length()];
        char[] question=s.toCharArray();
        for(int l=0;l<s.length();l++)
        {
            if(codermap.containsKey(question[l])){
                answer[l]=codermap.get(question[l]);
            }else{
                answer[l]=question[l];
            }
        }
        return new String(answer);
    }
}
