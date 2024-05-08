import java.util.*;

public class AStarPuzzleSolver{
    // Method to solve the puzzle using A* algorithm
    public void solvePuzzle(Container initialContainer) {
        // Initialize data structures for open and closed sets
        Hashtable<Integer, Container> openSet = new Hashtable<>();
        Set<String> closedSet = new HashSet<>();        
        // Map to store the parent of each container
        Map<Container, Container> parentMap = new HashMap<>();
        
        // Create the initial state and add it to the open set
        openSet.put(initialContainer.hashCode(), initialContainer);
        long startTime = System.currentTimeMillis();
        
        // Continue searching until the open set is empty or the maximum node count is reached
        while (!openSet.isEmpty()) {
            // Get the state with the minimum total cost from the open set
            Container currentContainer = getMinCostContainer(openSet);            
            // Check if the current state is the goal state
            if (Tools.isGoalState(currentContainer)) {
                // Record end time
                long endTime = System.currentTimeMillis();
                // Calculate elapsed time
                long elapsedTime = endTime - startTime;
                // Output the solution path
                outputSolutionPath(currentContainer, parentMap,elapsedTime);
                return;
            }
            
            // Remove the current state from the open set and mark it as visited in the closed set
            String stateHash = currentContainer.toString();
            if (closedSet.contains(stateHash)) {
                closedSet.remove(stateHash);
            }
            closedSet.add(stateHash);
            openSet.remove(currentContainer.hashCode());
            
            // Generate neighbors and update the open set
            List<Container> neighbors = Tools.generateNeighbors(currentContainer);
            neighbors.sort(Comparator.comparingInt(Container::getHeuristic));
            updateOpenSet(openSet, closedSet, neighbors);
            
            // Store parent-child relationship for backtracking
            for (Container neighbor : neighbors) {
                parentMap.put(neighbor, currentContainer);
            }
        }
        
        // Record end time if no solution is found
        long endTime = System.currentTimeMillis();
        // Calculate elapsed time
        long elapsedTime = endTime - startTime;
        System.out.println("No solution found. Time elapsed: " + elapsedTime + " milliseconds.");
    }

    // Helper method to output the solution path
    private void outputSolutionPath(Container goalContainer, Map<Container, Container> parentMap,long elapsedTime) {
        List<Container> path = new ArrayList<>();
        Container current = goalContainer;
        while (current != null) {
            path.add(current);
            current = parentMap.get(current);
        }
        Collections.reverse(path);
        System.out.println("Solution path:");
        for (Container container : path) {
            System.out.println(container);
        }
        System.out.println("Puzzle has been solved in " + path.size() + " steps in " + elapsedTime + " milliseconds!");
    }
    private void updateOpenSet(Hashtable<Integer, Container> openSet, Set<String> closedSet, List<Container> neighbors) {
        for (Container neighborContainer : neighbors) {
            int neighborHashCode = neighborContainer.hashCode();
            String neighborStateHash = neighborContainer.toString();
            // Check if the neighbor is not in the closed set and not already in the open set
            if (!closedSet.contains(neighborStateHash) && !openSet.containsKey(neighborHashCode)) {
                openSet.put(neighborHashCode, neighborContainer);
            }
        }
    }
    // Helper method to get the container with the minimum total cost from the open set
    private Container getMinCostContainer(Hashtable<Integer, Container> openSet) {
        Container minContainer = null;
        double heuristic;
        double minHeuristic = Double.MAX_VALUE; 
        for (Container container : openSet.values()) {
            heuristic = container.getHeuristic();
            if (heuristic < minHeuristic) {
                minHeuristic = heuristic;
                minContainer = container;
            }
        }
        return minContainer;
    }
    
}
