import java.io.IOException;
import java.util.List;
public class Main {
    
    public static void main(String[] args) {
        String filePath = "instences.txt";
        try {
            List<String> initRows = Tools.extractInitRows(filePath);
            int i = 0;
            for (String initRow : initRows) {
                System.out.println("Puzzle "+i+":");
                i++;
                if (i==15) 
                    i++;
                int[][] superHardstate = Tools.convertStringTo2DArray(initRow);
                Container c = new Container(superHardstate);
                Tools.solvePuzzle(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
//     public static void main(String[] args) {
//         String input = "[[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[],[88,6,6,33,66,0,0,0,17,4,38,49,41,36,9,9,16,38,37,7,19,21,21,22,22,22,58,23,60,74,40,25,1,2,27,29,20,66,92,36,17,64,17,35,61,72,74,10,30,36,8,44,37,48,5,39,39,39,21,90,42,42,89,37,45,74,51,64,43,93,50,54,96,76,68,41,69,86,2,12,9,45,15,68,46,16,2,75,47,47,47,21,68,21,87,48,48,13,42,90],[51,51,51,51,51,51,51,51,51,51,51,51,51,51,51,51,51,20,2,10,18,72,84,98,41,9,78,89,0,72,14,60,92,75,74,57,19,77,32,0,3,4,4,66,7,86,28,21,53,65,13,75,15,37,54,72,17,17,6,18,19,19,22,22,25,36,29,55,30,49,8,45,83,23,28,33,24,34,34,35,35,11,2,36,22,37,48,45,42,47,78,74,64,55,40,44,4,56,2,45],[52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,52,31,29,36,44,94,11,77,75,71,74,11,10,19,59,73,9,23,44,7,94,38,80,78,12,37,47,65,94,5,47,62,21,51,99,71,85,32,89,65,37,40,81,0,4,54,0,9,9],[53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,53,36,61,31,38,50,32,66,98,59,72,74,24,71,7,41,75,63,65,96,2,95,54,60,77,81,56,31,55,15,3,19,37,69,78,76,2,66,70,97,80,78,64,9,28,46],[54,54,54,54,54,54,54,44,66,74,38,5,87,47,85,32,10,9,79,12,5,81,67,65,58,38,68,98,21,26,51,47,28,69,95,36,80,0,83,20,27,71,6,64,95,48,47,79,11,21,79,83,78,19,69,84,7,72,22,73,24,65,55,69,58,28,31,27,11,17,49,17,21,22,36,84,12,57,13,13,14,15,10,66,17,18,18,38,22,22,23,14,27,93,83,34,11,55,30,30],[55,55,55,55,55,55,55,55,55,55,55,55,55,23,34,50,71,78,18,86,93,38,53,61,96,87,76,93,96,74,30,31,65,88,28,85,47,57,87,49,1,91,99,83,72,18,2,66,88,76,51,96,55,15,75,48,83,74,65,68,29,34,51,49,42,29,99,14,80,71,72,85,73,41,15,28,64,51,67,0,42,58,12,60,28,24,32,66,39,76,42,74,56,82,87,83,1,3,27,0],[56,56,56,56,56,56,56,56,56,56,56,56,56,56,56,56,56,56,56,56,56,56,56,56,56,56,56,56,56,56,56,56,56,56,56,56,56,56,56,56,56,56,56,56,56,56,56,56,56,56,56,56,56,56,56,56,71,31,37,4,40,0,90,58,11,10,70,57,5,24,27,63,62,75,29,1,4,4,4,7,9,26,14,26,66,66,17,17,72,19,23,24,25,27,41,71,11,50,29,29],[57,57,57,57,57,57,57,57,57,57,57,57,57,57,57,57,57,57,57,57,57,57,57,57,57,57,57,57,57,57,57,57,57,57,57,57,92,28,94,36,48,36,6,16,63,4,75,18,22,75,87,32,94,44,12,12,84,62,17,12,59,49,94,7,34,48,41,64,12,50,97,1,95,59,14,30,23,37,13,13,13,14,14,14,58,20,22,61,23,23,23,44,34,26,83,2,11,81,29,25],[41,10,65,17,23,9,98,36,33,92,65,51,12,95,78,2,11,86,6,86,63,75,79,84,20,36,48,76,23,81,82,72,36,32,32,96,0,1,87,48,49,11,61,51,93,44,68,99,23,31,78,55,32,4,43,97,70,78,99,70,34,28,31,23,77,62,35,11,41,85,12,62,87,89,54,38,5,63,54,25,96,5,59,95,62,19,87,8,34,32,62,73,58,6,38,77,89,3,4,87],[59,59,59,59,59,59,59,59,59,59,59,59,59,59,59,59,59,59,59,59,59,59,59,59,8,32,36,30,10,60,35,32,59,92,26,58,87,17,1,99,91,48,40,81,53,30,88,7,60,63,39,84,64,54,87,72,4,58,61,72,75,4,2,24,80,23,65,3,80,96,21,82,27,83,75,36,1,4,4,31,93,9,9,50,49,45,13,14,78,6,57,15,83,17,52,18,57,29,30,39],[60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,60,9,50,7,49,84,74,40,76,2,0,28,21,93,28,91,63,74,26,6,86,60,53,99,59,28,63,95,82,3,75,70,74,68,8,77,74,20,94,16,72,49,74,2,23,45,97,0,50,65,9,11,40,36,77,13,14,14,16],[61,61,61,61,61,61,61,61,61,61,61,61,61,61,61,61,61,61,61,61,61,61,61,61,61,61,61,94,98,55,41,73,80,84,47,4,39,15,30,8,9,1,25,70,5,95,48,83,4,16,53,86,46,42,63,94,58,1,49,56,1,59,41,94,81,54,46,81,80,10,96,31,83,19,85,37,58,18,72,6,78,64,1,24,87,48,12,98,11,83,41,95,82,48,98,1,1,3,92,90],[86,66,48,94,0,1,66,34,74,5,6,23,60,58,86,14,15,16,0,17,17,18,18,49,7,13,39,8,96,6,3,9,33,33,86,34,35,35,37,37,90,39,39,39,12,83,40,72,41,81,71,39,42,42,63,8,98,65,78,44,91,25,45,45,45,45,45,45,13,82,46,46,46,46,21,85,79,36,97,89,38,47,47,47,73,48,48,48,48,48,48,48,99,42,31,91,67,88,1,33],[63,68,27,73,2,38,2,43,32,93,77,11,97,73,36,66,97,89,61,5,63,87,74,13,98,57,33,87,27,19,67,18,24,74,54,60,84,8,72,25,51,54,74,32,96,81,71,46,55,73,21,63,99,25,75,64,35,74,88,57,71,57,42,36,27,71,84,5,7,58,48,63,85,17,54,63,8,71,84,57,73,71,45,19,62,32,57,0,0,57,58,9,66,97,13,14,15,16,16,17],[64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,93,67,52,35,7,7,81,20,71,64,12,51,79,49,84,79,31,95,78,50,83,62,30,55,8,0,77,87,23,22,51,96,48,7,11,26,50,43,35,57,92,83,7,77,60,99,26,19,14,85,79,68,39,26,95,78,65,45,81,89,8,57,8,38,51,30,88,1,63,13,31],[10,68,42,16,99,48,62,4,42,74,1,1,1,1,76,35,42,97,30,9,36,35,62,70,2,55,89,38,38,17,14,19,92,22,22,24,15,32,26,83,33,33,34,46,25,79,35,39,37,39,97,28,68,55,38,87,8,41,87,43,43,43,43,43,9,20,33,44,44,44,12,41,76,45,45,68,80,46,46,9,79,59,21,94,47,7,71,33,50,45,86,50,94,48,48,0,77,25,48,86],[66,66,66,66,66,66,66,66,66,86,89,51,7,71,12,12,21,73,74,97,31,23,67,69,2,86,7,86,65,32,49,12,40,94,11,87,3,70,76,76,21,46,9,86,95,36,13,69,15,15,31,16,18,55,19,19,19,24,24,25,5,62,67,64,74,84,29,29,30,22,98,96,23,34,20,76,28,35,35,35,43,26,37,37,38,8,49,41,39,41,94,40,40,41,41,43,43,43,5,83],[67,67,67,67,67,67,67,67,67,67,67,67,67,67,67,67,67,67,67,67,67,67,67,67,67,67,67,67,67,67,67,67,67,67,67,67,67,67,67,67,67,67,67,67,67,19,58,25,18,26,92,36,74,22,10,45,36,77,69,75,79,81,9,54,76,83,38,43,84,79,96,76,51,24,89,76,42,1,39,60,32,93,30,48,73,55,60,18,62,68,95,31,62,11,37,2,7,6,3,3],[68,68,68,68,68,68,68,68,68,68,68,68,68,68,68,68,68,68,68,68,68,68,68,68,68,68,68,68,68,68,68,68,68,68,68,68,95,62,8,11,50,72,65,44,5,78,34,84,85,75,49,52,75,34,12,3,24,38,8,24,36,30,71,58,11,77,68,7,2,59,41,1,70,48,5,86,31,86,32,88,5,60,61,29,70,11,79,74,79,24,64,51,83,4,24,64,90,10,51,84],[69,69,69,69,69,69,69,69,69,69,69,69,69,69,69,69,69,69,69,69,69,69,69,69,69,69,69,69,69,69,69,69,69,69,69,69,69,69,69,69,69,69,69,69,55,38,55,36,50,0,72,6,8,84,83,66,67,19,57,80,20,25,71,75,52,40,81,77,59,21,68,17,85,51,7,93,57,24,75,33,65,85,32,61,96,75,97,22,50,21,0,1,1,42,21,29,75,9,63,14],[70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,70,25,36,36,22,96,76,35,44,94,7,18,5,13,62,95,6,31,40,27,51,12,76,67,52,29,0,31,1,56,16,38,87,32,9,9,10,94,13,46,28,78],[46,99,24,99,63,79,0,44,69,73,62,26,83,71,82,0,3,3,14,4,10,86,59,78,13,14,15,7,17,18,19,20,21,7,74,50,27,35,6,79,92,14,10,34,27,41,98,49,96,62,86,47,22,39,39,52,19,10,95,71,41,41,47,42,72,66,31,43,59,51,41,37,52,44,35,82,24,45,45,45,27,73,50,69,46,46,46,68,6,2,87,58,1,54,5,71,47,47,47,43],[45,74,63,25,57,56,38,62,37,38,71,77,62,19,66,40,27,81,6,0,1,76,4,9,69,80,40,16,16,52,18,18,84,19,98,61,23,23,23,24,34,0,37,34,18,29,96,4,74,30,50,93,42,70,64,58,34,81,72,69,87,99,38,58,29,39,39,39,39,58,95,40,32,41,77,42,44,46,45,66,23,33,62,94,46,37,81,38,27,13,85,47,40,83,35,28,18,72,91,6],[73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,73,71,83,86,55,75,11,83,98,58,38,72,86,37,90,15,21,5,98,50,89,76,62,2,55,22,6,63,22,80,26,71,60,68,79,21,9,12,40,53,8,79,75,5,30,75,85,79],[20,37,97,46,47,89,96,98,86,13,91,39,11,0,1,26,7,30,58,41,9,9,80,21,74,49,13,14,15,16,99,10,17,18,20,22,71,23,40,24,24,25,48,29,44,47,26,28,83,41,33,33,33,99,34,64,12,35,25,30,37,37,37,47,84,39,39,65,40,40,38,41,41,42,42,42,43,43,43,43,51,44,44,5,11,45,45,45,45,45,45,50,83,75,46,46,46,46,97,31],[75,75,75,75,75,75,75,75,75,75,75,75,31,14,59,61,12,79,41,8,17,1,9,95,28,35,43,38,74,1,1,38,38,32,64,77,64,26,77,36,0,3,3,4,4,39,13,14,88,19,4,17,19,95,58,40,59,26,38,61,51,30,30,53,19,32,34,34,34,46,42,35,72,15,86,85,10,37,37,49,44,52,49,31,39,39,39,40,94,52,41,95,42,43,43,90,76,65,92,44],[76,76,76,76,76,76,76,77,95,0,61,38,10,4,36,2,18,54,1,3,55,24,13,13,13,14,16,16,18,19,65,22,22,23,75,58,47,25,26,29,99,2,10,8,54,51,4,34,34,35,35,35,33,48,64,39,39,40,63,77,41,41,42,42,60,72,2,43,43,43,69,44,44,44,44,44,0,58,45,45,45,28,71,9,32,62,22,19,14,47,43,92,76,48,48,11,55,34,44,10],[77,77,77,77,77,77,77,59,77,14,49,32,14,87,28,6,46,93,78,68,68,15,94,96,50,1,2,2,67,19,8,66,79,7,87,11,32,54,36,44,76,26,96,84,53,96,11,84,7,51,79,59,48,87,6,54,38,48,64,73,64,72,4,89,43,88,72,11,71,36,66,60,80,65,64,2,14,40,47,65,32,7,6,91,94,80,52,1,3,4,11,96,90,40,49,14,15,75,16,44],[78,78,78,78,78,78,78,78,78,78,78,78,78,78,78,78,78,78,78,78,78,78,78,78,78,78,78,78,78,78,78,78,78,78,55,91,57,91,87,61,99,70,41,2,54,93,7,32,77,81,63,68,32,96,69,96,19,31,54,12,33,96,60,28,50,12,68,97,2,79,50,60,10,38,81,19,92,96,17,62,77,55,27,60,6,84,80,92,4,53,79,3,4,8,86,9,14,46,15,16],[71,11,25,75,93,58,14,55,13,16,13,28,40,13,51,71,15,15,16,31,19,19,20,22,22,22,72,23,24,26,90,72,29,29,70,30,55,49,86,53,33,33,25,34,34,34,1,35,35,8,67,28,37,37,27,72,89,39,39,39,39,51,83,27,41,42,99,55,44,44,44,44,45,45,45,45,45,45,45,99,91,90,36,47,97,76,48,48,48,11,85,77,90,44,18,99,35,34,6,83],[80,80,80,80,80,80,80,80,80,80,80,80,80,80,80,80,80,80,80,80,80,80,80,80,80,80,80,80,80,80,80,80,80,80,80,80,80,80,80,80,80,80,44,36,80,5,73,96,36,60,69,66,0,48,1,79,3,4,45,91,14,59,14,14,15,28,18,68,19,20,20,21,21,23,24,24,26,27,71,68,80,29,42,43,65,65,33,33,33,34,24,35,35,84,68,37,37,86,33,6],[81,81,81,81,81,81,81,81,81,81,81,81,81,81,50,98,50,6,29,40,77,30,44,21,47,94,52,68,92,29,58,68,35,26,75,92,27,97,50,75,51,43,5,47,20,71,75,32,79,83,83,76,54,44,36,63,7,85,20,17,43,77,96,47,58,12,40,37,31,50,85,40,17,3,54,90,32,7,29,94,84,63,92,3,23,49,42,42,1,1,30,4,54,47,49,66,79,55,9,9],[82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,82,75,77,74,16,83,2,71,30,51,88,3,64,21,59,61,38,0,1,4,4,4,54,93,54,7,49,54,4,80,51,10,13,14,15,41,28,17,19,20,20,21,22,24,25,26,53,29,29,91],[54,46,98,0,78,1,42,9,82,72,29,12,14,14,68,16,16,17,19,38,66,99,22,25,59,62,27,53,66,30,45,61,85,91,33,33,34,49,28,69,37,72,67,39,41,41,41,62,42,42,42,72,43,43,43,2,48,26,44,20,2,45,45,45,45,45,45,87,46,99,46,58,87,84,61,6,47,82,8,49,99,48,48,48,48,81,84,7,1,8,86,79,95,73,12,55,12,17,59,97],[84,84,84,84,84,84,84,84,84,84,84,84,84,84,84,84,84,84,84,84,84,84,84,84,84,84,84,84,84,84,84,84,84,84,72,5,29,8,30,99,11,56,1,34,61,57,29,67,35,83,71,51,81,5,57,57,5,40,33,77,12,34,24,55,42,1,61,4,6,78,5,29,6,43,15,16,18,20,62,43,29,22,86,41,19,10,80,11,29,66,30,85,68,83,24,1,94,57,8,27],[85,85,85,85,85,85,85,85,85,85,85,85,85,85,85,85,85,85,85,85,85,85,85,85,85,85,85,85,85,85,85,85,85,85,85,85,12,25,28,30,41,33,57,76,78,85,87,28,54,31,21,85,28,96,8,83,69,81,72,31,2,91,83,9,77,73,36,54,32,22,90,10,41,86,79,20,30,59,27,1,3,56,98,17,29,68,13,14,23,19,55,22,22,23,24,65,25,67,61,62],[39,86,96,10,56,89,65,10,38,86,57,57,16,11,92,85,41,22,89,2,28,36,94,89,63,47,22,41,58,86,3,58,57,37,86,80,99,95,49,94,95,53,8,32,85,31,30,95,35,19,6,65,11,54,1,39,7,19,18,63,44,97,52,99,49,63,33,9,34,77,17,21,21,3,72,39,40,1,3,76,87,4,44,13,54,34,32,11,18,18,38,20,22,62,23,23,24,25,25,25],[87,87,87,87,87,87,87,87,87,87,87,87,87,87,87,87,87,87,87,87,58,44,15,73,95,81,32,38,28,1,31,36,23,89,53,18,55,53,77,10,72,65,78,83,20,95,12,27,6,32,11,13,63,96,65,86,37,46,96,79,64,99,66,26,8,62,99,84,14,31,30,68,81,74,27,51,31,77,8,51,67,72,71,90,96,3,7,17,69,50,13,90,43,15,17,18,18,18,19,20],[88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,88,35,25,19,16,69,81,8,20,6,78,37,84,57,46,46,98,0,24,84,26,94,50,86,30,24,95,14,82,20,36,13,91,13,61,5,88,55,99,72,42,13,74,3,3,86],[89,89,89,89,89,89,89,89,89,89,89,89,89,89,89,89,89,89,89,89,89,89,89,89,89,89,89,89,89,89,89,89,89,89,89,89,89,89,89,58,95,69,41,70,64,58,33,54,86,91,99,66,59,35,72,38,34,2,0,74,51,80,36,27,38,90,38,95,51,38,64,49,11,55,73,49,10,83,2,9,55,96,63,98,14,37,17,9,20,21,22,23,23,25,25,26,27,78,6,30],[90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,18,62,31,55,27,7,34,76,22,94,29,87,80,95,94,71,27,7,28,66,97,34,0,96,91,60,44,31,62,91,38,76,5,2,6,63,60,50,6,82,49,69,92,12,39,11,76,43,63,47,3,54,3,3,4,4,42,6,17,13],[91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,91,43,57,91,91,28,56,95,38,73,41,99,58,94,76,79,59,16,43,40,47,51,77,62,54,38,15,77,46,48,80,63,25,62,45,99,46,15,59,62,51,92,8,27,55,48,90],[92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,92,34,11,33,99,94,2,16,45,35,65,36,80,66,75,69,8,32,7,96,75,35,97,75,62,66,44,17,9,19,8,47,79,52,94,46,90,39,95,73,52,13,76,18,66,28,38,42,94,32,63,38,51,50,2,60,11,8,86,84,76,8,51,37,80,26,47,3,13],[93,93,93,93,93,93,93,93,93,93,93,93,93,93,93,93,93,93,93,93,93,93,93,93,93,93,93,93,93,93,93,93,93,93,93,93,93,93,93,93,93,93,93,93,59,83,7,94,12,96,15,21,70,46,5,74,89,90,92,89,77,20,55,74,50,11,69,33,21,80,65,90,66,85,68,86,82,37,93,4,23,58,13,15,46,39,76,20,21,99,30,23,97,24,25,5,27,54,76,30],[94,94,94,94,94,94,94,94,94,94,88,98,7,63,67,62,63,15,64,68,81,36,11,0,75,74,72,18,0,53,60,0,9,9,9,12,14,15,15,15,16,77,17,11,18,19,68,20,10,23,23,23,23,38,25,26,46,50,61,30,67,33,33,34,34,35,35,35,35,12,3,62,99,37,54,63,84,72,37,53,24,56,39,39,78,77,81,62,41,41,21,42,42,65,43,56,33,30,22,79],[81,84,88,89,97,36,19,32,39,2,47,64,81,10,28,84,45,71,64,9,7,6,68,33,69,59,13,25,5,34,95,35,83,28,69,89,40,58,48,46,82,79,62,17,79,29,91,2,66,49,63,32,74,51,79,43,59,55,40,26,84,76,94,71,71,49,50,99,23,5,27,10,60,30,61,17,71,22,60,99,98,33,66,89,0,47,83,51,17,9,17,94,9,48,86,2,15,17,18,20],[28,65,79,68,48,16,16,75,2,98,68,33,61,86,16,43,58,79,17,99,40,35,75,93,44,45,59,88,0,36,59,90,49,94,25,31,47,59,2,12,16,17,58,7,44,19,93,81,63,13,29,29,85,30,30,30,32,38,34,84,35,61,37,77,32,40,79,35,50,64,42,42,83,74,6,38,50,44,42,44,44,44,44,44,98,97,97,57,45,45,65,32,74,74,6,83,77,49,46,46],[97,97,97,97,97,97,97,97,97,97,97,97,97,97,97,97,97,97,97,97,97,97,97,23,18,61,95,39,12,50,18,79,96,33,49,44,31,7,39,12,93,8,51,75,40,82,77,60,71,3,62,67,65,71,0,35,16,10,71,15,61,20,20,22,24,25,26,26,26,31,29,30,30,12,40,79,32,26,50,40,28,16,37,73,39,9,53,92,40,71,41,41,64,42,40,43,43,85,54,44],[98,98,98,98,98,98,98,98,98,98,98,98,98,98,98,98,98,98,98,98,98,98,98,98,98,98,98,98,98,98,31,63,7,61,17,78,77,93,55,28,58,12,58,20,63,36,59,80,13,14,42,36,1,3,3,3,59,4,65,2,73,9,9,57,13,3,14,99,49,15,16,0,24,21,76,46,26,27,29,29,29,30,30,49,74,34,30,95,35,52,37,22,52,39,10,38,41,42,42,43],[57,29,43,65,6,10,10,95,65,11,66,25,78,5,63,58,28,99,5,79,43,38,7,67,86,36,10,81,62,31,81,35,23,45,12,22,60,55,91,10,37,45,1,53,74,1,96,73,83,75,2,2,41,11,24,63,65,2,66,33,42,20,42,12,97,46,97,25,37,74,36,92,26,34,72,83,65,18,95,46,54,52,65,78,74,63,22,86,6,6,48,56,76,6,46,4,42,7,48,20],[92,77,28,77,86,24,95,97,48,28,95,62,8,91,97,87,32,94,8,79,89,88,65,96,58,74,83,47,78,16,12,90,47,63,69,48,72,64,83,12,63,5,75,58,72,94,2,84,26,92,91,19,11,75,87,9,9,50,77,81,35,69,40,75,23,74,12,32,64,45,10,34,74,40,68,83,39,30,58,96,65,84,3,3,4,4,4,97,2,13,15,15,16,30,95,24,20,4,84,24],[85,65,90,28,54,20,13,97,95,29,84,13,73,65,60,0,3,3,26,4,4,63,3,78,73,33,33,81,13,14,14,67,15,17,18,5,20,21,54,86,23,23,56,72,28,95,29,30,95,72,33,33,89,58,34,34,27,35,37,37,62,18,36,3,7,41,41,88,43,43,10,44,44,12,64,17,59,46,46,34,73,37,86,94,26,47,47,47,8,24,2,99,76,38,49,42,13,48,48,97],[52,54,51,88,68,33,31,22,45,6,24,17,52,48,19,6,21,85,83,6,49,20,98,75,44,39,36,31,28,73,36,16,30,95,79,21,33,76,10,41,23,39,12,89,67,59,95,59,63,80,17,15,50,8,57,98,17,38,74,96,31,19,7,67,2,67,46,83,18,5,20,72,86,45,75,82,50,56,36,83,79,93,22,0,1,7,9,13,97,36,17,20,20,21,41,24,25,98,79,77],[52,61,27,6,53,25,18,81,53,39,58,65,10,96,99,88,93,96,4,21,5,86,27,97,50,3,3,49,20,8,11,85,30,83,83,61,35,63,71,54,21,11,27,63,70,23,21,31,21,13,76,75,29,12,67,79,37,39,25,31,32,37,47,19,94,59,10,56,26,12,51,17,92,43,90,21,46,55,26,2,2,58,96,77,48,75,0,4,50,7,27,57,40,46,15,15,62,79,7,17],[0,4,14,97,13,86,15,15,16,16,17,18,18,19,21,64,98,23,23,11,24,25,23,71,79,7,29,90,3,9,68,76,34,88,35,35,64,44,30,63,92,20,49,0,39,39,39,39,41,81,72,39,74,42,42,51,89,43,43,43,42,96,42,85,91,95,44,77,72,48,45,45,45,58,72,23,52,46,46,46,2,28,4,29,47,27,71,98,48,5,19,23,61,98,58,74,72,24,34,37],[36,58,70,6,4,27,20,28,26,55,98,84,54,88,29,6,28,98,79,36,26,10,70,17,28,70,7,6,85,69,87,45,32,7,95,95,77,29,55,51,62,43,46,80,30,61,8,94,83,11,78,28,97,61,54,11,81,10,45,95,57,54,25,33,19,65,69,46,14,21,21,30,34,4,72,7,18,65,49,9,8,33,13,14,14,14,98,21,16,16,16,51,22,20,24,24,44,81,26,92],[1,16,14,50,21,70,48,46,65,84,8,96,13,82,56,83,59,92,22,50,19,61,56,99,83,22,96,8,12,90,95,91,93,59,83,34,38,26,47,49,47,36,24,4,50,68,94,89,8,36,69,40,65,91,2,34,1,85,79,84,0,34,66,5,29,86,91,50,51,17,38,21,77,55,71,88,72,96,7,43,91,39,75,6,42,54,52,90,51,80,18,64,95,92,72,27,51,20,14,77],[47,94,14,47,58,70,93,66,33,53,63,65,66,12,47,95,8,37,49,72,85,58,49,1,28,51,6,88,43,53,77,10,27,51,58,94,55,52,5,50,92,47,84,3,23,98,47,77,2,59,36,86,89,47,28,19,5,72,32,34,14,78,37,20,25,54,31,47,11,79,47,37,40,8,81,3,5,37,98,74,69,69,67,77,86,25,75,15,46,13,1,58,13,15,52,61,72,79,57,69],[32,15,8,33,10,12,31,62,10,5,41,33,0,52,88,13,50,86,86,84,61,87,75,65,9,23,86,86,68,99,98,38,19,50,65,75,31,53,38,46,0,95,27,37,79,82,37,98,36,33,2,78,94,47,38,51,4,28,97,76,3,13,16,16,16,17,86,83,19,21,22,22,22,24,25,42,29,2,5,33,23,94,93,8,34,99,2,65,35,10,79,77,37,37,37,30,39,68,2,15],[2,79,40,71,45,93,20,34,42,26,27,36,96,54,72,97,64,78,24,40,18,43,12,72,3,24,15,17,48,57,91,12,54,31,96,30,71,43,81,49,57,5,87,85,94,15,11,2,71,84,59,91,86,51,66,65,2,8,33,88,81,43,77,25,47,34,92,52,58,26,56,0,99,86,1,3,3,4,4,30,43,17,51,13,14,84,75,16,16,60,18,18,95,20,18,0,22,23,25,72],[35,73,73,68,29,94,5,93,95,36,95,13,19,92,93,63,85,2,34,32,60,59,44,32,22,99,52,90,15,39,82,16,74,29,83,56,14,76,25,30,50,81,59,77,50,58,40,48,97,93,18,86,41,42,80,66,75,55,23,47,87,34,31,48,60,55,20,62,38,0,94,28,15,15,15,19,20,20,21,21,65,83,43,24,43,27,71,62,29,95,38,30,28,63,35,35,35,2,28,82],[72,75,31,54,26,76,75,66,66,58,25,41,25,77,78,96,26,93,49,96,30,67,25,31,44,28,1,83,31,30,46,36,72,26,2,82,48,2,83,62,50,71,84,25,2,27,27,74,89,82,26,68,72,97,76,54,82,12,81,78,48,63,11,45,71,98,68,67,11,95,51,11,20,63,97,7,33,82,66,10,71,23,19,0,58,66,27,78,55,11,97,76,45,0,87,48,47,40,3,9],[95,8,13,98,39,11,62,16,75,90,10,18,2,90,9,91,53,11,65,85,7,89,9,31,40,6,2,0,49,15,91,86,76,0,32,95,40,11,8,5,81,75,65,49,40,10,63,65,55,65,74,10,98,93,61,65,86,28,8,18,90,55,32,16,36,63,55,81,66,17,46,58,38,6,18,99,6,80,33,13,88,47,37,12,80,50,79,21,7,78,74,95,25,61,95,51,27,17,27,96],[82,34,30,45,20,12,97,65,91,96,24,1,22,34,44,10,75,15,43,64,88,90,80,41,47,16,79,26,5,76,14,76,43,3,83,99,78,9,68,79,97,14,62,19,19,20,20,47,22,23,23,52,26,60,81,29,29,29,30,30,30,30,30,29,8,63,97,11,34,34,49,74,0,67,14,46,50,37,81,39,18,51,17,41,78,30,43,83,62,99,66,79,66,26,44,44,40,76,28,45],[63,27,70,78,87,64,58,17,72,53,32,90,80,8,72,71,72,52,57,61,99,56,71,17,54,88,29,79,25,27,65,32,45,96,74,66,72,12,48,30,13,10,7,71,10,28,29,70,51,85,50,92,59,90,1,47,26,42,75,85,42,59,25,77,66,16,87,63,7,31,50,71,82,2,57,55,4,24,2,71,57,24,59,32,79,14,20,74,86,64,6,4,66,61,38,65,46,66,1,1],[82,50,90,55,45,28,65,73,96,90,87,99,15,56,73,5,64,54,99,78,61,56,44,76,72,30,31,67,26,86,83,12,62,83,57,47,87,44,47,39,96,49,54,81,96,18,24,5,76,76,70,49,70,75,65,4,27,11,67,11,92,95,55,69,20,64,84,71,30,20,81,59,62,80,97,11,79,79,74,24,95,93,55,96,1,3,96,28,4,68,7,83,33,14,54,16,15,34,17,35],[10,10,37,51,24,85,5,98,76,10,45,67,60,50,88,66,12,6,69,41,18,39,49,55,28,67,12,50,95,41,28,37,81,95,9,61,49,89,67,19,50,72,55,44,58,60,62,61,8,16,65,11,18,49,5,28,5,90,56,95,69,37,3,97,64,29,93,87,66,63,63,36,33,24,88,96,74,15,71,64,63,33,28,42,27,36,21,44,71,77,9,46,12,10,60,61,99,1,51,4],[45,76,22,36,97,10,80,84,16,77,0,99,9,54,98,50,97,72,46,86,73,74,42,33,49,22,37,3,61,77,63,74,25,56,55,92,70,77,39,24,62,15,30,61,25,60,87,15,62,71,70,76,54,81,82,70,1,93,95,98,39,96,66,16,96,42,39,45,23,71,50,1,64,81,76,2,57,96,51,4,94,0,55,13,4,4,45,7,10,67,9,6,87,50,12,13,14,15,16,20],[13,38,28,44,3,59,50,74,33,0,78,6,3,58,4,95,38,30,28,95,75,13,13,86,0,21,18,20,20,21,90,23,23,71,24,97,25,26,26,46,92,40,29,47,39,2,28,33,33,56,82,34,34,35,83,1,52,12,42,39,39,15,15,40,40,40,40,42,8,43,43,43,43,43,7,94,36,44,44,7,54,45,45,81,83,57,46,55,78,47,20,59,0,6,79,51,59,77,11,87],[90,31,20,41,68,44,0,75,26,96,48,58,50,59,45,69,72,83,3,44,46,94,64,92,32,14,72,48,6,83,49,54,9,34,62,11,72,2,51,17,64,30,54,61,62,91,71,50,50,95,94,40,76,52,49,78,83,62,51,38,59,11,36,38,2,74,72,96,76,83,0,14,21,60,42,41,82,71,27,27,89,48,72,41,49,11,92,98,64,55,94,81,26,3,6,33,59,13,13,14],[17,17,83,48,69,5,66,99,4,8,86,93,28,66,66,26,21,89,6,63,56,85,7,6,43,73,6,16,8,17,51,98,25,78,2,28,66,88,76,66,53,7,41,8,90,71,87,40,37,92,62,36,5,74,75,65,16,84,46,26,94,77,61,19,26,94,55,85,1,62,97,15,0,52,70,18,22,15,16,69,18,18,79,21,61,22,22,65,82,8,24,69,63,26,26,8,42,18,41,30],[5,83,53,3,99,5,70,31,6,7,0,59,56,47,40,0,50,2,63,36,11,5,71,41,87,99,12,86,11,61,59,48,17,66,89,54,7,28,45,86,95,93,34,71,7,34,46,41,42,42,35,6,5,44,27,69,59,96,90,9,35,72,28,33,79,71,21,22,77,15,79,82,46,46,91,7,38,97,24,57,11,72,96,17,3,4,4,69,9,19,14,28,15,15,15,49,16,16,17,20],[0,27,33,41,78,94,57,82,95,86,7,99,62,63,57,20,30,88,51,3,68,58,18,1,37,5,50,18,21,14,26,66,2,99,20,75,8,98,77,65,83,46,62,21,31,66,0,26,52,4,57,64,53,42,92,83,50,63,76,40,43,46,74,61,96,21,45,37,59,5,72,17,80,88,42,72,3,3,4,97,9,9,9,9,9,85,18,18,58,95,19,43,80,24,25,25,26,27,49,46],[58,71,32,61,49,94,62,42,1,28,20,69,53,83,14,66,33,80,23,14,60,58,55,45,17,20,96,80,11,54,50,99,30,50,38,30,46,87,61,36,71,95,81,79,72,63,96,72,30,27,28,69,77,52,71,0,78,63,1,3,3,3,4,25,23,9,36,61,31,54,81,15,17,5,18,18,19,20,20,34,22,22,22,85,1,27,27,16,32,90,83,44,94,40,20,40,91,41,35,64],[53,70,30,43,14,99,77,72,78,89,32,2,60,15,64,56,56,72,12,81,25,75,18,3,38,22,24,17,7,92,9,72,41,66,94,79,86,66,1,60,26,43,31,55,6,1,44,13,32,71,47,12,62,83,52,19,12,89,6,32,28,66,62,7,60,54,8,36,19,51,79,21,14,76,3,43,19,94,13,14,15,46,16,59,40,22,22,23,25,25,37,29,44,58,48,99,98,33,94,7],[67,32,97,88,27,39,9,33,87,98,30,88,14,87,55,43,36,32,45,9,86,26,65,29,82,40,10,48,77,95,79,45,76,96,31,49,14,83,79,86,65,81,14,76,21,79,59,27,22,64,40,92,32,27,94,87,32,11,67,93,8,82,47,82,77,68,95,10,60,70,13,38,74,92,11,94,53,30,13,99,17,18,0,27,83,99,10,9,14,38,15,15,37,99,17,19,19,19,12,21],[31,10,63,1,37,98,92,62,65,32,53,21,22,31,12,52,99,10,46,80,10,10,24,50,69,68,93,26,31,12,31,90,19,45,22,26,55,27,98,98,8,93,1,94,48,31,8,66,19,20,62,25,14,98,27,5,14,86,5,19,5,12,62,18,39,93,2,55,65,47,20,12,64,72,61,0,75,40,72,60,37,12,60,12,9,25,94,41,48,89,38,74,66,79,31,9,14,13,13,14],[76,81,71,32,49,11,54,90,99,17,54,78,74,82,3,98,93,16,65,98,85,61,21,2,78,97,47,6,5,94,67,28,28,82,76,34,93,97,65,27,22,48,5,19,67,85,93,79,66,54,58,64,5,81,38,22,84,81,81,93,89,63,27,69,82,40,38,42,99,24,18,7,50,55,61,18,7,20,10,22,22,10,24,24,40,45,25,17,26,26,36,29,29,29,93,96,47,34,35,6],[85,39,47,38,21,63,96,53,52,9,47,98,0,65,11,47,22,42,81,51,11,85,21,5,96,93,38,0,3,94,32,81,19,17,29,27,14,9,9,62,96,32,13,37,15,16,67,77,74,24,71,8,29,29,57,30,25,34,8,37,37,37,58,32,41,99,15,42,42,75,43,43,43,44,44,44,30,75,45,45,45,26,43,8,46,46,46,46,65,60,58,93,57,47,40,46,80,52,65,66],[0,78,89,72,52,86,92,32,87,61,92,33,18,83,55,56,35,15,64,42,96,39,87,48,60,61,44,49,60,14,53,70,18,6,76,74,66,15,2,57,63,18,99,51,49,1,27,33,96,80,21,17,60,46,37,86,4,36,22,77,58,35,25,23,50,58,0,94,59,77,42,66,88,40,41,31,93,46,17,33,69,96,68,72,85,37,49,99,27,7,1,31,59,27,95,98,1,1,3,73],[95,97,81,40,79,58,35,75,98,79,92,50,72,54,11,79,11,58,54,38,0,2,49,31,67,46,49,81,22,83,38,99,64,76,6,11,64,16,76,46,46,23,60,3,53,50,63,6,31,9,49,46,13,14,40,67,15,16,17,19,56,21,36,22,22,23,5,25,36,26,26,92,29,29,78,96,62,77,19,81,34,35,35,35,98,29,37,32,39,41,41,13,43,4,32,87,40,44,50,33],[32,83,49,47,94,24,48,48,47,43,8,88,8,19,59,11,34,15,32,66,64,6,46,3,33,49,81,30,39,5,18,15,92,34,61,49,5,89,85,20,71,12,87,49,77,67,94,23,12,28,92,78,97,48,99,25,81,18,21,85,94,2,75,21,44,5,86,94,5,45,23,6,14,40,36,15,77,63,7,69,84,4,67,10,21,42,44,15,19,18,22,22,22,23,23,24,24,63,29,29],[56,57,72,21,91,72,60,24,63,75,35,71,62,31,84,59,6,66,83,52,25,53,4,18,12,62,6,76,63,31,47,79,74,67,71,33,36,47,85,84,53,27,82,16,71,62,58,26,95,58,9,65,25,62,59,81,13,13,15,15,16,16,11,17,54,49,32,62,22,62,23,24,25,25,25,25,25,38,26,27,27,71,29,33,62,97,33,33,37,92,1,34,40,35,7,37,41,39,39,39],[44,11,20,29,62,53,20,65,50,37,87,59,15,10,35,36,5,33,39,87,16,10,17,83,63,7,28,83,43,8,77,97,55,3,63,90,89,30,26,90,31,39,68,62,96,87,81,79,75,51,79,24,10,6,98,1,65,92,91,90,7,76,57,14,44,81,54,1,35,44,92,4,14,95,43,92,24,16,84,76,17,17,96,18,32,74,23,24,24,58,25,25,2,26,76,59,76,29,30,35],[4,89,47,12,8,55,40,79,39,31,72,79,27,59,69,60,59,26,32,15,67,24,32,84,89,89,65,43,54,31,63,73,98,8,50,51,71,29,55,28,7,54,2,8,73,63,75,68,48,96,68,7,54,57,3,2,58,56,78,21,48,46,12,83,41,0,23,1,42,4,57,7,28,11,57,73,69,13,14,14,7,18,94,20,21,21,22,22,25,26,8,51,73,68,9,33,33,33,34,34],[99,27,97,21,77,0,10,77,55,94,62,68,5,40,86,65,55,38,35,16,46,57,11,62,31,30,94,79,81,27,76,32,65,30,86,81,1,89,29,59,40,71,48,99,40,99,61,21,83,47,38,8,57,75,86,35,20,79,28,17,69,94,24,11,50,95,86,10,0,47,11,38,10,3,58,8,13,16,18,18,71,21,22,6,25,25,96,26,29,29,39,18,10,85,33,70,34,98,35,3],[66,10,32,90,0,43,28,73,77,55,37,5,77,6,1,38,48,39,54,8,1,55,74,82,65,58,86,43,39,63,53,80,47,87,11,49,48,54,1,24,12,90,94,51,22,5,27,12,12,54,2,10,21,30,47,40,33,49,99,53,27,94,37,94,62,31,84,2,94,75,75,35,91,9,39,42,75,1,29,48,49,33,83,5,28,51,46,18,74,54,42,99,89,70,31,76,10,71,15,17],[38,27,87,65,0,47,24,59,41,10,69,99,34,95,43,66,52,99,74,8,2,62,35,77,27,35,76,69,40,10,64,79,23,59,83,7,43,29,76,82,98,31,8,54,50,49,80,41,77,87,64,4,41,33,73,13,51,16,19,81,20,42,22,23,25,77,26,4,29,29,29,30,30,4,49,63,34,34,76,35,35,35,18,78,83,66,37,37,26,54,82,40,74,41,41,41,67,39,78,43],[45,65,91,80,23,68,97,69,80,36,12,30,68,82,32,23,43,65,31,65,96,97,58,34,36,8,41,79,42,47,29,4,58,15,75,83,95,5,10,2,83,39,93,20,95,6,31,63,62,95,45,99,51,50,5,76,11,59,47,41,74,36,84,74,13,74,7,38,1,3,4,63,12,79,6,13,13,16,16,19,41,18,18,20,20,42,22,23,23,23,64,24,97,32,30,30,66,55,27,77],[70,45,6,5,99,65,6,21,48,7,72,49,22,10,31,55,9,28,65,75,54,99,41,11,92,55,0,52,18,19,36,3,92,36,58,45,63,36,76,0,77,91,96,2,74,87,41,58,85,61,50,35,89,38,32,17,73,35,89,31,48,5,89,35,59,55,11,84,33,37,12,15,13,13,14,36,16,16,19,20,39,21,24,25,27,27,26,29,33,89,94,33,33,0,95,34,34,34,35,35],[13,82,47,47,41,87,52,36,5,4,86,53,97,33,95,8,99,61,76,10,99,57,58,49,98,48,71,21,12,96,31,47,39,78,4,26,36,19,8,5,19,6,6,77,74,9,78,89,55,23,19,87,96,67,92,31,8,28,62,31,28,26,65,67,55,73,58,37,76,58,36,3,48,7,81,64,89,49,37,84,71,50,54,33,32,49,40,97,49,53,3,48,83,64,95,90,16,16,16,66],[79,83,16,1,9,31,43,21,99,58,32,96,6,48,12,94,74,50,8,80,64,63,64,94,11,34,14,44,26,74,19,31,56,84,44,22,16,94,65,19,66,58,14,49,3,8,65,92,67,42,87,97,58,6,32,9,92,2,20,8,76,69,7,51,71,65,4,90,60,98,32,4,40,31,9,10,89,26,58,88,89,58,16,16,16,82,19,19,20,32,77,23,23,24,75,25,19,27,49,79],[97,80,14,63,28,87,90,12,1,90,57,80,11,96,13,13,87,52,27,77,92,13,24,81,24,65,72,79,42,81,15,56,79,12,92,44,42,95,24,70,19,22,21,62,44,76,86,87,37,3,6,15,49,51,90,0,24,7,61,97,14,86,59,67,31,81,56,25,99,88,24,36,97,9,3,63,74,84,54,55,77,97,19,27,46,3,3,58,31,62,37,9,9,79,16,19,18,44,21,86],[10,20,35,29,44,6,37,96,62,20,37,91,27,28,23,89,87,4,95,25,50,73,24,26,13,95,48,18,88,10,93,39,33,95,94,33,17,19,41,80,13,95,99,31,88,7,3,23,80,63,80,26,23,3,38,39,0,3,5,38,7,17,71,14,14,16,38,9,40,58,86,80,14,22,6,25,7,26,74,29,29,14,31,4,34,34,35,35,71,86,68,97,37,51,39,39,39,54,40,18],[25,7,38,34,5,50,35,99,93,49,99,5,23,1,7,28,74,95,98,88,62,57,27,49,99,79,28,40,26,32,28,33,10,78,62,21,86,6,88,78,21,41,15,63,31,16,96,93,5,12,68,39,50,1,79,67,48,87,61,32,74,51,98,74,32,87,86,76,10,8,76,48,80,50,48,81,21,32,61,96,86,38,90,55,17,38,98,97,74,4,89,54,0,95,94,9,5,17,11,75],[15,54,83,3,83,33,89,36,56,66,86,28,88,62,89,45,12,85,91,38,74,6,7,28,19,25,0,70,56,50,38,85,5,97,81,40,17,9,62,12,47,8,45,57,42,50,71,20,87,94,36,85,97,40,12,27,46,63,34,40,33,0,1,39,19,4,4,4,15,63,9,96,66,78,13,13,16,16,8,18,18,20,20,75,2,23,25,25,25,42,27,66,77,77,29,74,12,33,75,35],[17,47,15,64,42,98,54,70,99,62,34,6,71,81,54,76,60,63,72,64,68,46,49,2,86,96,14,96,71,6,32,61,23,83,32,55,87,38,62,65,42,50,72,2,73,61,88,72,36,85,7,87,61,75,74,64,53,84,43,60,12,71,44,46,43,30,78,0,24,93,76,0,57,98,21,74,10,37,92,3,54,15,66,50,71,60,89,85,64,49,58,46,66,79,79,23,5,1,54,26],[10,46,43,61,48,25,51,28,36,56,44,56,26,43,44,41,4,87,12,71,74,90,82,91,6,62,96,35,79,51,86,26,34,92,20,72,5,49,36,58,54,10,2,92,73,60,71,13,0,5,10,74,10,47,66,68,57,28,67,41,16,21,27,22,25,29,27,27,29,29,67,5,5,33,27,76,34,78,56,35,35,33,22,78,36,37,37,40,11,40,41,41,42,74,43,44,23,45,45,45],[71,81,59,35,11,99,75,12,64,54,3,82,6,31,31,24,22,90,1,49,10,6,45,7,62,57,92,41,8,58,63,67,90,8,61,95,81,62,28,0,44,14,87,98,56,86,92,48,99,51,55,99,70,35,17,40,31,66,97,61,99,97,81,55,40,99,87,72,51,76,76,13,86,20,50,49,66,36,75,38,40,47,86,16,24,70,68,63,58,50,80,1,76,95,96,12,49,42,9,10],[31,84,52,42,93,16,49,20,42,86,50,42,11,82,47,24,52,72,63,10,87,31,66,8,69,5,40,50,9,75,0,85,94,75,85,59,84,95,32,65,20,8,42,34,55,56,3,79,17,21,21,38,11,24,53,30,5,45,77,90,81,44,38,3,99,74,87,50,0,0,4,43,85,54,93,13,60,30,84,22,85,23,23,23,85,1,25,65,26,54,52,29,29,29,32,86,34,67,61,92]]";
//         int[][] superHardstate = Tools.convertStringTo2DArray(input);
//         Container c = new Container(superHardstate);
//         System.out.println("Puzzle 18:");
//         Tools.solvePuzzle(c);
//     }
// }    

