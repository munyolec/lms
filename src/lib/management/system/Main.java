package lib.management.system;
import java.util.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        /**
         * list of books to be added
         */
        List <Book> bookList = new ArrayList<Book>();
        Book book1 = new Book(1, "Book One");
        Book book2 = new Book(2,"Book Two");
        Book book3 = new Book(3, "Book Three");
        Book book4 = new Book(3, "Book four");
        Book book5 = new Book(3, "Book five");
        Book book6 = new Book(3, "Book six");

        /**
         * list of members to be added
         */
        List <Member> memberList = new ArrayList<Member>();
        Member member1 = new Member(1, "Member One");
        Member member2 = new Member(2, "Member Two");
        Member member3 = new Member(3, "Member Three");
        Member member4 = new Member(3, "Member Four");
        Member member5 = new Member(3, "Member Five");

        /**
         * library and librarian
         */
        Librarian librarian = new Librarian(1, "Mercy");
        Library newLibrary = new Library("The Great Library", memberList,bookList, librarian);

        librarian.addBook(book1);
        librarian.addBook(book2);
        librarian.addBook(book3);
        librarian.addBook(book4);
        librarian.addBook(book5);
        librarian.addBook(book6);

        librarian.addMember(member1);
        librarian.addMember(member2);
        librarian.addMember(member3);
        librarian.addMember(member4);

        //remove a member
//        librarian.removeMember(member1);

        System.out.println(newLibrary.getLibName() + " has a total of "
                + newLibrary.getBooks().stream().count()+ " books and " +
                newLibrary.getMembers().stream().count() +" members" + " librarian is: " +librarian.getName());
        System.out.println();

         member1.borrowBook(book1);
         member2.borrowBook(book2);
         member3.borrowBook(book3);
         member4.borrowBook(book4);
         member5.borrowBook(book6);

        /**
         * Get name of book borrowed by Member
         */
//        System.out.println("Member one has borrowed: " + member1.getBorrowedBooks()
//                + " ,total count is " +member1.getBorrowedBooks().size());
//        System.out.println();

        /**
         * Borrowed status of books
         */
//        System.out.println("Book one borrowed status :" + book1.isBorrowedStatus());
//        System.out.println("Book two borrowed status :" + book2.isBorrowedStatus());
//        System.out.println("Book three borrowed status :" + book3.isBorrowedStatus());
//        System.out.println("Book five borrowed status :" + book5.isBorrowedStatus());

        /**
         * Get name of book borrower
         */
//        System.out.println("book one has been borrowed by: " +book1.getBorrowerName());

        /**
         * Total number of borrowed books in the lib
         */
        newLibrary.getTotalBooksOut();
    }


}
