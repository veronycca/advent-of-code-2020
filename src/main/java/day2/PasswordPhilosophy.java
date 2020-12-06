package day2;

import static helpers.ReadData.splitByLinesToStringList;

import java.io.IOException;

public class PasswordPhilosophy {

  private static final String DATA_FILE = "passwords.txt";

  public static long validateRule1() throws IOException {
    return splitByLinesToStringList(DATA_FILE).stream()
        .filter(PasswordPhilosophy::isPassValidByRule1)
        .count();
  }

  public static long validateRule2() throws IOException {
    return splitByLinesToStringList(DATA_FILE).stream()
        .filter(PasswordPhilosophy::isPassValidByRule2)
        .count();
  }

  private static boolean isPassValidByRule1(String pass) {
    PasswordAndRules passwordAndRules = getPasswordRules(pass);
    long count =
        passwordAndRules
            .getPassword()
            .chars()
            .filter(ch -> ch == passwordAndRules.getRuleChar())
            .count();

    return count >= passwordAndRules.getMinValue() && count <= passwordAndRules.getMaxValue();
  }

  private static boolean isPassValidByRule2(String pass) {
    PasswordAndRules passwordAndRules = getPasswordRules(pass);
    String password = passwordAndRules.getPassword();
    char ruleChar = passwordAndRules.getRuleChar();
    char char1 = password.charAt(passwordAndRules.getMinValue() - 1);
    char char2 = password.charAt(passwordAndRules.getMaxValue() - 1);

    return (char1 == ruleChar || char2 == ruleChar) && char1 != char2;
  }

  private static PasswordAndRules getPasswordRules(String element) {
    String[] splitToRuleAndPAss = element.split(": ");
    String rule = splitToRuleAndPAss[0];
    String[] numbersAndWords = rule.split(" ");
    char ruleChar = numbersAndWords[1].replace(":", "").charAt(0);
    String[] numbersMinMax = numbersAndWords[0].split("-");
    final int min = Integer.parseInt(numbersMinMax[0]);
    final int max = Integer.parseInt(numbersMinMax[1]);

    return new PasswordAndRules(splitToRuleAndPAss[1], ruleChar, min, max);
  }
}
