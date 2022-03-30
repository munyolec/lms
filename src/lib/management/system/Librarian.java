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
    private List<Member> membersAdded;

    /**
     * create a new librarian
     * @param id librarian id
     * @param name librarian name
     */
    public Librarian(int id, String name){
        this.id = id;
        this.name = name;
        this.booksAdded = new ArrayList<Book>();
        this.membersAdded = new ArrayList<Member>();
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
        Library.addBooks(book);

    }
    public void addMember(Member member) {
        this.membersAdded.add(member);
        Library.addMember(member);

    }
    public void removeMember(Member member) {
        this.membersAdded.removeIf(element ->element.equals(member));
        Library.removeMember(member);
    }

}
