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
public class LinkedString implements ListInterface{
    private int numNodes;
    private Node head;
    
    //A constructor which creates a LinkedList of character values from an array of chars
    public LinkedString(char[] value)
    {
        numNodes = 0;
        Node head = null;
        for(int i = 0; i < value.length; i++)
        {
            this.insert(i, value[i]);
        }
    }
    
    //A constructor which creates a LinkedList of character values from a string
    public LinkedString(String original)
    {
        numNodes = 0;
        Node head = null;
        for(int i = 0; i < original.length(); i++)
        {
            this.insert(i , original.charAt(i));
        }
    }
    
    //finds and returns the char elements at the index which was input.
    public char charAt(int index) throws stackException
    {
        char ans;
        if(index >= 0 && index < numNodes)
        {
            Node n = this.get(index);
            ans = n.item;
            return ans;
        }
        else
        {
            throw new stackException("Index Is Out Of Bounds");
        }
    }
    
    //concatenates a LinkedString LinkedList str with the current LinkedString.
    public LinkedString concat(LinkedString str)
    {
        int num = this.length();
        for(int i = 0; i < str.length(); i++)
        {
            this.insert(num + i, str.charAt(i));
        }
        
        return this;
    }
    
    //returns true if numNodes is equal to 0 and false otherwise
    public boolean isEmpty()
    {
        return (numNodes == 0);
    }
    
    public int length()
    {
        return numNodes;
    }
    
    //
    public LinkedString substring(int beginIndex,int endIndex)
    {
        int cIndex = 0;
        char[] c = new char[endIndex - beginIndex];
        for(int i = beginIndex; i < endIndex; i++)
        {
            c[cIndex] = this.charAt(i);
            cIndex++;
        }
        LinkedString ans = new LinkedString(c);
        return ans;
    }
    
    //inserts a new Node at a given index in between what is currently there and 
    //what comes before it
    public void insert(int index, char data)
    {
        if(index >= 0 && index <= numNodes){
            if(index == 0)
            {
                Node node = new Node(data);
                node.next = head;
                head = node;
            }
            else
            {
                //find your previous and your current
                Node curr = find(index);
                Node prev = find(index - 1);
            
                //add the new node with current as the successor and previous as the 
                //predecessor
                Node node = new Node(data, curr);
                prev.next = node;
            }
            numNodes++;
        }
        else
        {
            throw new IndexOutOfBoundsException();
        }
    }
    
    public void delete(int index)
    {
        if(index >= 0 && index <= numNodes)
        {
            if(index == 0)
                head = head.next;
            else
            {
                //find the location
                Node prev = find(index - 1);
                Node curr = prev.next;
                //start deleting
                curr = curr.next;
                prev = curr;
            }
            numNodes--;
        }
        else
            throw new IndexOutOfBoundsException();
    }
    
    public Node get(int index)
    {
        Node ans = find(index);
        return ans;
    }
    //finds and returns a node at a given index. 
    //use this method to help find current and previous nodes
    private Node find(int index)
    {
        Node curr = head;
        for(int i = 0; i < index; i++)
        {
            curr = curr.next;
        }
        return curr;
    }
    
    private void deleteAll()
    {
        head = null;
        numNodes = 0;
    }
    
    public void printList()
    {
        printList2(head);
    }
    
    //recursive implementation of printing a list
    private void printList2(Node curr)
    {
        if(curr.next == null)
        {
            System.out.println(curr.item);
        }
        else
        {
            System.out.print(curr.item + " ");
            printList2(curr.next);
        }
    }
}
