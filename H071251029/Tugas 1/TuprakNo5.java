import java.util.Scanner;

public class TuprakNo5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] nums = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };

        try {
            System.out.print("Cari angka: ");
            int cari = sc.nextInt();

            boolean ketemu = false;

            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums[i].length; j++) {
                    if (nums[i][j] == cari) {
                        System.out.println("Found " + cari + " at [" + i + "][" + j + "]");
                        ketemu = true;
                        break;
                    }
                }
                if (ketemu) break;
            }

            if (!ketemu) {
                System.out.println("Tidak ditemukan");
            }

        } catch (Exception e) {
            System.out.println("Input harus angka!");
        }
    }
}