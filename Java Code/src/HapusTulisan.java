import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class HapusTulisan {
    public static void main(String[] args) {
        String hasilAcak;
        try (Scanner input = new Scanner(System.in)) {
            String teksAsli = "qi";
            int jumlahAcak = 5; // Tentukan jumlah hasil acakan yang diinginkan

            System.out.println("Hasil Acak (" + jumlahAcak + " kali):");

            for (int i = 0; i < jumlahAcak; i++) {
                hasilAcak = acakTeks(teksAsli);

                System.out.println((i + 1) + ". " + hasilAcak);
            }

            System.out.flush(); // Memastikan tulisan langsung muncul

            try {
                // 2. Beri jeda waktu (5000 milidetik = 5 detik)
                Thread.sleep(5000);

                // 3. Hapus tulisan di terminal menggunakan ANSI Escape Code
                // \033[H memindahkan kursor ke pojok kiri atas
                // \033[2J menghapus seluruh layar terminal
                System.out.print("\033[H\033[2J");
                System.out.flush();

                for (int i = 0; i <3; i++) {
                    System.out.println("Masukkan angka tadi: ");
                    String nama = input.nextLine();
                    hasilAcak = acakTeks(teksAsli);
                    if (nama.equals(hasilAcak)) {
                        System.out.println(hasilAcak + "\n" + "Selamat, Anda berhasil mengingat simbol acak!");
                        break;
                    } else {
                        System.out.println("Maaf, jawaban Anda salah.");
                    }


                }

                // 4. Tampilkan tulisan baru setelah teks sebelumnya hilang


            } catch (InterruptedException e) {
                System.out.println("Terjadi kesalahan pada jeda waktu.");
            }
        }
    }

    public static String acakTeks(String input) {
        // 1. Ubah string menjadi List of Characters
        List<Character> karakter = new ArrayList<>();
        for (char c : input.toCharArray()) {
            karakter.add(c);
        }

        // 2. Acak urutan karakter di dalam List
        Collections.shuffle(karakter);

        // 3. Gabungkan kembali karakter menjadi String
        StringBuilder sb = new StringBuilder();
        for (char c : karakter) {
            sb.append(c);
        }

        return sb.toString();
    }
}
