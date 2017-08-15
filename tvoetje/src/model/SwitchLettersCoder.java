/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author Bram Gadeyne
 */
public class SwitchLettersCoder extends ICoder {

    public String code(String s) {
        char[] arr=s.toCharArray();
        char[] codedarr=new char[arr.length];
        int j=0;
        for(int i=(arr.length - 1); i>=0; i--)
        {
            codedarr[j]=arr[i];
            j++;
        }
        return new String(codedarr);
    }

    public String decode(String d) {
        char[] arr=d.toCharArray();
        char[] codedarr=new char[arr.length];
        int j=0;
        for(int i=(arr.length - 1); i>=0; i--)
        {
            codedarr[j]=arr[i];
            j++;
        }
        return new String(codedarr);
    }

}
