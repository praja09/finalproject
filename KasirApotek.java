import java.util.Scanner;

public class KasirApotek {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);


        int     kuantitas;
        String  namaObat;
        double   harga, totalHarga;
        boolean memilikiKartuMember;

        System.out.println("Nama Obat: ");
        namaObat = sc.nextLine();
        System.out.println("kuantitas");
        kuantitas = sc.nextInt();
        System.out.println("Harga :");
        harga = sc.nextDouble();
        System.out.println("Apakah Anda memiliki kartu member (true/false)");
        memilikiKartuMember = sc.nextBoolean();

    
        totalHarga = kuantitas*harga;

        if (memilikiKartuMember) {
            if (totalHarga >= 50000){
                totalHarga = totalHarga - 20000;
            }

         

        } else {
            if (totalHarga >= 150000){
                totalHarga = totalHarga - 20000;
            }
        }
       
       System.out.print("Total Harga = " + totalHarga);
        
        sc.close();
    }


    
}
