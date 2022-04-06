package lib.management.system;
import java.time.LocalDate;

/**
 * Keeps track of books in the library
 * id, title, borrowed_status, borrower
 */

public class Book {
    private int id;
    private String title;
    private boolean borrowedStatus;
    private String borrowerName;
    private LocalDate borrowedDate;
    private LocalDate returnDate;
    private Boolean isOverDue;


    /**
     * create a new instance of a book
     *
     * @param id    book id
     * @param title book title
     */

    public Book(int id, String title) {
        this.id = id;
        this.title = title;
        this.borrowedStatus = false;
        this.borrowerName = null;
        this.borrowedDate = null;
        this.returnDate = null;
        this.isOverDue = false;
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

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate dueDate) {
        this.returnDate = dueDate;
        setOverDue();
    }

    public void setOverDue() {
        if(getReturnDate() == null){
            isOverDue = false;
        }
        else if (getReturnDate().isBefore(LocalDate.now())){
            isOverDue = true;
        }
        else if (getReturnDate().isAfter(LocalDate.now())){
            isOverDue = false;
        }
    }
    public boolean getOverDue(){
        return isOverDue;
    }
    @Override
    public boolean equals(Object o) {
        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }
        /* Check if o is an instance of Book or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Book)) {
            return false;
        }

        // typecast o to Book so that we can compare data members
        Book b = (Book) o;

        // Compare the data members and return accordingly
        return Integer.compare(id, b.id) == 0;

    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                '}';
    }
}
