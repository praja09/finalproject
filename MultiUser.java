import java.util.Scanner;

public class MultiUser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String namaPengguna[] = new String[10];
        namaPengguna[0] = "afgan";
        namaPengguna[1] = "praja";
        namaPengguna[2] = "fasya";
        namaPengguna[3] = "maisya";

        String password[] = new String[10];
        password[0] = "afgan1";
        password[1] = "praja10";
        password[2] = "fasya12";
        password[3] = "maisya18";

        int pengguna = 4;
        String nama, kataSandi;
        boolean login;
        String shift = "tidak", akun;

        System.out.println("********************************");
        System.out.println("SELAMAT DATANG DI APOTEK PRAFAMA");
        System.out.println("*********************************");

        while (true) {
            System.out.print("sudah punya akun? ");
            akun = sc.nextLine();

            if (akun.equalsIgnoreCase("sudah")) {
                System.out.print("masukkan nama pengguna    : ");
                nama = sc.nextLine();
                System.out.print("masukkan password         : ");
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
                }

            } else if (akun.equalsIgnoreCase("belum")) {
                for (int i = 0; i < namaPengguna.length; i++) {
                    System.out.print("masukkan nama : ");
                    namaPengguna[pengguna] = sc.nextLine();
                    System.out.print("masukkan password : ");
                    password[pengguna] = sc.nextLine();

                    System.out.println("\nselamat datang " + namaPengguna[pengguna]);
                    pengguna++;
                    break;
                }

            } else {
                System.out.println("nama pengguna atau password invalid ");
            }

            int menu;
            do {
                System.out.println("\nMenu Kasir Apotek :");
                System.out.println("1.Inventaris");
                System.out.println("2.Transaksi");
                System.out.println("3.Laporan Penjualan");
                System.out.println("4.Selesai");
                System.out.print("\nPilih menu (1/2/3/4): ");
                menu = sc.nextInt();
                sc.nextLine();

                switch (menu) {
                    case 1:
                        System.out.println("menu inventaris");
                        break;

                    case 2:
                        System.out.println("menu transaksi");
                        break;

                    case 3:
                        System.out.println("menu laporan penjualan");
                        
                        break;

                    case 4:
                        System.out.print("apakah ingin ganti shift ? ");
                        shift = sc.nextLine();

                        if (shift.equals("iya")) {
                            continue;
                        } else {
                            break;
                        }
                }

            } while (menu != 4);

        }
    }

}
