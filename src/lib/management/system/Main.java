package lib.management.system;
import java.util.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //add books
        Book book1 = new Book(1, "Book One");
        Book book2 = new Book(2,"Book Two");
        Book book3 = new Book(3, "Book Three");
        Book book4 = new Book(3, "Book four");
        Book book5 = new Book(3, "Book fice");


        List <Book> bookList = new ArrayList<Book>();
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);

        //members
        Member member1 = new Member(1, "Member One");
        Member member2 = new Member(2, "Member Two");
        Member member3 = new Member(3, "Member Three");
        Member member4 = new Member(3, "Member Four");

        List <Member> memberList = new ArrayList<Member>();
        memberList.add(member1);
        memberList.add(member2);
        memberList.add(member3);
        memberList.add(member4);

        // create a new Library
        Librarian librarian = new Librarian(1, "Librarian");
        Library newLibrary = new Library("The Great Library", memberList, bookList);

        librarian.addBook(book4);
        librarian.addBook(book5);

        //remove a member
        newLibrary.removeMember(member1);

        //add a member
        newLibrary.addMember(member4);

        System.out.println(newLibrary.getLibName() + " has a total of "
                + newLibrary.getBooks().stream().count()+ " books and " +
                newLibrary.getMembers().stream().count() +" members" );

         member1.borrowBook(book1);
         member1.borrowBook(book2);
         member2.borrowBook(book2);


        /**
         * Get name of book borrowed by Member
         */
        System.out.println("Member one has borrowed: " + member1.getBorrowedBooks()
                + " ,total count is " +member1.getBorrowedBooks().size());
        System.out.println();
        System.out.println("Member two has borrowed " + member2.getBorrowedBooks()
                + " ,total count is " +member2.getBorrowedBooks().size());

        /**
         * Borrowed status of books
         */
        System.out.println("Book one borrowed status :" + book1.isBorrowedStatus());
        System.out.println("Book two borrowed status :" + book2.isBorrowedStatus());
        System.out.println("Book three borrowed status :" + book3.isBorrowedStatus());

        /**
         * Get name of book borrower
         */
        System.out.println("book one has been borrowed by: " +book1.getBorrowerName());

        /**
         * Total number of borrowed books in the lib
         */
        int count = 0;
        for (Book b : bookList){
            if (b.isBorrowedStatus() == true){
                count++;
                System.out.println(b.getTitle());
            }

        }
        System.out.println("Total number of borrowed books: " +count);
    }


}
