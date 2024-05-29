import java.util.Arrays;
import java.util.*;

public class Container {
    private int[][] levels;
    private int heuristic;
    private int numOfColors;
    private int steps; // New variable to store the number of steps

    // Method to calculate the number of colors
    public int numOfColors() {
        HashSet<Integer> set = new HashSet<>();
        for (int[] row : levels) {
            for (int num : row) {
                set.add(num);
            }
        }
        return set.size();
    }

    // Getter for numOfColors
    public int getNumOfColors() {
        return numOfColors;
    }

    // Constructor with levels parameter
    public Container(int[][] levels) {
        this.levels = levels;
        this.numOfColors = numOfColors();
        this.heuristic = Tools.calculateHeuristic(this);
        this.steps = 0;
    }
    public Container(int[][] levels, int steps, int heuristic, int numOfColers) {
        this.levels = levels;
        this.numOfColors = numOfColers;
        this.heuristic = heuristic;
        this.steps = steps;
    }
    // Default constructor
    public Container() {
        this.levels = new int[0][0];
        this.heuristic = 0;
        this.numOfColors = 0;
        this.steps = 0;
    }

    // Copy constructor
    public Container(Container other) {
        int numRows = other.levels.length;
        int numCols = other.levels[0].length;
        this.levels = new int[numRows][numCols];
        for (int i = 0; i < numRows; i++) {
            System.arraycopy(other.levels[i], 0, this.levels[i], 0, numCols);
        }
        this.heuristic = other.heuristic;
        this.numOfColors = other.numOfColors;
        this.steps = other.steps;
    }

    // Getter for levels
    public int[][] getLevels() {
        return levels;
    }

    // Setter for levels
    public void setLevels(int[][] levels) {
        this.levels = levels;
    }

    // Getter for heuristic
    public int getHeuristic() {
        return heuristic;
    }

    // Setter for heuristic
    public void setHeuristic(int val) {
        this.heuristic = val;
    }

    // Getter for steps
    public int getSteps() {
        return steps;
    }

    // Setter for steps
    public void setSteps(int steps) {
        this.steps = steps;
    }

    // Override toString method
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int[] row : levels) {
            sb.append(Arrays.toString(row)).append("\n");
        }
        return sb.toString();
        //  + "Heuristic value: " + heuristic + "\nSteps: " + steps;
    }
}
