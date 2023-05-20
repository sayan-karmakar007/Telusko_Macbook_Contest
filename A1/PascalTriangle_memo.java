import java.util.HashMap;
import java.util.Map;


public class PascalTriangle_memo {
    public static Map<String, Integer> memo;

    public static void main(String[] args) {
        int rows = 6;
        memo = new HashMap<>();

        System.out.println("\nPascal's Triangle:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(pascaltriangle(i, j) + " ");
            }
            System.out.println();
        }
    }

    public static int pascaltriangle(int row, int col) {
        String key = row + "-" + col;

        if (col == 0 || col == row) {
            return 1;
        } else if (memo.containsKey(key)) {
            return memo.get(key);
        } else {
            int result = pascaltriangle(row - 1, col - 1) + pascaltriangle(row - 1, col);
            memo.put(key, result);
            return result;
        }
    }
}
