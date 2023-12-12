import java.util.Scanner;

public class perubahan {

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
        //SEHARUSNYA UDAH BISA INI 4 DESEMBER

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
        System.out.println("Selamat Datang " + loginUser + "!");

        boolean member = false;

        boolean backToMenu = false;
        while (true) {
            System.out.println("\nMenu Kasir Apotek ");
            System.out.println("1.Inventaris");
            System.out.println("2.Transaksi");
            System.out.println("3.Laporan Penjualan");
            System.out.println("4.Selesai");
            System.out.print("Pilih menu (1/2/3/4): ");
            int menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1:
                    boolean menuUtama = false;

                    while (true) {
                        System.out.println("\nMenu Inventory");
                        System.out.println("1.Inventory");
                        System.out.println("2.Update Stok");
                        System.out.println("3.Kembali");
                        System.out.print("Pilih Menu (1/2/3) : ");
                        String menuInventory = sc.nextLine();
                      

                        switch (menuInventory) {
                            case "1":

                                System.out.println("\nDaftar Obat : ");
                                System.out.printf("%-4s%-30s%-12s%-12s%-15s%n", "ID", "Nama Obat", "Kode Obat",
                                        "Kuantitas",
                                        "Harga per Unit");

                                for (int i = 0; i < daftarObat.length; i++) {
                                    System.out.printf("%-4d%-30s%-12s%-12s%-15s%n", i + 1, daftarObat[i][0],
                                            daftarObat[i][1],
                                            daftarObat[i][2], daftarObat[i][3]);
                                }
                                // System.out.println("==========================================");
                                while (true) {
                                    System.out.print("\nMasukkan kode obat: ");
                                    String kode = sc.nextLine();
                                    // kode = sc.nextLine(); // Membuang karakter newline
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
                                break;
                            case "2":
                                // sc.nextLine();
                                System.out.println("----------------------------------------------------");
                                System.out.println("                   Update Stok                      ");
                                System.out.println("----------------------------------------------------");

                                System.out.print("  Masukkan kode obat     : ");
                                String key = sc.nextLine();
                                for (int i = 0; i < daftarObat.length; i++) {
                                    for (int j = 0; j < daftarObat[i].length; j++) {

                                        if (daftarObat[i][j].equalsIgnoreCase(key)) {
                                            System.out.print("Masukan Stok              : ");
                                            daftarObat[i][j + 1] = sc.nextLine();

                                            System.out.println("Penambahan obat berhasil!");
                                            System.out.println("----------------------------------------------------");

                                        }

                                    }

                                }
                                break;
                            case "3":
                                backToMenu = true;
                                break;

                            default:
                                System.out.println("\nMenu inventory tidak valid!");
                                break;
                        }

                        if (backToMenu) {
                            break;
                        }
                    }
                    break;

                case 2:
                    int totalHarga = 0;
                    int diskon = 0;
                    String[] keranjang = new String[100];
                    int indexKeranjang = 0;
                    int qty = 0;

                    System.out.println("\n--------------Transaksi-----------------");
                    while (true) {
                        System.out.print("\nMasukkan kode obat yang ingin dibeli: ");
                        // sc.nextLine(); // harus tetap ada jangan di comment
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
                            sc.nextLine();

                            if (qty <= Integer.parseInt(daftarObat[idx][2])) {
                                int subtotal = Integer.parseInt(daftarObat[idx][3]) * qty;
                                System.out.println("Subtotal\t\t: " + subtotal);
                               
                                daftarObat[idx][2] = String.valueOf(qty);
                                totalHarga += subtotal;
                                keranjang[indexKeranjang] = daftarObat[idx][0];
                                indexKeranjang++;
                            } else {
                                System.out.println("---- Stok tidak mencukupi.");
                            }    
                        } else {
                            System.out.println("Kode obat tidak valid.");
                        }

                        System.out.print("\nApakah Anda ingin membeli obat lagi (ya/tidak)? ");
                        // sc.nextLine();
                        String lanjut = sc.nextLine();
                        

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
                    System.out.printf("%-4s%-30s%30s%20s%n", "ID", "Nama Obat", "Kode Obat", "Sisa Kuantitas");

                    for (int i = 0; i < indexKeranjang; i++) {
                        System.out.printf("%-4d%-30s%25s%18s%n", i + 1, keranjang[i], daftarObat[i][1],
                                daftarObat[i][2]);
                    }
                    System.out.println(
                            "---------------------------------------------------------------------------------------");
                    System.out.println("");

                    // sc.nextLine(); // INI HARUSNYA GA DISINI GAUSAH
                    System.out.print("Apakah Anda punya member (ya/tidak)? ");
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
                    System.out.println("No. Transaksi   :                                 #INV123456789");
                    System.out.println("Tanggal         :                              17 November 2023");
                    System.out.println("Kasir            :                               " + loginUser);
                    System.out.println("------------------------------------------------------------");
                    System.out.printf("%-4s%-30s%-12s%-12s%n", "ID", "Nama Obat", "Kode Obat", "Sisa Kuantitas");
                    System.out.println("------------------------------------------------------------");
                    for (int i = 0; i < indexKeranjang; i++) {
                        System.out.printf("%-4d%-30s%4s%15s%n", i + 1, keranjang[i], daftarObat[i][1],
                                daftarObat[i][2]);
                    }
                    System.out.println("------------------------------------------------------------");
                    System.out.println("Sub total       :                                 " + totalHarga);
                    System.out.println("Diskon          :                                 " + diskon);
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
                    System.out.println("Laporan Penjualan");

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