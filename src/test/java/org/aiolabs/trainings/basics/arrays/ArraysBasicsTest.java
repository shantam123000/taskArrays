package org.aiolabs.trainings.basics.arrays;

import org.aiolabs.trainings.basics.constants.SortOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ArraysBasicsTest {

    // SUT stands for system under test
    ArraysBasics sut;

    @BeforeEach
    void setUp() {
        sut = new ArraysBasics();
    }

    @Test
    void sumAll() {

        assertThat(sut.sumAll(new int[]{1, 2, 3}))
                .isEqualTo(6);

        assertThat(sut.sumAll(new int[]{}))
                .isEqualTo(0);

        assertThat(sut.sumAll(new int[]{1}))
                .isEqualTo(1);

        assertThat(sut.sumAll(new int[]{-1, 0, 1}))
                .isEqualTo(0);

        assertThat(sut.sumAll(new int[]{-1, -2, -3, -4}))
                .isEqualTo(-10);

        assertThat(sut.sumAll(new int[]{Integer.MAX_VALUE, 1}))
                .isEqualTo(2147483648L);

        assertThat(sut.sumAll(null)).isZero();
    }

    @Test
    void appendElement() {
        assertThat(sut.appendElement(new int[]{1, 2, 3}, 4))
                .isEqualTo(new int[]{1, 2, 3, 4});
    }

    @Test
    void missingNumber() {
        assertThat(sut.missingNumber(new int[]{10, 9, 12, 7, 5, 6, 8}, 5, 12))
                .isEqualTo(11);

        assertThrows(IllegalArgumentException.class, () -> sut.missingNumber(new int[]{}, 1, 10));
    }

    @Test
    void unionArrays() {
        assertThat(sut.unionArrays(new int[]{1, 2}, new int[]{1, 2}))
                .isEqualTo(new int[]{1, 2, 1, 2});
        assertThat(sut.unionArrays(new int[]{1, 2}, new int[]{}))
                .isEqualTo(new int[]{1, 2});
    }

    @Test
    void removeDuplicates() {
        assertThat(sut.removeDuplicates(new int[]{1, 2, 1, 3, 4, 3, 5}))
                .isEqualTo(new int[]{1, 2, 3, 4, 5});
        assertThat(sut.removeDuplicates(new int[]{1, 20, 1, 3, 4, 3, 5}))
                .isEqualTo(new int[]{1, 20, 3, 4, 5});

        assertThat(sut.removeDuplicates(new int[]{1, 20, 0, 3, 0, 3, 5}))
                .isEqualTo(new int[]{1, 20, 0, 3, 5});
        assertThat(sut.removeDuplicates(new int[]{1, Integer.MAX_VALUE, 0, 3, 0, 3, 5}))
                .isEqualTo(new int[]{1, Integer.MAX_VALUE, 0, 3, 5});
        assertThat(sut.removeDuplicates(new int[]{1, 20, 0, 3, 0, 3, Integer.MIN_VALUE}))
                .isEqualTo(new int[]{1, 20, 0, 3, Integer.MIN_VALUE});
    }

    @Test
    void searchArray() {
        assertThat(sut.searchArray(new int[]{1, 5, 2, 6, 9, 1}, 1))
                .isEqualTo(new int[]{0, 5});
        assertThat(sut.searchArray(new int[]{1, 5, 2, 6, 9, 1}, 1))
                .isEqualTo(new int[]{0, 5});
        assertThat(sut.searchArray(new int[]{1, 5, 2, 6, 9, 1}, 100))
                .isNull();
    }

    @Test
    void sortArray() {
        assertThat(sut.sortArray(new int[]{1, 5, 2, 6, 9, 1}, SortOrder.ASC))
                .isEqualTo(new int[]{1, 1, 2, 5, 6, 9});
        assertThat(sut.sortArray(new int[]{1, 5, 2, 6, 9, 1}, SortOrder.DESC))
                .isEqualTo(new int[]{9, 6, 5, 2, 1, 1});
    }

    @Test
    void sortedArrays() {
        assertThat(sut.sortedArrays(
                new int[]{1, 3, 6},
                new int[]{1, 2, 5, 7, 9}
        )).isEqualTo(new int[]{1, 1, 2, 3, 5, 6, 7, 9});
    }

    @Test
    void arrayToNumber() {
        assertThat(sut.arrayToNumber(new int[]{1, 12, 54}))
                .isEqualTo(18);
        assertThat(sut.arrayToNumber(new int[]{0, 12, 0}))
                .isEqualTo(8);
    }

    @Test
    void stringToArray() {
        assertThat(sut.stringToArray("123456"))
                .isEqualTo(new int[]{1, 2, 3, 4, 5, 6});
    }

    @Test
    void sumLargeNumbers() {
        assertThat(sut.sumLargeNumbers("123456789", "123456789"))
                .isEqualTo("246913578");
        assertThat(sut.sumLargeNumbers(
                "99999999999999999999999999999999999",
                "9999999999999999999999999"))
                .isEqualTo("100000000009999999999999999999999998");
    }

}