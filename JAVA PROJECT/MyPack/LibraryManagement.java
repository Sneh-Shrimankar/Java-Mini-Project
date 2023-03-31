package MyPack;
import java.util.Scanner;
import java.util.Date;
import java.time.Instant;
import java.text.SimpleDateFormat;  

class Library
{
    // create data fields
     int code;
     static String name;
     static String bname;
     double price;
     int qty;
     Date mfg_date;

    void addBook()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter code,bookname,authorname, price and quantity");
        code=sc.nextInt();
        bname=sc.next();
        name=sc.next();
        price=sc.nextDouble();
        qty=sc.nextInt();
    }

    void getBook()
    {
    System.out.println(code+" \t"+bname+"\t\t"+name+"\t\t"+price+"\t\t"+qty);
    }

    static int search_book(Library l[],int lc,String type)
    {
        String searchname;
        System.out.println("Enter the name of the book to be " +type);
        Scanner sc=new Scanner(System.in);
        searchname=sc.next();
            if(searchname.equals(bname))
            {
                System.out.println("Book Searched in record");
                System.out.println("");
            }    
            else
            {
                System.out.println("Book not found in record ");
                System.out.println("");
            }
            return 0;
    }  
}
class Book extends Library
{ 
    static void update_book(Library l[],int lc)
    {
        int sid=search_book(l,lc,"Updated");
        if(sid<lc)
        {

            System.out.println("Press 1 for price update");
            System.out.println("Press 2 for quantity update");
            Scanner sc=new Scanner(System.in);
            int choice=sc.nextInt();
            switch(choice)
            {

            case 1: // price update
                    System.out.println("Enter the new price");
                    double nprice=sc.nextDouble();
                    l[sid].price=nprice;
                    System.out.println("BOOK PRICE UPDATED SUCCESSFULLY");
                    break;
            case 2: // quantity update
                    System.out.println("Enter the new quantity");
                    int nqty=sc.nextInt();
                    l[sid].qty=nqty;
                    System.out.println("PRODUCT QUANTITY UPDATED SUCCESSFULLY");
                    break;             
            default:
                    System.out.println("Invalid Option");
                    System.out.println("");
                    break;
            }

        }
        else
        {
                System.out.println("Product doesn't exist");
        }    
} 
static void buy_Book()
{   
    Scanner sc = new Scanner(System.in);
    String buyname;
    int a;
    System.out.println("Enter the name of book you want to buy");
    buyname=sc.next();
    System.out.println("You can purchase 1 book at a time");
    if(buyname.equals(bname))
    {
        System.out.println("BOOK FOUND");
        System.out.println("1.PROCEED(Already Registered)");
        System.out.println("2.Stop");
        System.out.println("3.Register with us");
        a=sc.nextInt();
        System.out.println("");
        switch(a)
  {
    case 1: System.out.println("Yu will get the bill of book on the provided EMAIL");
            System.out.println("You bought the book successfully");
            Date date = new Date();
            Instant todayInstant = date.toInstant();
            System.out.println("Buying date=" +date);
            System.out.println("");
            System.out.println("Pay the book amount to Librarian when you come to return the book");
            System.out.println("Return the book after 15 days");
            System.out.println("");
            break;

    case 2: System.out.println("Process Stopped  !!!!!");
             break;
    case 3: String email;
            System.out.println("Enter your email to register with us");
            email=sc.next();
            System.out.println("");
            System.out.println("THANKS FOR REGISTERING WITH US");
            System.out.println("You registered with us successfully");
            System.out.println("NOW AGAIN SELECT THE OPTION OF BUY BOOK");

            default:
            System.out.println("Invalid choice");
            break;
  }
    }
    else
         {
            System.out.println("Book not found");
         }
} // end of buy_Book()
 
 static void return_book()
{
    Scanner sc = new Scanner(System.in);
    String rbook;
    int rdays,b,camt;
    Date pdate;
    System.out.println("Enter the name of the book to be returned");
    rbook=sc.next();
    sc.nextLine();
    System.out.println("After how many days you are returning the book");
    rdays=sc.nextInt();
    if(rdays>15)
    {
        System.out.println("You are returning the book late");
         System.out.println("Pay the fine of RS.150");
         System.out.println("RETURN THE BOOK IMMEDIATELY");
         System.out.println("1-ONLINE MODE, 2-CASH MODE");
         b=sc.nextInt();
         switch(b)
         {
         case 1:System.out.println("VISIT OUR WEBSITE =www.onlinelibmanage.com");
                System.out.println("After paying the money take screenshot of payment");
                System.out.println("Show the screenshot to the librarian");
                break;
         case 2:System.out.println("Pay the cash amount RS.150 to the Librarian");
                System.out.println("The mail has been sent to the Librarian about you");

         }
    }
    else 
      {
        System.out.println("");
        System.out.println("Thanks for returning the book on time");
        System.out.println("PAY THE BOOK AMOUNT TO THE LIBRARIAN");
        System.out.println("The bill of your book is sent to your email id(Registered)");
        System.out.println("----------DO VISIT AGAIN----------");
      }
}
}
class LibraryManagement
{
    public static void main(String args[]) throws Exception
    {
        Book b[]=new Book[50];
        int lc=0,id=0,i;
        Scanner sc=new Scanner(System.in);
        
        while(true)  
        {    

            System.out.println("1.Add Book");
            System.out.println("2.Display Books");
            System.out.println("3.Total Books");
            System.out.println("4.Search Book");
            System.out.println("5.Update Book");
            System.out.println("6.Return Book");
            System.out.println("7.Buy Book");
            System.out.println("8.Exit");
            System.out.println("Enter the choice:");
            int choice=sc.nextInt();    
            
            switch(choice)
            {
                case 1:
                        b[id]=new Book();
                        b[id].addBook();
                        id++;
                        lc++;
                        break;
                case 2: 
                        if(lc==0)
                        {
                             System.out.println("There is no product in the database");   
                        }    
                        else
                        {    
                            System.out.println("Book Details are as follows\n");
                            System.out.println("*******************************************************************");
                            System.out.println("Code\tBookName\tAuthName\tPrice\t\tQty");
                            System.out.println("*******************************************************************");
                            for(i=0;i<lc;i++)
                            {    
                            b[i].getBook();
                            }
                        }
                        break;
                case 3:
                         System.out.println("Total Books="+lc);
                         break;
        
                case 4:         
                        int sid= Book.search_book(b,lc,"Searched"); // array and count 
                        break;

                case 5:
                        Book.update_book(b,lc);
                        break;

                
                case 6: 
                        Book.return_book();
                        break;
                case 7:
                        Book.buy_Book();
                        break;
                case 8:
                         System.out.println("End of Program");
                         System.exit(0);
                         break;
                default :
                    System.out.println("Invalid input");
            }
        } // end of while loop  
    }
}
