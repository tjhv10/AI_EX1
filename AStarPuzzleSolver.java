import java.util.*;

public class AStarPuzzleSolver {
    public void solvePuzzle(Container initialContainer) {
        Hashtable<Integer, Container> openSet = new Hashtable<>();
        Set<String> closedSet = new HashSet<>();
        Map<Container, Container> parentMap = new HashMap<>();
        openSet.put(initialContainer.hashCode(), initialContainer);
        long startTime = System.currentTimeMillis();
        while (!openSet.isEmpty()) {
            Container currentContainer = Tools.getMinCostContainer(openSet);
            if (Tools.isGoalState(currentContainer)) {
                long endTime = System.currentTimeMillis();
                long elapsedTime = endTime - startTime;
                Tools.outputSolutionPath(currentContainer, parentMap, elapsedTime);
                return;
            }
            String stateHash = currentContainer.toString();
            if (!closedSet.contains(stateHash)) {
                closedSet.add(stateHash);
            }
            openSet.remove(currentContainer.hashCode());
            List<Container> neighbors = Tools.generateNeighbors(currentContainer);
            neighbors.sort(Comparator.comparingInt(Container::getHeuristic));
            Tools.updateOpenSet(openSet, closedSet, neighbors);
            for (Container neighbor : neighbors) {
                parentMap.put(neighbor, currentContainer);
            }
        }
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("No solution found. Time elapsed: " + elapsedTime + " milliseconds.");
    }
}
