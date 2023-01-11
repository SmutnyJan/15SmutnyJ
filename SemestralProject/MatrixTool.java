/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package semestralproject;

/**
 *
 * @author smutn
 */
public class MatrixTool {

    /**
     * Creates spirale matrix filled with numbers 1..width*height starting from top left corner
     *
     * @param width width of matrix
     * @param height height of matrix
     * @return spirale matrix with entered size
     */
    public static int[][] spirale(int width, int height) {
        int[][] matrix = new int[height][width];
        int x = 0;
        int y = 0;
        int xMovement = 1; // určení, jakým směrem se budeme pohybovat
        int yMovement = 0;
        int xBound = 0;
        int yBound = 0;

        int topEdge = 1;
        int rightEdge = width - 1;
        int botEdge = height - 1;
        int leftEdge = xBound;

        for (int i = 0; i < height * width; i++) {
            matrix[y][x] = i + 1;

            if (y == botEdge && yMovement == 1) {
                yMovement = 0;
                xMovement = -1;
            } else if (y == topEdge && yMovement == -1) { //oběhli jsme matici kolem dokola a můžeme tím pádem jít o jeden level dovnitř
                yMovement = 0;
                xMovement = 1;
                yBound++;
                xBound++;

                topEdge = 1 + yBound;
                rightEdge = width - 1 - xBound;
                botEdge = height - 1 - yBound;
                leftEdge = 0 + xBound;
            }

            if (x == rightEdge && xMovement == 1) {
                xMovement = 0;
                yMovement = 1;
            } else if (x == leftEdge && xMovement == -1) {
                xMovement = 0;
                yMovement = -1;
            }

            y += yMovement;
            x += xMovement;
        }

        return matrix;

    }

    public static void printMatrix(int[][] matrix) {
        int length = (int) (Math.log10(matrix.length * matrix[0].length) + 1);
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.printf("%0" + length + "d ", matrix[row][col]);
            }
            System.out.println("");
        }
    }
}
