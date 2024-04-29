import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class SolveMaze {

  
  public static boolean nextStep(MazeLocation x, Maze maze) {
    System.out.println("New call of NextStep().");
    if(x.equals(maze.getFinish())) {
      System.out.println("  Maze is finished! Ended at " + x);
      maze.setContents(x.getRow(), x.getCol(), MazeContents.PATH);
      return true;
    }

    MazeContents xCont = maze.getContents(x.getRow(), x.getCol());

    if(xCont==MazeContents.VISITED || xCont==MazeContents.WALL) {
      System.out.println("  Can't go to (" + x.getRow() + ", " + x.getCol() + ") because it is: " + xCont);
      return false;
    }

    // if neither of these if statements returned true, it means this is an open space. setting it as visited, later either being changed to path or dead end.

    maze.setContents(x.getRow(), x.getCol(), MazeContents.VISITED);
    
    /*MazeLocation nextLoc = x.neighbor(MazeDirection.NORTH);
    MazeContents nextCont = maze.getContents(nextLoc.getRow(), nextLoc.getCol());*/
    if(nextStep(x.neighbor(MazeDirection.NORTH),maze) || nextStep(x.neighbor(MazeDirection.SOUTH),maze) || nextStep(x.neighbor(MazeDirection.EAST),maze) || nextStep(x.neighbor(MazeDirection.WEST),maze)) {
      System.out.println("    One of the neighbors of " + x + " returned true.");
      maze.setContents(x.getRow(), x.getCol(), MazeContents.PATH);
      return true;
    }
    else {
      System.out.println("    No neighbors of " + x + " returned true. Dead end.");
      maze.setContents(x.getRow(), x.getCol(), MazeContents.DEAD_END);
      return false;
    }
  }


  public static void main(String[] args) {
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
    int row = 0;
    // reading from input
    while (file2.hasNextLine()) {
      String line = file2.nextLine();
      //System.out.println(line);
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
              //System.out.println("  " + tempL + " is the start.");
          }
          else if(line.charAt(i)=='F') {
              maze.setFinish(tempL);
              //System.out.println("  " + tempL + " is the finish.");
          }
          //System.out.print(tempL + " is " + maze.getContents(tempL.getCol(), tempL.getRow()) + ". ");
      }
      row++;
      System.out.println();
    }   

    file2.close();
    /*Maze maze = new Maze();
    maze.initDemoMaze();*/
    MazeViewer viewer = new MazeViewer(maze);
    MazeLocation x = maze.getStart();
    nextStep(x, maze);
  }
}
