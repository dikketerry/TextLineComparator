package be.intecbrussel.services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.jupiter.api.Assertions.*;

// tests TODO:
// no list or an empty list?
// array out of bounds?
// using MethodSource, but for what, a List with Lists of Strings maybe?
// look into stream?
// other?


class LineComparatorTest {
    final String S1 = "bob";
    final List<String> FULLLIST = Arrays.asList("bb", "b", "bo", "b");
    final List<String> EMPTY = Arrays.asList();
    final LineComparator LC = new LineComparator();

    @BeforeEach
    void init() {
        System.out.println("init...");
        // but how to really init?
    }

    @AfterEach
    void exit() {
        System.out.println("after test...");
    }

    @Test
    void testFullListSetGet() {
        // when
        LC.setFullList(FULLLIST);
        // then
        assertThat(FULLLIST, is(LC.getFullList()));
    }

    @Test
    void testListToCompareToSetGet() {
        final List<String> COMPARELIST = Arrays.asList("bb", "", "bo", "b");
        final int INDEX = 1;

        // when
        LC.setListToCompareTo(FULLLIST, INDEX);
        // then
        assertThat(COMPARELIST, is(LC.getListToCompareTo()));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void paramTestStringSetGet(int index) {
        // when
        LC.setStringToCheck(FULLLIST.get(index));
        // and
        final String OUTPUT = LC.getStringToCheck();
        // then
        assertEquals(FULLLIST.get(index), OUTPUT);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void paramTestLineNr(int index) {
        // when
        LC.setLineNrStringToCheck(index);
        // and
        int lineNr = index + 1;
        // then
        assertEquals(lineNr, LC.getLineNrStringToCheck());
    }

    @Test
    void testComparison() {
        final List<String> LIST = Arrays.asList("bob", "b", "oo", "dodo", "b");
        final String WORD = "boo";
        final int COUNT = 2;
        // when
        int comparisonCount = LC.comparison(WORD, LIST);
        assertEquals(COUNT, comparisonCount);
    }

}