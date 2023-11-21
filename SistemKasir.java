import java.util.Scanner;
public class SistemKasir {

    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("");
    System.out.println("********************************");
    System.out.println("SELAMAT DATANG DI APOTEK PRAFAMA");
    System.out.println("*********************************");
    System.out.println("");

    String kartuMember, pembayaran,tambahan;
    String namaObat [] = new String [10];
    int jumlahObat [] = new int [10];
    double harga [] = new double [10];
    double totalHarga, kembalian, uangBayar; 
    int i = 0;
    
    //nama obat, jumlah obat dan harga
    do {
        
        System.out.print("masukkan nama obat : ");
        namaObat [i] = sc.next();
        System.out.print("masukkan kuantitas yang dibeli : ");
        jumlahObat[i]= sc.nextInt();
        System.out.print("masukkan harga : ");
        harga [i] = sc.nextDouble();
        System.out.print("apakah ada tambahan? (y/n) : ");
        tambahan = sc.next();
    
    } while (tambahan.equalsIgnoreCase("y"));
    
    totalHarga  = jumlahObat[i] * harga[i];
    
    System.out.println();
    System.out.println("apakah mempunyai kartu member?");
    kartuMember = sc.next();
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
    pembayaran = sc.next();

    if (pembayaran.equals("tunai")) {
        System.out.print("masukkan jumlah uang yang dibayarkan : ");
        uangBayar = sc.nextDouble();

        kembalian = uangBayar - totalHarga;
        System.out.println("kembalian = " +kembalian);

    } else {
       System.out.print("menggunakan pembayaran apa? : ");
       pembayaran = sc.next();

       System.out.println("pembayaran lunas");
    }
    
    System.out.println("");
    System.out.println("**********************************");
    System.out.println("terima kasih sudah berbelanja :)");
    System.out.println("**********************************");
    System.out.println("");
    
    }
}
