public class Main {
    public static void main(String[] args) {
        AStarPuzzleSolver solver = new AStarPuzzleSolver();
        int[][] state = 
        {{1,2,3,3}
        ,{1,2,3,1}
        ,{2,3,1,2}
        ,{-1,-1,-1,-1}
        ,{-1,-1,-1,-1}};
        Container c = new Container(state);
        solver.solvePuzzle(c);
    }
}
