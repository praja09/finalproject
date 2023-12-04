import java.util.Scanner;

public class CobaAja {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] namaObat = { "Alprazolam tablet", "Benzatin benzil penisilin", "Clobazam tablet", "Deksametason",
                "Entromisin kaplet", "Flukonazol tablet", "Glimepiride tablet", "Hidrokortison krim",
                "Ibu profen tablet", "Kalsium laktat tablet" };
        String[] kodeObat = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J" };
        int[] jumlah = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
        int[] hargaObat = { 12000, 15000, 12500, 26500, 11500, 29000, 11000, 9500, 3000, 7000 };

        System.out.println("         ====== SELAMAT DATANG DI APOTEK PRAFAMA ======        ");
        System.out.println("");

        System.out.println("Daftar Obat : ");
        System.out.printf("%-4s%-30s%-12s%-12s%-15s%n", "ID", "Nama Obat", "Kode Obat", "Kuantitas", "Harga per Unit");

        for (int i = 0; i < namaObat.length; i++) {
            System.out.printf("%-4s%-30s%-12s%-12d%-15d%n", i, namaObat[i], kodeObat[i], jumlah[i], hargaObat[i]);
        }

        while (true) {

            System.out.print("Masukkan kode obat: ");
            String x = sc.nextLine();

            boolean obatDitemukan = false;
            int kuantitas = 0;
            double totalHarga = 0;

            for (int i = 0; i < kodeObat.length; i++) {
                if (kodeObat[i].equalsIgnoreCase(x)) {
                    System.out.println("Kode : " + kodeObat[i]);
                    System.out.println("Nama Obat : " + namaObat[i]);
                    System.out.println("Kuantitas : " + jumlah[i]);
                    System.out.println("Harga : " + hargaObat[i]);

                    System.out.print("Jumlah obat yang dibeli: ");
                    kuantitas = sc.nextInt();

                    int harga = hargaObat[i];
                    totalHarga = kuantitas * harga;

                    System.out.println("Total harga : " + totalHarga);
                    obatDitemukan = true;
                    break;
                }
            }

            if (!obatDitemukan) {
                System.out.println("Obat tidak ditemukan!");
                continue;
            } else {
                System.out.print("Apakah Anda memiliki kartu member (ya/tidak)? ");
                String memilikiKartu = sc.next();

                if (memilikiKartu.equalsIgnoreCase("ya")) {
                    if (totalHarga >= 50000) {
                        totalHarga -= 10000;
                        System.out.println("Anda mendapatkan diskon sebesar 10.000.");
                    } else {
                        System.out.println("Anda tidak memenuhi syarat untuk mendapatkan diskon.");
                    }
                }

                System.out.println("Total harga setelah diskon: " + totalHarga);

                double uangPelanggan = 0;
                while (uangPelanggan < totalHarga) {
                    System.out.print("Masukkan uang yang diberi: ");
                    uangPelanggan = sc.nextDouble();
                    if (uangPelanggan < totalHarga) {
                        System.out.println("Uang yang diberikan kurang, silakan coba lagi.");
                    }
                }

                double kembalian = uangPelanggan - totalHarga;

                System.out.println("Kembalian : Rp " + kembalian);
                System.out.println("Terimakasih Telah belanja!");

                System.out.println("apakah sudah makan?");
                sc.nextLine();

                break;
            }
        }

    }
}