import java.util.Arrays;
import java.util.Scanner;

public class ParkingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int []dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        boolean[][] isOccupied  = new boolean[dimensions[0]][dimensions[1]];
        for (int i = 0; i < isOccupied.length; i++) {
            isOccupied[i][0] = true;
        }
        String input = scanner.nextLine();



        while (!input.equals("stop")){
        String []tokens = input.split("\\s+");
        int entryRow = Integer.parseInt(tokens[0]);
        int targetRow = Integer.parseInt(tokens[1]);
        int targetCol = Integer.parseInt(tokens[2]);

        boolean freePlace = false;
            int distance = 1;
          distance += Math.abs(targetRow - entryRow);

          if (!isOccupied[targetRow][targetCol]){
              distance += targetCol;
              isOccupied[targetRow][targetCol] = true;
              freePlace = true;
          }
          else {
              for (int i = 1; i < isOccupied[targetRow].length ; i++) {
                  if (targetCol - i > 0 && !isOccupied[targetRow][targetCol - i]){
                      distance += targetCol - i;
                      isOccupied[targetRow][targetCol - i] = true;
                      freePlace = true;
                      break;
                  }
                  if (targetCol + i < isOccupied[targetRow].length  && !isOccupied[targetRow][targetCol + i]){
                      distance += targetCol + i;
                      isOccupied[targetRow][targetCol + i] = true;
                      freePlace = true;
                      break;
                  }
              }
          }
          if (freePlace){
              System.out.println(distance);
          }else {
              System.out.printf("Row %d full%n",targetRow);
          }

            input = scanner.nextLine();
        }
    }
}
