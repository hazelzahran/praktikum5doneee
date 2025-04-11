import java.util.Scanner;

public class PraktikumPemlan5 {
    // Harga final jaket
    private static final int HARGA_A = 100000;
    private static final int HARGA_B = 125000;
    private static final int HARGA_C = 175000;
    
    // Harga diskon
    private static final int DISKON_A = 95000;
    private static final int DISKON_B = 120000;
    private static final int DISKON_C = 160000;
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("=== Program Transaksi Jaket CV. Labkomdas ===");
        System.out.println("Tipe Jaket:");
        System.out.println("1. Jaket A - Rp100.000/biji");
        System.out.println("2. Jaket B - Rp125.000/biji");
        System.out.println("3. Jaket C - Rp175.000/biji");
        System.out.println("Diskon berlaku jika membeli lebih dari 100 biji");
        System.out.println("---------------------------------------------");
        
        // Input jumlah jaket
        System.out.print("Masukkan jumlah Jaket A yang dibeli: ");
        int jumlahA = input.nextInt();
        
        System.out.print("Masukkan jumlah Jaket B yang dibeli: ");
        int jumlahB = input.nextInt();
        
        System.out.print("Masukkan jumlah Jaket C yang dibeli: ");
        int jumlahC = input.nextInt();
        
        // Hitung harga masing-masing jaket
        int totalA = hitungHarga(jumlahA, HARGA_A, DISKON_A);
        int totalB = hitungHarga(jumlahB, HARGA_B, DISKON_B);
        int totalC = hitungHarga(jumlahC, HARGA_C, DISKON_C);
        
        // Hitung total pembelian
        int totalPembelian = totalA + totalB + totalC;
        
        // Tampilkan hasil
        System.out.println("\n=== Rincian Pembelian ===");
        System.out.println("Jaket A: " + jumlahA + " x " + (jumlahA > 100 ? DISKON_A : HARGA_A) + " = Rp" + totalA);
        System.out.println("Jaket B: " + jumlahB + " x " + (jumlahB > 100 ? DISKON_B : HARGA_B) + " = Rp" + totalB);
        System.out.println("Jaket C: " + jumlahC + " x " + (jumlahC > 100 ? DISKON_C : HARGA_C) + " = Rp" + totalC);
        System.out.println("---------------------------------------------");
        System.out.println("Total Pembelian: Rp" + totalPembelian);
        
        input.close();
    }
    
    private static int hitungHarga(int jumlah, int hargaNormal, int hargaDiskon) {
        if (jumlah > 100) {
            return jumlah * hargaDiskon;
        } else {
            return jumlah * hargaNormal;
        }
    }
}