package be.intecbrussel.services;

import java.util.ArrayList;
import java.util.List;

public class LineComparator {
    // approach: select line, create new list without selected line, run
    // comparison selected line versus combinations of any 2 items in new list
    // performance: perform length check, only if length is same, create
    // combi string and check content of strings

    List<String> fullList;
    List<String> listToCompareTo;

    String stringToCheck;

    int lineNrStringToCheck;

    public void setFullList(List<String> list) {
        this.fullList = list;
    }

    public void runThroughFileAndCheckCombinations() {
        for (int i = 0; i < fullList.size(); i++) {
            setLineAndListToPerformComparisonOn(fullList, i);
            comparison(stringToCheck, listToCompareTo);
        }
    }

    // private 'setter' for both line x and new list to compare line x with
    private void setLineAndListToPerformComparisonOn(List<String> fullList,
                                                     int index) {
        this.stringToCheck = fullList.get(index);
        this.lineNrStringToCheck = index + 1;
        listToCompareTo = new ArrayList<>(fullList);
        listToCompareTo.remove(index);
    }

    private void comparison(String s, List<String> l) {
        for (int i = 0; i < l.size() - 1; i++) {

            for (int j = i + 1; j < l.size(); j++) {

                if (lengthOfStringsIsSame(l.get(i), l.get(j), s)) {
                    String c = l.get(i) + l.get(j);

                    if (c.equals(s)) {
                        System.out.println("for line " + lineNrStringToCheck + " " + s + " found combination " + l.get(i) + " + " + l.get(j));
                    }
                }
            }
        }
    }

    private boolean lengthOfStringsIsSame(String s1, String s2, String main) {
        return s1.length() + s2.length() == main.length();
    }
}
