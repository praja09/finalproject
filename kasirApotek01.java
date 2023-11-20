import java.util.Scanner;

public class kasirApotek01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[][] daftarObat = {
                { "Alprazolam tablet", "A", "10", "12000" },
                { "Benzatin benzil penisilin", "B", "20", "15000" },
                { "Clobazam tablet", "C", "30", "12500" },
                { "Deksametason", "D", "40", "26500" },
                { "Entromisin kaplet", "E", "50", "11500" },
                { "Flukonazol tablet", "F", "60", "29000" },
                { "Glimepiride tablet", "G", "70", "11000" },
                { "Hidrokortison krim", "H", "80", "9500" },
                { "Ibu profen tablet", "I", "90", "3000" },
                { "Kalsium laktat tablet", "J", "100", "7000" }
        };

        String[] username = { "afgan1", "user2", "user3", "user4" };
        String[] password = { "pass1", "pass2", "pass3", "pass4" };

        boolean loginBerhasil = false;
        String loginUser = "";

        while (!loginBerhasil) {
            System.out.print("\nMasukkan username : ");
            String user = sc.nextLine();

            System.out.print("Masukkan Password : ");
            String pw = sc.nextLine();

            for (int i = 0; i < username.length; i++) {
                if (user.equals(username[i]) && pw.equals(password[i])) {
                    loginBerhasil = true;
                    loginUser = username[i];
                    break;
                }
            }
            if (!loginBerhasil) {
                System.out.println("Username atau password salah, Silahkan coba lagi");
            }
        }
        System.out.println("\nSelamat Datang " + loginUser + "!");

        boolean member = false;

        while (true) {
            System.out.println("\nMenu Kasir Apotek :");
            System.out.println("1.Inventaris");
            System.out.println("2.Transaksi");
            System.out.println("3.Laporan Penjualan");
            System.out.println("4.Selesai");
            System.out.print("\nPilih menu (1/2/3/4): ");
            int menu = sc.nextInt();
           

            switch (menu) {
                case 1:
                    boolean kembaliKeMenuUtama = false;

                    System.out.println("\nDaftar Obat : ");
                    System.out.printf("%-4s%-30s%-12s%-12s%-15s%n", "ID", "Nama Obat", "Kode Obat", "Kuantitas",
                            "Harga per Unit");

                    for (int i = 0; i < daftarObat.length; i++) {
                        System.out.printf("%-4d%-30s%-12s%-12s%-15s%n", i + 1, daftarObat[i][0], daftarObat[i][1],
                                daftarObat[i][2], daftarObat[i][3]);
                    }
                    // System.out.println("==========================================");
                    while (true) {
                        System.out.print("\nMasukkan kode obat: ");
                        sc.nextLine(); // Membuang karakter newline
                        String kode = sc.nextLine();
                        int index = -1;
                        for (int i = 0; i < daftarObat.length; i++) {
                            if (daftarObat[i][1].equalsIgnoreCase(kode)) {
                                index = i;
                                break;
                            }
                        }

                        if (index != -1) {
                            System.out.println("Nama Obat\t: " + daftarObat[index][0]);
                            System.out.println("Kuantitas\t: " + daftarObat[index][2]);
                            System.out.println("Harga Obat\t: " + daftarObat[index][3]);
                        } else {
                            System.out.println("Kode obat tidak ditemukan.");
                        }

                        System.out.print("Apakah Anda ingin searching data lagi? (ya/tidak): ");
                        String lanjut = sc.nextLine();
                        // sc.nextLine();

                        if (lanjut.equalsIgnoreCase("tidak")) {
                            break;
                        }

                    }

                    boolean inventoryMenu = false;
                    do {
                        System.out.println("\nPilih menu inventory : ");
                        System.out.println("1.Tambah Barang baru");
                        System.out.println("2.Update Stok");
                        System.out.println("3.Kembali");
                        System.out.print("Pilih Menu Inventory (1/2/3) : ");
                        String menuInventory;
                        menuInventory = sc.next();

                        switch (menuInventory) {
                            case "1":
                                sc.nextLine();
                                System.out.println("---------------------------------------------------");

                                System.out.println("                Tambah barang baru               ");
                                System.out.println("---------------------------------------------------");

                                System.out.print("Input barang baru : ");
                                String barangBaru = sc.nextLine();

                                System.out.print("Kode obat         : ");
                                String obatBaru = sc.nextLine();

                                System.out.print("Harga             : ");
                                String hargaBaru = sc.nextLine();

                                System.out.print("Stok              : ");
                                String stokBaru = sc.nextLine();

                                break;
                            case "2":
                                System.out.println("\nUpdate Stok : ");
                                System.out.printf("%-4s%-30s%-12s%-12s%-15s%n", "ID", "Nama Obat", "Kode Obat",
                                        "Kuantitas",
                                        "Harga per Unit");

                                for (int i = 0; i < daftarObat.length; i++) {
                                    System.out.printf("%-4d%-30s%-12s%-12s%-15s%n", i + 1, daftarObat[i][0],
                                            daftarObat[i][1],
                                            daftarObat[i][2], daftarObat[i][3]);
                                }

                                System.out.print("Masukkan kode obat untuk cek stok : ");
                                sc.nextLine();
                                String kodeObatCek = sc.nextLine();



                                int indexObatCek = -1;
                                for (int i = 0; i < daftarObat.length; i++) {
                                    if (daftarObat[i][1].equalsIgnoreCase(kodeObatCek)) {
                                        indexObatCek = i;
                                        break;
                                    }
                                }

                                break;
                            case "3":
                                kembaliKeMenuUtama = true;
                                break;

                            default:
                                System.out.println("Menu tidak valid, Silahkan Pilih 1, 2, atau 3.");
                                break;

                        }
                    } while (!kembaliKeMenuUtama);

                    break;
                case 2:
                    int totalHarga = 0;
                    int diskon = 0;
                    String[] keranjang = new String[100];
                    int indexKeranjang = 0;
                    int qty = 0;

                    System.out.println("--------------Transaksi-----------------");
                    while (true) {
                        System.out.print("\nMasukkan kode obat yang ingin dibeli: ");
                        sc.nextLine(); // Membuang karakter newline
                        String x = sc.nextLine();

                        int idx = -1;
                        for (int i = 0; i < daftarObat.length; i++) {
                            if (daftarObat[i][1].equalsIgnoreCase(x)) {
                                idx = i;
                                break;
                            }
                        }

                        if (idx != -1) {
                            System.out.println("Nama Obat\t\t: " + daftarObat[idx][0]);
                            System.out.println("Harga Obat\t\t: " + daftarObat[idx][3]);
                            System.out.print("Kuantitas\t\t: ");
                            qty = sc.nextInt();

                            if (qty <= Integer.parseInt(daftarObat[idx][2])) {
                                int subtotal = Integer.parseInt(daftarObat[idx][3]) * qty;
                                System.out.println("Subtotal\t\t: " + subtotal);
                                int sisaKuantitas = Integer.parseInt(daftarObat[idx][2]) - qty;
                                daftarObat[idx][2] = String.valueOf(sisaKuantitas);
                                totalHarga += subtotal;
                                keranjang[indexKeranjang] = daftarObat[idx][0];
                                indexKeranjang++;
                            } else {
                                System.out.println("---- Stok tidak mencukupi.");
                            }
                        } else {
                            System.out.println("Kode obat tidak valid.");
                        }

                        System.out.print("Apakah Anda ingin membeli obat lagi (ya/tidak)? ");
                        String lanjut = sc.next();
                        // sc.nextLine();

                        if (lanjut.equalsIgnoreCase("tidak")) {
                            break;
                        }
                    }

                    System.out.println("");
                    System.out.println(
                            "=======================================================================================");
                    System.out.println(
                            "                             Daftar Obat dalam Keranjang                               ");
                    System.out.println(
                            "=======================================================================================");
                    System.out.printf("%-4s%-30s%30s%n", "ID", "Nama Obat", "Kode Obat");

                    for (int i = 0; i < indexKeranjang; i++) {
                        System.out.printf("%-4d%-30s%25s%n", i + 1, keranjang[i], daftarObat[i][1]);
                    }
                    System.out.println(
                            "---------------------------------------------------------------------------------------");
                    System.out.println("");

                    sc.nextLine(); // Membuang karakter newline
                    System.out.print("Apakah Anda punya kartu member (ya/tidak)? ");
                    String response = sc.nextLine();

                    if (response.equalsIgnoreCase("ya")) {
                        if (totalHarga >= 50000) {
                            System.out.println("Anda mendapatkan diskon sebesar 10.000.");
                            diskon = 10000;
                        } else {
                            System.out.println("Anda tidak memenuhi syarat untuk mendapatkan diskon.");
                        }
                    }

                    int finalHarga = totalHarga - diskon;
                    System.out.println("Total Harga\t\t: " + finalHarga);

                    int uangPelanggan = 0;
                    while (uangPelanggan < finalHarga) {
                        System.out.print("Masukkan uang anda\t: ");
                        uangPelanggan = sc.nextInt();
                        if (uangPelanggan <= finalHarga) {
                            System.out.println("Uang yang diberikan kurang, silakan coba lagi.");
                        }

                    }
                    int kembalian = uangPelanggan - finalHarga;

                    System.out.println("\n============================================================");
                    System.out.println("                 STRUK PEMBAYARAN - INVOICE");
                    System.out.println("============================================================");
                    System.out.println("No. Transaksi   :                              #INV123456789");
                    System.out.println("Tanggal         :                              17 November 2023");
                    System.out.println(  "Kasir           :                              " + loginUser);
                    System.out.println("------------------------------------------------------------");
                    System.out.printf("%-4s%-30s%-12s%n", "ID", "Nama Obat", "Kode Obat");
                    System.out.println("------------------------------------------------------------");
                    for (int i = 0; i < indexKeranjang; i++) {
                        System.out.printf("%-4d%-30s%4s%15s%n", i + 1, keranjang[i], daftarObat[i][1]);
                    }
                    System.out.println("------------------------------------------------------------");
                    System.out.println("Sub total       :                                 " + "Rp " + totalHarga);
                    System.out.println("Diskon          :                                 " + "Rp " + diskon);
                    System.out.println("------------------------------------------------------------");
                    System.out.println("Total           :                                 " + "Rp " + finalHarga);
                    System.out.println("Tunai           :                                 " + "Rp " + uangPelanggan);
                    System.out.println("Kembali         :                                 " + "Rp " + kembalian);
                    System.out.println("------------------------------------------------------------");
                    System.out.println(
                            "                TERIMA KASIH, LEKAS MEMBAIK                                       ");
                    System.out.println(
                            "               POP MEDIKA GAK TUTUP, ADA OBAT!                                    ");
                    System.out.println(
                            "            ======== LAYANAN KONSUMEN ========                                    ");
                    System.out.println(
                            "                      0857 4957 7424                                              ");
                    System.out.println(
                            "                    popmedika@gmail.com                                           ");
                    System.out.println("============================================================");

                    // double kembalian = uangPelanggan - finalHarga;
                    // System.out.println("");
                    // System.out.println("------------------------------------------");
                    // System.out.println("Kembalian : Rp " + kembalian);
                    // System.out.println("");
                    // System.out.println("Terimakasih Telah belanja!");
                    // System.out.println("------------------------------------------");
                    break;
                case 3:
                    System.out.println("Cetak Struk");
                    // Tambahkan logika untuk mencetak struk disini
                    break;

                case 4:
                    System.out.println("=--------------------------------------------=");
                    System.out.println("Terima kasih telah berbelanja di apotek kami!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Menu tidak valid. Silakan pilih menu 1, 2, 3, atau 4.");
                    break;
            }
        }
    }
}