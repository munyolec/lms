## Overview
### Functions of Library
* keep track of number books & members in the library 
* add a book
* remove a book 
* add a member 
* remove a member 

### Library Class
* Name
* Members
* Books
* Total books borrowed
* Total books owned

### Members Class
* id
* name
* books borrowed

### Books Class
* id
* title
* borrowed_status
* borrower_name
* borrowed_date
* return_date

### Rules
* a book needs to exist to borrow.
* a book has a due return date.
* a member can borrow a maximum of 3 books at a time.
* a member cannot borrow a book if they have a book with
  them past due date.