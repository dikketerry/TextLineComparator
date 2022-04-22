package be.intecbrussel.services;

import java.util.ArrayList;
import java.util.List;

public class LineComparator {
    String stringToCheck;
    List<String> fullList;
    List<String> listToCompareTo;

    // method A: take 1 line, compare it with combination of 2 elements in
    // new list where the new list is a copy of full list without the line
    // being checked

    public void setFullList(List<String> list) {
        this.fullList = list;
    }

    // private 'setter' for both line x and new list to compare line x with
    private void setLineAndListToPerformComparisonOn(List<String> fullList,
                                                     int index) {
        this.stringToCheck = fullList.get(index);
        listToCompareTo = new ArrayList<>(fullList);
        listToCompareTo.remove(index);
    }

    private void comparison(String s, List<String> l) {
        for (int i = 0; i < l.size() - 1; i++) {
            for (int j = i + 1; j < l.size(); j++) {
                String c = l.get(i) + l.get(j);
                if (c.equals(s)) {
                    System.out.println("for the line " + s + " a valid " +
                                               "combination has been found: " + l.get(i) + " and " + l.get(j));
                }
            }
        }
    }

    public void runThroughFileAndCheckCombinations() {
        for (int i = 0; i < fullList.size(); i++) {
            setLineAndListToPerformComparisonOn(fullList, i);
            comparison(stringToCheck, listToCompareTo);
        }
    }

    // method B (not used): take 2 lines, concatenate, compare lines in list -
    // currently incorrect, this method does not take lines listed
    // before the line elements taken for comparison
    public void compareElement(List<String> listToCheck) {

        for (int i = 0; i < listToCheck.size() - 1; i++) {
            String part1 = listToCheck.get(i);
            String part2 = listToCheck.get(i + 1);
            stringToCheck = part1 + part2;
            for (int j = i + 2; j < listToCheck.size() - 1; j++) {
                if (stringToCheck.equals(listToCheck.get(j))) {
                    System.out.println("combination of " + part1 + " and " + part2 + " is encountered at line " + j + " (" + listToCheck.get(j) + ").");
                } else { }

            }
        }
    }
}
