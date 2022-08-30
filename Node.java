/*
 * Program to define a Node class that creates nades for a 
 * linked list data structure
 */ 
class Node //start of class
{
    int data; //declaring instance variables
    Node link;
    Node() //default constructor
    {
        data=0; //initialising instance variables
        link=null;
    }
    Node(int d, Node n) //parameterised constructor
    {
        data=d; //initialising instance variables
        link=n;
    }

    int getData() //returns the data stored in node to calling method
    {
        return data;
    }

    void setData(int d) //initialises node with data
    {
        data=d;
    }

    Node getLink() //returns the link to the next node to calling method
    {
        return link;
    }

    void setLink(Node n) //sets the link to the next node
    {
        link=n;
    }
} //end of class
/*
 *                 Variable Description Table              
 * S.No.    Variable Name  Data Type          Description
 *  1           data         int        Stores the item in the node
 *  2           link         Node       Stores the link to the next node
 *  3            d           int        Stores the data to be inserted in node
 *  4            n           Node       Stores the link to the next node
 */