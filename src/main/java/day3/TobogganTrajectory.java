package day3;

import static helpers.ReadData.splitByLinesToStringList;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class TobogganTrajectory {

  private static final String DATA_FILE = "slope.txt";

  public static int calculateTreesForOneSlope() throws IOException {
    List<String> tressMap = splitByLinesToStringList(DATA_FILE);
    Coordinates coordinates = new Coordinates(3, 1);
    return calculateTrees(coordinates, tressMap);
  }

  public static BigInteger calculateTreesForMultipleSlopes() throws IOException {
    List<String> tressMap = splitByLinesToStringList(DATA_FILE);
    List<Coordinates> coordinatesList = new ArrayList<>();
    coordinatesList.add(new Coordinates(1, 1));
    coordinatesList.add(new Coordinates(3, 1));
    coordinatesList.add(new Coordinates(5, 1));
    coordinatesList.add(new Coordinates(7, 1));
    coordinatesList.add(new Coordinates(1, 2));

    return coordinatesList.stream()
        .map(coordinates -> BigInteger.valueOf(calculateTrees(coordinates, tressMap)))
        .reduce(BigInteger.valueOf(1), BigInteger::multiply);
  }

  private static int calculateTrees(Coordinates coordinates, List<String> treesMap) {
    int x = 0;
    int y = 0;

    int xStep = coordinates.getX();
    int yStep = coordinates.getY();
    int numberOfLines = treesMap.size();

    int treesNumber = 0;
    while (y + yStep < numberOfLines) {
      x += xStep;
      int treesMapXLength = treesMap.get(0).length();
      if (x > treesMapXLength - 1) {
        x -= treesMapXLength;
      }
      y += yStep;

      if (treesMap.get(y).charAt(x) == '#') {
        treesNumber += 1;
      }
    }

    return treesNumber;
  }
}
