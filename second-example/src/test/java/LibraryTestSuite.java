import library.Book;
import library.Library;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.stream.IntStream;

public class LibraryTestSuite {
    @Test
    public void testGetBooks() {
        //Given
        Library library1 = new Library("Library");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> library1.getBooks().add(new Book(
                        "Title " + n,
                        "Author " + n,
                        LocalDate.now().minusYears(n).minusMonths(2*n).minusDays(3*n))));

        Library library2 = null;
        try {
            library2 = library1.shallowCopy();
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        //When
        library1.getBooks().clear();
        //Then
        System.out.println(library1);
        System.out.println(library2);
        Assert.assertEquals(0, library1.getBooks().size());
        Assert.assertEquals(0, library2.getBooks().size());
    }

    @Test
    public void testGetBooks2() {
        //Given
        Library library1 = new Library("Library");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> library1.getBooks().add(new Book(
                        "Title " + n,
                        "Author " + n,
                        LocalDate.now().minusYears(n).minusMonths(2*n).minusDays(3*n))));

        Library library2 = null;
        try {
            library2 = library1.deepCopy();
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        System.out.println(library1);
        System.out.println(library2);

        //When
        library1.getBooks().clear();
        //Then
        Assert.assertEquals(0, library1.getBooks().size());
        Assert.assertEquals(10, library2.getBooks().size());
    }
}
