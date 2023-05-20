
public class PascalTriangle_recursive {
    public static void main(String[] args) {
        int rows = 6;
        
        System.out.println("\nPascal's Triangle:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(pascalRecursive(i, j) + " ");
            }
            System.out.println();
        }
    }
    
    public static int pascalRecursive(int row, int col) {
        if (col == 0 || col == row) {
            return 1;
        } else {
            return pascalRecursive(row - 1, col - 1) + pascalRecursive(row - 1, col);
        }
    }
}