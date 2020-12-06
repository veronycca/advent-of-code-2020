package day1;

import static helpers.ReadData.splitByLinesToIntegerList;

import java.io.IOException;
import java.util.List;

public class ReportRepair {

  private static final int EXPENSES_SUM = 2020;
  private static final String DATA_FILE = "expenses.txt";

  public static int calculateForTwoValues() throws IOException {
    List<Integer> expenses = splitByLinesToIntegerList(DATA_FILE);
    for (int i = 0; i < expenses.size(); i++) {
      for (int j = 1; j < expenses.size(); j++) {
        if (expenses.get(i) + expenses.get(j) == EXPENSES_SUM) {
          return expenses.get(i) * expenses.get(j);
        }
      }
    }
    return 0;
  }

  public static int calculateForThreeValues() throws IOException {
    List<Integer> expenses = splitByLinesToIntegerList(DATA_FILE);
    for (int i = 0; i < expenses.size(); i++) {
      for (int j = 1; j < expenses.size(); j++) {
        for (int k = 0; k < expenses.size(); k++) {
          if (expenses.get(i) + expenses.get(j) + expenses.get(k) == EXPENSES_SUM) {
            return expenses.get(i) * expenses.get(j) * expenses.get(k);
          }
        }
      }
    }
    return 0;
  }
}
