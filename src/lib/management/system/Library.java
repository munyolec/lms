package lib.management.system;
import java.util.*;

/**
 * Keeps track of library, members and books
 */

public class Library {
    private String libName;
    private  Librarian librarian;
    private static List<Member> members;
    private static List<Book> books;
    private static int totalBooksOut;

    /**
     * create a new library
     * @param libName library name
     * @param members list of library members

     */
    public Library(String libName, List<Member> members, List<Book> books, Librarian librarian) {
        this.libName = libName;
        this.members = members;
        this.books = books;
        this.librarian = librarian;
        totalBooksOut = 0;
    }

    /**
     * @return name of library
     */
    public String getLibName() {
        return libName;
    }

    /**
     * @return library member list
     */
    public static List<Member> getMembers() {
        return members;
    }

    /**
     * @return books in the library
     */
    public List<Book> getBooks() {
        return books;
    }

    /**
     * add books to the library
     * @param bookAdded book
     */
    public static void addBooks(Book bookAdded) {
        if(books.contains(bookAdded)){
            System.out.println("Cannot add duplicate copy");
        }
        else {
            books.add(bookAdded);
        }
    }

    /**
     * @return number of borrowed books
     */
    public int getTotalBooksOut() {
        for (Book b : books){
            if (b.isBorrowedStatus() == true){
                totalBooksOut++;
            }
        }
        System.out.println("Total number of borrowed books in the library: " +totalBooksOut);
        return totalBooksOut;
    }

    /**
     * remove a member from the list
     * @param member member to be removed
     */
    public static void removeMember(Member member) {
        members.removeIf(element ->element.equals(member));
    }

    public static void addMember(Member memberAdded) {
        members.add(memberAdded);
    }

   }



