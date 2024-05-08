import java.util.*;

public class AStarPuzzleSolver{

    // Method to solve the puzzle using A* algorithm
    public Container solvePuzzle(Container initialContainer) {
        // Initialize data structures for open and closed sets
        Hashtable<Integer, Container> openSet = new Hashtable<>();
        Set<String> closedSet = new HashSet<>();
        // Create the initial state and add it to the open set
        openSet.put(initialContainer.hashCode(), initialContainer);
        // Continue searching until the open set is empty or the maximum node count is reached
        while (!openSet.isEmpty()) {
            // Get the state with the minimum total cost from the open set
            Container currentContainer = getMinCostContainer(openSet);            
            // Check if the current state is the goal state
            if (Tools.isGoalState(currentContainer)) {
                System.out.println("amazing");
                return currentContainer;
            }
            // Remove the current state from the open set and mark it as visited in the closed set
            String stateHash = currentContainer.toString();
            if (closedSet.contains(stateHash)) {
                closedSet.remove(stateHash);
            } 
            closedSet.add(stateHash);
            openSet.remove(currentContainer.hashCode());
            // Generate neighbors and update the open set
            System.out.println("new------------");
            System.out.println(currentContainer);
            System.out.println("neighbors:");
            List<Container> neighbors = Tools.generateNeighbors(currentContainer);
            neighbors.sort(Comparator.comparingInt(Container::getHeuristic));
            updateOpenSet(openSet, closedSet, neighbors);
        }
        System.out.println("null");
        return null;
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
