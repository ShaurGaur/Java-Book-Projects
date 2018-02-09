/**
 * Created by shauryavratxg19 on 9/26/2017.
 */
import java.util.Scanner;

public class AverageValue {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int intboi;
        int count = 0;
        int total = 0;

        do {
            System.out.printf("Enter a number (0 to quit): ");
            intboi = input.nextInt();
            total += intboi;
            count++;
        } while (intboi != 0);
        count--;

        double average = (double) total / (double) count;
        System.out.printf("Average value: %s", average);
    }
}
