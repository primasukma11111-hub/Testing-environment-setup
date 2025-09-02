//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.List;
import org.example.Book;
import org.example.BookManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BookManagerTest {
    private BookManager bookManager;

    @BeforeEach
    void setUp() {
        this.bookManager = new BookManager();
    }

    @Test
    @DisplayName("Test menambahkan buku")
    void testAddBook() {
        Book buku = new Book("Pemrograman", "Andi", 2020);
        this.bookManager.addBook(buku);
        Assertions.assertEquals(1, this.bookManager.getBookCount());
    }

    @Test
    @DisplayName("Test menghapus buku yang ada")
    void testRemoveExistingBook() {
        Book buku = new Book("Basis Data", "ErLangga", 2021);
        this.bookManager.addBook(buku);
        boolean removed = this.bookManager.removeBook("Basis Data");
        Assertions.assertTrue(removed);
        Assertions.assertEquals(0, this.bookManager.getBookCount());
    }

    @Test
    @DisplayName("Test menghapus buku yang tidak ada")
    void testRemoveNonExistingBook() {
        boolean removed = this.bookManager.removeBook("Tidak Ada");
        Assertions.assertFalse(removed);
    }

    @Test
    @DisplayName("Test mencari buku berdasarkan author")
    void testFindBooksByAuthor() {
        Book buku = new Book("Java", "Dewo", 2025);
        this.bookManager.addBook(buku);
        List<Book> result = this.bookManager.findBooksByAuthor("Dewo");
        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals("Java", ((Book)result.get(0)).getJudul_Buku());
    }

    @Test
    @DisplayName("Test mendapatkan semua buku")
    void testGetAllBooks() {
        Book buku1 = new Book("Java", "Dewo", 2025);
        Book buku2 = new Book("Python", "Andi", 2024);
        this.bookManager.addBook(buku1);
        this.bookManager.addBook(buku2);
        List<Book> allBooks = this.bookManager.getAllBooks();
        Assertions.assertEquals(2, allBooks.size());
    }
}
