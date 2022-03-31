package lib.management.system;

import java.util.ArrayList;
import java.util.List;

public class Librarian implements ManageLibrary{
    private String name;
    private int id;
    private List<Member> members;
    private List<Book> books;

    public Librarian(String name, int id) {
        this.name = name;
        this.id = id;
        this.members = new ArrayList<Member>();
        this.books = new ArrayList<Book>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void addBook(Book book) {
        Library.addBook(book);
    }

    @Override
    public void addMember(Member member) {
        Library.addMember(member);
    }

    @Override
    public void removeBook(Book book) {
        Library.removeBook(book);

    }

    @Override
    public void removeMember(Member member) {
        Library.removeMember(member);

    }
}
