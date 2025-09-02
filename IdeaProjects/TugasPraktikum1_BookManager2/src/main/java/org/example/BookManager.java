//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookManager {
    private final List<Book> buku = new ArrayList();

    public void addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Buku tidak boleh kosong");
        } else {
            this.buku.add(book);
        }
    }

    public boolean removeBook(String judul) {
        if (judul != null && !judul.trim().isEmpty()) {
            return this.buku.removeIf((b) -> b.getJudul_Buku().equalsIgnoreCase(judul.trim()));
        } else {
            throw new IllegalArgumentException("Judul tidak boleh kosong");
        }
    }

    public List<Book> getAllBooks() {
        return new ArrayList(this.buku);
    }

    public List<Book> findBooksByAuthor(String penulis) {
        if (penulis != null && !penulis.trim().isEmpty()) {
            return (List)this.buku.stream().filter((book) -> book.getPenulis().equalsIgnoreCase(penulis.trim())).collect(Collectors.toList());
        } else {
            throw new IllegalArgumentException("Penulis tidak boleh kosong");
        }
    }

    public List<Book> findBooksByYear(int tahun) {
        if (tahun >= 2000 && tahun <= 2100) {
            return (List)this.buku.stream().filter((book) -> book.getTahun() == tahun).collect(Collectors.toList());
        } else {
            throw new IllegalArgumentException("Tahun hanya bisa diisi dari tahun 2000 sampai 2100");
        }
    }

    public int getBookCount() {
        return this.buku.size();
    }

    public boolean containsBook(String judul) {
        if (judul != null && !judul.trim().isEmpty()) {
            return this.buku.stream().anyMatch((book) -> book.getJudul_Buku().equalsIgnoreCase(judul.trim()));
        } else {
            throw new IllegalArgumentException("Judul tidak boleh kosong");
        }
    }

    public void clearAllBooks() {
        this.buku.clear();
    }
}
