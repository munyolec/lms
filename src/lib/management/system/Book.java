package lib.management.system;
import java.time.LocalDate;

/**
 * Keeps track of books in the library
 * id, title, borrowed_status, borrower
 */

public class Book {
    private int id;
    private String title;
    private  boolean borrowedStatus;
    private String borrowerName;
    private LocalDate borrowedDate;
    private LocalDate returnDate;

    /**
     * create a new instance of a book
     * @param id book id
     * @param title book title
     */

    public Book(int id, String title) {
        this.id = id;
        this.title = title;
        this.borrowedStatus = false;
        this.borrowerName = null;
        this.borrowedDate = null;
        this.returnDate = null;

    }

    /**
     * @return book id
     */
    public int getId() {
        return id;
    }

    /**
     * @return book title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return book borrowed status
     */
    public boolean isBorrowedStatus() {
        return borrowedStatus;
    }

    /**
     * @param borrowedStatus update book borrowed status
     */
    public void updateBorrowedStatus(boolean borrowedStatus) {
        this.borrowedStatus = borrowedStatus;
    }

    /**
     * @return borrower of the book
     */
    public String getBorrowerName() {
        return borrowerName;
    }

    /**
     * @param member book borrower
     */
    public void updateBorrowerName(String member) {
        this.borrowerName = member;
    }

    public LocalDate getBorrowedDate() {
        return borrowedDate;
    }
    public void setBorrowedDate(LocalDate date) {
        this.borrowedDate = date;
    }

    public LocalDate getReturnDate(){
        return returnDate;
    }
    public void setReturnDate(LocalDate dueDate) {
        this.returnDate = dueDate;
    }

    @Override
    public String toString() {
        return ", title='" + title + '\'' +
                ", borrowedDate=" + borrowedDate +
                ", returnDate=" + returnDate
                ;
    }
}
