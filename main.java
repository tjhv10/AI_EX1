public class main {
    public static void main(String[] args) {
        AStarPuzzleSolver solver = new AStarPuzzleSolver();
        int[][] state = {{1,2,3,2},{2,2,4,3},{1,4,3,4},{1,3,4,1},{-1,-1,-1,-1}};
        Container c = new Container(state);
        solver.solvePuzzle(c);
    }

    
}
