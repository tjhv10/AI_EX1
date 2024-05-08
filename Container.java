import java.util.Arrays;

public class Container {
    private int[][] levels;
    private int hueristic;
    // Regular constructor
    public Container(int[][] levels) {
        this.levels = levels;
        this.hueristic = getHeuristic();
    }

    // Default constructor
    public Container() {
        // Initialize levels with an empty array
        this.levels = new int[0][0];
        hueristic = 0;
    }

    // Copy constructor
    public Container(Container other) {
        // Copy the levels array from the other container
        int numRows = other.levels.length;
        int numCols = other.levels[0].length;
        this.levels = new int[numRows][numCols];
        for (int i = 0; i < numRows; i++) {
            System.arraycopy(other.levels[i], 0, this.levels[i], 0, numCols);
        }
        hueristic = other.hueristic;
    }

    // Getters and setters
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
        return sb.toString() + hueristic+"\n";
    }
}
