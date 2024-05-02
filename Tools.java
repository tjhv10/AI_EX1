import java.util.ArrayList;
import java.util.List;

public class Tools {

    public static int top(int[] arr)
    {
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i+1]!=-1)
                return i;
        }
        return -1;
    }
    public static boolean full(int []arr)
    {
        return arr[0]!=0;
    }
    // Check if a move is valid on the game board
    public static boolean isValidMove(int i1,int i2,Container c1) {
       return (top(c1.getLevels()[i1])==top(c1.getLevels()[i2])&&!full(c1.getLevels()[i2])&&top(c1.getLevels()[i1])!=-1)||top(c1.getLevels()[i2])==-1&&top(c1.getLevels()[i1])!=-1;
    }

    // Perform the liquid transfer from one container to another
    public static void performMove(int fromContainer, int toContainer, Container container) {
        int[][] levels = container.getLevels();
        levels[fromContainer][0]--;
        levels[toContainer][1]++;
        container.setLevels(levels);
    }

    // Check if the containers are in the goal state
    public static boolean isGoalState(Container c) {
        int cur;
        for (int i = 0; i < c.getLevels().length; i++) {
            cur = c.getLevels()[i][0];
            for (int j = 1; j < c.getLevels()[0].length; j++)
                if (cur!=c.getLevels()[i][j]) {
                    return false;
                }
        }
        return true;
    }

    // Generate neighboring states from the current state (container)
    public static List<Container> generateNeighbors(Container currentContainer) {
        List<Container> neighbors = new ArrayList<>();
        boolean flag = false;
        int numContainers = currentContainer.getLevels().length;
        // Try pouring from each container to all other containers
        for (int from = 0; from < numContainers; from++) {
            for (int to = 0; to < numContainers; to++) {
                    flag = isValidMove(from, to, currentContainer);
                    if (flag) {
                        Container neighbor = new Container(currentContainer); // Create a copy of the current container
                        performMove(from, to, neighbor); // Perform the move
                        neighbors.add(neighbor); // Add the new container to neighbors
                }
            }
        }
        return neighbors;
    }

    // Check if two containers are equal
    public static boolean containersEqual(Container container1, Container container2) {
        int[][] levels1 = container1.getLevels();
        int[][] levels2 = container2.getLevels();

        // Check if the levels in each container are equal
        for (int i = 0; i < levels1.length; i++) {
            if (levels1[i][0] != levels2[i][0] || levels1[i][1] != levels2[i][1]) {
                return false;
            }
        }
        return true;
    }

    // Convert a container to a string representation
    public static String containerToString(Container container) {
        StringBuilder builder = new StringBuilder();
        int[][] levels = container.getLevels();

        // Append the levels of each container
        for (int i = 0; i < levels.length; i++) {
            builder.append("Container ").append(i + 1).append(": [").append(levels[i][0]).append(", ").append(levels[i][1]).append("]\n");
        }
        return builder.toString();
    }
}
