package org.example;
import java.util.*;
//
// Defines the field and track the state of the grid of tiles.
// interaction with the field.
// Keep editing of variables in here
// put fill here
//
public class Field {
    // The 2d grid of tiles that can be mines or represent the number of nearby mines.
    private Tile[][] Tiles;
    //Number of tiles on the horizontal axis.
    private int width;
    private int height;
    private int mineCount;
    //Number of tiles that have been REVEALED.
    private int RevealedTotal;
    //Number of tiles marked with a flag to block Revealing as they are suspected to be bombs.
    private int flaggedCount;
    //field with the specific width and height.
    //tiles are populated non mine tiles
    public Field(int width, int height) {
        this.width = width;
        this.height = height;
        mineCount = 0;
        Tiles = new Tile[width][height];
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                Tiles[x][y] = new Tile();
            }
            }
        RevealedTotal = 0;
        flaggedCount = 0;
    }
    //PRINT FIELD HERE
    //----------------------------------------------------------------------------------
    public void printField() {
        // Numbers for each column
        for(int x = 0; x < width; x++) {
            System.out.print("\u001B[36m"+(x+1) + " "+"\u001B[0m");
            if(x+1 < 10)
                // accounts for space
                System.out.print(" ");
        }
        // prints above axis
        System.out.println();
        for (int x=0; x<width; x++) {
            System.out.print("\u001B[36m"+"---"+"\u001B[0m");
        }
        System.out.println();
        // field tiles printed here

        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                System.out.print(Tiles[x][y] + "  ");
            }
            // Print the numbering for this row at the end
            System.out.println("\u001B[0m"+"\u001B[36m" + "|"+ (y + 1)+"\u001B[0m");
        }
    }
    //print current status, total revealed tiles,total number of tiles,
    //number of mines on the field,number of flagged tiles.
    public void printStatus() {
        System.out.println(RevealedTotal + " tiles dug out of " + (height*width)
                + " with " + mineCount + " mines! Tiles flagged: " + flaggedCount);
    }
    //Mine check
    public boolean isTileMine(Coordinate Coordinate) {
        return Tiles[Coordinate.x][Coordinate.y].getIsMine();
    }
    // tile reveal check
    public boolean isTileRevealed(Coordinate Coordinate) {
        return Tiles[Coordinate.x][Coordinate.y].getIsRevealed();
    }
    //flag check
    public boolean isTileFlagged(Coordinate Coordinate) { return Tiles[Coordinate.x][Coordinate.y].getIsFlagged(); }
    //get tile check
    public Tile getTileAt(Coordinate Coordinate) {
        return Tiles[Coordinate.x][Coordinate.y];
    }
    //Reveal tile
    public void RevealTile(Coordinate Coordinate) {
        if(Tiles[Coordinate.x][Coordinate.y].getAdjMines() != 0) {
            // Reveal the single tile
            RevealedTotal++;
            Tiles[Coordinate.x][Coordinate.y].Reveal();
        } else {
            // Reveal all tiles adjacent if no mines found.
            List<Coordinate> RevealedTiles = floodFillReveal(Coordinate);
            // Repeat for bordering tiles
            List<Coordinate> borderRevealedTiles = RevealAroundListOfPoints(RevealedTiles);
            RevealedTotal += RevealedTiles.size() + borderRevealedTiles.size();
        }
    }
    // flag Tile
    public void flagTile(Coordinate Coordinate) {
        getTileAt(Coordinate).toggleIsFlagged();
        // Keep count of the number of flagged Tiles
        if(getTileAt(Coordinate).getIsFlagged()) flaggedCount++;
        //changes flagged count accordingly
        else flaggedCount--;
    }
    //Mine Spawner
    //-------------------------
    // limits total mines in field
    // can fail if tile selected multiple times
    public void spawnMines(int maxMines) {
        Random rand = new Random();
        for(int i = 0; i < maxMines; i++) {
            // does that mean i will never have mines on max width and max height rows?
            addMine(new Coordinate(rand.nextInt(width), rand.nextInt(height)));
        }
    }

    //checks if player has won
    public boolean isWon() {
        return RevealedTotal + mineCount == width*height;
    }

    // Reveals all tiles
    public void RevealAll() {
        for(int y = 0; y < Tiles.length; y++) {
            for (int x = 0; x < Tiles[0].length; x++) {
                try {
                    Tiles[y][x].Reveal();
                } catch (Exception e) {
                    System.out.println("X: "+x +" Y: "+ y);
                    e.printStackTrace();
                }
            }
        }
    }

    // adds a mine at coordinate
    private boolean addMine(Coordinate Coordinate) {
        // don't add mines to mines
        if(getTileAt(Coordinate).getIsMine()) return false;
        // bounds of tiles + or - 1 around x,y
        // adjusts for array 0 and 1 start
        int left = Math.max(0,Coordinate.x-1);
        int right = Math.min(width-1,Coordinate.x+1);
        int bottom = Math.max(0,Coordinate.y-1);
        int top = Math.min(height-1,Coordinate.y+1);
         // increase AdjMines for all surrounding tiles
        // that are in bounds
        for(int y1 = bottom; y1 <= top; y1++) {
            for (int x1 = left; x1 <= right; x1++) {
                Tiles[x1][y1].addAdjMines();
            }
        }
        getTileAt(Coordinate).setAsMine();
        mineCount++;
        return true;
    }

    // tests if coordinates are within field
    public boolean validCoordinate(Coordinate Coordinate)
    {
        return Coordinate.x >= 0 && Coordinate.y >= 0 && Coordinate.x < width && Coordinate.y < height;
    }
    //FILL HERE
    //------------------------------------------------------------------------------------------------
        //flood fills at x,y Revealing all Tiles with 0 AdjMines that are adjacent.
    // this is complex and awful
    private List<Coordinate> floodFillReveal(Coordinate Coordinate)
    {
        // matrix that travels around field
        int[][] travel = new int[width][height];

        // set all tiles in said matrix to 0
        for(int x=0;x<width;x++){
            for(int y=0;y<height;y++){
                travel[x][y]=0;
            }
        }
        // make a list of all coordinates flooded called changed points
        List<Coordinate> changedPoints =  new ArrayList<>();
        //create queue from said list
        Queue<Coordinate> CoordinateQueue = new LinkedList<>();
        // select coordinate evaluated first
        CoordinateQueue.add(Coordinate);
        travel[Coordinate.x][Coordinate.y] = 1;
        // until queue is not empty
        while (!CoordinateQueue.isEmpty())
        {
            // take coordinate from queue
            Coordinate CoordinateToReveal = CoordinateQueue.remove();
            getTileAt(CoordinateToReveal).Reveal();
            changedPoints.add(CoordinateToReveal);
            // up,down,right,left tile
            checkFloodFillToTile(new Coordinate(CoordinateToReveal.x+1,CoordinateToReveal.y),travel,CoordinateQueue);
            checkFloodFillToTile(new Coordinate(CoordinateToReveal.x-1,CoordinateToReveal.y),travel,CoordinateQueue);
            checkFloodFillToTile(new Coordinate(CoordinateToReveal.x,CoordinateToReveal.y+1),travel,CoordinateQueue);
            checkFloodFillToTile(new Coordinate(CoordinateToReveal.x,CoordinateToReveal.y-1),travel,CoordinateQueue);
        }
        return changedPoints;
    }
    //helps floodFillReveal() by testing one tile at Coordinate p (see reveal around list of points)
    //if the selected tile is VALID COORDINATE!, has not yet been checked,
    //and is a valid element to reveal(not a mine) for the flood fill of all tiles with 0 adjMines.
    //then it will add the tile as a new tile to check AdjMines of, and mark it as travel
    private void checkFloodFillToTile(Coordinate Coordinate, int[][] travel, Queue<Coordinate> CoordinateQueue) {
        //valid?
        if (validCoordinate(Coordinate)) {
            // traveled through by travel matrix
            if (travel[Coordinate.x][Coordinate.y] == 0
                    // tile isn't already revealed
                    && !getTileAt(Coordinate).getIsRevealed()
                    // not a mine
                    && getTileAt(Coordinate).getAdjMines() == 0) {
                // add to queue
                CoordinateQueue.add(Coordinate);
            }
            //reset
            travel[Coordinate.x][Coordinate.y] = 1;
        }
        }
    //takes a list of coordinates and iterates through all coordinates to
    //perform a reveal of all tiles up to 1 unit away from each tiles
    private List<Coordinate> RevealAroundListOfPoints(List<Coordinate> points) {
        //new list
        List<Coordinate> changedTiles = new ArrayList<>();
        // for each coordinate p in points
        for(Coordinate p : points) {
            // add list of points around p to revealed tiles
            List<Coordinate> RevealedTiles = RevealAllAroundPoint(p);
            changedTiles.addAll(RevealedTiles);
        }
        return changedTiles;
    }
    // Reveals all tiles UP TO one unit away from the coordinate.
    // skips any tiles that have 0 neighbouring mines.
    private List<Coordinate> RevealAllAroundPoint(Coordinate Coordinate) {
        // new tile
        List<Coordinate> changedTiles = new ArrayList<>();
        // get tiles + or - 1 around x,y
        int left = Math.max(0,Coordinate.x - 1);
        int right = Math.min(width - 1,Coordinate.x + 1);
        int bottom = Math.max(0,Coordinate.y - 1);
        int top = Math.min(height - 1,Coordinate.y + 1);
        // iterate through all surrounding tiles
        for(int y1 = bottom; y1 <= top; y1++) {
            for (int x1 = left; x1 <= right; x1++) {
                // Not already dug and not the start of another already revealed area.
                if(!Tiles[x1][y1].getIsRevealed() && Tiles[x1][y1].getAdjMines()>0) {
                    changedTiles.add(new Coordinate(x1,y1));
                    Tiles[x1][y1].Reveal();
                }
            }
        }
        return changedTiles;
    }
}

