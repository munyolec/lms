package lib.management.system;
import java.util.*;

/**
 * Keeps track of library, members and books
 */

public class Library  {
    private String libName;
    private Librarian librarian;
    private static List<Member> members;
    private static List<Book> books;
    private int totalBooksOut;

    /**
     * create a new library
     *
     * @param libName library name
     */
    public Library(String libName) {
        this.libName = libName;
        this.members = new ArrayList<Member>();
        books = new ArrayList<Book>();
        this.librarian = null;
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
        return this.members;
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
    public static void addBook(Book bookAdded) {
        if (books.contains(bookAdded)) {
            System.out.println("Cannot add duplicate copy");
        } else {
            books.add(bookAdded);
        }
    }

    /**
     * remove books
     * @param book book added
     */
    public static void removeBook(Book book) {
        books.removeIf(element -> element.equals(book));
    }

    /**
     * add a member
     * @param memberAdded member
     */
    public static void addMember(Member memberAdded) {
        if (members.contains(memberAdded)) {
            System.out.println("Cannot add duplicate member");
        } else {
            members.add(memberAdded);
        }
    }

    /**
     * remove a member from the list
     *
     * @param member member to be removed
     */
    public static void removeMember(Member member) {
        members.removeIf(element -> element.equals(member));
    }

    /**
     * add a librarian name
     * @param librarianName librarian name
     */
    public void addLibrarian(Librarian librarianName) {
        this.librarian = librarianName;
    }

    /**
     * @return name of librarian
     */
    public String getLibrarian() {
        try {
            return librarian.getName();
        } catch (NullPointerException e) {
            System.out.println("Librarian not yet added");
        }
        return null;
    }


    /**
     * @return number of borrowed books
     */
    public int getTotalBooksOut() {
        for (Book b : books) {
            if (b.isBorrowedStatus() == true) {
                totalBooksOut++;
            }
        }
        System.out.println("Borrowed books in the library: " + totalBooksOut);
        return totalBooksOut++;
    }

    /**
     * issue a book
     * @param member member borrowing a book
     * @param book book being borrowed
     */
    public static void issueBook(Member member, Book book) {
        if (members.contains(member) && books.contains(book)) {
                member.borrowBook(book);
        } else {
            System.out.println("That member or book does not exist");
        }
    }

    public List<String> getBorrowedBooks(Member member) {
        if (members.contains(member)) {
            try {
                return member.getBorrowedBooks();
            }catch (NullPointerException e){
                System.out.println("No Books borrowed");
            }
        }
        return null;
    }



    /**
     * show details of books in the library
     */
    public void booksSummary() {
        for (Book b : books) {
            System.out.println(b.getTitle() + " Borrowed status: "
                    + b.isBorrowedStatus() + "\nBorrower: "
                    + b.getBorrowerName() + "\nBorrowed date: "
                    + b.getBorrowedDate() + "\nDue date: " + b.getReturnDate());
            System.out.println();
        }
    }
}




