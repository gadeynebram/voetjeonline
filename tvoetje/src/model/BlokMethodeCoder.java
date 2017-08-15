/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author bram
 */
public class BlokMethodeCoder extends ICoder {

    public BlokMethodeCoder()
    {
    }

    @Override
    public String code(String s) {
        //verwijder spaties
        String input=s.replace(" ", "");
        input=input.toLowerCase();
        int size=input.length();
        int sqroot=(int)Math.sqrt((double)size);
        //als wortel geen geheel getal is dan zoek volgend passende grootte met gehele wortel.
        //Vul aan met X-en
        if((double)sqroot != Math.sqrt((double)size))
        {
            int verschil = (int)Math.pow(sqroot+1, 2) - size;
            char[] Xarr=new char[verschil];
            for(int i=0; i<verschil;i++)
            {
                Xarr[i]='X';
            }
            input=input.concat(new String(Xarr));
            size=size+verschil;
            sqroot++;
        }
        //grootte van de inputstring heeft nu zeker een gehele wortel.
        char[] inputarr=input.toCharArray();
        char[][] blokbox=new char[sqroot][sqroot];
        int pointer=0;  //toont locatie in de inputstring
        int col=0;      //kolom
        int row=0;      //rij
        //vul de vierkante matrix op met de tekst rij per rij.
        while(row<sqroot)
        {
            while(col<sqroot)
            {
                blokbox[row][col]=inputarr[pointer];
                col++;
                pointer++;
            }
            col=0;
            row++;
        }
        row=col=pointer=0;
        //overloop de matrix opnieuw kolom per kolom om de gecodeerde tekst te bekomen.
        while(col<sqroot)
        {
            while(row<sqroot)
            {
                inputarr[pointer]=blokbox[row][col];
                row++;
                pointer++;
            }
            row=0;
            col++;
        }
        //de inputarr bevat nu de gecodeerde inputString.
        return new String(inputarr);
    }

    @Override
    public String decode(String d) {
        String antwoord="foutieve opgave.";
        int size=d.length();
        int sqroot=(int)Math.sqrt((double)size);
        //de vierkantswortel van de lengte moet een geheel getal zijn.
        if(sqroot == Math.sqrt((double)size))
        {
            char[] inputArr=d.toCharArray();
            char[][] blokArr=new char[sqroot][sqroot];
            int pointer=0;
            int row=0;
            int col=0;
            //vul de vierkante matrix op met de tekst rij per rij.
            while(row<sqroot)
            {
                while(col<sqroot)
                {
                    blokArr[row][col]=inputArr[pointer];
                    col++;
                    pointer++;
                }
                col=0;
                row++;
            }
            row=col=pointer=0;
            //overloop de matrix opnieuw kolom per kolom om de gecodeerde tekst te bekomen.
            while(col<sqroot)
            {
                while(row<sqroot)
                {
                    inputArr[pointer]=blokArr[row][col];
                    row++;
                    pointer++;
                }
                row=0;
                col++;
            }
            antwoord=new String(inputArr);
            antwoord=antwoord.replaceAll("X", "");
        }
        return antwoord;
    }

}
