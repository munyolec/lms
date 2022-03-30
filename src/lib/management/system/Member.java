package lib.management.system;

import java.util.*;
import java.time.LocalDate;
import java.util.function.Function;

/**
 * Keeps track of lib members
 * id, name, number of borrowed books
 */

public class Member {
    private static int id;
    private  String name;
    private List <String> booksBorrowed;


    /**
     * create a new member
     * @param id member id
     * @param name member name
     */

    public Member(int id, String name) {
        this.id = id;
        this.name = name;
        this.booksBorrowed = new ArrayList<String>();
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
    public  String getName() {
        return name;
    }

    /**
     * Let member borrow book
     * update book borrowed status
     * @param booksBorrowed list of book borrowed
     */
    public void borrowBook(Book booksBorrowed) {
        if (booksBorrowed.isBorrowedStatus() == false) {
            this.booksBorrowed.add(booksBorrowed.getTitle());
            booksBorrowed.updateBorrowedStatus(true);
            booksBorrowed.updateBorrowerName(getName());
            booksBorrowed.setBorrowedDate(LocalDate.now());
            booksBorrowed.setReturnDate((LocalDate.now().plusWeeks(1)));
        }
        else{
            System.out.println("Book not available");
        }

    }
    public List<String> getBorrowedBooks(){
        return this.booksBorrowed;
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


}
