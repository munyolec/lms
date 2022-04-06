import lib.management.system.Book;
import lib.management.system.Librarian;
import lib.management.system.Library;
import lib.management.system.Member;
import org.junit.jupiter.api.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumingThat;


public class LibraryClassTest {
    Library library = new Library("Cool Lib");

    @Test
    @DisplayName("Get library name")
    public void testGetLibName() {
        assertThat("Cool Lib").isEqualTo(library.getLibName());

    }

    @Test
    @DisplayName("default  books list is empty")
    public void testGetBooks() {
        assertThat(library.getBooks()).isEmpty();
//        assertEquals(Arrays.asList(), library.getBooks());
    }

    @Test
    @DisplayName("add a book to the library")
    public void testAddBooks() {
        Book book = new Book(1, "Book One");
        library.addBook(book);

        assertThat(library.getBooks()).isNotEmpty().hasSize(1);
    }

    @Test
    @DisplayName("test cannot add duplicate books")
    public void testAddBooksBookExists() {
        Book book = new Book(1, "Book One");
        assumingThat(library.getBooks().contains(book),() ->
        {
            library.addBook(book);
        });
        assertThat(library.getBooks()).hasSize(0);

    }

    @Test
    @DisplayName("test remove book")
    public void testRemoveBook(){
        Book book = new Book(1, "Book One");
        library.addBook(book);
        library.removeBook(book);
        assertThat(library.getBooks()).isEmpty();

    }

    @Test
    @DisplayName("test default members list is empty")
    public void testGetMembers() {
        assertThat(library.getMembers()).isEmpty();

    }

    @Test
    @DisplayName("test add members ")
    public void testAddMembers() {
        Member member = new Member(1, "Member One");

        library.addMember(member);

        assertThat(library.getMembers()).isNotEmpty().hasSize(1);

    }

    @Test
    @DisplayName("Cannot add duplicate members")
    public void testAddMembersMemberExists() {
        Member member = new Member(1, "Member One");

        assumingThat(library.getMembers().contains(member),() ->
        {
            library.addMember(member);
        });

        assertThat(library.getMembers()).hasSize(0);

    }

    @Test
    @DisplayName("test remove member")
    public void testRemoveMember(){
        Member member = new Member(1, "Member One");
        library.addMember(member);
        library.removeMember(member);
        assertThat(library.getMembers()).isEmpty();

    }

    @Test
    @DisplayName("test librarian does not exists")
    public void testLibrarianDoesNotExist() {
        assertThat(library.getLibrarian()).isNull();

    }

    @Test
    @DisplayName("test add librarian")
    public void testAddLibrarian(){
        Librarian librarian = new Librarian("Librarian",1);
        library.addLibrarian(librarian);
        assertThat("Librarian").isEqualTo(library.getLibrarian());
    }

    @Test
    @DisplayName("test library can issue a book to a member, both member and book have to be in the library")
    public void testIssueBook(){
        Member member = new Member(1, "Member One");
        Book book = new Book(1, "Book One");
        library.addBook(book);
        library.addMember(member);
        library.issueBook(member,book);

        assertThat(library.getBooks()).contains(book);
        assertThat(library.getBooks().contains(member));
        assertThat(library.getBorrowedBooks(member)).isNotEmpty().hasSize(1);
    }

    @Test
    @DisplayName("test get total number of borrowed books")
    public void testGetTotalBooksOut(){
        Member member = new Member(1, "Member One");
        Book book = new Book(1, "Book One");
        library.addMember(member);
        library.addBook(book);
        library.issueBook(member,book);
        assertThat(library.getTotalBooksOut()).isEqualTo(1);
    }

    @Test
    public void testGetBookSummary(){
        Member member = new Member(1, "Member One");
        Book book = new Book(1, "Book One");
        library.addMember(member);
        library.addBook(book);
        library.issueBook(member,book);
        library.booksSummary();
    }

}




