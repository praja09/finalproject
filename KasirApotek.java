/**
 * KasirApotek18
 */
import java.util.Scanner;
public class KasirApotek18 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int kuantitas;
        String namaObat;
        double harga, totalHarga;

        System.out.println("Nama Obat: ");
        namaObat = sc.nextLine();
        System.out.println("Kuantitas yang dibeli: ");
        kuantitas = sc.nextInt();
        System.out.println("Harga obat:");
        harga = sc.nextDouble();

        totalHarga = harga*kuantitas;

        if (totalHarga >=50000) {
        totalHarga = totalHarga-5000;
        }else {}

        System.out.println("total harga = " + totalHarga);

    }
}