import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;


public class Tools {
    public static int top(int[] arr)
    {
        boolean flag= false;
        if(arr[0]==-1)
            flag = true;
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i+1]!=-1)
               { 
                    if(flag)
                        return i+1;
                    return i;
               }
        }
        return -1;
    }
    public static boolean full(int []arr)
    {
        return arr[0]!=-1;
    }
    // Check if a move is valid on the game board
    public static boolean isValidMove(int i1,int i2,Container c1) {
        if (top(c1.getLevels()[i1])==-1) {
            return false;
        }
        return top(c1.getLevels()[i2])==-1||(c1.getLevels()[i1][top(c1.getLevels()[i1])]==c1.getLevels()[i2][top(c1.getLevels()[i2])]&&!full(c1.getLevels()[i2]));
    }
    // Perform the liquid transfer from one container to another
    public static void performMove(int fromContainer, int toContainer, Container container) {
        int[][] levels = container.getLevels();
        int color = levels[fromContainer][top(levels[fromContainer])];
        levels[fromContainer][top(levels[fromContainer])] =-1;
        if (top(levels[toContainer])==-1) {
            levels[toContainer][levels[toContainer].length-1] = color;
        }
        else{
            levels[toContainer][top(levels[toContainer])-1] = color;
        }
        container.setLevels(levels);
    }
    // Check if the containers are in the goal state
    public static boolean isGoalState(Container c) {
        int cur;
        for (int i = 0; i < c.getLevels().length; i++) {
            cur = c.getLevels()[i][0];
            for (int j = 0; j < c.getLevels()[0].length; j++)
                if (cur!=c.getLevels()[i][j]) {
                    return false;
                }
        }
        return true;
    }
    public static int numOfColores(int[][] levels)
    {
        HashSet<Integer> set = new HashSet<>();
        for (int[] row : levels) {
            for (int num : row) {
                set.add(num);
            }
        }
        return set.size()-1;
    }
    public static int calculateHeuristic(int[][] levels) {
        int heuristicValue = 0;
        int[] res = new int[numOfColores(levels)+2];
        res[0] = 0;
        int color;
        for (int i = 0; i < levels.length; i++) {
            if (top(levels[i])!=-1) {
                for (int j = levels[i].length-1; j > top(levels[i]); j--) {
                    color = levels[i][j];
                    while (levels[i][j-1]==color) {
                        j--;
                        if(j==0)
                        break;
                    }
                    // int top = top(levels[i]);
                    res[color] += j - top(levels[i]);
                }
            }
        }
        for (int i = 0; i < res.length; i++) {
            heuristicValue += res[i];
        }
        return heuristicValue;
    }

    // Generate neighboring states from the current state (container)
    public static List<Container> generateNeighbors(Container currentContainer) {
        List<Container> neighbors = new ArrayList<>();
        int numContainers = currentContainer.getLevels().length;
        // Try pouring from each container to all other containers
        for (int from = 0; from < numContainers; from++) {
            for (int to = 0; to < numContainers; to++) {
                if (isValidMove(from, to, currentContainer)&&from!=to) {
                    Container neighbor = new Container(currentContainer); // Create a copy of the current container
                    performMove(from, to, neighbor);
                    neighbor.setHeuristic(neighbor.getHeuristic());
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
