package lib.management.system;
import java.util.*;

/**
 * Keeps track of library, members and books
 */

public class Library {
    private String libName;
    private List<Librarian> librarian;
    private List<Member> members;
    private static List<Book> books;
    private static int totalBooksOut;

    /**
     * create a new library
     *
     * @param libName library name
     * @param members list of library members
     * @param books   list of library books
     */
    public Library(String libName, List<Member> members, List<Book> books) {
        this.libName = libName;
        this.members = members;
        this.books = books;
        //  totalBookCount = 0;
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
    public List<Member> getMembers() {
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
     *
     * @param bookAdded book
     */
    public static void updateBooks(Book bookAdded) {
        books.add(bookAdded);
    }

    /**
     * @return number of borrowed books
     */
    public int getTotalBooksOut() {
        return totalBooksOut;
    }

    /**
     * update the number of borrowed books
     *
     * @param booksOut new number of borrowed books
     */
    public static void updateTotalBooksOut(int booksOut) {
        totalBooksOut += booksOut;
    }

    /**
     * remove a member from the list
     * @param member member to be removed
     */
    public void removeMember(Member member) {
        this.members.removeIf(element ->element.equals(member));
    }

    public void addMember(Member member) {
        this.members.add(member);

    }

   }



