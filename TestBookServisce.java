package seminars.fourth.book;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class TestBookServisce {

    @Test
    void TestBookServisce1(){
        Book Book mock() = mock(Book.class);
        when(Book.getId()).thenReturn("3");
        when(Book.getTitle()).thenReturn("Book1");
        when(Book.getAuthor()).thenReturn("Pushkin");

        TestBookServisce testBookServisce = new TestBookServisce(Book);
        assertThat(testBookServisce.findById(3)).isEqualTo("3", "Book1", "Pushkin");
    }

    @Test
    void TestBookServisce(){
        BookRepository BookRepository mock() = mock(BookRepository.class);
        when(BookRepository.findById(1)).thenReturn("1", "Book1", "Author1");
        when(BookRepository.findAll()).thenReturn(("1", "Book1", "Author1"), ("2", "Book2", "Author2"));

        TestBookServisce testBookServisce = new TestBookServisce(BookRepository);
        BookRepository.findById(1);
        verify(BookRepository, times(1)).charge("1", "Book1", "Author1");
    }
}
