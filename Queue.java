/*
 * Program to implement linked list as a Queue and perform enqueue, 
 * dequeue and display actions 
 * 
 * Queue is a linear data structure which enables the user to add elements 
 * from the rear end and remove elements from the front end only, using the 
 * concept of FIFO (First In First Out).
 */

import java.io.*; //importing io package
public class Queue //start of class 
{
    Node front, rear;
    int size; //declaring instance variables

    Queue() //constructor
    {
        front=null; //initialising instance variables
        rear=null; 
    }

    void enqueue(int n) //method to add nodes to the rear
    {
        Node nptr= new Node(n, null);
        if(front==null) //incase queue is initially empty
        {
            front=nptr;
            rear=front;
        }
        else //inserting elements
        {
            rear.setLink(nptr);
            rear=nptr;
        }
        size=size+1;
    }

    void dequeue() //method to delete nodes from the front
    {
        front=front.getLink();
        size=size-1;
    }

    public void display() //displaying queue
    {
        Node ptr=front;
        while(ptr!=null) //traversing the queue
        {
            System.out.println(ptr.getData());
            ptr=ptr.getLink();
        }
        return;
    }

    public static void main(String args[])throws IOException //start of main()
    {
        BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
        //creating an object
        Queue obj=new Queue();
        int i=0; //declaring and initialising variables

        outer: while(i>=0){
            //taking user input 
            System.out.println("Enter 1 to enqueue, 2 to dequeue, 3 to display & 4 to exit.");
            int ch = Integer.parseInt(stdin.readLine());

            switch(ch) //start of menu
            {
                case 1 : //enqueueing elements
                {
                    System.out.println("Enter the element to be entered");
                    int n= Integer.parseInt(stdin.readLine());
                    obj.enqueue(n);
                }
                break;

                case 2: //dequeueing elements
                {
                    obj.dequeue();
                }
                break;

                case 3: //displaying queue
                {
                    obj.display();
                    break;
                }
                
                case 4: //exiting menu
                {
                    break outer ;
                }
                
                default: //displaying invalid output
                {
                    System.out.println("Invalid Input");
                    break;
                }
            } //end of menu
        }
    } //end of main()
} //end of class

/*              Variable Description Table
 * 
 * S.No.    Variable Name        Data Type              Description
 *  1           size                int         stores the size of the queue
 *  2           rear                Node        stores the rear pointer
 *  3           front               Node        stores the front pointer
 *  4            n                  int         stores the element to be added 
 *  5            i                  int         loop control variable
 *  6           ptr                 Node        helps traverse the linked list  
 *  7           ch                  int         stores the user's menu choice
 *  
 */