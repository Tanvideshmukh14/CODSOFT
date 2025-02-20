import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        int EnglishScore;
        int HindiScore;
        int MathsScore;
        int ScienceScore;
        int SSTScore;
        double totalMarksObtained;
        double percentage;

        Scanner Input = new Scanner(System.in);

        System.out.println("Enter your English Marks : ");
        EnglishScore = Input.nextInt();

        System.out.println("Enter your Hindi Marks : ");
        HindiScore = Input.nextInt();

        System.out.println("Enter your Maths Marks : ");
        MathsScore = Input.nextInt();

        System.out.println("Enter your Science Marks : ");
        ScienceScore = Input.nextInt();

        System.out.println("Enter your SST Marks : ");
        SSTScore = Input.nextInt();

        totalMarksObtained = EnglishScore + HindiScore + MathsScore + ScienceScore + SSTScore;
        System.out.println("Total marks obtained : " + totalMarksObtained);

        percentage = (totalMarksObtained / 500) * 100;
        System.out.println("Average percentage scored : " + percentage + "%");

        if (percentage > 90){
            System.out.println("Grade obtained :  A Grade");
        } else if (percentage > 80) {
            System.out.println("Grade obtained :  B Grade");
        } else if (percentage > 75) {
            System.out.println("Grade obtained :  C Grade");
        } else if (percentage > 35) {
            System.out.println("Grade obtained :  D Grade");
        }else {
            System.out.println("Grade obtained : Fail");
        }

    }
}
