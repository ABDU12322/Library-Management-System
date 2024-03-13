import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) {
        Library lib =new Library();
        Scanner sc=new Scanner(System.in);
        int a=0;
        while(true) {
            System.out.println("Hello! Welcome to the Library Management System.");
            System.out.println("If you want to add new books, press 1");
            System.out.println("If you want to add the user, press 2");
            System.out.println("If you want to get the book out of the Library, press 3");
            System.out.println("If you want Search the book, press 4");
            System.out.println("If you want return the book, press 5");
            System.out.println("If you want exit the program, press 6");
            System.out.println("Press 7, if you want to view all the books");
            while (true) {
                try {
                    a = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("The option should be an integer");
                    sc.next();
                    continue;
                }
                break;
            }
            if (a == 1) {
                addBooks();
            } else if (a == 2) {
                addUsers();
            } else if (a == 3) {
                checkingOutBooks();
            } else if (a == 4) {
                searchingBooks();
            } else if (a == 5) {
                returningBooks();
            } else if(a==6){
                break;
            }
            else if(a==7)
            {
               lib.displayBooks();
            }
            else {
                System.out.println("Invalid! Enter the correct option");
                continue;
            }
            System.out.println("Enter y/Y for doing it again and n/N to exit the LMS");
            char ans=sc.next().charAt(0);
            if (ans=='y'||ans=='Y')
            {
                continue;
            }
            else if(ans=='n'||ans=='N')
            {
                break;
            }
            else break;
        }
//        int in=sc.nextInt();
//        Library lib =new Library();
//        boolean n=true;
//        lib.returningBooks(n,"harrypotter");
    }
    public static void addBooks()
    {

        Library lib=new Library();
        Scanner scanner=new Scanner(System.in);
        Book b1=new Book();
        System.out.println("Enter the name of the book");
        b1.title =scanner.nextLine();
        System.out.println("Enter the name of the author of the book");
        b1.author=scanner.nextLine();
        System.out.println("Enter the genre of the book");
        b1.genre=scanner.nextLine();
        System.out.println("Enter the id of the book");
        while(true){
            try{
                b1.bookID=scanner.nextInt();}
            catch(InputMismatchException e){
                System.out.println("The id must be an integer");
                continue;
            }break;}
        lib.addBooks(b1.title,b1.bookID, b1.author, b1.genre, true);
    }
    public static void addUsers()
    {
        Library lib=new Library();
        Scanner scanner=new Scanner(System.in);
        User user=new User();
        System.out.println("Enter the User name: ");
        user.name= scanner.nextLine();
        System.out.println("Enter the contact information: ");

        user.contactInformation=scanner.nextLine();
        System.out.println("Enter the password: ");
        user.password= scanner.nextLine();
        System.out.println("Enter the user ID: ");
        while(true){
            try{
                user.userID=scanner.nextInt();}
            catch(InputMismatchException e){
                System.out.println("The user id must be an integer");
                continue;
            }break;}
        scanner.nextLine();
        lib.addUsers(user.name,user.userID,user.password,user.contactInformation);
    }
    public static void checkingOutBooks()
    {
        int id=0;
        Library lib=new Library();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the name of the book you want to borrow");
        String name =scanner.nextLine();
        System.out.println("Enter the id of the book you want to checkout: ");
        while (true){try {
            id = scanner.nextInt();
        }catch(InputMismatchException e){
            System.out.println("Invalid! Enter only number");
            scanner.next();
            continue;
        }break;}
        lib.checkingOutBooks(id,name);
    }
    public static void searchingBooks()
    {
        Library lib=new Library();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the name of the book you want to search for: ");
        String name=scanner.nextLine();
        lib.searchingBooks(name);
    }
    public static void returningBooks()
    {
        Library lib=new Library();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the name of the book you want to return to the library: ");
        String name=scanner.nextLine();
        lib.returningBooks(name);
}
}
