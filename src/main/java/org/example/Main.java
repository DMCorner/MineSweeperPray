package org.example;

// firstClick still not created // unnecessary
// accepting strings bug? as 1 1
// boundary issues when hitting bomb on edge && height != width // nic fixed in like 10 seconds
//
public class Main {
    // keep this place clean
    // stop putting all code here
    public static void main(String[] args) {
        Minesweeper game = new Minesweeper();
        game.startMineSweeper();
    }
}

//public class Main {
//    public static void main(String[] args) {
//        // Grid generation
//
//        int[][] matrix = null;
//        int row = 0;
//        int column = 0;
//        int row_edit = 0;
//        int column_edit = 0;
//        Scanner scan = null;
//        // create Scanner class object to read input
//        scan = new Scanner(System.in);
//        // read row and column size
//        System.out.print("Enter an integer for row size: ");
//        row = scan.nextInt();
//        System.out.print("Enter an integer for column size: ");
//        column = scan.nextInt();
//        // initialize matrix
//        matrix = new int[row + 1][column + 1];
//        // read input for matrix
////        System.out.println("Enter matrix elements,");
//        for (int i = 0; i <= row; i++) {
//
//
//            for (int j = 0; j <= column; j++) {
//
////                System.out.print("Element[" + i + "][" + j + "]: ");
//                matrix[0][0] = 9;
//                matrix[0][j] = j;
//                matrix[i][0] = i;
//                double mine_maker = Math.random()*10;
//                if (mine_maker<2) {
//                    matrix[i][j] = 3;
//                } else {
//                    matrix[i][j] = 0;
//                }
//            }
//        }
//        // display matrix using for-each loop
//        //-----------------------------------------------------------
//        // keep numeric matrix but have number converted to character
//        // 0 = U, Undiscovered
//        // 1 = U, Undiscovered Mine
//        // ----------------------------------------------------------
//        System.out.println("\nThe field is ready,");
//        for (int[] i : matrix) {
////            System.out.println(i[0]++);
//            for (int j : i) {
//                if (i[0] == 0 && j == 9) {
//                    System.out.print("X ");
//                } else if (j == 0 ) {
//                    System.out.print('U' + " ");
//                } else if (j == 3 ) {
//                    System.out.print('M' + " ");
//                } else {
//                    System.out.print(j + " ");
//                }
//            }
//            System.out.println(); // new line
//        }
//        boolean gameRunning = true;
//        //edits generated matrix and prints again.
//        //---------------------------------------
//        //playing
//
//
//        while (gameRunning == true) {
//
//
//        scan = new Scanner(System.in);
//        System.out.print("Enter a row to dig: ");
//        row_edit = scan.nextInt();
//        System.out.print("Enter a column to dig: ");
//        column_edit = scan.nextInt();
//        if (gameRunning && matrix[row_edit][column_edit] == 3) {
//            matrix[row_edit][column_edit] = 3;
//            System.out.println("Mine Hit!");
//            gameRunning = false;
//        } else {
//            matrix[row_edit][column_edit] = 1;
//            //Ring Fill
//            //-----------------------------------
//            ringFill(row_edit,column_edit, matrix);
//
//
//        }
//        System.out.println("\nThe field is ready,");
//        for (int[] i : matrix) {
////            System.out.println(i[0]++);
//            for (int j : i) {
//                if (i[0] == 0 && j == 9) {
//                    System.out.print("X ");
//                } else if (j == 0 ) {
//                    System.out.print('U' + " ");
//                } else if (j == 3) {
//                    System.out.print('M' + " ");
//                } else {
//                    System.out.print(j + " ");
//                }
//            }
//            System.out.println(); // new line
//        }
//        //Win Check
//            int safe_tile_count = 0;
//            int mine_count = 0;
//            for (int[] i : matrix) {
//                for(int j: i) {
//                    if (j == 0) {
//                        safe_tile_count++;
//
//                    } else if (j == 3) {
//                        mine_count++;
//                    }
//                }
//            }
//            if (safe_tile_count==0) {
//                System.out.println("All safe tiles dug!");
//                System.out.println("Minefield cleared!");
//                gameRunning=false;
//            }
//            System.out.println("Safe tiles remaining: " + safe_tile_count);
//            System.out.println("Mines in field: " + mine_count);
//        }
//        System.out.println("Game End!");
//    }
//
//    public static void ringFill(int R,int C,int[][] M) {
//        int X = 0;
//        //right tile
//        if (M[R][C + 1] == 0) {
//            M[R][C + 1] = 1;
//            X++;
//            //left tile
//        } if (M[R][C - 1] == 0) {
//            M[R][C - 1] = 1;
//            X++;
//            // below tile
//        } if (M[R + 1][C] == 0) {
//            M[R + 1][C] = 1;
//            X++;
//            //above tile
//        } if (M[R - 1][C] == 0) {
//            M[R - 1][C] = 1;
//            X++;
//            //bottom right
//        } if (M[R + 1][C + 1] == 0) {
//            M[R + 1][C + 1] = 1;
//            X++;
//            //bottom left
//        } if (M[R + 1][C - 1] == 0) {
//            M[R + 1][C - 1] = 1;
//            X++;
//            //top right
//        } if (M[R - 1][C + 1] == 0) {
//            M[R - 1][C + 1] = 1;
//            X++;
//            // top left
//        } if (M[R - 1][C - 1] == 0) {
//            M[R - 1][C - 1] = 1;
//            X++;
//
//        }
//        System.out.println(("ringFill was used to fill: " + X + "squares! "));
//    }
//
//}
//
////Mon Working grid with mines and non-mines
////Tue
////Wed
////Thu
////Fri
//
////The number part of the square can just iterate through all squares around it and count how many bombs there are
//// don't worry about paint fill method just yet.