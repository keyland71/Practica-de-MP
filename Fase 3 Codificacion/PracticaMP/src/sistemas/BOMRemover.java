/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemas;

/**
 *
 * @author Ángel Marqués
 */
public class BOMRemover {
    private static final String UTF8_BOM = "\uFeFF";
    
    public static String removeUTF8BOM(String s){
        if (s.startsWith(UTF8_BOM)){
            s = s.substring(1);
        }
        return s;
    }
}
