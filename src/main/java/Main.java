import static day1.ReportRepair.calculateForThreeValues;
import static day1.ReportRepair.calculateForTwoValues;
import static day2.PasswordPhilosophy.validateRule1;
import static day2.PasswordPhilosophy.validateRule2;
import static day3.TobogganTrajectory.calculateTreesForMultipleSlopes;
import static day3.TobogganTrajectory.calculateTreesForOneSlope;
import static day4.PassportProcessing.validatePassportByRule1;
import static day4.PassportProcessing.validatePassportByRule2;

import java.io.IOException;

public class Main {

  public static void main(String[] args) throws IOException {

    System.out.println("=== DAY1 ===");
    System.out.println(calculateForTwoValues());
    System.out.println(calculateForThreeValues());
    System.out.println("=== DAY2 ===");
    System.out.println(validateRule1());
    System.out.println(validateRule2());
    System.out.println("=== DAY3 ===");
    System.out.println(calculateTreesForOneSlope());
    System.out.println(calculateTreesForMultipleSlopes());
    System.out.println("=== DAY4 ===");
    System.out.println(validatePassportByRule1());
    System.out.println(validatePassportByRule2());
  }
}


