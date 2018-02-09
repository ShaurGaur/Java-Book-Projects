import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int userNum;
        do {
            System.out.print("Enter a numeric grade (negative number to quit): ");
            userNum = input.nextInt();
            if (isValidNumber(userNum, 0, 100)) {
                System.out.printf("The grade %s is a(n) %s.\n", userNum, getLetterGrade(userNum));
            }
        } while(userNum > -1);
    }

    public static boolean isValidNumber(int user, int min, int max) {
        if (min <= user  && user <= max) return true;
        else return false;
    }

    public static String getLetterGrade(int num) {
        if (num < 60) return "F";
        else if (num < 70) return "D";
        else if (num < 80) return "C";
        else if (num < 90) return "B";
        else return "A";
    }
}
