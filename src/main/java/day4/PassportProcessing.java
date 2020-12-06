package day4;

import static helpers.ReadData.splitByEmptyLineToStringList;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PassportProcessing {

  private static final List<String> MANDATORY_FIELDS =
      Arrays.asList("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid");
  private static final String DATA_FILE = "passports.txt";

  public static long validatePassportByRule1() throws IOException {
    return splitByEmptyLineToStringList(DATA_FILE).stream()
        .filter(PassportProcessing::isValidByRule1)
        .count();
  }

  public static long validatePassportByRule2() throws IOException {
    return splitByEmptyLineToStringList(DATA_FILE).stream()
        .filter(PassportProcessing::isValidByRule2)
        .count();
  }

  private static boolean isValidByRule1(String passport) {
    return Arrays.stream(passport.split("[ \n]"))
        .map(field -> field.split(":")[0])
        .collect(Collectors.toList())
        .containsAll(MANDATORY_FIELDS);
  }

  private static boolean isValidByRule2(String passport) {
    String[] pasportFields = passport.split("[ \n]");
    Map<String, String> map = new HashMap<>();

    for (String field : pasportFields) {
      map.put(field.split(":")[0], field.split(":")[1]);
    }

    return ((map.containsKey("byr") && isYearValid(map.get("byr"), 1920, 2002))
        && (map.containsKey("iyr") && isYearValid(map.get("iyr"), 2010, 2020))
        && (map.containsKey("eyr") && isYearValid(map.get("eyr"), 2020, 2030))
        && (map.containsKey("hgt") && isHgtValid(map.get("hgt")))
        && (map.containsKey("hcl") && isHclValid(map.get("hcl")))
        && (map.containsKey("ecl") && isEclValid(map.get("ecl")))
        && (map.containsKey("pid") && isPidValid(map.get("pid"))));
  }

  private static boolean isYearValid(String value, int min, int max) {
    return value.length() == 4 && Integer.parseInt(value) >= min && Integer.parseInt(value) <= max;
  }

  private static boolean isHgtValid(String value) {
    String unit = value.substring(value.length() - 2);
    return ("cm".equals(unit) && isHeightValueValid(value, 150, 193))
        || ("in".equals(unit) && isHeightValueValid(value, 59, 76));
  }

  private static boolean isHeightValueValid(String value, int min, int max) {
    int number = Integer.parseInt(value.substring(0, value.length() - 2));
    return number >= min && number <= max;
  }

  private static boolean isHclValid(String value) {
    String code = value.substring(1);
    return '#' == (value.charAt(0)) && code.length() == 6 && Pattern.matches("^[a-f0-9]+$", code);
  }

  private static boolean isEclValid(String value) {
    List<String> eyesColors = Arrays.asList("amb", "blu", "brn", "gry", "grn", "hzl", "oth");
    return eyesColors.contains(value);
  }

  private static boolean isPidValid(String value) {
    return value.length() == 9 && Pattern.matches("^[0-9]+$", value);
  }
}
