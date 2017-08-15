/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author Bram Gadeyne
 */
public class NoCoder extends ICoder {

    public String code(String s) {
        return "not coded.";
    }

    public String decode(String d) {
        return "not decoded.";
    }

}
