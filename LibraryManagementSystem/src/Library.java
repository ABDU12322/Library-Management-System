import java.io.*;
import java.util.*;


public class Library {
ArrayList<String> Books;
ArrayList<String> Users;
void addBooks(String name,int iban,String author,String genre,boolean available) {
    try {
        FileWriter myFileWriter = new FileWriter("books.txt",true);
        String line="Name:"+name+" id:"+iban+" author:"+author+" genre:"+genre+" availabilityStatus:"+available+"\n";
        String[] abd=line.split(",");
        for (String s : abd) {

            myFileWriter.write(s);
        }
        myFileWriter.close();
    }
    catch (IOException e)
    {
        e.printStackTrace();
    }
}
    void addUsers(String name, int uid, String password, String contactInformation) {
        try {
            FileWriter myFileWriter = new FileWriter("users.txt", true);
            myFileWriter.write("Name: " + name + " ID: " + uid + " Contact Info: " + contactInformation + " Password:"+password+"\n");
            myFileWriter.flush();
            myFileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
void checkingOutBooks(int id, String name) {
         try{
             FileReader myFileReader = new FileReader("books.txt");
             FileWriter fj = new FileWriter("borrowed_books.txt", true);
             FileReader fk = new FileReader("borrowed_books.txt");
             Scanner sc = new Scanner(myFileReader);
             Scanner scanner = new Scanner(fk);

             Books = new ArrayList<>();
            ArrayList<String> bb = new ArrayList<>();

            if (!sc.hasNextLine()) {
                System.out.println("There are no books available in the library");
                return;
            }


            while (sc.hasNextLine()) {
                Books.add(sc.nextLine());
            }


            while (scanner.hasNextLine()) {
                bb.add(scanner.nextLine());
            }


            boolean alreadyBorrowed = false;
            for (String borrowedBook : bb) {
                if (borrowedBook.contains(name)) {
                    alreadyBorrowed = true;
                    break;
                }
            }

            for (String book : Books) {
                String bookId = String.valueOf(id);

                if (book.contains(bookId) && book.contains(name) && !alreadyBorrowed) {

                    System.out.println("The Book is available");
                    fj.write(book + "\n");
                    fj.flush();
                    System.out.println("You have successfully borrowed this book");
                    fj.close();
                    return;
                } else if (alreadyBorrowed) {
                    System.out.println("You have already borrowed this book");
                    return;
                }
            }


            System.out.println("The book is not available in the library");
            myFileReader.close();
//            fj.close();
            fk.close();
            sc.close();
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void searchingBooks(String name) {

    try {
        FileReader myFile=new FileReader("books.txt");
        Scanner scanner=new Scanner(myFile);
        int i=0;
        while(scanner.hasNextLine())
        {
            if(scanner.nextLine().contains(name))
            {
                System.out.println("The book is present in the library");
                i++;
                break;
            }
        }
        if(i==0)
        {
            System.out.println("The book is not present in the library");
        }
        myFile.close();
        scanner.close();
    } catch (IOException e) {
    e.printStackTrace();
    }
}
    void returningBooks(String name) {
        try {
            File f =new File("borrowed_books.txt");
            FileWriter fi = new FileWriter("returned.txt", true);
            FileReader fk = new FileReader("borrowed_books.txt");
            Scanner scanner = new Scanner(f);
            Books = new ArrayList<>();
            int k = 0;

            while (scanner.hasNextLine()) {
                Books.add( scanner.nextLine());
            }
            scanner.close();
            fk.close();
            FileWriter fj = new FileWriter("borrowed_books.txt", true);
            FileWriter fl = new FileWriter("borrowed_books.txt");

            for (int i = 0; i < Books.size(); i++) {
                if (Books.get(i).contains(name)) {
                    fi.write(Books.get(i) + "\n");
                    fi.flush();
                    Books.remove(i);
                    k++;
                }
            }

            if (k == 0) {
                System.out.println("This book is not borrowed by the user");
            }

            for (String book : Books) {
                fl.write(book + "\n");
            }
            fl.close();

            fi.close();
            fj.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
void displayBooks()
{
    try{
        FileReader f=new FileReader("books.txt");
        Scanner scanner=new Scanner(f);
        Books=new ArrayList<>();
        while(scanner.hasNextLine())
        {
            Books.add(scanner.nextLine());
        }
        for(String name:Books){
        System.out.println(name);}
        f.close();
    }catch(IOException e)
    {
         e.printStackTrace();
    }
}
}
//void returning(String name) {
//    try {
//        int i=0;
//        FileReader myFile = new FileReader("borrowed_books.txt");
//        Scanner scanner=new Scanner(myFile);
//        Books=new ArrayList<>();
//        while(scanner.hasNextLine())
//        {
//            Books.add(scanner.nextLine());
//
//        }
//        myFile.close();
//        FileWriter myfile = new FileWriter("borrowed_books.txt");
//        for(String book:Books)
//        {
//            if(book.contains(name))
//            {
//                Books.remove(i);
//                break;
//            }
//        i++;
//        }
//        for (String book:Books)
//        {
//            myfile.write(book+"\n");
//        }
//        myfile.close();
//    }
//    catch (IOException e)
//    {
//        e.printStackTrace();
//    }
//    }

