//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.example;

public class Main {
    public static void main(String[] args) {
        BookManager bookManager = new BookManager();
        bookManager.addBook(new Book("Pemrograman", "Andi", 2026));
        bookManager.addBook(new Book("Basis Data", "Budi", 2021));
        bookManager.addBook(new Book("Java OOP", "Andi", 2022));
        System.out.println("\ud83d\udcda Daftar Semua Buku:");

        for(Book book : bookManager.getAllBooks()) {
            System.out.println(book);
        }

        System.out.println("\n\ud83d\udd0d Cari buku penulis 'Andi':");

        for(Book book : bookManager.findBooksByAuthor("Andi")) {
            System.out.println(book);
        }

        System.out.println("\n❌ Hapus buku 'Basis Data':");
        boolean removed = bookManager.removeBook("Basis Data");
        System.out.println("Berhasil dihapus? " + removed);
        System.out.println("\n\ud83d\udcda Daftar Semua Buku (Setelah Hapus):");

        for(Book book : bookManager.getAllBooks()) {
            System.out.println(book);
        }

        System.out.println("\nJumlah total buku: " + bookManager.getBookCount());
    }
}
