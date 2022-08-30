/*
 * Program to perform basic operations to a Linked List data structure
 * such as inserting, deleting and displaying.
 */

import java.io.*; //importing io package
public class Linked_List_Basics //start of class
{
    Node start, end; //instance variables
    int size;

    Linked_List_Basics() //constructor
    {
        start=null;
        end=null; //initialising instance variables
        size=0;
    }

    public void insertAtStart(int item) //to insert at the start of the list
    {
        Node nptr=new Node(item, null); //new Node
        size=size+1;

        if(start==null) //no element
        {
            start=nptr;
            end=nptr;
        }
        else
        {
            nptr.setLink(start); //nptr points towards start
            start=nptr;
        }
    }

    public void insertAtEnd(int item) //to insert at the end of the list
    {
        Node nptr=new Node(item, null);//new Node
        size=size+1;

        if(end==null)// empty list
        {
            start=nptr;
            end=start;
        }
        else{

            end.setLink(nptr);//end points to nptr
            end=nptr;
        }
    }

    public void insertAtPosition(int item, int pos)//to insert at a position entered by the user
    {
        Node nptr=new Node(item, null);//new Node

        if(start==null)// empty
        {
            size=size+1;
            start=nptr;
            end=nptr;
        }
        else if(pos==1)//at the start of the lsit
        {
            insertAtStart(item);
        }
        else if(pos>size)//at the end of the list
        {
            insertAtEnd(item);
        }
        else
        {
            Node ptr=start;//new Node
            Node tmp=null;//new Node
            int i=1;
            while(i<pos-1){
                ptr=ptr.getLink();
                i++;
            }
            tmp=ptr.getLink();//tmp stores the link after ptr
            ptr.setLink(nptr);//ptr points to nptr
            nptr.setLink(tmp);//nptr points to tmp
            size=size+1;
        }
    }

    public void deleteAtStart()//to delete an element from start
    {
        start=start.getLink();//start stores the link after start
        size=size-1;
    }

    public void deleteAtEnd()//to delete an element from the end
    {
        Node ptr=start;//new Node
        for(int i=1;i<size-1;i++){
            ptr=ptr.getLink();
        }
        end=ptr;
        end.setLink(null);//end points to null
        size=size-1;
    }

    public void deleteAtPosition(int pos)//delete from a positon
    {
        Node ptr=start;//new Node
        Node tmp=null;//new Node
        for(int i=1;i<pos-1;i++){
            ptr=ptr.getLink();
        }
        tmp=ptr.getLink();//tmp stores the link after ptr
        ptr.setLink(tmp.getLink());//ptr points to the link after tmp
        size=size-1;
    }

    public void display()//to display the list
    {
        Node ptr = start;//new Node
        System.out.println("Size of the Linked List= "+size);
        while(ptr!=null)//till the end of the list
        {
            System.out.println(ptr.getData());
            ptr=ptr.getLink();
        }
    }

    public static void main(String args[])throws IOException//start of the main()
    {
        BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
        Linked_List_Basics obj=new Linked_List_Basics();//object created
        int i=0;
        outer: while(i>=0)//infinite loop labeled outer
        { 
            //taking input
            System.out.println("Enter 1 to insert at end. Enter 2 to insert at start of the linked list.");
            System.out.println("Enter 3 to insert at position. Enter 4 to delete from end."); 
            System.out.println("Enter 5 to delete from start. Enter 6 to delete from a position."); 
            System.out.println("Enter 7 to display the list. Enter 8 to exit the program.");

            int ch=Integer.parseInt(stdin.readLine());//choice
            switch(ch)
            {
                case 1://to insert at the end of the array
                {
                    System.out.println("Enter element.");
                    int item=Integer.parseInt(stdin.readLine());
                    obj.insertAtEnd(item);
                    break;
                }  

                case 2://to insert at the start of the array
                {
                    System.out.println("Enter element.");
                    int item=Integer.parseInt(stdin.readLine());
                    obj.insertAtStart(item);
                    break;
                }

                case 3://to insert at a position
                {
                    System.out.println("Enter element.");
                    int item=Integer.parseInt(stdin.readLine());
                    System.out.println("Enter position");
                    int n = Integer.parseInt(stdin.readLine());
                    obj.insertAtPosition(item,n);
                    break;
                }            

                case 4://to delete the last element
                {
                    obj.deleteAtEnd();
                    break;
                }

                case 5://to delete the first element
                {
                    obj.deleteAtStart();
                    break;
                }

                case 6:// to delete from a position
                {
                    System.out.println("Enter position");
                    int n = Integer.parseInt(stdin.readLine());
                    obj.deleteAtPosition(n);
                    break;
                }            

                case 7://to display
                {
                    obj.display();               
                    break;
                }

                case 8://to exit
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
    } //end of the main()
} //end of class

/*
 *                 Variable Description Table
 *               
 * S.No.    Variable Name    Data Type          Description
 *  1           item            int       Stores item to be inserted
 *  2            n              int       Stores position to be inserted or deleted
 *  3            ch             int       Stores the choice of the user
 *  4            i              int       Loop Control variable
 *  5          start            Node      Stores the start of the linked list
 *  6           end             Node      Stores the end of the linked list
 *  7           size            Node      Stores the size of the linked list
 *  
 */