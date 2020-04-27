package org.example;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


/**
 * Unit test for simple App.
 */
public class AppTest
{

    @Test
    public void TestAdditionalMatrices(){
        int[][] matrixFirstExample = {{4,5},{6,7}};
        int[][] matrixSecondExample = {{1,2},{3,4}};
        int[][] matrixResult = {{5,7},{9,11}};
        assertArrayEquals(matrixResult,App.additionMatrix(matrixFirstExample,matrixSecondExample));
    }


    @Test
    public void TestNotEqualSizeMultiplyMatrices(){
        int[][] matrixA = {{4,5},{3,2},{6,7}};
        int[][] matrixB = {{1,2},{3,4},{5,6}};
        assertThrows(ArrayIndexOutOfBoundsException.class,()->{App.multiplyMatrix(matrixA,matrixB);});
    }

    @Test
    public void TestSubtractionMatrices(){
        int[][] matrixFirstExample = {{4,5},{6,7}};
        int[][] matrixSecondExample = {{1,2},{3,4}};
        int[][] matrixResult = {{3,3},{3,3}};
        assertArrayEquals(matrixResult,App.subMatrix(matrixFirstExample,matrixSecondExample));
    }

    @Test
    public void TestMultiplyMatrices(){
        int[][] matrixA = {{4,5,7},{-2,-4,8},{6,7,0}};
        int[][] matrixB = {{1,2,3},{-4,5,0},{-3,4,6}};
        int[][] matrixResult = {{-37,61,54},{-10,8,42},{-22,47,18}};
        assertArrayEquals(matrixResult,App.multiplyMatrix(matrixA,matrixB));
    }

    @Test
    public void TestTranspose(){
        int[][] matrixA = {{4,5},{6,7}};
        int[][] matrixResult = {{4,6},{5,7}};
        assertArrayEquals(matrixResult,App.transpose(matrixA));
    }

//    @ParameterizedTest
//    @ValueSource(ints = { "racecar", "radar", "nenez zenen" })
//    void palindromes(String kek) {
//        assertTrue(App.isPalindrome(kek));
//    }

//    @ParameterizedTest
//    @ValueSource(ints = {3,3,4})
//    public void TestWithParametrs(int ){
//
//    }
}
