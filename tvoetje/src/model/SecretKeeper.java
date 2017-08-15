/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.HashMap;

/**
 * This class holds a pair of a reference to a coder and a tekst to translate.
 * @author bram
 */
public class SecretKeeper {
    private String toTranslate;
    private String coder;
    private HashMap<String,String> options;

    public SecretKeeper(String toTranslate, String coder) {
        this.toTranslate = toTranslate;
        this.coder = coder;
    }

    /**
     * @return the toTranslate
     */
    public String getToTranslate() {
        return toTranslate;
    }

    /**
     * @param toTranslate the toTranslate to set
     */
    public void setToTranslate(String toTranslate) {
        this.toTranslate = toTranslate;
    }

    /**
     * @return the coder
     */
    public String getCoder() {
        return coder;
    }

    /**
     * @param coder the coder to set
     */
    public void setCoder(String coder) {
        this.coder = coder;
    }

    @Override
    public String toString() {
        int end=10;
        if(toTranslate.length()<end)
            end=toTranslate.length();
        return coder+" - "+toTranslate.substring(0, end);
    }

    /**
     * @return the options
     */
    public HashMap<String, String> getOptions() {
        return options;
    }

    /**
     * @param options the options to set
     */
    public void setOptions(HashMap<String, String> options) {
        this.options = options;
    }



}
