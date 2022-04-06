package lib.management.system;

public interface ManageLibrary {
    void addBook(Book book);
    void addMember(Member member);
    void removeBook(Book book);
    void removeMember(Member member);
    void issueBook(Member member,Book book);
}
