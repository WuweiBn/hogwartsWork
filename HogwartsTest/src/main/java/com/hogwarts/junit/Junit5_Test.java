package com.hogwarts.junit;

public class Junit5_Test {
    public static int result = 0;

    public static int addition(int x, int y) {

        int result = x + y;
        return result;
    }

    public static int Subtraction(int x, int y) {

        int result = x - y;
        return result;
    }

    public static int multiplication(int x, int y) {

        int result = x * y;
        return result;
    }

    public static int division(int x, int y) {

        int result = x / y;
        return result;
    }

    public static int count(int x) {
        int i = result;
        result = i + x;
        return result;
    }

    public synchronized static int syncount(int x) {
        int i = result;
        result = i + x;
        return result;
    }

}
