/*
 * Program to perform more functions on a linked list data structure
 * such as finding the sum of all nodes using recursion, searching for a node,
 * counting the number of nodes using recursion and printing the linked list
 * using recursion.
 */

import java.io.*; //importing io package
public class Linked_List_Functions //start of class
{
    int count=0;
    
    public int sum(Node n) //calculating sum of elements
    {
        if(n==null) //returning zero when there is no element
        {
            return 0;
        }
        else //recursively returning the sum to the calling method
        {
            return n.getData()+sum(n.getLink());
        }
    }

    public void search(int num, Node start) //searching for a node
    {
        Node ptr=start;
        int pos=1; //declaring and initialising variables
        int flag=0;
        
        while(ptr!=null) //staring a loop to run through all elements
        {
            int temp=ptr.getData();
            
            if(temp==num) //incrementing flag if search element is found
            {
                flag=1;
                break;
            }
            
            ptr=ptr.getLink(); //moving to next node
            pos++;
        }
        
        if(flag==0) //printing negative result
        {
            System.out.println(num+" not found");
        }
        else //printing positive result
        {
            System.out.println(num+" found at position "+pos);
        }
    }

    public int count(Node n) //counting the number of nodes
    {
        if(n==null) //condition for empty list
        {
            return 0; //returning 0
        }
        else //counting nodes
        {
            count=count+1; //incrementing count
            count(n.getLink()); //calling the function recursively
            return count; //returning no. of nodes
        }
    }
    
    public void print(Node n) //printing the linked list
    {
        if(n==null) //condition for empty list 
        {
            return; //returning control to calling method
        }
        else //printing list
        {
            System.out.println(n.getData()); //extracting node data
            print(n.getLink()); //calling the function recursively
            return; //returning control to calling method
        }
    }
    
    public static void main(String args[]) throws IOException
    {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        //creating object of class LinkedListBasics
        Linked_List_Basics obj=new Linked_List_Basics();
        //creating an object of this class
        Linked_List_Functions obj1= new Linked_List_Functions();
        int i=0; //declaring and initialising variables

        outer:while(i==0)
        {
            System.out.println("Enter 1 to insert element.");
            System.out.println("Enter 2 to display sum of elements using recursion.");
            System.out.println("Enter 3 to search for an element in the linked list.");
            System.out.println("Enter 4 to count the nodes using recursion.");
            System.out.println("Enter 5 to print the linked list using recursion"); 
            System.out.println("Enter 6 to exit.");
            int choice=Integer.parseInt(br.readLine());

            switch(choice)
            {
                case 1: //inserting elements
                {
                    System.out.println("Enter element.");
                    int item=Integer.parseInt(br.readLine());
                    obj.insertAtEnd(item);
                    break;
                }

                case 2: //displaying sum of elements
                {
                    int s= obj1.sum(obj.start);
                    System.out.println("The sum of the LinkedList is= "+s);
                    break;
                }
                
                case 3: //searching for an element in the linked list
                {
                    System.out.println("Enter element to be searched.");
                    int item=Integer.parseInt(br.readLine());
                    obj1.search(item, obj.start);
                    break;
                }
                
                case 4: //counting the number of nodes
                {
                    int c= obj1.count(obj.start);
                    System.out.println("The no. of elements in the LinkedList is= "+c);
                    break;
                }

                case 5: //printing the linked list
                {
                    obj1.print(obj.start);
                    break;
                }

                case 6: //exiting the menu
                {
                    break outer;
                }

                default: //displaying invalid output
                {
                    System.out.println("Invalid option");
                    break;
                }
            } //end of menu
        } 
    } //end of the main()
}//end of class


/*
 *                 Variable Description Table
 *               
 * S.No.    Variable Name    Data Type          Description
 *  1           item            int       stores item to be inserted or searched
 *  2            n              int       use to travel the linked list
 *  3            ch             int       stores the choice of the user
 *  4            i              int       loop control variable
 *  5          start            Node      stores the start of the linked list
 *  6           end             Node      stores the end of the linked list
 *  7           size            Node      stores the size of the linked list
 *  8           sum             int       stores the sum of all the elements
 *  9            np             Node      loop control variable
 *  10           pt             Node      loop control variable
 *  14          pos             int       stores position of searched item
 *  15         flag             int       flag variable
 *  16          ptr             Node      used to traverse the linked list
 *  17         temp             Node      temporary variable to store a node 
 *  18         count            int       counts number of nodes
 *  19           c              int       stores no. of nodes
 *  
 */