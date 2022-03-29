package lib.management.system;

import java.util.ArrayList;
import java.util.List;

/**
 * Librarian class
 */
public class Librarian {
    private int id;
    private String name;
    private List<Book> booksAdded;

    /**
     * create a new librarian
     * @param id librarian id
     * @param name librarian name
     */
    public Librarian(int id, String name){
        this.id = id;
        this.name = name;
        this.booksAdded = new ArrayList<Book>();
    }

    /**
     * @return librarian ID
     */
    public int getId() {
        return id;
    }

    /**
     * @return librarian Name
     */
    public String getName() {
        return name;
    }
    public void addBook(Book book) {
        this.booksAdded.add(book);
        Library.updateBooks(book);

//
    }

}
