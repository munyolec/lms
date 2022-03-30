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

        /**
         * list of members to be added
         */
        List <Member> memberList = new ArrayList<Member>();
        Member member1 = new Member(1, "Member One");
        Member member2 = new Member(2, "Member Two");

        /**
         * library and librarian
         */
        Librarian librarian = new Librarian(1, "Mercy");
        Library newLibrary = new Library("The Great Library", memberList,bookList, librarian);

        librarian.addBook(book1);
        librarian.addBook(book2);

        librarian.addMember(member1);
        librarian.addMember(member2);

        System.out.println(newLibrary.getLibName() + " has a total of "
                + newLibrary.getBooks().stream().count()+ " books and " +
                newLibrary.getMembers().stream().count() +" members" + " librarian is: " +librarian.getName());
        System.out.println();

        /**
         * Borrow a book
         */
        member1.borrowBook(book1);
        member2.borrowBook(book2);
        member2.borrowBook(book1);

        for (Member m :memberList){
            System.out.println(m.getName() + " has borrowed" + m.getBorrowedBooks()
                    + " ,total count is " +m.getBorrowedBooks().size());
            System.out.println();
        }
        for (Book b : bookList){
            System.out.println(b.getTitle() +" Borrowed status: "
                    + b.isBorrowedStatus() + "\nBorrower: "
                    +b.getBorrowerName() + "\nBorrowed date: "
                    +b.getBorrowedDate() + "\nDue date: " + b.getReturnDate());
            System.out.println();
        }

        /**
         * return a book
         */
        member1.returnBook(book1);

        /**
         * Total number of borrowed books in the lib
         */
        newLibrary.getTotalBooksOut();
    }


}
