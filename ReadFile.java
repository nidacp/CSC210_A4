import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/** Class containing a file reading demo */
public class ReadFile {
  /** The main method reads from a file and prints the contents. */
  public static void main(String[] args) {
    // Figuring out input source
    Scanner file = null;
    if (args.length >0) {
      String filename = args[0];
      try {
        file = new Scanner(new File(filename));
      } catch (FileNotFoundException e) {
        System.err.println("Cannot locate file.");
        System.exit(-1);
      }
    } else {
      file = new Scanner(System.in);
    }
    Maze maze = new Maze();
    //ArrayList<ArrayList<MazeContents>> grid = new ArrayList<>();
    int fileHeight = 0;

    // reading from input
    while (file.hasNextLine()) {
        String line = file.nextLine();

        fileHeight++;
        maze.setWidth(line.length());       
    }
    System.out.println(fileHeight);
    maze.setGrid(fileHeight, maze.getWidth());
    file.close();

    Scanner file2 = null;
    if (args.length >0) {
      String filename = args[0];
      try {
        file2 = new Scanner(new File(filename));
      } catch (FileNotFoundException e) {
        System.exit(-1);
      }
    } else {
      file2 = new Scanner(System.in);
    }
    //ArrayList<ArrayList<MazeContents>> grid = new ArrayList<>();

    // reading from input
    int row = 0;
    while (file2.hasNextLine()) {
        String line = file2.nextLine();
        System.out.println(line);
        for(int i=0; i<line.length(); i++) {
            MazeLocation tempL = new MazeLocation(row, i);

            if(line.charAt(i)=='#') {
                maze.setContents(row, i, MazeContents.WALL);
            }
            else {
                maze.setContents(row, i, MazeContents.OPEN);
            }

            if(line.charAt(i)=='S') {
                maze.setStart(tempL);
                System.out.println("  " + tempL + " is the start.");
            }
            else if(line.charAt(i)=='F') {
                maze.setFinish(tempL);
                System.out.println("  " + tempL + " is the finish.");
            }
            System.out.print(tempL + " is " + maze.getContents(tempL.getCol(), tempL.getRow()) + ". ");
        }
        row++;
        System.out.println();
    }    
    file2.close();
    }
    
} 