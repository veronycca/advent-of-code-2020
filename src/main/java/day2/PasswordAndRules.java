package day2;

public class PasswordAndRules {

  private String password;
  private char ruleChar;
  private int minValue;
  private int maxValue;

  public PasswordAndRules(String password, char ruleChar, int minValue, int maxValue) {
    this.password = password;
    this.ruleChar = ruleChar;
    this.minValue = minValue;
    this.maxValue = maxValue;
  }

  public String getPassword() {
    return password;
  }

  public char getRuleChar() {
    return ruleChar;
  }

  public int getMinValue() {
    return minValue;
  }

  public int getMaxValue() {
    return maxValue;
  }
}
