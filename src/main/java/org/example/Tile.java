package org.example;

public class Tile {
    private boolean isMine;
    private boolean isRevealed;
    // mines around tile
    private int AdjMines;
    // isFlagged does not prevent Reveal() and should be done by the system managing
    // the tile by checking getIsFlagged().
    private boolean isFlagged;
    // constructor for tile
    public Tile() {
        resetTile();
    }
    public void resetTile() {
        isMine = false;
        isRevealed = false;
        AdjMines = 0;
        isFlagged = false;
    }
    public void setAsMine() {
        isMine = true;
    }
    // get true if tile is a mine
    public boolean getIsMine() {
        return isMine;
    }
    //sets the tile to be dug not prevented by isFlagged
    public void Reveal() {
        isRevealed = true;
    }
    public boolean getIsRevealed() {
        return isRevealed;
    }
    //increases depending on nearby mines
    public void addAdjMines() {
        AdjMines++;
    }
    // the actual number of adjacent mines for a tile
    public int getAdjMines() {
        return AdjMines;
    }
    // checks if tile is flagged so that player doesn't Reveal flags
    public boolean getIsFlagged() {
        return isFlagged;
    }
    public void toggleIsFlagged() {
        isFlagged = !isFlagged;
    }
    // M for Mine. F for flagged, R for revealed, or
    public String toString() {
        if(getIsRevealed()) {
            if(getIsMine()) {
                return "\u001B[101m"+"\u001B[30m"+"M";

            }if (AdjMines==0) {
                return "\u001B[40m"+"\u001B[97m"+""+AdjMines;
            } if (AdjMines==1) {
                return "\u001B[40m"+"\u001B[92m"+""+AdjMines;
            } if (AdjMines==2) {
                return "\u001B[40m"+"\u001B[32m"+""+AdjMines;
            } if (AdjMines==3) {
                return "\u001B[40m"+"\u001B[94m"+""+AdjMines;
            } if (AdjMines==4) {
                return "\u001B[40m"+"\u001B[34m"+""+AdjMines;
            } if (AdjMines==5) {
                return "\u001B[40m"+"\u001B[93m"+""+AdjMines;
            } if (AdjMines==6) {
                return "\u001B[40m"+"\u001B[33m"+""+AdjMines;
            } if (AdjMines==7) {
                return "\u001B[40m"+"\u001B[91m"+""+AdjMines;
            } if (AdjMines==8) {
                return "\u001B[40m"+"\u001B[31m"+"" + AdjMines;
            } else {
                return ""+AdjMines;
            }
        } else if(isFlagged) {
            return "\u001B[44m"+"\u001B[30m"+"F";
        } else {
            return "\u001B[97m"+"\u001B[40m"+".";
        }
    }
}
