const Book = require("./book");
const BookManager = require("./BookManager");

describe("BookManager", () => {
  let bookManager;

  beforeEach(() => {
    bookManager = new BookManager();
  });

  test("Test menambahkan buku", () => {
    const book = new Book("Test Book", "Test Author", 2023);
    bookManager.addBook(book);
    expect(bookManager.getBookCount()).toBe(1);
  });

  test("Test menghapus buku yang ada", () => {
    const book = new Book("To Remove", "Author", 2023);
    bookManager.addBook(book);

    const removed = bookManager.removeBook("To Remove");
    expect(removed).toBe(true);
    expect(bookManager.getBookCount()).toBe(0);
  });

  // Test menghapus buku yang tidak ada
  test("Test menghapus buku yang tidak ada", () => {
    const removed = bookManager.removeBook("Not Exist Book");
    expect(removed).toBe(false);
    expect(bookManager.getBookCount()).toBe(0);
  });

  // Test mencari buku berdasarkan penulis
  test("Test mencari buku berdasarkan author", () => {
    const book1 = new Book("Book A", "Author1", 2020);
    const book2 = new Book("Book B", "Author2", 2021);
    const book3 = new Book("Book C", "Author1", 2022);

    bookManager.addBook(book1);
    bookManager.addBook(book2);
    bookManager.addBook(book3);

    const booksByAuthor1 = bookManager.findBooksByAuthor("Author1");

    expect(booksByAuthor1.length).toBe(2);
    expect(booksByAuthor1).toEqual(expect.arrayContaining([book1, book3]));
  });

  // Test mendapatkan semua buku
  test("Test mendapatkan semua buku", () => {
    const book1 = new Book("Book A", "Author1", 2020);
    const book2 = new Book("Book B", "Author2", 2021);

    bookManager.addBook(book1);
    bookManager.addBook(book2);

    const allBooks = bookManager.getAllBooks();

    expect(allBooks.length).toBe(2);
    expect(allBooks).toEqual(expect.arrayContaining([book1, book2]));
  });
});
