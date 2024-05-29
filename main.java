import java.io.IOException;
import java.util.List;
public class Main {
    
//     public static void main(String[] args) {
//         String filePath = "instences.txt";
//         try {
//             List<String> initRows = Tools.extractInitRows(filePath);
//             int i = 0;
//             for (String initRow : initRows) {
//                 System.out.println("Puzzle "+i+":");
//                 i++;
//                 if (i==15) 
//                     i++;
//                 int[][] superHardstate = Tools.convertStringTo2DArray(initRow);
//                 Container c = new Container(superHardstate);
//                 Tools.solvePuzzle(c);
//             }
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }
// }
    public static void main(String[] args) {
        String input = "[[],[],[],[],[],[],[],[],[],[],[10,14,5,48,23,16,3,23,16,2,20,24,22,20,8,8,18,19,23,1,7,22,39,40,1,22,7,20,2,37,13,24,26,38,17,22,22,29,23,46,36,5,21,3,34,1,5,3,7,12],[11,5,26,35,29,15,40,27,10,14,18,38,23,4,44,25,48,35,38,10,30,27,15,19,30,28,41,21,42,41,1,5,19,36,47,25,3,36,35,48,27,43,45,42,28,27,44,8,40,0],[9,39,2,32,41,24,43,9,18,29,25,35,18,34,2,37,24,37,23,10,15,37,17,34,11,16,32,33,39,31,31,0,1,3,13,42,21,46,23,30,5,39,35,46,0,7,28,14,10,49],[31,12,2,4,7,30,30,30,4,31,41,7,45,45,9,43,47,30,31,20,7,15,29,23,9,49,8,11,21,21,1,14,17,21,38,10,2,43,48,48,30,25,8,14,27,5,6,20,17,48],[7,27,37,45,5,31,7,44,9,48,28,24,18,46,42,18,15,30,44,49,26,49,9,36,21,8,3,11,23,0,25,10,10,3,28,24,26,45,20,20,13,37,25,32,48,6,4,13,6,15],[15,15,15,43,10,5,27,7,46,9,3,4,31,13,44,23,28,15,27,44,14,38,6,28,15,34,37,14,43,40,2,12,8,34,3,49,6,44,12,17,35,47,25,24,30,21,39,24,26,41],[16,16,16,16,16,16,16,16,16,16,16,16,16,19,11,23,21,10,15,8,49,10,14,16,11,30,38,12,34,34,25,9,26,13,44,10,26,35,38,16,1,14,41,8,48,37,10,5,37,46],[17,17,17,17,17,17,17,17,17,17,17,17,17,2,38,48,0,1,41,1,47,14,22,1,6,27,37,17,1,36,34,1,25,18,18,23,8,10,1,47,11,24,42,1,8,40,2,33,18,33],[46,17,31,3,30,13,34,11,1,37,10,5,30,28,31,47,30,31,18,32,34,0,24,21,22,30,37,11,44,6,11,29,49,32,25,32,3,4,7,12,31,3,8,12,25,13,20,0,9,21],[19,19,19,19,19,19,19,19,19,19,19,19,19,19,49,36,1,28,35,3,49,27,2,30,10,28,37,10,23,12,0,15,4,39,39,4,4,5,7,47,3,15,7,35,38,40,23,43,36,23],[11,0,24,19,5,9,43,3,30,49,27,4,13,37,38,8,4,36,11,8,12,31,41,25,10,28,13,11,39,24,45,5,43,45,26,5,46,23,7,7,24,16,34,11,22,45,28,9,9,9],[21,21,21,21,21,21,21,21,42,47,32,18,35,13,13,39,31,36,29,37,39,19,44,45,8,12,28,10,16,17,2,0,6,39,10,37,32,3,28,38,25,41,13,2,44,2,37,49,18,12],[22,22,22,22,22,22,22,22,22,22,13,22,35,39,17,22,47,29,34,36,11,0,14,13,14,15,26,39,38,26,41,41,20,13,17,44,44,44,3,0,3,49,36,3,28,29,29,40,48,21],[23,23,23,23,23,23,23,23,23,5,35,27,24,15,17,15,40,34,1,32,40,45,13,16,42,22,23,20,12,49,12,6,35,37,49,22,15,49,26,47,23,46,28,42,24,46,24,26,4,16],[24,24,24,24,24,24,24,24,24,9,22,23,4,39,2,20,36,27,9,47,9,20,31,4,19,45,44,23,4,32,8,49,39,43,16,17,37,23,20,21,3,3,21,35,26,15,20,2,5,38],[1,0,40,13,30,49,28,6,36,37,22,29,9,14,36,32,30,39,25,19,37,45,40,17,24,7,26,1,24,1,1,7,4,17,21,4,11,45,23,1,10,43,14,5,4,32,33,42,44,26],[15,12,34,3,29,23,30,47,40,22,4,8,29,34,1,29,29,13,25,28,14,44,10,16,2,35,40,16,8,24,10,42,12,41,11,2,25,46,22,22,25,6,33,45,18,20,9,27,32,26],[48,5,38,21,37,17,21,32,41,26,46,45,16,1,46,4,49,3,39,15,44,12,34,14,41,28,32,44,4,48,24,14,13,47,10,34,35,4,28,15,24,24,48,45,31,28,32,24,10,44],[28,28,28,28,28,28,34,37,22,27,38,27,49,23,33,33,6,15,37,44,5,45,21,31,7,21,12,44,26,44,4,43,49,30,5,13,12,31,21,44,5,14,7,46,6,31,0,1,18,19],[29,29,29,29,29,29,29,29,29,29,22,42,46,13,14,40,38,47,33,38,14,14,35,19,47,12,25,13,15,42,15,28,31,31,14,24,38,28,39,9,43,8,43,0,49,24,46,3,3,39],[30,30,30,30,30,5,2,39,9,38,34,1,19,40,34,1,7,5,18,10,46,30,15,27,45,25,39,32,20,46,21,32,2,18,19,43,22,46,11,14,11,40,14,41,3,3,3,11,31,9],[31,31,11,43,32,38,10,20,36,45,32,32,13,11,6,38,21,11,8,15,6,12,0,18,34,9,9,11,14,31,0,39,2,12,48,29,33,10,28,37,43,40,16,26,13,41,0,24,49,18],[32,32,32,32,32,32,32,32,32,6,41,42,46,27,46,7,44,25,28,40,8,32,26,40,6,20,47,48,27,18,48,5,35,4,46,4,7,14,0,4,45,39,15,13,19,44,9,9,9,9],[33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,33,45,17,35,37,9,24,47,25,10,41,22,18,7,34,42,49,37,35,35,3,6,39,44,32,10,49,26],[34,34,34,34,35,35,41,39,29,25,8,34,43,13,1,6,47,39,47,42,12,0,3,43,17,1,31,15,29,12,22,30,13,46,8,25,19,45,12,35,25,36,22,23,41,15,2,26,0,43],[35,35,35,35,35,35,35,35,46,3,25,27,15,38,0,34,29,30,7,3,30,31,45,13,40,19,8,18,25,21,36,23,23,46,31,31,20,7,31,20,21,12,11,21,9,13,21,44,0,6],[36,36,36,36,36,36,36,36,36,36,36,36,23,34,1,11,38,8,30,44,40,15,5,26,3,6,21,26,3,25,20,7,31,0,41,9,3,25,20,12,4,36,16,14,43,7,27,47,28,20],[45,18,27,5,41,25,8,43,13,37,41,29,14,4,28,44,43,34,27,13,23,2,44,25,45,37,2,11,47,0,37,47,27,24,27,2,20,36,18,14,25,22,30,6,22,7,30,48,10,29],[38,38,38,38,38,38,2,48,21,0,37,38,47,36,42,22,41,43,3,16,34,20,44,37,45,18,43,40,4,21,11,17,34,13,39,0,48,34,19,21,25,8,4,11,12,5,14,6,28,6],[39,39,39,39,39,39,6,30,41,35,36,13,3,44,37,21,30,26,49,10,33,43,42,47,46,39,6,32,35,6,38,24,40,43,18,24,22,26,46,37,2,4,47,8,16,25,49,25,9,47],[40,40,40,40,40,40,40,40,40,40,40,40,40,40,11,35,36,40,23,28,47,48,31,28,20,35,29,23,27,48,17,30,48,49,41,39,20,39,27,24,19,18,12,47,33,8,8,18,2,47],[49,32,5,39,43,7,27,1,34,34,18,31,26,11,27,8,25,20,20,2,13,27,8,5,37,15,30,19,9,42,23,26,10,22,5,5,28,6,33,14,27,36,44,45,39,30,39,29,2,13],[42,42,42,42,42,42,42,42,42,42,42,42,42,42,42,42,42,42,42,42,42,42,18,8,29,8,31,9,20,28,9,27,17,38,39,19,48,9,7,18,37,14,49,17,41,47,35,0,24,5],[43,43,43,43,43,43,43,43,43,3,27,14,29,18,43,1,14,39,33,44,31,19,46,44,40,7,16,43,24,34,11,9,18,17,17,6,21,25,9,45,26,32,31,23,33,21,11,4,0,0],[26,45,32,5,49,33,30,1,9,4,1,40,5,14,39,28,11,17,38,2,36,22,37,18,16,13,47,2,34,15,1,28,14,40,10,16,17,10,27,47,12,11,8,31,26,11,26,0,6,3],[45,45,45,45,45,45,45,45,45,45,45,18,35,20,17,45,37,18,43,10,40,22,44,18,16,4,21,19,44,41,1,47,27,13,35,37,0,28,16,15,3,15,4,26,17,29,47,0,4,45],[46,46,46,46,46,46,46,46,46,46,46,46,46,39,26,3,48,24,24,47,31,18,31,22,11,8,41,19,25,36,49,7,1,7,22,5,41,23,26,24,29,41,20,1,6,26,38,28,18,19],[30,30,49,12,48,12,31,41,38,1,32,10,32,9,10,20,4,3,18,49,1,26,14,36,31,3,40,2,42,35,7,20,41,47,3,29,36,14,5,45,12,1,26,29,11,5,35,16,12,45],[48,48,48,48,48,48,48,48,48,48,48,48,12,27,36,5,32,31,12,47,7,27,37,38,5,7,14,48,45,16,32,20,8,6,10,13,18,47,38,23,18,15,28,37,9,4,43,34,25,39],[49,49,49,49,49,49,49,49,49,49,49,42,33,33,19,44,43,15,31,14,8,24,41,0,25,37,1,2,4,16,2,28,27,25,18,33,6,46,49,12,27,15,6,29,5,24,7,35,0,35],[47,29,19,11,45,14,30,4,4,25,36,19,0,15,15,5,48,38,28,35,24,34,1,16,0,39,13,17,32,44,6,12,21,11,40,14,36,22,27,29,10,47,3,5,15,10,18,7,25,29],[19,8,35,44,33,15,19,38,20,49,22,26,0,2,2,44,18,48,33,45,27,11,2,10,41,13,32,6,43,11,6,25,15,27,14,32,49,21,6,39,12,48,20,41,36,7,33,47,9,20],[6,38,46,29,48,28,45,12,47,29,36,12,2,28,15,36,2,4,38,4,37,13,28,33,18,43,20,47,41,14,49,37,0,27,10,25,17,31,4,18,7,20,40,34,33,7,7,25,45,9],[15,11,22,49,26,41,2,20,26,25,20,23,35,17,20,32,47,16,6,38,18,11,25,19,40,6,19,31,25,11,7,8,38,5,27,36,33,47,8,43,37,34,19,23,2,38,40,32,33,0],[27,31,20,44,21,25,26,27,13,32,12,42,38,32,4,10,5,26,47,0,41,44,34,44,0,23,8,24,14,21,1,48,12,46,41,42,24,29,46,13,13,42,46,1,48,22,9,9,9,9],[31,34,4,22,2,34,39,10,14,7,22,39,46,26,34,28,46,31,44,35,44,26,10,7,46,17,13,37,26,43,41,41,38,30,41,33,26,38,47,43,8,12,6,1,30,0,33,18,6,10],[31,41,36,19,30,30,4,8,41,48,32,15,22,15,13,2,8,9,1,20,27,34,47,35,42,16,23,37,11,40,16,18,16,30,17,0,20,10,2,44,13,16,0,17,0,38,28,26,1,26],[1,21,8,7,38,29,6,41,16,27,12,14,4,20,35,12,12,4,48,25,7,19,37,5,36,17,5,16,29,0,40,3,8,3,38,6,31,20,5,5,37,7,7,9,18,11,2,10,44,20],[2,16,14,6,11,11,20,13,30,32,21,29,3,46,44,15,42,9,19,31,17,45,47,23,17,42,2,48,19,37,10,26,2,41,21,27,6,11,4,39,0,3,3,43,29,42,8,29,12,8],[30,42,34,43,43,17,41,2,7,47,30,48,19,16,32,41,36,23,49,9,6,48,16,34,0,2,5,34,40,13,41,22,34,1,14,0,16,6,36,12,39,21,12,14,8,35,15,12,27,6]]";
        // String input = "[[],[],[-1,-1,-1,2,2],[1,2,4,4,2],[0,0,3,3,1],[1,4,2,4,0],[3,4,0,1,0]]";
        int[][] superHardstate = Tools.convertStringTo2DArray(input);
        Container c = new Container(superHardstate);
        System.out.println("Puzzle 15:");
        Tools.solvePuzzle(c);
        // Tools.calculateHeuristic(c);
    }
}    

