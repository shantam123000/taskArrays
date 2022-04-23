package org.aiolabs.trainings.basics.arrays;

import org.aiolabs.trainings.basics.constants.SortOrder;

import java.math.BigInteger;

/**
 * You can replace POINTS in the comments with DIFFICULTY_LEVEL. Lower is easier.
 * Do not invest a lot of time in the question. If you are able to figure out a workable solution within 5 minutes
 * of looking at the question, and are able to express that as some sort of pseudocode, you are good.
 * Try solving upto POINTS: 10.
 * <p>
 * You can work out the more difficult problems in your spare time after getting a job.
 * We will discuss them all in the next session.
 * <p>
 * In case of any invalid input just throw {@link IllegalArgumentException}
 */
public class ArraysBasics {

    /**
     * Icebreaker:
     * POINTS: 5
     * <p>
     * Find sum of all elements in the array.
     *
     * @param arr of numbers whose sum needs to be obtained
     * @return Sum of elements of an array
     */
    public long sumAll(int[] arr) {

        long sum = 0L;
        if (arr != null && arr.length > 0 ) {


            for (int j : arr) {
                sum += j;
            }
        }
        return sum;
    }

    /**
     * POINTS: 8
     * <p>
     * Append one element at the end of the array
     *
     * @param arr    to which the number has to be appended
     * @param number to be appended
     * @return A new array with a new number added at the tail
     */
    public int[] appendElement(int[] arr, int number) {
        if (arr != null && arr.length > 0) {
            int[] p = new int[arr.length + 1];
            for (int i = 0; i < arr.length; i++) {
                p[i] = arr[i];
            }
            p[p.length - 1] = number;
            return p;
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * POINTS: 9
     * <p>
     * Given an array of positive numbers starting from A to B. The array is not sorted.
     * All numbers from A to B except one is present. Find the missing number.
     * eg: arr = [10, 9, 12, 7, 5, 6, 8], A = 5, B = 12.
     * Missing number is 11
     *
     * @param array of numbers
     * @return missing number
     */
    public int missingNumber(int[] array, int a, int b) {

        if (array != null && array.length > 0) {
            while (a <= b) {
                boolean flag = false;
                for (int i : array) {
                    if (a == i) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    return a;
                } else {
                    a++;
                }
            }
        } else {
            throw new IllegalArgumentException();
        }

        return -1;
    }

    /**
     * POINTS: 8
     * <p>
     * Joins two arrays into one single array
     *
     * @param arrOne first array
     * @param arrTwo second array
     * @return array containing elements of both the arrays
     */
    public int[] unionArrays(int[] arrOne, int[] arrTwo) {
        if (arrOne != null && arrTwo != null) {
            int[] arr = new int[arrOne.length + arrTwo.length];
            for (int i = 0; i < arrOne.length; i++) {
                arr[i] = arrOne[i];
            }
            for (int i = arrOne.length; i < arr.length; i++) {
                arr[i] = arrTwo[i - arrOne.length];
            }
            return arr;
        } else {
            throw new IllegalArgumentException();

        }
    }

    /**
     * POINTS: 9
     * <p>
     * Remove duplicates from the array. All duplicates after the first occurrence should be deleted
     *
     * @param array whose duplicates are to be removed
     * @return resulting array with no duplicates
     */
    public int[] removeDuplicates(int[] array) {

        if (array.length > 0) {
            int c = 0;
            for (int i = 0; i < array.length; i++) {

                if (array[i] != -1) {
                    for (int j = 0; j < array.length; j++) {
                        if (array[i] == array[j] && i != j) {
                            array[j] = -1;
                        }
                    }
                    c++;
                }

            }
            int[] result = new int[c];
            int i2 = 0;
            for (int j : array) {
                if (j != -1) {
                    result[i2] = j;
                    i2++;
                }
            }

            return result;
        } else {
            throw new IllegalArgumentException();

        }
    }

    /**
     * POINTS: 5
     * <p>
     * Find the position of an element in an array. if not found, return -1
     *
     * @param array   in which the elements are to be searched for
     * @param element that needs to be searched
     * @return the positions of the element in the array or null if not found
     */
    public int[] searchArray(int[] array, int element) {

        if (array != null && array.length > 0) {
            int c = 0;
            for (int j : array) {
                if (j == element) {
                    c++;
                }
            }
            if (c > 0) {
                int[] a = new int[c];
                int p = 0;
                for (int i = 0; i < array.length; i++) {
                    if (array[i] == element) {
                        a[p] = i;
                        p++;
                    }
                }
                return a;
            } else {
                return null;
            }
        }
        return null;
    }

    /**
     * POINTS: 10
     * <p>
     * Sort the elements of an array in a given order
     *
     * @param array whose elements need to be sorted
     * @return sorted array
     */
    public int[] sortArray(int[] array, SortOrder sortOrder) {
        if (sortOrder == SortOrder.ASC) {
            for (int i = 0; i < array.length - 1; i++) {

                for (int j = 0; j < array.length - i - 1; j++)
                    if (array[j] > array[j + 1]) {
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
            }

        } else {
            for (int i = 0; i < array.length - 1; i++) {

                for (int j = 0; j < array.length - i - 1; j++)
                    if (array[j] < array[j + 1]) {
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
            }
        }
        return array;
    }

    /**
     * POINTS: 11
     * <p>
     * Merge sorted arrays into one sorted array. For example,
     * aOne = [1, 3, 5]
     * aTwo = [1, 2, 3, 4, 7]
     * result = [1, 1, 2, 3, 3, 4, 5, 7]
     *
     * @param arrayOne sorted array one
     * @param arrayTwo sorted array two
     * @return merged sorted array
     */
    public int[] sortedArrays(int[] arrayOne, int[] arrayTwo) {
        int n = arrayOne.length;
        int m = arrayTwo.length;
        int[] arrayThree = new int[arrayOne.length + arrayTwo.length];

        int n1 = 0;
        int n2 = 0;
        int i = 0;
        while (n1 < n && n2 < m && i < (n + m)) {

            if (arrayOne[n1] <= arrayTwo[n2]) {
                arrayThree[i] = arrayOne[n1];
                n1++;
                i++;
            } else {
                arrayThree[i] = arrayTwo[n2];
                n2++;
                i++;
            }
        }
        if (n1 != n) {
            while (n1 < n) {
                arrayThree[i] = arrayOne[n1];
                n1++;
                i++;
            }
        }
        if (n2 != m) {
            while (n2 < m) {
                arrayThree[i] = arrayTwo[n2];
                n2++;
                i++;
            }
        }
        return arrayThree;

    }

    /**
     * POINTS: 10
     * <p>
     * Assume that you are given an array of integer such that no element of the array has more than two digits
     * and the size of the array is not more than 10. Perform following operations on the array:
     * 1. Join all elements of the array into one large number
     * 2. If the resulting number is even, divide it by two else add one to it.
     * Continue performing step 2 until the result is 1.
     * Return the total number of operations required to get 1.
     * Here is an example:
     * arr = [12, 0, 1]
     * obtained number after joining all the elements: 1201
     * Start performing operations:
     * 1201 is not even => add one => 1202 (oppCount = 1 and next number => 1202)
     * 1202 is even => divide by 2 => 601 (oppCount = 2 and next number => 601).
     * continue doing this until you get 1 as next number
     *
     * @param array that needs to be reduced
     * @return number of operations performed to get reach 1
     */
    public int arrayToNumber(int[] array) {
        // {1, 12, 54}
        if (array.length > 0) {
            int number = 0;
            for (int i = 0; i < array.length; i++) {
                int x = array[i];
                int d = 1;
                if (x > 9) {
                    d = 2;
                }
                number = (int) (number * (Math.pow(10, d)) + array[i]);
//                number = (int) ((number*10) +array[i]x);

            }
            int c = 0;
            while (number != 1) {
                c++;
                if (number % 2 == 0) {
                    number /= 2;
                } else {
                    number += 1;
                }
            }
            return c;
        }


        return -1;
    }

    /**
     * POINTS: 6
     * <p>
     * Given a very large number as a string, store this large number in an array such that each cell of the array
     * stores one digit of the number.
     * eg. "12523442345345"
     * could be stored as: [1, 2, 5, 2, 3, ...]
     *
     * @param number that needs to be stored
     * @return array containing elements of the string
     */
    public int[] stringToArray(String number) {
        if (!number.isEmpty() || number != null) {
            int n = number.length();
            int[] result = new int[n];
            for (int i = 0; i < number.length(); i++) {
                result[i] = Integer.parseInt(String.valueOf(number.charAt(i)));
            }
            return result;
        }
        return null;
    }

    /**
     * POINTS: 15
     * <p>
     * Scientific research can require us to store numbers that are really large. There may be computers dedicated to do
     * just one operation eg. finding the value of PI
     * In our current problem, we are just going to perform simple addition operation on very large positive number.
     * Your task is to find sum of two large numbers
     *
     * @param largeNumberOne first number
     * @param largeNumberTwo second number
     * @return resulting number as String
     */
    public String sumLargeNumbers(String largeNumberOne, String largeNumberTwo) {

        BigInteger i = new BigInteger(largeNumberOne);
        BigInteger j = new BigInteger(largeNumberTwo);

        return String.valueOf(i.add(j));
    }

}
