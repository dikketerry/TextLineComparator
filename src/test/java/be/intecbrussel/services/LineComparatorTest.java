package be.intecbrussel.services;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LineComparatorTest {
    String testString = "bob";
    List<String> testList = Arrays.asList("bb", "b", "bo", "b");
    LineComparator lc;

    @Test
    void runThroughFileAndCheckCombinationsEmptyList() {
        List<String> empty = Arrays.asList("");
        lc.runThroughListCheckCombinations(); // argh, not possible,
        // help-methods.. probably need to adapt whole structure :(
        // need to clarify.
        // also, how on earth to test file readers??

    }
}