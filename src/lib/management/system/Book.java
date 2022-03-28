package lib.management.system;

/**
 * Keeps track of books in the library
 * id, title, borrowed_status, borrower
 */

public class Book {
    private int id;
    private String title;
    private  boolean borrowedStatus;
    private String borrowerName;

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
    public  void updateBorrowedStatus(boolean borrowedStatus) {
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

}
