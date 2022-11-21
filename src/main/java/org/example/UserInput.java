package org.example;
import java.util.Arrays;
import java.util.Scanner;

//public class UserInput {
//
//    public static void print2D(int mat[][]) {
//
//    }
//
//    public static void main(String[] args) {
//        int[][] matrix = null;
//        int row = 0;
//        int column = 0;
//        int row_edit = 0;
//        int column_edit = 0;
//        Scanner scan = null;
//        // create Scanner class object to read input
//        scan = new Scanner(System.in);
//        // read row and column size
//        System.out.print("Enter row and column size in the form 'rows cols': ");
//        row = scan.nextInt();
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
//                matrix[i][j] = 0;
//                matrix[0][j] = j;
//                matrix[i][0] = i;
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
//                if (i[0] == 0 && j == 0) {
//                    System.out.print("X ");
//                } else if (j == 0 ) {
//                    System.out.print('U' + " ");
//
//                } else {
//                    System.out.print(j + " ");
//                }
//            }
//                System.out.println(); // new line
//            }
//
//        //edits generated matrix and prints again.
//        scan = new Scanner(System.in);
//        System.out.print("Enter row and column to dig in the form 'row col': ");
//        row_edit = scan.nextInt();
//        column_edit = scan.nextInt();
//        matrix[row_edit][column_edit] = 1;
//        System.out.println("\nThe field is ready,");
//        for (int[] i : matrix) {
////            System.out.println(i[0]++);
//            for (int j : i) {
//                if (i[0] == 0 && j == 0) {
//                    System.out.print("X ");
//                } else if (j == 0 ) {
//                    System.out.print('U' + " ");
//
//                } else {
//                    System.out.print(j + " ");
//                }
//            }
//            System.out.println(); // new line
//        }
//
//        }
//    }
//


//        Scanner scan = new Scanner(System.in);
//        System.out.println("Enter number of rows");
//        int user_input_rows = scan.nextInt();
//        System.out.println("The entered rows value is: ");
//        System.out.println(user_input_rows);
//        System.out.println("Enter number of cols");
//        int user_input_cols = scan.nextInt();
//        System.out.println("The entered cols value is: ");
//        System.out.println(user_input_cols);
//        int mat[][] = { { 0, 0, 0, 0 },
//                        { 0, 0, 0, 0 },
//                        { 0, 0, 0, 0 } };
//        print2D(mat);
