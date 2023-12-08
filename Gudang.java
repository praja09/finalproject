import java.util.Scanner;

public class Gudang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] namaObat = { "Alprazolam tablet", "Benzatin benzil penisilin", "Clobazam tablet", "Deksametason",
                "Entromisin kaplet", "Flukonazol tablet", "Glimepiride tablet", "Hidrokortison krim",
                "Ibu profen tablet", "Kalsium laktat tablet" };
        String[] kodeObat = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J" };
        int[] jumlah = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
        int[] hargaObat = { 120000, 150000, 125000, 265000, 115000, 290000, 110000, 95000, 30000, 70000 };

        System.out.print("Masukkan kode obat: ");
        String x = sc.nextLine();

        boolean obatDitemukan = false;
        for (int i = 0; i < kodeObat.length; i++) {
            if (kodeObat[i].equalsIgnoreCase(x)) {
                System.out.println("Kode:" + kodeObat[i]);
                System.out.println("Nama Obat:" + namaObat[i]);
                System.out.println("Jumlah:" + jumlah[i]);
                System.out.println("Harga:" + hargaObat[i]);
                obatDitemukan = true;
                break;
            }
        }
    }
}