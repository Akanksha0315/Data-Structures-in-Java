import java.io.*;
class Stack
{
   int s[];
   int size, top, capacity;
   Stack(int c)
   {
      capacity = c;
      top = -1;
      s = new int [c];
    }
   void push(int element)
   {
      if(top == capacity-1)
      {
         System.out.println("Overflow");
        }
      else 
      {
         top = top + 1;
         s[top] = element;
      }
   }
   void pop()
   {
       if(top == -1)
       {
          System.out.println("underflow");
        }
       else 
       {
          int e = s[top];
          System.out.println("Popped element" + e);
          top = top - 1;
        }
   }
   void display()
   {
      for(int i = top; i>= 0; i--)
      {
          System.out.println();
        }
    }
   public static void main(String args[])throws IOException
   {
      InputStreamReader isr = new InputStreamReader(System.in);
      BufferedReader br = new BufferedReader(isr);
      System.out.println("Enter capacity");
      int c = Integer.parseInt(br.readLine());
      char cha = ' ';
      Stack ob = new Stack(c);
      do
      {
         System.out.println("Enter 1 for push");
         System.out.println("Enter 2 for pop");
         System.out.println("Enter 3 for display");
         System.out.println("Enter 4 to terminate");
         int ch = Integer.parseInt(br.readLine());
         switch(ch)
         {
            case 1 :      
              System.out.println("enter element");
              int el = Integer.parseInt(br.readLine());
              ob.push(el);
            break;
            case 2 : 
              ob.pop();
            break;
            case 3 : 
              ob.display();
            break;
            default: 
            break;
         }
         System.out.println("do you want to continue Y/N ?");
         cha = (br.readLine()).charAt(0);
      }while(cha == 'Y'||cha == 'y'); 
   }
}