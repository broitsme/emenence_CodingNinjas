package matrix;

public class UnequalColoumnAndRow extends RuntimeException {
    private long[][] matrix1;
    private long[][] matrix2;
    public UnequalColoumnAndRow(long[][] matrix1, long[][] matrix2){
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
    }

    @Override
    public String toString() {
        return "Unequal length of column and rows matrices:"+" "+matrix1+" and "+matrix2;
    }
}
