public class Main {
    public static void main(String[] args) {
        AStarPuzzleSolver solver = new AStarPuzzleSolver();
        int[][] state = 
        {{1,2,3,3}
        ,{1,2,3,1}
        ,{2,3,1,2}
        ,{-1,-1,-1,-1}
        ,{-1,-1,-1,-1}};
        int[][] states = 
        {{-1,2,3,3}
        ,{-1,2,3,1}
        ,{-1,-1,1,2}
        ,{-1,-1,-1,2}
        ,{-1,-1,-1,3}};
        // int[][] states = {{1,1,2,2}};
        // System.out.println(Tools.top(states[3]));
        // System.out.println(2+1+0+3+2+1+0+3+2+1+0);
        // System.out.println(Tools.calculateHeuristic(state));
        Container c = new Container(state);
        solver.solvePuzzle(c);
    }
}
