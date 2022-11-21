package org.example;// import statements
// Create a GridSquare class

//import java.util.Scanner;
//
//public  class GridSquare {
//
//    private boolean isMine;
//
//    private boolean isRevealed;
//    // mines around square
//    private int neighbours;
//
//    private boolean isFlagged;
//
//    public square() {
//        resetSquare();
//    }
//}
//public class GridSquare {
//    boolean isOpened;  // Create a class attribute
//    boolean isMine;
//    int row;
//    int column;
//    int tile_number;
//    // Create a class constructor for the Main class
//    public GridSquare(int number_of_rows, int number_of_columns) {
//        this.isOpened = false;  // Set the initial value for the class attribute x
//        this.isMine = false;
//
//        // number after modulo can be replaced with row/col size.
//        this.row = Math.round(tile_number / 4) + 1;
//        if (tile_number % 4 == 0) {
//            this.row=this.row - 1;
//        }
//        this.column =  tile_number % 4;
//        if (this.column == 0) {
//            this.column = 4;
//        }
//    }
//
//
//// I want rows and columns assigned automatically.
//    public static void main(String[] args) {
//        int tile_number=1;
//        int tile_number_max=16;
//        int number_of_rows=5;
//        int number_of_columns=5;
//        while(tile_number<=tile_number_max) {
//            GridSquare myObj = new GridSquare(10, 10); // Create an object of class Main (This will call the constructor)
//            tile_number_max = number_of_rows*number_of_columns;
//            System.out.println("Opened: " + myObj.isOpened); // Print the value of x
//            System.out.println("Mine: " + myObj.isMine);
//            System.out.println("row: " + myObj.row);
//            System.out.println("col: " + myObj.column);
//            tile_number++;
//        }
//    }
//}

// Outputs 5
