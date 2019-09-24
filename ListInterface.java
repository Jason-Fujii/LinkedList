/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project2;

/**
 *
 * @author jasonfujii
 */
public interface ListInterface {
    public char charAt(int index);
    public LinkedString concat(LinkedString str);
    public boolean isEmpty();
    public int length();
    public LinkedString substring(int beginIndex,int endIndex);
}
