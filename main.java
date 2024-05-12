
public class Main {
    public static void main(String[] args) {
        AStarPuzzleSolver solver = new AStarPuzzleSolver();
        int[][] ezState = 
        {{1,2,0,0}
        ,{1,2,0,1}
        ,{2,0,1,2}
        ,{-1,-1,-1,-1}
        ,{-1,-1,-1,-1}};
        int[][] unsolveableState = 
        {{1,2,3,2}
        ,{2,2,0,3}
        ,{1,0,3,0}
        ,{1,0,3,1}
        ,{-1,-1,-1,-1}};
        int[][] hardState = 
        {{1,2,1,3}
        ,{4,1,0,2}
        ,{2,0,2,1}
        ,{4,4,4,0}
        ,{0,3,3,3}
        ,{-1,-1,-1,-1}
        ,{-1,-1,-1,-1}};
        int[][] superHardstate = {
        {1,3,5,4,4,7,6,1},
        {2,2,0,0,4,3,6,7},
        {2,1,1,4,5,6,0,2},
        {0,6,6,5,4,7,7,3},
        {3,4,1,0,5,7,4,4},
        {7,6,2,2,3,1,0,0},
        {7,3,3,1,2,5,5,6},
        {7,6,5,5,3,2,1,0},
        {-1,-1,-1,-1,-1,-1,-1,-1},
        {-1,-1,-1,-1,-1,-1,-1,-1}};
        Container c = new Container(superHardstate);
        solver.solvePuzzle(c);
    }
}
