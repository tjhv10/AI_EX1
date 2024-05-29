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
                int[][] superHardstate = Tools.convertStringTo2DArray(initRow);
                Container c = new Container(superHardstate);
                Tools.solvePuzzle(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}    

