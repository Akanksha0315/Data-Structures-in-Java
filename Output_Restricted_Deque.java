/*
 * Program to implement a linked list as an Output Restricted Deque.
 * 
 * An Output Restricted Deque is a data structure which is a double ended queue i.e. elements
 * can be added from both ends of the list, however output is restricted to deleting from the front. 
 */

import java.io.*;//importing io package
public class Output_Restricted_Deque//start of class
{
    Node front, rear;
    int size; //declaring instance variables

    Output_Restricted_Deque() //constructor
    {
        front=null;
        rear=null;
        size=0;
    }

    void insRear(int item) //inserting at the end of the queue
    {
        Node nptr=new Node(item, null); //creating new Node       
        size=size+1;

        if(rear==null)//condition for no element
        {
            rear=nptr;
            front=nptr;
        }
        else //inserting element
        {
            rear.setLink(nptr);
            rear=nptr;
        }
    }

    void insFront(int item)//inserting at the start of the queue
    {
        Node nptr=new Node(item, null);//creating new Node     
        size=size+1;

        if(front==null)//condition for empty queue
        {
            front=nptr;
            rear=nptr;
        }
        else //inserting element
        {
            nptr.setLink(front);
            front=nptr;
        }
    }

    void delFront() //deleting element from the front of the queue
    {
        if(front==null)//condition for empty queue
        {
            System.out.println("Underflow.");
        }
        else
        {
            size=size-1;       
            System.out.println("Deleted element:"+front.getData());
            front=front.getLink();//link of element after front
        }
    }

    void display() //displaying all the elements of the queue
    {
        Node ptr=front; //creating new Node
        while(ptr!=null) //traversing the queue
        {
            System.out.println(ptr.getData()); 
            ptr=ptr.getLink();
        }
    }

    public static void main(String args[])throws IOException //start of the main()
    {
        BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
        //creating object
        Output_Restricted_Deque obj=new Output_Restricted_Deque();

        outer: while(1>0)//infinite loop
        {
            System.out.println("Enter 1 to insert at front. Enter 2 to insert at rear.");
            System.out.println("Enter 3 to delete at front. Enter 4 to display and 5 to exit.");
            //taking input
            int ch=Integer.parseInt(stdin.readLine());

            switch(ch) //start of menu
            {
                case 1: //inserting
                {
                    System.out.println("Enter the item to be inserted");
                    int item = Integer.parseInt(stdin.readLine());
                    obj.insFront(item);
                    break;
                }

                case 2: //deleting at front 
                {
                    System.out.println("Enter the item to be inserted");
                    int item = Integer.parseInt(stdin.readLine());
                    obj.insRear(item);
                    break;
                }

                case 3: //deleting at rear
                {
                    obj.delFront();
                    break;
                }

                case 4: //displaying deque
                {
                    obj.display();
                    break;
                }

                case 5: //exiting menu
                {
                    break outer;
                }

                default: //displaying invalid output
                {
                    System.out.println("Invalid Input");
                    break;
                }
            }//end of menu
        }
    }// end of main()
} //end of class

/*
 *                      Variable Description Table 
 *                  
 *   S.No    Variable Name      Data Type               Description
 *    1          ch               int         Stores the choice for outer menu
 *    2         item              int         Stores the element to be entered
 *    3         front             Node        Stores the front of the list
 *    4         rear              Node        Stores the rear of the list
 *    5         size              int         Stores the size of the list
 *    6         ptr               int         Local variable used to carry out functions
 *    
 */