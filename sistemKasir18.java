import java.util.Scanner;

public class sistemKasir18 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] keranjang = new String[100];
        int indexKeranjang = 0;

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

            keranjang[indexKeranjang] = namaObat;
            indexKeranjang++;

            System.out.println("Subtotal harga obat "+ namaObat + ":"+ subtotal);

            System.out.println("====================================");

            System.out.print("Apakah Anda ingin memasukkan obat lagi? (ya/tidak): ");
            String lanjut = input.next();
            input.nextLine(); 

            if (lanjut.equalsIgnoreCase("tidak")) {
                selesai = true;
            }
        }

        System.out.println("Daftar Obat dalam Keranjang:");
        for(int i = 0; i < indexKeranjang; i++){
            System.out.println((i+1) + ". " + keranjang[i]);
        }        
        
        System.out.println("Apakah Anda ingin mencari item di keranjang? (ya/tidak): ");
        String searchChoice = input.nextLine();
        if(searchChoice.equalsIgnoreCase("ya")){
            System.out.print("Masukkan nama obat yang ingin Anda cari: ");
            String cariObat = input.nextLine();
            int indexing = 0;

            for (int i=0; i < keranjang.length; i++) {
                if (cariObat==keranjang[i]) {
                    indexing=i;
                    break;
                }
            }
            System.out.println("Obat "+cariObat+" Terdapat di Index "+indexing);
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
                totalHarga-=10000;
            }
        }

        // ... Bagian kode yang tersisa tetap tidak berubah ...

        System.out.println("Total Harga (termasuk potongan diskon): " + totalHarga);

        System.out.print("Input Uang yang Dibayarkan: ");
        uangDibayarkan = input.nextDouble();
        kembalian = uangDibayarkan - totalHarga;

        System.out.println("Uang Kembalian: " + kembalian);

        System.out.println("Terima kasih telah berbelanja di apotek Maisya!");
        input.close();
    }
}
