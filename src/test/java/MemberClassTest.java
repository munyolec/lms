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
    @DisplayName("test default borrowed books array is empty")
    public void testGetBorrowedBooksTitles() {
        assertEquals(Arrays.asList(), member.getBorrowedBookTitle());
    }


    @Test
    public void testGetBorrowedBooksObject() {
        assertThat(member.getBorrowedBooksObject()).isEmpty();
    }


    @Test
    @DisplayName("Given a new member account default overdue status is false")
    public void testGetHasOverDue(){
        Member member = new Member(1, "Member One");
        assertThat(member.getHasOverDue()).isFalse();
    }
    @Test
    @DisplayName("Test set HasOverDue to true")
    public void testSetHasOverDue(){
        Member member = new Member(1, "Member One");
        member.setHasOverDue(true);
        assertThat(member.getHasOverDue()).isTrue();
    }

    @Test
    @DisplayName("test borrow book")
    public void testBorrowBook() {
        Book book = new Book(1, "Book One");
        member.borrowBook(book);
        assertEquals(Arrays.asList("Book One"), member.getBorrowedBookTitle());
    }

    @Test
    @DisplayName("Member cannot borrow more than 3 books")
    public void testBorrowLimit() {
        Book book = new Book(1, "Book One");
        assumingThat(member.getBorrowedBookTitle().size() >= 3,
                () -> {
                    member.borrowBook(book);
                });
        assertThat(member.getBorrowedBookTitle()).hasSize(0);
        assertNotEquals(Arrays.asList("Book One"), member.getBorrowedBookTitle());
    }

    @Test
    @DisplayName("cannot borrow already borrowed book")
    public void testBorrowAvailableBooks() {
        Book book = new Book(1, "Book One");
        book.updateBorrowedStatus(true);
        member.borrowBook(book);
        assertNotEquals(Arrays.asList("Book One"), member.getBorrowedBookTitle());
        assertEquals(Arrays.asList(), member.getBorrowedBookTitle());
    }

    @Test
    @DisplayName("cannot borrow if member has an overdue book")
    public void testBorrowWithAnOverdueBook() {
        Book book = new Book(1, "Book One");
        Member member2 = new Member(2, "Member two");
        member2.setHasOverDue(true);
        member2.borrowBook(book);
        assertNotEquals(Arrays.asList("Book One"), member2.getBorrowedBookTitle());
        assertEquals(Arrays.asList(), member2.getBorrowedBookTitle());
    }

    @Test
    @DisplayName("test return book")
    public void testReturnBook() {
        Book book = new Book(1, "Book One");
        member.borrowBook(book);
        member.returnBook(book);
        assertNotEquals(Arrays.asList("Book One"), member.getBorrowedBookTitle());
        assertEquals(Arrays.asList(), member.getBorrowedBookTitle());
    }

    @Test
    @DisplayName("test return true if object compared to itself is true ")
    public void testEquals(){
        Member member2 = new Member(1, "Member One");
        assertTrue(member.equals(member2));
    }

    @Test
    public void testToString()
    {
        Member member2 = new Member(1, "Member One");
        String expected = "id=1, name='Member One', booksBorrowed=[]";
        assertThat(member2.toString()).isEqualTo(expected);

    }

}





