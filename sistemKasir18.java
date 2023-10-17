import java.util.Scanner;

public class sistemKasir18 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String namaObat ;
        int kuantitas ;
        double hargaObat, subtotal, uangDibayarkan, kembalian, totalHarga = 0;
        boolean selesai = false;

        System.out.println("==== Selamat Datang Di Apotek Maisya =====");

        while (!selesai) {
            System.out.print("Input Nama Obat: ");
            namaObat = input.nextLine();
            System.out.print("Input Kuantitas Obat: ");
            kuantitas = input.nextInt();
            System.out.print("Input Harga Obat: ");
            hargaObat = input.nextDouble();
            input.nextLine(); 

            subtotal = kuantitas * hargaObat;
            totalHarga = totalHarga + subtotal;

            System.out.println("Subtotal harga obat "+ namaObat + ":"+ subtotal);

            System.out.println("====================================");

            System.out.print("Apakah Anda ingin memasukkan obat lagi? (ya/tidak): ");
            String lanjut = input.next();
            input.nextLine(); 

            if (lanjut.equalsIgnoreCase("tidak")) {
                selesai = true;
            }
        }

        System.out.print("Apakah Anda memiliki kartu member? (ya/tidak): ");
        String member = input.nextLine();

        if (member.equalsIgnoreCase("ya")) {
            if (totalHarga < 50000) {
                totalHarga -= 5000;
            } else if (totalHarga >= 50000 && totalHarga < 150000) {
                totalHarga -= 10000;
            }
        } else {
            if (totalHarga >= 50000 && totalHarga < 150000) {
                totalHarga -= 5000;
            } else if (totalHarga >= 150000) {
                totalHarga -= 10000;
            }
        }

        System.out.println("Total Harga (termasuk potongan diskon): " + totalHarga);

        System.out.print("Input Uang yang Dibayarkan: ");
        uangDibayarkan = input.nextDouble();
        kembalian = uangDibayarkan - totalHarga;

        System.out.println("Uang Kembalian: " + kembalian);

        System.out.println("Terima kasih telah berbelanja di apotek Maisya!");
        input.close();
    }
}