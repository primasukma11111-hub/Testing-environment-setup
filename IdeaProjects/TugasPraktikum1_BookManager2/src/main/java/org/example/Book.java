//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.example;

import java.util.Objects;

public class Book {
    private final String Judul_Buku;
    private final String Penulis;
    private final int Tahun;

    public Book(String judul_buku, String penulis, int tahun) {
        if (judul_buku != null && !judul_buku.trim().isEmpty()) {
            if (penulis != null && !penulis.trim().isEmpty()) {
                if (tahun >= 2000 && tahun <= 2100) {
                    this.Judul_Buku = judul_buku.trim();
                    this.Penulis = penulis.trim();
                    this.Tahun = tahun;
                } else {
                    throw new IllegalArgumentException("Tahun hanya bisa diisi dari tahun 2000 sampai 2100");
                }
            } else {
                throw new IllegalArgumentException("Author harus diisi");
            }
        } else {
            throw new IllegalArgumentException("Judul harus diisi");
        }
    }

    public String getJudul_Buku() {
        return this.Judul_Buku;
    }

    public String getPenulis() {
        return this.Penulis;
    }

    public int getTahun() {
        return this.Tahun;
    }

    public String toString() {
        return String.format("%s by %s (%d)", this.Judul_Buku, this.Penulis, this.Tahun);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj != null && this.getClass() == obj.getClass()) {
            Book book = (Book)obj;
            return this.Tahun == book.Tahun && this.Judul_Buku.equals(book.Judul_Buku) && this.Penulis.equals(book.Penulis);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.Judul_Buku, this.Penulis, this.Tahun});
    }
}
