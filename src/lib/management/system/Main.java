package lib.management.system;
import java.time.LocalDate;
import java.util.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        /**
         * list of books to be added
         */
        Book book1 = new Book(1, "Book One");
        Book book2 = new Book(2,"Book Two");
        Book book3 = new Book(3,"Book Three");
        Book book4 = new Book(4,"Book Four");
        Book book5 = new Book(5,"Book Five");
        Book book6 = new Book(6,"Book Six");

        /**
         * list of members to be added
         */
        Member member1 = new Member(1, "Member One");
        Member member2 = new Member(2, "Member Two");
        Member member3 = new Member(2, "Member Two");

        Library newLibrary = new Library("The Great Library");
        Librarian librarian = new Librarian("Nancy", 1);
        newLibrary.addLibrarian(librarian);

        //add member(s)
        librarian.addMember(member1);
        librarian.addMember(member2);
        librarian.addMember(member3);

        //remove member(s)
//        newLibrary.removeMember(member1);

        //add book
        librarian.addBook(book1);
        librarian.addBook(book2);
        librarian.addBook(book3);
        librarian.addBook(book4);
        librarian.addBook(book5);
//        newLibrary.addBook(book6);
        librarian.addBook(book6);

        System.out.println(newLibrary.getLibName() + " Summary :\n"
                + newLibrary.getBooks().stream().count()+ " book(s)  \n" +
                newLibrary.getMembers().stream().count() +" member(s) \n" +
                "Librarian: " +newLibrary.getLibrarian());
        System.out.println();

        //issue books
        newLibrary.issueBook(member1, book1);
        newLibrary.issueBook(member1, book2);
        newLibrary.issueBook(member1, book3);

        //member cannot have more than 3 borrowed books
        newLibrary.issueBook(member2, book4);


        //return book
//        member1.returnBook(book1);
//        member2.returnBook(book2);
        System.out.println();
        System.out.println("Member one has borrowed: "+ newLibrary.getBorrowedBooks(member1));
        System.out.println();
//



        // total number of borrowed books
        newLibrary.getTotalBooksOut();
        System.out.println();
        //books summary
        newLibrary.booksSummary();
    }


}
