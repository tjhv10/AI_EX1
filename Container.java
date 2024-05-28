import java.util.Arrays;
import java.util.*;

public class Container {
    private int[][] levels;
    private int hueristic;
    private int numOfColoers;

    public int numOfColores()
    {
        HashSet<Integer> set = new HashSet<>();
        for (int[] row : levels) {
            for (int num : row) {
                set.add(num);
            }
        }
        return set.size();
    }
    public int getNumOfColores()
    {
        return numOfColoers;
    }
    public Container(int[][] levels) {
        this.levels = levels;
        this.numOfColoers = numOfColores();
        this.hueristic = Tools.calculateHeuristic(this);
    }
    public Container() {
        this.levels = new int[0][0];
        hueristic = 0;
        numOfColoers = 0;
    }
    public Container(Container other) {
        int numRows = other.levels.length;
        int numCols = other.levels[0].length;
        this.levels = new int[numRows][numCols];
        for (int i = 0; i < numRows; i++) {
            System.arraycopy(other.levels[i], 0, this.levels[i], 0, numCols);
        }
        hueristic = other.hueristic;
        numOfColoers = other.numOfColoers;
    }
    public int[][] getLevels() {
        return levels;
    }

    public void setLevels(int[][] levels) {
        this.levels = levels;
    }
    public int getHeuristic()
    {
        return hueristic;
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
