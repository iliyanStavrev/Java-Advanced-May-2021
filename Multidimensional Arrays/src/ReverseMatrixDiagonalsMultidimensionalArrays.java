import java.util.*;

public class ReverseMatrixDiagonalsMultidimensionalArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int[][]matrix = new int[dimensions[0]][dimensions[1]];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }
        Map<Integer , List<Integer>>diagonals = new LinkedHashMap<>();


        for (int group = 0,diagonal = 0, row = matrix.length - 1; row >= 0 ; row--,diagonal = group++) {
            for (int col = matrix[row].length - 1; col >= 0  && col >= group;col--,diagonal++) {

                addValue(diagonals,matrix[row][col],diagonal);

            }
            for (int r = matrix.length - 2 - group; r >= 0 && group < dimensions[1]; r--,diagonal++) {
               addValue(diagonals,matrix[r][group],diagonal);
            }
        }
        diagonals.entrySet().stream()
                .forEach(v ->
                        System.out.printf("%s %n",v.getValue()));
    }

    private static void addValue(Map<Integer, List<Integer>> diagonals, int value, int diagonal) {
        diagonals.putIfAbsent(diagonal,new ArrayList<>());
        diagonals.get(diagonal).add(value);
    }
}
