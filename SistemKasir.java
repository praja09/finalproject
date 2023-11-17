import java.util.Scanner;
public class SistemKasir {

    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("");
    System.out.println("********************************");
    System.out.println("SELAMAT DATANG DI APOTEK PRAFAMA");
    System.out.println("*********************************");
    System.out.println("");

    String namaObat, kartuMember, pembayaran;
    int jumlahObat;
    double harga, totalHarga, kembalian, uangBayar;

    //nama obat, jumlah obat dan harga
    System.out.print("masukkan nama obat : ");
    namaObat = sc.nextLine();
    System.out.print("masukkan kuantitas yang dibeli : ");
    jumlahObat = sc.nextInt();
    System.out.print("masukkan harga : ");
    harga = sc.nextDouble();
    sc.nextLine();

    totalHarga = jumlahObat*harga;
    
    System.out.println();
    System.out.println("apakah mempunyai kartu member?");
    kartuMember = sc.nextLine();
    System.out.println();

    if (kartuMember.equals("punya")) {
        if (totalHarga <= 50000) {
            totalHarga = totalHarga - 5000;
            System.out.println("mendapat diskon 5000");
            System.out.println("total bayar : " +totalHarga);
        } else {
            totalHarga = totalHarga - 10000;
            System.out.println("mendapat diskon 10000");
            System.out.println("total bayar : " +totalHarga);
        }
    } else {
        if (totalHarga <= 150000) {
            totalHarga = totalHarga - 5000;
            System.out.println("mendapat diskon 5000");
            System.out.println("total bayar : " +totalHarga);
        } else {
            totalHarga = totalHarga - 10000;
            System.out.println("mendapat diskon 10000");
            System.out.println("total bayar : " +totalHarga);
        }
    }

    System.out.println("");
    System.out.print("pembayaran melalui tunai / non tunai ? : ");
    pembayaran = sc.nextLine();

    if (pembayaran.equals("tunai")) {
        System.out.print("masukkan jumlah uang yang dibayarkan : ");
        uangBayar = sc.nextDouble();

        kembalian = uangBayar - totalHarga;
        System.out.println("kembalian = " +kembalian);

    } else {
       System.out.print("menggunakan pembayaran apa? : ");
       pembayaran = sc.nextLine();

       System.out.println("pembayaran lunas");
            
        }
    
    System.out.println("");
    System.out.println("**********************************");
    System.out.println("terima kasih sudah berbelanja :)");
    System.out.println("**********************************");
    System.out.println("");
    
    }
}