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
public class Node {
    char item;
    Node next;
    
    public Node()
    {
        item = 'A';
        next = null;
    }
    
    public Node(char c, Node n)
    {
        item = c;
        next = n;
    }
    
    public Node(char c)
    {
        item = c;
        next = null;
    }
    
    @Override
    public String toString()
    {
        String s = "Name: " +item+ " Next: " + next;
        return s;
    }
}
