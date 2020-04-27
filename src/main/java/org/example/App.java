package org.example;

public class App
{
    public static boolean isPalindrome(String candidate) {
        if (candidate == null) {
            return true;
        }
        char[] chars = candidate.toCharArray();
        int length = chars.length;
        for(int i = 0; i < length / 2; i++) {
            if (chars[i] != chars[length - 1 - i]) {
                return false;
            }
        }
        return true;
    }
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    public static int[][] transpose(int[][] matrix) {
        int[][] transpose = new int[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                transpose[j][i] = matrix[i][j];
        return transpose;
    }

    public static int[][] multiplyMatrix(int[][] firstMatrix,int[][] secondMatrix){
        secondMatrix = transpose(secondMatrix);
        if(firstMatrix[0].length!=secondMatrix.length){
            throw new ArrayIndexOutOfBoundsException("Size not equal");
        }
        int a = firstMatrix.length;
        int b = secondMatrix[0].length;
        int c = firstMatrix[0].length;
        int resultMatrix[][] = new int[a][b];

        for(int i = 0; i < a; i++){
            for (int j = 0; j < b; j++){
                for(int k = 0; k < c; k++){
                    resultMatrix[i][j] += firstMatrix[i][k] * secondMatrix[j][k];
                }
            }
        }
        return resultMatrix;
    }

    public static int[][] additionMatrix(int[][] firstMatrix,int[][] secondMatrix){
        if(firstMatrix.length!=secondMatrix.length
            || firstMatrix[0].length!=secondMatrix[1].length){
            throw new IllegalArgumentException("Size not equal");
        }
        int a = firstMatrix.length;
        int b = secondMatrix[0].length;
        int c = firstMatrix[0].length;
        int resultMatrix[][] = new int[a][b];

        for(int i = 0; i < a; i++){
            for (int j = 0; j < b; j++){
                resultMatrix[i][j] += firstMatrix[i][j] + secondMatrix[i][j];
            }
        }
        return resultMatrix;
    }

    public static int[][] subMatrix(int[][] firstMatrix,int[][] secondMatrix){
        if(firstMatrix.length!=secondMatrix.length
            || firstMatrix[0].length!=secondMatrix[1].length){
            throw new IllegalArgumentException("Size not equal");
        } else if (firstMatrix.length <= 0 || firstMatrix[0].length <= 0
            || secondMatrix.length <= 0 || secondMatrix[0].length <= 0) {
            throw new IllegalArgumentException("Size less 0");
        }
        int a = firstMatrix.length;
        int b = secondMatrix[0].length;
        int c = firstMatrix[0].length;
        int resultMatrix[][] = new int[a][b];

        for(int i = 0; i < a; i++){
            for (int j = 0; j < b; j++){
                resultMatrix[i][j] += firstMatrix[i][j] - secondMatrix[i][j];
            }
        }
        return resultMatrix;
    }

    public static void printMatrix(int[][] matrix) {
        int rows=matrix.length;
        int cols=matrix[0].length;
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++)
                System.out.print(matrix[i][j]+" ");
            System.out.println();
        }
    }
}
