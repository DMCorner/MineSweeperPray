package org.example;

import java.util.Scanner;





public class UglyGrid {
    public static void main(String[] args) {
        // Grid generation

        int[][] matrix = null;
        int row = 0;
        int column = 0;
        int row_edit = 0;
        int column_edit = 0;
        int action_choice = 0;
        int adjNumber = 0;
        Scanner scan = null;
        // create Scanner class object to read input
        scan = new Scanner(System.in);
        // read row and column size
        System.out.print("Enter an integer for row size: ");
        row = scan.nextInt();
        System.out.print("Enter an integer for column size: ");
        column = scan.nextInt();
        // initialize matrix
        matrix = new int[row + 1][column + 1];
        // read input for matrix
//        System.out.println("Enter matrix elements,");
        for (int i = 0; i <= row; i++) {


            for (int j = 0; j <= column; j++) {

//                System.out.print("Element[" + i + "][" + j + "]: ");
                matrix[0][0] = 9;
                matrix[0][j] = j;
                matrix[i][0] = i;
                double mine_maker = Math.random()*10;
                if (mine_maker<2) {
                    matrix[i][j] = 3;
                } else {
                    matrix[i][j] = 0;
                }
            }
        }
        // display matrix using for-each loop
        //-----------------------------------------------------------
        // keep numeric matrix but have number converted to character
        // 0 = U, Undiscovered
        // 1 = U, Undiscovered Mine
        // ----------------------------------------------------------
        System.out.println("\nThe field is ready,");
        for (int[] i : matrix) {
//            System.out.println(i[0]++);
            for (int j : i) {
                if (i[0] == 0 && j == 9) {
                    System.out.print("X ");
                } else if (j == 0 ) {
                    System.out.print('U' + " ");
                } else if (j == 3 ) {
                    System.out.print('M' + " ");
                } else if (j == 1 ) {
                    System.out.print('0' + " ");
                } else {
                    System.out.print(j + " ");
                }
            }
            System.out.println(); // new line
        }
        boolean gameRunning = true;
        //edits generated matrix and prints again.
        //---------------------------------------
        //playing


        while (gameRunning == true) {
            scan = new Scanner(System.in);
            System.out.println("enter 'D' to Dig or 'F' to Flag");
            // action choice
            action_choice = scan.next().charAt(0);
            // Digging
            // ----------------------------------------------------------
            if (action_choice == 'D') {


            scan = new Scanner(System.in);
            System.out.print("Enter a row to dig: ");
            row_edit = scan.nextInt();
            System.out.print("Enter a column to dig: ");
            column_edit = scan.nextInt();
            if (gameRunning && matrix[row_edit][column_edit] == 3) {
                matrix[row_edit][column_edit] = 3;
                System.out.println("Mine Hit!");
                gameRunning = false;
            } else {
                matrix[row_edit][column_edit] = 1;
                //Ring Fill
                //-----------------------------------
                ringFill(row_edit,column_edit, matrix);


            }
            System.out.println("\nThe field is ready,");
            for (int[] i : matrix) {
//            System.out.println(i[0]++);
                for (int j : i) {
                    if (i[0] == 0 && j == 9) {
                        System.out.print("X ");
                    } else if (j == 0 ) {
                        System.out.print('U' + " ");
                    } else if (j == 3) {
                        System.out.print('M' + " ");
                    } else if (j == 1 ) {
                        System.out.print(adjMines(row_edit,column_edit,matrix) + " ");
                    } else if (j == 2 ) {
                        System.out.print('F' + " ");
                    } else if (j == 4 ) {
                        System.out.print('P' + " ");
                    } else {
                        System.out.print(j + " ");
                    }
                }
                System.out.println(); // new line
            }
            //Flagging
                //--------------------------------------------
            } if (action_choice == 'F') {
                System.out.println("Flagging selected");
                scan = new Scanner(System.in);
                System.out.print("Enter a row to Flag: ");
                row_edit = scan.nextInt();
                System.out.print("Enter a column to Flag: ");
                column_edit = scan.nextInt();
                if (gameRunning && matrix[row_edit][column_edit] == 3) {
                    matrix[row_edit][column_edit] = 4;
                    System.out.println("Tile Flagged");
                } else {
                    matrix[row_edit][column_edit] = 2;
                    System.out.println("Tile Flagged");


                }
                System.out.println("\nThe field is ready,");
                for (int[] i : matrix) {
//            System.out.println(i[0]++);
                    for (int j : i) {
                        if (i[0] == 0 && j == 9) {
                            System.out.print("X ");
                        } else if (j == 0 ) {
                            System.out.print('U' + " ");
                        } else if (j == 3) {
                            System.out.print('M' + " ");
                        } else if (j == 1 ) {
                            System.out.print('0' + " ");
                        } else if (j == 2 ) {
                            System.out.print('F' + " ");
                        } else if (j == 4 ) {
                            System.out.print('P' + " ");
                        } else {
                            System.out.print(j + " ");
                        }
                    }
                    System.out.println(); // new line
                }

            } else {
                System.out.println("Choose F or D first");
            }
            //Win Check
            int safe_tile_count = 0;
            int mine_count = 0;
            for (int[] i : matrix) {
                for(int j: i) {
                    if (j == 0) {
                        safe_tile_count++;

                    } else if (j == 3) {
                        mine_count++;
                    }
                }
            }
            if (safe_tile_count==0) {
                System.out.println("All safe tiles dug!");
                System.out.println("Minefield cleared!");
                gameRunning=false;
            }
            System.out.println("Safe tiles remaining: " + safe_tile_count);
            System.out.println("Mines in field: " + mine_count);
        }
        System.out.println("Game End!");
    }

    public static int adjMines(int R,int C,int[][] M) {
        int adjNumber = 0;
        if (M[R][C + 1] == 3) {
            adjNumber++;
            //left tile
        } if (M[R][C - 1] == 3) {
            adjNumber++;
            // below tile
        } if (M[R + 1][C] == 3) {
            adjNumber++;
            //above tile
        } if (M[R - 1][C] == 3) {
            adjNumber++;
            //bottom right
        } if (M[R + 1][C + 1] == 3) {
            adjNumber++;
            //bottom left
        } if (M[R + 1][C - 1] == 3) {
            adjNumber++;
            //top right
        } if (M[R - 1][C + 1] == 3) {
            adjNumber++;
            // top left
        } if (M[R - 1][C - 1] == 3) {
            adjNumber++;
        }
        return adjNumber;

    }

    public static void ringFill(int R,int C,int[][] M) {
        int X = 0;
        //right tile
        if (M[R][C + 1] == 0) {
            M[R][C + 1] = 1;
            X++;
            //left tile
        } if (M[R][C - 1] == 0) {
            M[R][C - 1] = 1;
            X++;
            // below tile
        } if (M[R + 1][C] == 0) {
            M[R + 1][C] = 1;
            X++;
            //above tile
        } if (M[R - 1][C] == 0) {
            M[R - 1][C] = 1;
            X++;
            //bottom right
        } if (M[R + 1][C + 1] == 0) {
            M[R + 1][C + 1] = 1;
            X++;
            //bottom left
        } if (M[R + 1][C - 1] == 0) {
            M[R + 1][C - 1] = 1;
            X++;
            //top right
        } if (M[R - 1][C + 1] == 0) {
            M[R - 1][C + 1] = 1;
            X++;
            // top left
        } if (M[R - 1][C - 1] == 0) {
            M[R - 1][C - 1] = 1;
            X++;

        }
        System.out.println(("ringFill was used to fill: " + X + " squares!"));
    }

    }



