package lib.management.system;
import java.util.*;

/**
 * Keeps track of library, members and books
 */

public class Library {
    private String libName;
    private List <Member> members;
    private List <Book> books;
   // private static int totalBookCount;
    private static int totalBooksOut;

    /**
     * create a new library
     * @param libName library name
     * @param members list of library members
     * @param books list of library books
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
     * update members list
     * @param members added member(s)
     */
    public void updateMembers(List<Member> members) {
        this.members = members;
    }

    /**
     * @return books in the library
     */
    public List<Book> getBooks() {
        return books;
    }

    /**
     * add books to the library
     * @param books book
     */
    public void updateBooks(List<Book> books) {
        this.books = books;
    }

    /**
     * @return total number of books in the library
     */
//    public int getTotalBookCount() {
//        return totalBookCount;
//    }

    /**
     * update library book count
     * @param bookCount number of added books
     */
//    public static void updateTotalBookCount(int bookCount) {
//        totalBookCount += totalBookCount;
//    }

    /**
     * @return number of borrowed books
     */
    public int getTotalBooksOut() {
        return totalBooksOut;
    }

    /**
     * update the number of borrowed books
     * @param booksOut new number of borrowed books
     */
    public static void updateTotalBooksOut(int booksOut) {
        totalBooksOut += booksOut;
    }
}

