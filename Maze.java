/* This class should implement the DisplayableMaze interface */
public class Maze implements DisplayableMaze {

  private int height;
  private int width;
  private MazeContents[][] mazeGrid;
  private MazeLocation start;
  private MazeLocation finish;


    /** The DemoMaze method will allow you to generate a simple maze
     * To test your code on as you develop it. Ultimately, you will want
     * to accept maze files as command line inputs or standard input.
     * * @author Tianah Gooden
     * * @version October 17th 2023
     */
    /*public Maze() {

    }

    public Maze(int height, int width, MazeContents[][] mazeGrid, MazeLocation start, MazeLocation finish) {
      this.height=height;
      this.width=width;
      this.mazeGrid=mazeGrid;
      this.start=start;
      this.finish=finish;
    }*/

    public void setGrid(int i, int j) {
      this.mazeGrid = new MazeContents[i][j];
    }

    public void initDemoMaze() { //String fileName, 
      System.out.println("DEMO !!!!!");
        this.height = 10;
        this.width = 8;
        this.mazeGrid = new MazeContents[height][width];
        this.start = new MazeLocation(1,1);
        this.finish = new MazeLocation(8,6);

        this.mazeGrid[0][0] = MazeContents.WALL; this.mazeGrid[0][1] = MazeContents.WALL; this.mazeGrid[0][2] = MazeContents.WALL; this.mazeGrid[0][3] = MazeContents.WALL; this.mazeGrid[0][4] = MazeContents.WALL; this.mazeGrid[0][5] = MazeContents.WALL; this.mazeGrid[0][6] = MazeContents.WALL; this.mazeGrid[0][7] = MazeContents.WALL;
        this.mazeGrid[1][0] = MazeContents.WALL; this.mazeGrid[1][1] = MazeContents.OPEN; this.mazeGrid[1][2] = MazeContents.OPEN; this.mazeGrid[1][3] = MazeContents.OPEN; this.mazeGrid[1][4] = MazeContents.OPEN; this.mazeGrid[1][5] = MazeContents.OPEN; this.mazeGrid[1][6] = MazeContents.WALL; this.mazeGrid[1][7] = MazeContents.WALL;
        this.mazeGrid[2][0] = MazeContents.WALL; this.mazeGrid[2][1] = MazeContents.WALL; this.mazeGrid[2][2] = MazeContents.OPEN; this.mazeGrid[2][3] = MazeContents.WALL; this.mazeGrid[2][4] = MazeContents.WALL; this.mazeGrid[2][5] = MazeContents.OPEN; this.mazeGrid[2][6] = MazeContents.WALL; this.mazeGrid[2][7] = MazeContents.WALL;
        this.mazeGrid[3][0] = MazeContents.WALL; this.mazeGrid[3][1] = MazeContents.OPEN; this.mazeGrid[3][2] = MazeContents.WALL; this.mazeGrid[3][3] = MazeContents.OPEN; this.mazeGrid[3][4] = MazeContents.OPEN; this.mazeGrid[3][5] = MazeContents.OPEN; this.mazeGrid[3][6] = MazeContents.WALL; this.mazeGrid[3][7] = MazeContents.WALL;
        this.mazeGrid[4][0] = MazeContents.WALL; this.mazeGrid[4][1] = MazeContents.OPEN; this.mazeGrid[4][2] = MazeContents.OPEN; this.mazeGrid[4][3] = MazeContents.OPEN; this.mazeGrid[4][4] = MazeContents.WALL; this.mazeGrid[4][5] = MazeContents.WALL; this.mazeGrid[4][6] = MazeContents.OPEN; this.mazeGrid[4][7] = MazeContents.WALL;
        this.mazeGrid[5][0] = MazeContents.WALL; this.mazeGrid[5][1] = MazeContents.OPEN; this.mazeGrid[5][2] = MazeContents.WALL; this.mazeGrid[5][3] = MazeContents.OPEN; this.mazeGrid[5][4] = MazeContents.OPEN; this.mazeGrid[5][5] = MazeContents.WALL; this.mazeGrid[5][6] = MazeContents.WALL; this.mazeGrid[5][7] = MazeContents.WALL;
        this.mazeGrid[6][0] = MazeContents.WALL; this.mazeGrid[6][1] = MazeContents.OPEN; this.mazeGrid[6][2] = MazeContents.WALL; this.mazeGrid[6][3] = MazeContents.WALL; this.mazeGrid[6][4] = MazeContents.OPEN; this.mazeGrid[6][5] = MazeContents.OPEN; this.mazeGrid[6][6] = MazeContents.OPEN; this.mazeGrid[6][7] = MazeContents.WALL;
        this.mazeGrid[7][0] = MazeContents.WALL; this.mazeGrid[7][1] = MazeContents.OPEN; this.mazeGrid[7][2] = MazeContents.WALL; this.mazeGrid[7][3] = MazeContents.OPEN; this.mazeGrid[7][4] = MazeContents.OPEN; this.mazeGrid[7][5] = MazeContents.WALL; this.mazeGrid[7][6] = MazeContents.OPEN; this.mazeGrid[7][7] = MazeContents.WALL;
        this.mazeGrid[8][0] = MazeContents.WALL; this.mazeGrid[8][1] = MazeContents.OPEN; this.mazeGrid[8][2] = MazeContents.OPEN; this.mazeGrid[8][3] = MazeContents.WALL; this.mazeGrid[8][4] = MazeContents.OPEN; this.mazeGrid[8][5] = MazeContents.WALL; this.mazeGrid[8][6] = MazeContents.OPEN; this.mazeGrid[8][7] = MazeContents.WALL;
        this.mazeGrid[9][0] = MazeContents.WALL; this.mazeGrid[9][1] = MazeContents.WALL; this.mazeGrid[9][2] = MazeContents.WALL; this.mazeGrid[9][3] = MazeContents.WALL; this.mazeGrid[9][4] = MazeContents.WALL; this.mazeGrid[9][5] = MazeContents.WALL; this.mazeGrid[9][6] = MazeContents.WALL; this.mazeGrid[9][7] = MazeContents.WALL;
        
        System.out.println("Demo done :)");
      }

    /** @return height of maze grid */
    public int getHeight() {
      return this.height;
    }

    /**
     * sets mazeGrid height to inputted int
     * @param height int value of the height of mazeGrid
     */
    public void setHeight(int height) {
      this.height = height;
    }

    /** @return width of maze grid */
    public int getWidth() {
      return this.width;
    }

    /**
     * sets width of mazeGrid to inputted int
     * @param width int width of maze grid
     */
    public void setWidth(int width) {
      this.width=width;
    }

    /** @return contents of maze grid at row i, column j */
    public MazeContents getContents(int i, int j) {
      if(i>=mazeGrid.length || j>=mazeGrid[i].length) {
        return MazeContents.WALL;
      }
      return this.mazeGrid[i][j];
    }

    public void setContents(int i, int j, MazeContents x) {
      this.mazeGrid[i][j]=x;
    }

    /** @return location of maze start point */
    public MazeLocation getStart() {
      return this.start;
    }

    /** @param s location of maze start point */
    public void setStart(MazeLocation s) {
      this.start = s;
    }

    /** @return location of maze finish point */
    public MazeLocation getFinish() {
      return this.finish;
    }

    /** @param f location of maze finish point */
    public void setFinish(MazeLocation f) {
      this.finish = f;
    }

    public static void main(String[] args) {
      Maze maze = new Maze(); 
      maze.initDemoMaze();
    }

}
