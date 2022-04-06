package lib.management.system;

import java.util.*;
import java.time.LocalDate;

/**
 * Keeps track of lib members
 * id, name, number of borrowed books
 */

public class Member {
    private int id;
    private String name;
    private List <String> booksBorrowedTitle;
    private List <Book> booksBorrowed;
    private boolean hasOverDue;

    /**
     * create a new member
     * @param id member id
     * @param name member name
     */

    public Member(int id, String name) {
        this.id = id;
        this.name = name;
        this.booksBorrowedTitle = new ArrayList<String>();
        this.booksBorrowed = new ArrayList<Book>();
        this.hasOverDue = false;

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
        return this.booksBorrowedTitle;
    }
    public List<Book> getBorrowedBooks2(){
        return booksBorrowed;
    }
    public void setHasOverDue(boolean hasOverDue){
        this.hasOverDue = hasOverDue;
    }

    public boolean getHasOverDue(){
        return hasOverDue;
    }

    /**
     * Let member borrow book
     * update book borrowed status
     * @param book list of book borrowed
     */
    public void borrowBook(Book book) {
        for(Book b : getBorrowedBooks2()){
            if(b.getOverDue() == true) {
                setHasOverDue(true);
            }
        }
        if (getBorrowedBooks().size() < 3) {
            if(getHasOverDue() == false){
                if (book.isBorrowedStatus() == false) {
                    book.updateBorrowedStatus(true);
                    this.booksBorrowedTitle.add(book.getTitle());
                    this.booksBorrowed.add(book);
                    book.updateBorrowerName(getName());
                    book.setBorrowedDate(LocalDate.now());
                    book.setReturnDate((LocalDate.now().plusWeeks(1)));
                } else {
                    System.out.println("Book has already been borrowed");
            }
            } else{
                System.out.println("You have an overdue book and hence cannot borrow");
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
            booksBorrowedTitle.remove(returnedBook.getTitle());
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
