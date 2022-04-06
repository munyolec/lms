import lib.management.system.Book;
import lib.management.system.Librarian;
import lib.management.system.Library;
import lib.management.system.Member;
import org.junit.jupiter.api.*;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class LibrarianClassTest {
   Librarian librarian = new Librarian("Librarian",1);

    @Test
    @DisplayName("test get library name")
    public void testGetLibrarianName() {
        assertEquals("Librarian", librarian.getName());
    }

    @Test
    @DisplayName("test get library Id")
    public void testGetLibrarianId() {
        assertEquals(1, librarian.getId());
    }

    @Test
    @DisplayName("test add books")
    public void testAddBooks() {
        Library library = new Library( "Library One");
        Book book = new Book(1, "Book One");
        librarian.addBook(book);
        assertEquals(Arrays.asList(book), library.getBooks());
    }

    @Test
    @DisplayName("test remove book")
    public void testRemoveBook(){
        Book book = new Book(1, "Book One");
        Library library = new Library( "Library One");
        librarian.addBook(book);
        librarian.removeBook(book);
        assertEquals(Arrays.asList(), library.getBooks());
    }

    @Test
    @DisplayName("test add members")
    public void testAddMembers() {
        Library library = new Library( "Library One");
        Member member = new Member(1, "Member One");
        librarian.addMember(member);
        assertEquals(Arrays.asList(member), library.getMembers());
    }

    @Test
    @DisplayName("test remove book")
    public void testRemoveMember(){
        Library library = new Library( "Library One");
        Member member = new Member(1, "Member One");
        librarian.addMember(member);
        librarian.removeMember(member);
        assertEquals(Arrays.asList(), library.getBooks());
    }

    @Test
    @DisplayName("test issue book")
    public void testIssueBook() {
        Library library = new Library( "Library One");
        Member member = new Member(1, "Member One");
        Book book = new Book(1, "Book One");
        librarian.addBook(book);
        librarian.addMember(member);
        librarian.issueBook(member,book);
        assertEquals(Arrays.asList("Book One"), library.getBorrowedBooks(member));
    }

}
