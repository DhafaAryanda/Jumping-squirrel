/*
@author Dhafa Aryanda
@java version 11.0.11
link video presentasi:
https://drive.google.com/file/d/1Kxq5VwGtiTWKZ3N4zAlJvoSWlBZqzNYA/view?usp=sharing
 */
import java.util.Scanner;

public class jumpingSquirrel {
    public static int posisiTupai;
    public static int[] baris1 = {10, 20, 30, 40, 50, 60, 70, 80, 90};
    public static int[] baris2 = {11, 21, 31, 41, 51, 61, 71, 81, 91};

    //Method Arrays yang akan ditampilkan
    public static int[][] tabel = new int[][]{
            { 1,  2,  3,  4,  5,  6,  7,  8,  9, 10},
            {11, 12, 13, 14, 15, 16, 17, 18, 19, 20},
            {21, 22, 23, 24, 25, 26, 27, 28, 29, 30},
            {31, 32, 33, 34, 35, 36, 37, 38, 39, 40},
            {41, 42, 43, 44, 45, 46, 47, 48, 49, 50},
            {51, 52, 53, 54, 55, 56, 57, 58, 59, 60},
            {61, 62, 63, 64, 65, 66, 67, 68, 69, 70},
            {71, 72, 73, 74, 75, 76, 77, 78, 79, 80},
            {81, 82, 83, 84, 85, 86, 87, 88, 89, 90},
            {91, 92, 93, 94, 95, 96, 97, 98, 99, 100}
    };

    public static void main(String[] args) {
        char restart;
        int jumlahLompat = 0;
        int nol = 0;
        //looping menggunakan do while
        do {
            posisiTupai = posisiTupai();
            int totalKesempatan = kesempatan(posisiTupai);      //total kesempatan yang dimiliki
            int kesempatan;
            if (posisiTupai > 50)
                kesempatan = 10;
            else {
                kesempatan = 20;
            }

            System.out.println("==============================Jump Squirrel, Jump!===============================");
            printArray(tabel);
            Scanner getUserInput = new Scanner(System.in);
            System.out.println("\n--== Perhatian ==--");
            System.out.println("Anda diminta untuk menggerakkan tupai hingga finish pada angka 100");
            System.out.println("Tupai dapat melompat ke arah kanan, kiri, atas, dan bawah");
            System.out.println("Jika tupai kehabisan kesempatan melompat maka dinyatakan kalah");
            System.out.println("\n~~~Let's start this game!~~~\n");
            System.out.println("Tupai berada pada angka : " + posisiTupai);
            //looping untuk menampilkan sisa kesempatan melompat, jumlah lompatan,
            //serta meminta input untuk lompatan yang ingin dituju dan mengulang permainan
            for (int nilai = 0; nilai < totalKesempatan; nilai++) {
                System.out.print("\nKesempatan melompat tersisa " + (kesempatan--) + ("\n"));
                System.out.print("Melompat ke angka : ");
                int lompat = getUserInput.nextInt();
                int j;
                boolean test1 = false;
                boolean test2 = false;
                jumlahLompat++;
                //Aturan untuk melakukan lompatan
                if ((lompat - posisiTupai == 10)                //melompat ke angka yang berada di bawah
                        || (lompat - posisiTupai == 1)          //melompat ke angka yang berada di kenan
                        || (posisiTupai - lompat == 10)         //melompat ke angka yang berada di atas
                        || (posisiTupai - lompat == 1)) {       //melompat ke angka yang berada di kiri
                    for (j = 0; j <= 8; j++) {
                        if (posisiTupai == baris1[j]) {
                            test1 = true;
                            break;
                        } else if (posisiTupai == baris2[j]) {
                            test2 = true;
                            break;
                        }
                    }
                    if (test1) {
                        if ((lompat - posisiTupai == 10)
                                || (lompat - posisiTupai == 1)
                                || (posisiTupai - lompat == 10)
                                || (posisiTupai - lompat == 1)) {
                            posisiTupai = lompat;
                            System.out.print("\nTupai pada angka : " + posisiTupai);
                            if (posisiTupai == 100) {
                                System.out.println("\nSelamat! tupai telah berhasil sampai di angka 100");
                                break;
                            }
                        } else {
                            // nilai = nilai - 1;
                            jumlahLompat -= 1;
                            System.out.println("\n~Salah lompat, Coba lagi");
                            System.out.print("\nTupai pada angka : " + posisiTupai);
                        }
                    } else if (test2) {
                        if ((lompat - posisiTupai == 10)
                                || (lompat - posisiTupai == 1)
                                || (posisiTupai - lompat == 10)
                                || (posisiTupai - lompat == 1)) {
                            posisiTupai = lompat;
                            System.out.print("\nTupai pada angka : " + posisiTupai);
                            if (posisiTupai == 100) {
                                System.out.println("\nSelamat! tupai telah berhasil sampai di angka 100");
                                break;
                            }
                        } else {
                            // nilai = nilai - 1;
                            jumlahLompat -= 1;
                            System.out.println("\n~Salah lompat, Coba lagi");
                            System.out.print("\nTupai pada angka : " + posisiTupai);
                        }
                    } else {
                        posisiTupai = lompat;
                        System.out.print("\nTupai pada angka :" + posisiTupai);
                        if (posisiTupai == 100) {
                            System.out.println("\nSelamat! tupai telah berhasil sampai di angka 100");
                            break;
                        }
                    }
                } else {
                    jumlahLompat -= 1;
                    System.out.println("\n~Salah lompat, Coba lagi");
                    System.out.print("\nTupai pada angka :" + posisiTupai);
                }
            }
            if (kesempatan == nol && posisiTupai!=100)
                System.out.println("\n~~ ANDA KALAH ~~");
            System.out.println("Jumlah lompatan yaitu : " + jumlahLompat);
            System.out.println("\n\nIngin bermain lagi? (y/n)");
            getUserInput.nextLine();
            restart = getUserInput.nextLine().charAt(0);
        } while (restart == 'Y' || restart == 'y');
    }

    // Method untuk menampilkan data Arrays
    public static void printArray(int[][] dataArray) {
        System.out.print("=================================================================================");
        System.out.print("\n");
        for (int[] baris : dataArray) {
            System.out.print("|");
            for (int angka : baris) {
                System.out.print("  " + angka + "\t|");
            }
            System.out.print("\n");
        }
        System.out.println("=================================================================================");
    }

    //Method untuk menentukan posisi awal tupai secara random
    public static int posisiTupai() {
        int min = 1, max = 99;
        return posisiTupai = (int) (min + Math.random() * (max - min));
    }

    //Method untuk aturan lompatan tupai
    //jika tupai berada pada selang 1-50 maka mendapat  20 kali kesempatan melompat
    //dan jika berada pada selang 51-99 maka mendapat 10 kali kesempatan melompat
    public static int kesempatan(int posisiTupai) {
        int kesempatan;
        if (posisiTupai > 50)
            kesempatan = 10;
        else {
            kesempatan = 20;
        }
        return kesempatan;
    }
}