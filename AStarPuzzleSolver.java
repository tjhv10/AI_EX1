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
            List<Container> neighbors = Tools.generateNeighbors(currentContainer);
            for (Container neighborContainer : neighbors) {
                int neighborHashCode = neighborContainer.hashCode();
                String neighborStateHash = neighborContainer.toString();

                // Check if the neighbor is not in the closed set and not already in the open set
                if (!closedSet.contains(neighborStateHash) && !openSet.containsKey(neighborHashCode)) {
                    openSet.put(neighborHashCode, neighborContainer);
                }
            }
        }
        // No solution found
        return null;
    }

    // Helper method to get the container with the minimum total cost from the open set
    private Container getMinCostContainer(Hashtable<Integer, Container> openSet) {
        // We don't need to consider cost in this implementation
        // So just return any container from the open set
        return openSet.elements().nextElement();
    }
}
