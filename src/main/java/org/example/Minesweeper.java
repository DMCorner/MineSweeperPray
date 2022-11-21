package org.example;

import java.util.Scanner;

//Game ends when all safe tiles dug
public class Minesweeper {
    private Scanner scan;
    private Field Field;
    //Initialises the game with scanner.
    //Field SIZE defined here along with number of mines
    // Set field attributes here
    //------------------------------------------------------------
    public Minesweeper() {
        scan = new Scanner(System.in);

        // max possible mines can be less

        Field = new Field(3,3);
        Field.spawnMines(1);
    }
    // game loop swapping between printing the field and
    // handles input required to meet next state
    // if a coordinate is typed in followed by "flag" the target tile will be flagged.
    //  game is won when all safe tiles are revealed
    public void startMineSweeper() {
        // Used to apply flag after coordinate.
        String extraCommand;
        Coordinate inputCoordinate;
        // let's implement the first try fix // unnecessary
            do {
                Field.printField();
                Field.printStatus();
                inputCoordinate = getCoordinateInput();
                extraCommand = getFlag(scan).trim();
                if (extraCommand.equalsIgnoreCase("flag")) {
                    Field.flagTile(inputCoordinate);
                } else if (Field.isTileFlagged(inputCoordinate)) {
                    System.out.println("\u001B[41m"+"You cant dig flagged tiles"+"\u001B[0m");
                    System.out.println("flag again to un-flag");
//                } else if (tryCount==0 && isTileMine(inputCoordinate) == true) {
//                    Field.addMine(inputCoordinate);
//                    Field.RevealTile(inputCoordinate);
//                    System.out.println("First click was a mine");
                } else {
                    Field.RevealTile(inputCoordinate);
                }
                // keep game going is players hasn't won && they haven't hit a mine
            } while (!Field.isWon() && (extraCommand.equalsIgnoreCase("flag") || !Field.isTileMine(inputCoordinate)));
            Field.RevealAll();
            Field.printField();
            if (Field.isWon()) {
                System.out.println("Game Won! All safe tiles revealed.");
            } else {
                System.out.println("Game Lost! You hit a mine!");
            }
        }
    //Checks flag
    public static String getFlag(Scanner scan) {
        String input = scan.nextLine();
        return input;
    }


    // loops until input is valid
    // accounts for array shenanigans start at 0
    public Coordinate getCoordinateInput() {
        Coordinate input = new Coordinate(0,0);
        do {
            System.out.println("Enter an integer for col: ");
            if(!scan.hasNextInt()) {
                getFlag(scan);
                System.out.println("X coordinate invalid");
                continue;
            }
            input.x = scan.nextInt();
            System.out.println("Enter an integer for row: ");
            System.out.println("type 'flag' after row input to flag tile.");
            if(!scan.hasNextInt()) {
                getFlag(scan);
                System.out.println("Y coordinate invalid");
                continue;
            }
            input.y = scan.nextInt();
            input.x--;
            input.y--;

            } while(!isCoordinateInputValid(input));
        return input;
        }

    //addresses already revealed tile
    //addresses tile out of bounds
    private boolean isCoordinateInputValid(Coordinate Coordinate) {
        if(!Field.validCoordinate(Coordinate)) {
            System.out.println("Coordinate entry out of bounds");
            return false;
        }
        if(Field.isTileRevealed(Coordinate)) {
            System.out.println("Tile is already Revealed");
            return false;
        }
        return true;
    }
    //Checks flag

}
