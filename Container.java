import java.util.Arrays;

public class Container {
    private int[][] levels;
    private int hueristic;

    
    public Container(int[][] levels) {
        this.levels = levels;
        this.hueristic = getHeuristic();
    }
    public Container() {
        this.levels = new int[0][0];
        hueristic = 0;
    }
    public Container(Container other) {
        int numRows = other.levels.length;
        int numCols = other.levels[0].length;
        this.levels = new int[numRows][numCols];
        for (int i = 0; i < numRows; i++) {
            System.arraycopy(other.levels[i], 0, this.levels[i], 0, numCols);
        }
        hueristic = other.hueristic;
    }
    public int[][] getLevels() {
        return levels;
    }

    public void setLevels(int[][] levels) {
        this.levels = levels;
    }
    public int getHeuristic()
    {
        return Tools.calculateHeuristic(this.levels);
    }
    public void setHeuristic(int val)
    {
        this.hueristic = val;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int[] row : levels) {
            sb.append(Arrays.toString(row)).append("\n");
        }
        return sb.toString() +"Hueristic value: "+ hueristic;
    }
}
