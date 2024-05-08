
public class Main {
    public static void main(String[] args) {
        AStarPuzzleSolver solver = new AStarPuzzleSolver();
        int[][] ezState = 
        {{1,2,3,3}
        ,{1,2,3,1}
        ,{2,3,1,2}
        ,{-1,-1,-1,-1}
        ,{-1,-1,-1,-1}};
        int[][] unsolveableState = 
        {{1,2,3,2}
        ,{2,2,4,3}
        ,{1,4,3,4}
        ,{1,4,3,1}
        ,{-1,-1,-1,-1}};
        int[][] hardState = 
        {{1,2,1,3}
        ,{4,1,5,2}
        ,{2,5,2,1}
        ,{4,4,4,5}
        ,{5,3,3,3}
        ,{-1,-1,-1,-1}
        ,{-1,-1,-1,-1}};
        // int[][] check = {{1,2,2,2}};
        // int[][] rndState = Tools.generateState(6,4);
        // System.out.println(Tools.calculateHeuristic(check));
        Container c = new Container(hardState);
        solver.solvePuzzle(c);
    }
}
