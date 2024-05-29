import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;



public class Tools {
    public static int top(int[] arr)
    {
        if(arr[arr.length-1]==-1)
            return -1;
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
    public static boolean isValidMove(int i1,int i2,int[][] c1) {
        if (top(c1[i1])==-1) {
            return false;
        }
        return top(c1[i2])==-1||(c1[i1][top(c1[i1])]==c1[i2][top(c1[i2])]&&!full(c1[i2]));
    }
    // Perform the liquid transfer from one container to another
    public static void performMove(int fromContainer, int toContainer, Container container) {
        int[][] levels = container.getLevels();
        int color = levels[fromContainer][top(levels[fromContainer])];
        while (top(levels[fromContainer])!=-1&&levels[fromContainer][top(levels[fromContainer])]==color&&!full(levels[toContainer])) {
            levels[fromContainer][top(levels[fromContainer])] =-1;
            if (top(levels[toContainer])==-1) {
                levels[toContainer][levels[toContainer].length-1] = color;
            }
            else{
                levels[toContainer][top(levels[toContainer])-1] = color;
            }
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
    
    public static int calculateHeuristic(Container c) {
        int heuristicValue = 0;
        int[] res = new int[c.getNumOfColors()];
        int color;
        for (int i = 0; i < c.getLevels().length; i++) {
            if (top(c.getLevels()[i])!=-1) {
                heuristicValue+=2;
                for (int j = c.getLevels()[i].length-1; j > top(c.getLevels()[i]); j--) {
                    color = c.getLevels()[i][j];
                    while (c.getLevels()[i][j-1]==color) {
                        j--;
                        if(j==0)
                        break;
                    }
                    res[color] += j - top(c.getLevels()[i]);
                }
            }
        }
        for (int i = 0; i < res.length; i++) {
            heuristicValue += res[i];
        }
        return heuristicValue - res.length+1;
    }


    // public static int calculateHeuristic(Container container) {
    //     int misplaced = 0;
    //     int emptyTubes = 0;
    //     int correctTubes = 0;
    //     int perfectTubes = 0;
    //     int heuristicValue = 0;

    //     int[][] state = container.getLevels();
    //     int numColors = container.getNumOfColors();
        
    //     for (int[] tube : state) {
    //         if (top(tube) == -1) {
    //             emptyTubes++;
    //             continue;
    //         }
    //         int correctColor = tube[tube.length - 1];
    //         for (int i = tube.length - 1; i >= 0; i--) {
    //             if (tube[i] != -1) {
    //                 correctColor = tube[i];
    //                 break;
    //             }
    //         }
    //         boolean allSameColor = true;
    //         for (int color : tube) {
    //             if (color != correctColor) {
    //                 misplaced++;
    //                 allSameColor = false;
    //             }
    //         }
    //         if (allSameColor) {
    //             correctTubes++;
    //             if (tube.length > numColors / 2) {
    //                 perfectTubes++;
    //             }                
    //         }
    //     }
    //     heuristicValue = (emptyTubes * 5) + (correctTubes * 5) - (misplaced * 2) + (perfectTubes * 5);
    //     return -1*heuristicValue;
    // }
    public static void print2DArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    public static int[][] filterArrays(int[][] arr) {
        ArrayList<int[]> filteredList = new ArrayList<>();
        boolean hasAddedFullOfNegOnes = false;

        for (int[] subArr : arr) {
            boolean isFullOfNegOnes = true;
            for (int num : subArr) {
                if (num != -1) {
                    isFullOfNegOnes = false;
                    break;
                }
            }
            if (isFullOfNegOnes && !hasAddedFullOfNegOnes) {
                filteredList.add(subArr);
                hasAddedFullOfNegOnes = true;
            } else if (!isFullOfNegOnes) {
                filteredList.add(subArr);
            }
        }

        // Convert the ArrayList back to a 2D array
        int[][] result = new int[filteredList.size()][];
        for (int i = 0; i < filteredList.size(); i++) {
            result[i] = filteredList.get(i);
        }

        return result;
    }
    public static int[][] addNewArrays(int[][] arr, int newArrays) {
        int numRows = arr.length;
        int numCols = arr[0].length;  // assuming all rows have the same number of columns

        // Create a new 2D array with the additional rows
        int[][] result = new int[numRows + newArrays][numCols];

        // Copy the original arrays into the result
        for (int i = 0; i < numRows; i++) {
            result[i] = Arrays.copyOf(arr[i], numCols);
        }

        // Add the new arrays full of -1
        for (int i = numRows; i < numRows + newArrays; i++) {
            Arrays.fill(result[i], -1);
        }
        return result;
    }
    // Generate neighboring states from the current state (container)
    public static List<Container> generateNeighbors(Container currentContainer) {
        List<Container> neighbors = new ArrayList<>();
        int numContainersStart = currentContainer.getLevels().length;
        
        currentContainer = new Container(filterArrays(currentContainer.getLevels()),currentContainer.getSteps(),currentContainer.getHeuristic(),currentContainer.getNumOfColors());

        int numContainers = currentContainer.getLevels().length;
        // Try pouring from each container to all other containers
        for (int from = 0; from < numContainers; from++) {
            for (int to = 0; to < numContainers; to++) {
                if (isValidMove(from, to, currentContainer.getLevels())&&from!=to) {
                    Container neighbor = new Container(currentContainer);
                    performMove(from, to, neighbor);
                    neighbor.setLevels(addNewArrays(neighbor.getLevels(), numContainersStart-numContainers));
                    neighbor.setSteps(currentContainer.getSteps()+1);
                    neighbor.setHeuristic(Tools.calculateHeuristic(neighbor));
                    neighbors.add(neighbor);
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
    public static boolean arraysEqual(int[] arr1, int[] arr2) {
        // Check each element of the arrays
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false; // Arrays are not equal if any elements differ
            }
        }

        return true;
    }
// Helper method to output the solution path
    public static void outputSolutionPath(Container goalContainer, Map<Container, Container> parentMap, long elapsedTime,int i) {
        List<String> path = new ArrayList<>();
        Container current = goalContainer;
        while (current != null) {
            Container parent = parentMap.get(current);
            if (parent != null) {
                int[][] parentLevels = parent.getLevels();
                int[][] currentLevels = current.getLevels();
                int[] diffIndex = findDifferentLevelIndex(parentLevels, currentLevels);
                String action = "Swap container " + diffIndex[0] + " with " + diffIndex[1];
                path.add(action+"\n"+current+'\n');
            }
            current = parent;
        }
        Collections.reverse(path);
        // System.out.println("Solution path:");
        // for (String action : path) {
        //     System.out.println(action);
        // }
        System.out.println("Puzzle has been solved in " + goalContainer.getSteps() + " steps in " + elapsedTime + " milliseconds in "+i+" itaretions.");
    }

    // Helper method to find the index of the different level between two arrays
    public static int[] findDifferentLevelIndex(int[][] levels1, int[][] levels2) {
        int[] arr = new int[2];
        boolean flag = false;
        for (int i = 0; i < levels1.length; i++) {
            if (!Tools.arraysEqual(levels1[i],levels2[i])&&flag==false) {
                arr[0] = i+1;
                flag = true;
            }
            if (!Tools.arraysEqual(levels1[i],levels2[i])&&flag==true) {
                arr[1] = i+1;
            }
        }
        return arr;
    }

    public static void updateOpenSet(Hashtable<Integer, Container> openSet, Set<String> closedSet, List<Container> neighbors) {
        for (Container neighborContainer : neighbors) {
            String neighborStateHash = neighborContainer.toString();
            int neighborHashCode = neighborContainer.hashCode();
            // Check if the neighbor is not in the closed set and not already in the open set
            if (!closedSet.contains(neighborStateHash)&& !openSet.containsKey(neighborHashCode))
                openSet.put(neighborContainer.hashCode(), neighborContainer);
        }
    }

    // Helper method to get the container with the minimum total cost from the open set
    public static Container getMinCostContainer(Hashtable<Integer, Container> openSet) {
        Container minContainer = null;
        double f;
        double minVal = Double.MAX_VALUE;
        for (Container container : openSet.values()) {
            f = container.getHeuristic()+container.getSteps();
            if (f < minVal) {
                minVal = f;
                minContainer = container;
            }
        }
        return minContainer;
    }
    public static int[][] convertStringTo2DArray(String input) {
        // Split the input string into individual arrays
        String[] arrayStrings = input.split("\\],\\[");

        // Create a 2D array with the maximum length found in the string
        int maxLength = 0;
        for (String arrayString : arrayStrings) {
            String[] elements = arrayString.replaceAll("[\\[\\]]", "").split(",");
            maxLength = Math.max(maxLength, elements.length);
        }
        int[][] result = new int[arrayStrings.length][maxLength];
        // Fill the array with values from the string
        for (int i = 0; i < arrayStrings.length; i++) {
            String[] elements = arrayStrings[i].replaceAll("[\\[\\]]", "").split(",");
            int[] intElements = new int[elements.length];
            for (int j = 0; j < elements.length; j++) {
                if (!elements[j].isEmpty()) {
                    intElements[j] = Integer.parseInt(elements[j]);
                }
                else
                {
                    intElements = new int[0];
                }
            }
            result[i] = fillArrayFromTop(intElements, maxLength);
        }
        return result;
    }

    public static int[] fillArrayFromTop(int[] arr, int maxLength) {
        int[] result = new int[maxLength];
        int len = arr.length;
        int diff = maxLength-len;
        for (int i = len-1; i >= 0; i--) {
            result[i + diff] = arr[i];
        }
        for (int i = 0; i < diff; i++) {
            result[i] = -1;
        }
        return result;
    }
    public static List<String> extractInitRows(String filePath) throws IOException {
        List<String> initRows = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        StringBuilder section = new StringBuilder();

        while ((line = reader.readLine()) != null) {
            if (line.startsWith("####")) {
                if (section.length() > 0) {
                    initRows.add(extractInitRow(section.toString()));
                    section.setLength(0); // Clear the section
                }
            } else {
                section.append(line).append("\n");
            }
        }

        // Handle the last section
        if (section.length() > 0) {
            initRows.add(extractInitRow(section.toString()));
        }

        reader.close();
        return initRows;
    }

    private static String extractInitRow(String section) {
        String[] lines = section.split("\n");
        for (String line : lines) {
            if (line.trim().startsWith("init=")) {
                return line.trim().split("=")[1];
            }
        }
        return "";
    }
    
    public static void solvePuzzle(Container initialContainer) {
        int i =0;
        List<Container> neighbors =null;
        Hashtable<Integer, Container> openSet = new Hashtable<>();
        Set<String> closedSet = new HashSet<>();
        Map<Container, Container> parentMap = new HashMap<>();
        openSet.put(initialContainer.hashCode(), initialContainer);
        long startTime = System.currentTimeMillis();
        while (!openSet.isEmpty()) {
            i++;
            Container currentContainer = Tools.getMinCostContainer(openSet);
            // System.out.println("h: "+currentContainer.getHeuristic()+" s: "+currentContainer.getSteps());
            if (Tools.isGoalState(currentContainer)) {
                long endTime = System.currentTimeMillis();
                long elapsedTime = endTime - startTime;
                Tools.outputSolutionPath(currentContainer, parentMap, elapsedTime,i);
                return;
            }
            String stateHash = currentContainer.toString();
            // System.out.println(stateHash);
            if (!closedSet.contains(stateHash)) {
                closedSet.add(stateHash);
            }
            openSet.remove(currentContainer.hashCode());
            neighbors = Tools.generateNeighbors(currentContainer);
            Tools.updateOpenSet(openSet, closedSet, neighbors);
            // for (int k = 0; k<neighbors.size(); k++)
            //     parentMap.put(neighbors.get(k), currentContainer);
        }
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("No solution found. Time elapsed: " + elapsedTime + " milliseconds In "+i+" itaretions.");
        return;
    }
}

