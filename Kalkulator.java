public class Kalkulator {
    // Static method untuk penjumlahan
    public static int tambah(int a, int b) {
        return a + b;
    }
    
    // Static method untuk pengurangan
    public static int kurang(int a, int b) {
        return a - b;
    }
    
    // Non-static method untuk perkalian
    public int kali(int a, int b) {
        return a * b;
    }
    
    // Non-static method untuk pembagian
    public double bagi(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Pembagi tidak boleh nol");
        }
        return (double) a / b;
    }
    
    // Non-static method untuk menyederhanakan pecahan
    public String sederhana(int pembilang, int penyebut) {
        if (penyebut == 0) {
            throw new IllegalArgumentException("Penyebut tidak boleh nol");
        }
        
        int fpb = hitungFPB(pembilang, penyebut);
        int sederhanaPembilang = pembilang / fpb;
        int sederhanaPenyebut = penyebut / fpb;
        
        if (sederhanaPenyebut == 1) {
            return Integer.toString(sederhanaPembilang);
        } else if (sederhanaPenyebut < 0) {
            // Pastikan penyebut positif
            sederhanaPembilang *= -1;
            sederhanaPenyebut *= -1;
        }
        
        return sederhanaPembilang + "/" + sederhanaPenyebut;
    }
    
    // Method untuk menghitung FPB (Faktor Persekutuan Terbesar)
    private int hitungFPB(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    public static void main(String[] args) {
        // Menggunakan static method
        System.out.println("Penjumlahan 5 + 3 = " + Kalkulator.tambah(5, 3));
        System.out.println("Pengurangan 5 - 3 = " + Kalkulator.kurang(5, 3));
        
        // Menggunakan non-static method
        Kalkulator kalkulator = new Kalkulator();
        System.out.println("Perkalian 5 * 3 = " + kalkulator.kali(5, 3));
        System.out.println("Pembagian 5 / 3 = " + kalkulator.bagi(5, 3));
        
        // Menyederhanakan pecahan
        System.out.println("Penyederhanaan 20/30 = " + kalkulator.sederhana(20, 30));
        System.out.println("Penyederhanaan 15/-9 = " + kalkulator.sederhana(15, -9));
        System.out.println("Penyederhanaan 10/2 = " + kalkulator.sederhana(10, 2));
    }
}