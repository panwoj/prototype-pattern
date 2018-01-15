package library;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public final class Library extends Prototype{
    String name;
    Set<Book> books = new HashSet<>();

    public Library(final String name) {
        this.name = name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        String s = "Library [" + name + "]\n";
        for(Book book : books) {
            s = s + book + "\n";
        }
        return s;
    }

    public Library shallowCopy() throws CloneNotSupportedException {
        return (Library)super.clone();
    }

    public Library deepCopy() throws CloneNotSupportedException {
        Library clonedLibrary = (Library)super.clone();
        clonedLibrary.books = new HashSet<>();
        clonedLibrary.name = this.name + " (cloned)";
        for (Book book : books) {
            String clonedBookTitle = book.getTitle();
            String clonedBookAuthor = book.getAuthor();
            LocalDate clonedBookDate = book.getPublicationDate();
            clonedLibrary.books.add(new Book(clonedBookTitle, clonedBookAuthor, clonedBookDate));
        }
        return clonedLibrary;
    }
}
