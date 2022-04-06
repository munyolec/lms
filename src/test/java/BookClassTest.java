import lib.management.system.Book;
import org.junit.jupiter.api.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;


public class BookClassTest {

    Book book = new Book(1,"Book One");

    @Test
    @DisplayName("test Get Book Title")
    public void testGetTitle(){
        assertEquals("Book One", book.getTitle());
    }

    @Test
    @DisplayName("test Default borrowed status is false")
    public void testBookIsBorrowed(){
        assertFalse(book.isBorrowedStatus());
    }

    @Test
    @DisplayName("test Update borrow status to true")
    public void testUpdateBorrowStatus(){
        book.updateBorrowedStatus(true);
        assertTrue(book.isBorrowedStatus());
    }

    @Test
    @DisplayName("test Default borrowed name null")
    public void testGetBorrowerName(){
        assertEquals(null, book.getBorrowerName());
    }

    @Test
    @DisplayName("test Update borrower name")
    public void testUpdateBorrowerName(){
        book.updateBorrowerName("Member One");
        assertEquals("Member One", book.getBorrowerName());
    }

    @Test
    @DisplayName("test Default borrowed date null")
    public void testGetBorrowedDate(){
        assertEquals(null, book.getBorrowedDate());
    }

    @Test
    @DisplayName("test set borrow date")
    public void testUpdateBorrowedDate(){
        book.setBorrowedDate(LocalDate.of(2022,3,19));
        assertEquals(LocalDate.of(2022,3,19), book.getBorrowedDate());
    }

    @Test
    @DisplayName("test default borrow date is null")
    public void testDefaultReturnDate(){
        assertEquals(null, book.getReturnDate());
    }

    @Test
    @DisplayName("test set return date")
    public void testUpdateReturnDate(){
        book.setReturnDate(LocalDate.of(2022,3,19));
        assertEquals(LocalDate.of(2022,3,19),book.getReturnDate());
    }

    @Test
    @DisplayName("test default overdue is false")
    public void testGetOverDue(){
        assertFalse(book.getOverDue());
    }

    @Test
    @DisplayName("test set overdue to false if return date is null")
    public void testSetOverDueFalseReturnDateNull(){
        assumingThat(book.getReturnDate() == null,
                ()-> assertFalse(book.getOverDue()));
    }

    @Test
    @DisplayName("test set overdue to true is return date already passed")
    public void testSetOverDueTrueReturnDatePast() {
        book.setReturnDate(LocalDate.of(2022,3,19));
        assumingThat(book.getReturnDate().isBefore(LocalDate.now()),
                () -> assertTrue(book.getOverDue()));
    }

    @Test
    @DisplayName("test set overdue to true is return date in the future")
    public void testSetOverDueTrueReturnDateFuture() {
        book.setReturnDate(LocalDate.of(2022,4,30));
        assumingThat(book.getReturnDate().isAfter(LocalDate.now()),
                () -> assertFalse(book.getOverDue()));
    }

    @Test
    @DisplayName("test return true if object compared to itself is true ")
    public void testEquals(){
        Book book2 = new Book(1,"Book One");
        assertTrue(book.equals(book2));
    }

}




