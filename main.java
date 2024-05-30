import java.io.IOException;
import java.util.List;
public class Main {
    
    public static void main(String[] args) {
        String filePath = "instences.txt";
        try {
            List<String> initRows = Tools.extractInitRows(filePath);
            for (int j = 0; j < 100; j++) {
            int i = 16;
            while (i<20)
            {

                System.out.println("Puzzle "+i+":");
                int[][] superHardstate = Tools.convertStringTo2DArray(initRows.get(i));
                i++;
                Container c = new Container(superHardstate);
                Tools.solvePuzzle(c);
                System.gc();
            }
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
    
    }
}    

