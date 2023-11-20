import java.util.Scanner;

public class MultiUser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String namaPengguna[] = { "afgan", "praja", "fasya", "maisya" };
        String password[] = { "afgan1", "praja10", "fasya12", "maisya18" };
        String nama, kataSandi;
        boolean login;

        System.out.println("********************************");
        System.out.println("SELAMAT DATANG DI APOTEK PRAFAMA");
        System.out.println("*********************************");

        do {
            System.out.print("masukkan nama pengguna : ");
            nama = sc.nextLine();
            System.out.print("masukkan password : ");
            kataSandi = sc.nextLine();

            login = false;
            for (int i = 0; i < namaPengguna.length; i++) {
                if (nama.equals(namaPengguna[i]) && kataSandi.equals(password[i])) {
                    login = true;
                    break;
                }
            }
            if (login) {
                System.out.println("");
                System.out.println("Selamat Datang " + nama);

            } else {
                System.out.println("nama pengguna atau password invalid ");
            }

        } while (!login);

        String[] namaObat = { "a", "b", "c", "d", "e", };
        int[] stok = { 5, 8, 10, 9, 6 };
        double[] harga = { 2000, 3000, 5000, 6000, 7000 };
        String obat;
        int stokies;
        double hargaa;
        boolean oke = true;

        for (int i = 0; i < namaObat.length; i++) {
            System.out.println("");
            System.out.print("masukkan nama obat : ");
            obat = sc.nextLine();
            namaObat[i] = obat;
            System.out.println("");

            if (obat.equals(namaObat[i])) {
                System.out.println("infomasi barang");
                switch (obat) {
                    case "a":
                        System.out.println("nama obat : " + namaObat[0]);
                        System.out.println("stok tersisa : " + stok[0]);
                        System.out.println("harga : " + harga[0]);
                        break;
                    case "b":
                        System.out.println("nama obat : " + namaObat[1]);
                        System.out.println("stok tersisa : " + stok[1]);
                        System.out.println("harga : " + harga[1]);
                        break;
                    case "c":
                        System.out.println("nama obat : " + namaObat[2]);
                        System.out.println("stok tersisa : " + stok[2]);
                        System.out.println("harga : " + harga[2]);
                        break;
                    case "d":
                        System.out.println("nama obat : " + namaObat[3]);
                        System.out.println("stok tersisa : " + stok[3]);
                        System.out.println("harga : " + harga[3]);
                        break;

                    default:
                        System.out.println("barang tidak tersedia");
                        break;
                }

            }
        }

    }
}
