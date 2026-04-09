import java.util.Scanner;

public class Soal5 {
    public static void main(String[] args) {

        int[][] nums = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };

        Scanner input = new Scanner(System.in);

        try {
            System.out.print("Input: ");
            int cari = input.nextInt();

            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums[i].length; j++) {

                    if (nums[i][j] == cari) {
                        System.out.println("Found " + cari + " at [" + i + "][" + j + "]");
                        return; 
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("Input tidak valid");
        }
    }
}



 


