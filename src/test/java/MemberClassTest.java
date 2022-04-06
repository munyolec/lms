import lib.management.system.Book;
import lib.management.system.Member;
import org.junit.jupiter.api.*;
import java.time.LocalDate;
import java.util.Arrays;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

public class MemberClassTest {
    Member member = new Member(1, "Member One");

    @Test
    @DisplayName("test Get Member Name")
    public void testGetName() {
        assertEquals("Member One", member.getName());
    }

    @Test
    @DisplayName("test Get Member Id")
    public void testGetID() {
        assertEquals(1, member.getId());
    }

    @Test
    @DisplayName("test default hasOverDue is false")
    public void testHasOverDue() {
        assertEquals(false, member.getHasOverDue());
    }

    @Test
    @DisplayName("test set hasOverDue to true")
    public void testSetOverDueTrue() {
        member.setHasOverDue(true);
        assertEquals(true, member.getHasOverDue());
    }

    @Test
    @DisplayName("test default borrowed books array is empty")
    public void testGetBorrowedBooks() {
        assertEquals(Arrays.asList(), member.getBorrowedBooks());
    }

    @Test
    @DisplayName("test borrow book")
    public void testBorrowBook() {
        Book book = new Book(1, "Book One");
        member.borrowBook(book);
        assertEquals(Arrays.asList("Book One"), member.getBorrowedBooks());
    }

    @Test
    @DisplayName("Member cannot borrow more than 3 books")
    public void testBorrowLimit() {
        Book book = new Book(1, "Book One");
        assumingThat(member.getBorrowedBooks().size() >= 3,
                () -> {
                    member.borrowBook(book);
                });
        assertThat(member.getBorrowedBooks()).hasSize(0);
        assertNotEquals(Arrays.asList("Book One"), member.getBorrowedBooks());
    }

    @Test
    @DisplayName("cannot borrow already borrowed book")
    public void testBorrowAvailableBooks() {
        Book book = new Book(1, "Book One");
        book.updateBorrowedStatus(true);
        member.borrowBook(book);
        assertNotEquals(Arrays.asList("Book One"), member.getBorrowedBooks());
        assertEquals(Arrays.asList(), member.getBorrowedBooks());
    }

    @Test
    @DisplayName("cannot borrow if member has an overdue book")
    public void testBorrowWithAnOverdueBook() {
        Book book = new Book(1, "Book One");
        Member member2 = new Member(2, "Member two");
        member2.setHasOverDue(true);
        member2.borrowBook(book);
        assertNotEquals(Arrays.asList("Book One"), member2.getBorrowedBooks());
        assertEquals(Arrays.asList(), member2.getBorrowedBooks());
    }

    @Test
    @DisplayName("test return book")
    public void testReturnBook() {
        Book book = new Book(1, "Book One");
        member.borrowBook(book);
        member.returnBook(book);
        assertNotEquals(Arrays.asList("Book One"), member.getBorrowedBooks());
        assertEquals(Arrays.asList(), member.getBorrowedBooks());
    }

    @Test
    @DisplayName("test return true if object compared to itself is true ")
    public void testEquals(){
        Member member2 = new Member(1, "Member One");
        assertTrue(member.equals(member2));
    }

}





