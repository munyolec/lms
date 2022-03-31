package lib.management.system;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.time.LocalDate;
import java.util.function.Function;

/**
 * Keeps track of lib members
 * id, name, number of borrowed books
 */

public class Member {
    private int id;
    private String name;
    private List <String> booksBorrowed;
    private List <LocalDate> overDue;

    /**
     * create a new member
     * @param id member id
     * @param name member name
     */

    public Member(int id, String name) {
        this.id = id;
        this.name = name;
        this.booksBorrowed = new ArrayList<String>();
        this.overDue = new ArrayList<LocalDate>();
    }

    /**
     * @return member id
     */
    public  int getId() {
        return id;
    }

    /**
     * @return member name
     */
    public String getName() {
        return name;
    }

    public List<String> getBorrowedBooks(){
        return this.booksBorrowed;
    }

    public List<LocalDate> getOverDue() {
        return overDue;
    }

    /**
     * Let member borrow book
     * update book borrowed status
     * @param book list of book borrowed
     */
    public void borrowBook(Book book) {
        if (getBorrowedBooks().size() < 3) {
            if (book.isBorrowedStatus() == false) {
                this.booksBorrowed.add(book.getTitle());
                book.updateBorrowedStatus(true);
                book.updateBorrowerName(getName());
                book.setBorrowedDate(LocalDate.now());
                book.setReturnDate((LocalDate.now().plusWeeks(1)));
            } else {
                System.out.println("Book has already been borrowed");
            }
        } else {
            System.out.println("Borrow limit reached");
        }
    }
    public void returnBook(Book returnedBook){
        if (returnedBook.isBorrowedStatus() == true) {
            returnedBook.updateBorrowedStatus(false);
            returnedBook.updateBorrowerName(null);
            returnedBook.setBorrowedDate(null);
            returnedBook.setReturnDate(null);
            booksBorrowed.remove(returnedBook.getTitle());
        }
    }
    @Override
    public String toString() {
        return
                "id=" + this.getId() +
                ", name='" + this.getName() + '\'' +
                ", booksBorrowed=" + this.getBorrowedBooks()
                ;
    }

    @Override
    public boolean equals(Object o) {
        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }
        /* Check if o is an instance of Book or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Member)) {
            return false;
        }

        // typecast o to Book so that we can compare data members
        Member m = (Member) o;

        // Compare the data members and return accordingly
        return Integer.compare(id, m.id) == 0;

    }
}
