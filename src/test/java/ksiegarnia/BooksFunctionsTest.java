package ksiegarnia;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BooksFunctionsTest {

    BooksFunctionOnlyForTest functionOnlyForTest = new BooksFunctionOnlyForTest();
    BooksFunctions booksFunctions = new BooksFunctions();
    List<Book> books = new ArrayList<>();

    @Before
    public void setUp(){
        books.add(new Book("Clean Code", "0132350882", 2008));
        books.add(new Book("Effective Java", "0134685997", 2018));
        books.add(new Book("Test Driven Development", "0321146530", 2003));
        books.add(new Book("Patterns of Enterprise Application Architecture", "0321127420", 2002));
        books.add(new Book("Head First Design Patterns", "0596007124", 2004));
    }

    @Test
    public void checkISBNnumber(){
//        assertEquals(books.get(0),functionOnlyForTest.findBookByISBN(books,"0132350882"));
        String expectedIsbn = "0132350882";
//        Optional<Book> bookByIsbn = functionOnlyForTest.getBookByIsbn(books,expectedIsbn);
//        if(bookByIsbn.isPresent()){
            assertEquals(books.get(0), functionOnlyForTest.getBookByIsbn(books,expectedIsbn));
//        }
//        else{
//            fail();
//        }
    }

    @Test
    public void checkIfListIsSortedByYearIncreasingly(){
        assertEquals(Arrays.asList(books.get(3),books.get(2),books.get(4),books.get(0),books.get(1)), booksFunctions.sortBooksByYearIncreasing(books));
    }

    @Test
    public void checkIfListIsSortedByYearDecreasingly(){
        Object[] booksArray = books.toArray();
        Object[] sortedBooksArray = booksFunctions.sortBooksByYearDecreasing(books).toArray();
        assertArrayEquals(new Object[]{booksArray[1],booksArray[0],booksArray[4],booksArray[2],booksArray[3]},sortedBooksArray);
    }

    @Test
    public void IsTwoLastBookReturned(){
        assertEquals(Arrays.asList(books.get(3),books.get(4)), functionOnlyForTest.getTwoLastBooks(books));
    }

    @Test
    public void IsItTheNewestBook(){
        assertEquals(books.get(1), functionOnlyForTest.getTheNewestBook(books));
    }

    @Test
    public void IsItTheOldestBook(){
        assertEquals(books.get(3), functionOnlyForTest.getTheOldestBook(books));
    }

    @Test
    public void IsSumOfPublicationYearCorrect(){
        assertEquals(10035, functionOnlyForTest.getSumOfPublicationYear(books));
    }

    @Test
    public void IsItCorrectListOfBooksPublishedAfterYear(){
        Object[] booksArray = books.toArray();
        Object[] sortedArray = booksFunctions.getBooksPublishedBeforeYear(books,2007).toArray();
        assertArrayEquals(new Object[]{booksArray[0],booksArray[1]},sortedArray);
    }

    @Test
    public void AreAllBooksPublishedAfterYear(){
        assertTrue(functionOnlyForTest.checkIfAllBooksArePublishedAfterYear(books,2000));
    }

    @Test
    public void IsAveragePublicationYearCorrect(){
        assertEquals((double)2007, functionOnlyForTest.getAveragePublicationYear(books),1);
    }

    @Test
    public void AreAllBooksPublishedBeforeYear(){
        assertTrue(functionOnlyForTest.checkIfAllBooksArePublishedBeforeYear(books,2100));
    }

    @Test
    public void IsItCorrectListStartedWithLetterAndFilteredByYear(){
        Object[] booksArray = books.toArray();
        Object[] sortedArray = functionOnlyForTest.getBooksStartedWithCertainLetterAndFilteredByYear(books,"C",2000).toArray();
        assertArrayEquals(new Object[]{booksArray[0]},sortedArray);
    }

    @Test
    public void IsAdding100YearsIsCorrect(){
        assertEquals(2108, functionOnlyForTest.addYearsToPublicationYear(books).get(0).getPublicationYear());
    }

    @Test
    public void AreTitlesDividedBy2(){
        assertEquals(books.get(0).getTitle(), functionOnlyForTest.getTitlesWhereYearIsDividedBy2(books).get(0));
    }

}
