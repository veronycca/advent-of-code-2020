package helpers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReadData {

  public static List<String> splitByLinesToStringList(String subPath) throws IOException {
    return Arrays.asList(Files.readString(Paths.get("src/main/resources/", subPath)).split("\n"));
  }

  public static List<Integer> splitByLinesToIntegerList(String subPath) throws IOException {
    return Arrays.stream(Files.readString(Paths.get("src/main/resources/", subPath)).split("\n"))
        .map(Integer::parseInt)
        .collect(Collectors.toList());
  }

  public static List<String> splitByEmptyLineToStringList(String subPath) throws IOException {
    return Arrays.asList(Files.readString(Paths.get("src/main/resources/", subPath)).split("\\n\\n"));
  }
}
