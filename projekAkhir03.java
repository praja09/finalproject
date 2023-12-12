import java.util.Scanner;

public class projekAkhir03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] kode = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J" };
        String[] obat = { "Alprazolam Tablet", "Benzatin benzil penisilin", "Clobazam tablet", "Deksametason",
                "Entromisin kaplet", "Flukonazol tablet", "Glimepiride tablet", "Hidrokortison krim",
                "Ibu profen tablet", "Kalsium laktat tablet" };
        int[] kuantitas = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 10 };
        int[] harga = { 12000, 15000, 12500, 26500, 11500, 29000, 11000, 9500, 3000, 7000 };

        String[] username = new String[10];
        username[0] = ("afgan1");
        username[1] = ("dipa10");
        username[2] = ("fasya12");
        username[3] = ("maisya18");

        String[] password = new String[10];
        password[0] = ("pass1");
        password[1] = ("pass2");
        password[2] = ("pass3");
        password[3] = ("pass4");

        String[][] dataPenjualan = new String[100][100];
        int jumlahTransaksi = 0;

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
            System.out.println("4.Buat Akun");
            System.out.println("5.Selesai");
            System.out.print("Pilih menu (1/2/3/4/5): ");
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

                                for (int i = 0; i < obat.length; i++) {
                                    System.out.printf("%-4d%-30s%-12s%-12s%-15s%n", i + 1, obat[i], kode[i],
                                            kuantitas[i], harga[i]);

                                }

                                while (true) {
                                    System.out.print("\nMasukkan kode obat  : ");
                                    String kodeObat = sc.nextLine();

                                    int index = -1;
                                    for (int i = 0; i < obat.length; i++) {
                                        if (kode[i].equalsIgnoreCase(kodeObat)) {
                                            index = i;
                                            break;
                                        }
                                    }

                                    if (index != -1) {
                                        System.out.println("Nama obat\t: " + obat[index]);
                                        System.out.println("Kuantitas\t: " + kuantitas[index]);
                                        System.out.println("Harga\t\t: " + harga[index]);
                                    } else {
                                        System.out.println("Kode obat tidak ditemukan!");
                                    }

                                    System.out.print("Apakah Anda ingin searching data lagi? (ya/tidak): ");
                                    String lanjut = sc.nextLine();

                                    if (lanjut.equalsIgnoreCase("tidak")) {
                                        break;
                                    }
                                }
                                break;
                            case "2":
                                System.out.println("----------------------------------------------------");
                                System.out.println("                   Update Stok                      ");
                                System.out.println("----------------------------------------------------");

                                System.out.print("Masukkan kode obat\t: ");
                                String key = sc.nextLine();

                                for (int i = 0; i < obat.length; i++) {
                                    if (kode[i].equalsIgnoreCase(key)) {
                                        System.out.print("Masukkan stok\t   : ");
                                        kuantitas[i] = sc.nextInt();

                                        System.out.println("Penambahan obat berhasil!");
                                        System.out.println("----------------------------------------------------");

                                        sc.nextLine();

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
                    int[] qtyArray = new int[100];
                    int indexKeranjang = 0;
                    int qty = 0;

                    System.out.println("\n--------------Transaksi-----------------");
                    System.out.print("Masukkan tanggal\t\t: ");
                    String tanggal = sc.nextLine();
                    while (true) {
                        System.out.print("\nMasukkan kode obat yang ingin dibeli    : ");

                        String x = sc.nextLine();

                        int idx = -1;
                        for (int i = 0; i < keranjang.length; i++) {
                            if (kode[i].equalsIgnoreCase(x)) {
                                idx = i;
                                break;

                            }

                        }

                        if (idx != -1) {
                            System.out.println("Nama Obat\t\t: " + obat[idx]);
                            System.out.println("Harga Obat\t\t: " + harga[idx]);
                            System.out.print("Kuantitas\t\t: ");
                            qty = sc.nextInt();
                            sc.nextLine();

                            if (qty <= kuantitas[idx]) {

                                int subtotal = harga[idx] * qty;
                                System.out.println("Subtotal\t\t: " + subtotal);

                                kuantitas[idx] -= (qty);
                                totalHarga += subtotal;
                                keranjang[indexKeranjang] = obat[idx];
                                qtyArray[indexKeranjang] = qty;
                                indexKeranjang++;

                            } else {
                                System.out.println("Stok tidak mencukupi!");
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
                    System.out.printf("%-4s%-30s%30s%20s%n", "ID", "Nama Obat", "Kode Obat", "Kuantitas");

                    for (int i = 0; i < indexKeranjang; i++) {
                        System.out.printf("%-4d%-30s%25s%18s%n", i + 1, keranjang[i], kode[i], qtyArray[i]);

                    }
                    System.out.println(
                            "---------------------------------------------------------------------------------------");
                    System.out.println("");

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
                    System.out.println("Tanggal         :                              " + tanggal);
                    System.out.println("Kasir            :                               " + loginUser);
                    System.out.println("------------------------------------------------------------");
                    System.out.printf("%-4s%-30s%-12s%n", "ID", "Nama Obat", "Kuantitas");
                    System.out.println("------------------------------------------------------------");

                    for (int i = 0; i < indexKeranjang; i++) {
                        System.out.printf("%-4d%-30s%15s%n", i + 1, keranjang[i],
                                qtyArray[i]);
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

                    dataPenjualan[jumlahTransaksi][0] = tanggal;
                    dataPenjualan[jumlahTransaksi][1] = loginUser;

                    // Simpan informasi barang yang dibeli
                    for (int i = 0; i < indexKeranjang; i++) {
                        dataPenjualan[jumlahTransaksi][2 + i * 3] = keranjang[i];
                        dataPenjualan[jumlahTransaksi][3 + i * 3] = Integer.toString(qtyArray[i]);
                        dataPenjualan[jumlahTransaksi][4 + i * 3] = Integer.toString(harga[i] * qtyArray[i]);
                    }

                    dataPenjualan[jumlahTransaksi][6] = Integer.toString(finalHarga);

                    // TAMBAHIN JUMLAH TRANSAKSI
                    jumlahTransaksi++;
                    break;
                case 3:
                    System.out.println("\nLaporan Penjualan");
                    for (int i = 0; i < jumlahTransaksi; i++) {
                        System.out.println("-----------------------------------------");
                        System.out.println("Nomor Transaksi     : #" + (i + 1));
                        System.out.println("Tanggal             : " + dataPenjualan[i][0]);
                        System.out.println("Kasir               : " + dataPenjualan[i][1]);
                        System.out.println("-----------------------------------------");

                        // Menampilkan barang yang dibeli
                        for (int j = 2; j < dataPenjualan[i].length - 1; j += 3) {
                            if (dataPenjualan[i][j] != null) {
                                System.out.println("\nBarang              : " + dataPenjualan[i][j]);
                                System.out.println("Kuantitas           : " + dataPenjualan[i][j + 1]);
                                System.out.println("Total Harga         : " + dataPenjualan[i][j + 2]);
                            }
                        }

                        System.out.println("\nTotal Pendapatan    : " + dataPenjualan[i][6]);
                    }
                    break;
                case 4:
                    int pengguna = 4;
                    boolean kembaliKeMenuAkun = false;

                    while (!kembaliKeMenuAkun) {
                        System.out.println("\nMenu Akun");
                        System.out.println("1.Buat Akun");
                        System.out.println("2.Daftar Akun");
                        System.out.println("3.Kembali");
                        System.out.print("Pilih Menu (1/2/3): ");
                        String pilihMenuAkun = sc.nextLine();

                        switch (pilihMenuAkun) {
                            case "1":
                                // Tambahkan akun baruz
                                System.out.print("\nMasukkan nama: ");
                                username[pengguna] = sc.nextLine();
                                System.out.print("Masukkan password: ");
                                password[pengguna] = sc.nextLine();
                                pengguna++;
                                System.out.println("Akun berhasil ditambahkan!");
                                break;
                            case "2":
                                // Tampilkan daftar akun
                                System.out.println("\n=========================================================");
                                System.out
                                        .println("                       DAFTAR AKUN                                ");
                                System.out.println("=========================================================");
                                System.out.printf("\n%-4s%-30s%20s%n", "ID", "Username", "Password");

                                for (int i = 0; i < username.length; i++) {
                                    if (username[i] != null && password[i] != null) {
                                        System.out.printf("%-4d%-30s%20s%n", i + 1, username[i], password[i]);
                                    }
                                }
                                System.out.println("---------------------------------------------------------");
                                break;
                            case "3":
                                // Kembali ke menu utama
                                kembaliKeMenuAkun = true;
                                break;
                            default:
                                System.out.println("Menu tidak valid. Silakan pilih menu 1, 2, atau 3.");
                                break;
                        }
                    }
                    break;

                // for (int i = 0; i < username.length; i++) {
                // System.out.print("masukkan nama : ");
                // username[pengguna] = sc.nextLine();
                // System.out.print("masukkan password : ");
                // password[pengguna] = sc.nextLine();
                // System.out.println("akun sudah ditambahkan");
                // break;
                // }

                case 5:
                    
                    System.out.println("=--------------------------------------------=");
                    System.out.println("Terima kasih telah berbelanja di apotek kami!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Menu tidak valid!. Silakan pilih menu 1, 2, 3, 4, atau 5.");
                    break;

            }

        }

    }
}