import java.util.Scanner;

public class TP1no5 {
    public static void main(String[] args) {
        int[][] nums = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Input: ");
            int target = sc.nextInt();
            boolean ketemu = false;


            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums[i].length; j++) {
                    if (nums[i][j] == target) {
                        System.out.println("Found " + target + " at [" + i + "] [" + j + "]");
                        ketemu = true;
                        break;
                    }
                }
            }

            if (!ketemu) System.out.println("Angka tidak ditemukan.");

        } catch (Exception e) {
           System.out.println("Error: Input harus berupa angka.");
        }
    }
}