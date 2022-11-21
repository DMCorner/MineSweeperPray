package org.example;// import statements
import java.util.Scanner;

//public class Grid {
//    int[][] matrix = null;
//    int row = 0;
//    int column = 0;
//    int row_edit = 0;
//    int column_edit = 0;
//    Scanner scan = null;
//    // create Scanner class object to read input
//    scan = new Scanner(System.in);
//    // read row and column size
//        System.out.print("Enter an integer for row size: ");
//    row = scan.nextInt();
//        System.out.print("Enter an integer for column size: ");
//    column = scan.nextInt();
//    // initialize matrix
//    matrix = new int[row + 1][column + 1];
//    // read input for matrix
////        System.out.println("Enter matrix elements,");
//        for (int i = 0; i <= row; i++) {
//
//
//        for (int j = 0; j <= column; j++) {
//
////                System.out.print("Element[" + i + "][" + j + "]: ");
//            matrix[0][0] = 9;
//            matrix[0][j] = j;
//            matrix[i][0] = i;
//            double mine_maker = Math.random()*10;
//            if (mine_maker<2) {
//                matrix[i][j] = 'M';
//            } else {
//                matrix[i][j] = 'U';
//            }
//        }
//    }
//    // display matrix using for-each loop
//    //-----------------------------------------------------------
//    // keep numeric matrix but have number converted to character
//    // 0 = U, Undiscovered
//    // 1 = U, Undiscovered Mine
//    // ----------------------------------------------------------
//        System.out.println("\nThe field is ready,");
//        for (int[] i : matrix) {
////            System.out.println(i[0]++);
//        for (int j : i) {
//            if (i[0] == 0 && j == 9) {
//                System.out.print("X ");
//            } else if (j == 'U' ) {
//
//                System.out.print('U' + " ");
//            } else if (j == 'M' ) {
//                System.out.print('M' + " ");
//            } else {
//                System.out.print(j + " ");
//            }
//        }
//        System.out.println(); // new line
//    }
//}

//frankly doing this grid first isn't awful.
//
//public class Grid implements ActionListener {
//    int count = 0;
//    JLabel label;
//    JFrame frameObj;
//    JButton btn1;
//    Object btn2 = new JButton();
//    // constructor
//    public Grid() {
//        frameObj = new JFrame();
//
//// creating 16 buttons
////        label = new JLabel("number of clicks: " + count);
//        btn1 = new JButton("1");
//        btn1.addActionListener(this);
//        JButton btn2 = new JButton("2");
//        btn2.addActionListener(this);
//        JButton btn3 = new JButton("3");
//        JButton btn4 = new JButton("4");
//        JButton btn5 = new JButton("5");
//        JButton btn6 = new JButton("6");
//        JButton btn7 = new JButton("7");
//        JButton btn8 = new JButton("8");
//        JButton btn9 = new JButton("9");
//        JButton btn10 = new JButton("10");
//        JButton btn11 = new JButton("11");
//        JButton btn12 = new JButton("12");
//        JButton btn13 = new JButton("13");
//        JButton btn14 = new JButton("14");
//        JButton btn15 = new JButton("15");
//        JButton btn16 = new JButton("16");
//// adding buttons to the frame
//// since, we are using the parameterless constructor, therefore;
//// the number of columns is equal to the number of buttons we
//// are adding to the frame. The row count remains one.
////        frameObj.add(label);
//        frameObj.add(btn1).setBackground(Color.BLACK);
//        frameObj.add(btn2).setBackground(Color.BLACK);
//        frameObj.add(btn3).setBackground(Color.BLACK);
//        frameObj.add(btn4).setBackground(Color.BLACK);
//        frameObj.add(btn5).setBackground(Color.BLACK);
//        frameObj.add(btn6).setBackground(Color.BLACK);
//        frameObj.add(btn7).setBackground(Color.BLACK);
//        frameObj.add(btn8).setBackground(Color.BLACK);
//        frameObj.add(btn9).setBackground(Color.BLACK);
//        frameObj.add(btn10).setBackground(Color.BLACK);
//        frameObj.add(btn11).setBackground(Color.BLACK);
//        frameObj.add(btn12).setBackground(Color.BLACK);
//        frameObj.add(btn13).setBackground(Color.BLACK);
//        frameObj.add(btn14).setBackground(Color.BLACK);
//        frameObj.add(btn15).setBackground(Color.BLACK);
//        frameObj.add(btn16).setBackground(Color.BLACK);
//// setting the grid layout
//// a 4 * 4 grid is created with the horizontal gap 20
//// and vertical gap 25
//        frameObj.setLayout(new GridLayout(4, 4, 20, 25));
//        frameObj.setSize(800, 800);
//        frameObj.setTitle("Overwatch 3");
//        frameObj.setVisible(true);
//    }
//
//    // main method
//    public static void main(String args[]) {
//        new Grid();
//    }
//
//    public void actionPerformed(ActionEvent evt) {
//// If event source is mine print game over
//        // If event source is safe set white
////        if (evt.getSource() == btn1)
//        if (btn1.getBackground() == Color.BLACK){
//            count++;
//            btn1.setBackground(Color.WHITE);
//        } else {
//            btn1.setBackground(Color.BLACK);
//        }
//
////        } else if (evt.getSource() == btn2) {
////            count--;
////            label.setText("number of clicks: " + count);
////        }
//
//    }
//}