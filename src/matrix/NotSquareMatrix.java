package matrix;

public class NotSquareMatrix extends RuntimeException {
    private long[][] matrix;

    public NotSquareMatrix(long[][] matrix) {
        this.matrix = matrix;
    }

    @Override
    public String toString() {
        return "NotSquareMatrix" + matrix;
    }
}
