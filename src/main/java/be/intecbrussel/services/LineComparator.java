package be.intecbrussel.services;

import java.util.ArrayList;
import java.util.List;

public class LineComparator {
    // approach: select line, create new list without selected line, run
    // comparison selected line versus combinations of any 2 items in new list
    // performance: perform length check, only if length is same, create
    // combi string and check content of strings

    private List<String> fullList;
    private List<String> listToCompareTo;
    private String stringToCheck;
    private int lineNrStringToCheck;

    public void setFullList(List<String> list) {
        this.fullList = list;
    }

    public List<String> getFullList() {
        return fullList;
    }

    public List<String> getListToCompareTo() {
        return listToCompareTo;}

    public void setListToCompareTo(List<String> list, int index) {
        List<String> listToCompareTo = new ArrayList<>(list);
        listToCompareTo.remove(index);             //removes String @i (String
        // to check
        listToCompareTo.add(index, "");    // adds "" at i, moves all
        // elements right of it 1 place to the right - keeps original
        // length, important for printing the line nr later on
        this.listToCompareTo = listToCompareTo;
    }

    public String getStringToCheck() {
        return stringToCheck;
    }

    public void setStringToCheck(String stringToCheck) {
        this.stringToCheck = stringToCheck;
    }

    public int getLineNrStringToCheck() {
        return lineNrStringToCheck;
    }

    public void setLineNrStringToCheck(int lineNrStringToCheck) {
        this.lineNrStringToCheck = lineNrStringToCheck + 1;
    }

    public void runThroughListCheckCombinations() {
        for (int i = 0; i < fullList.size(); i++) {
            setStringToCheck(fullList.get(i));
            setLineNrStringToCheck(i);
            setListToCompareTo(fullList, i);
            comparison(stringToCheck, listToCompareTo);
        }
    }

    int comparison(String s, List<String> l) {
        int count = 0;
        for (int i = 0; i < l.size(); i++) {
            if (l.get(i).trim().length() == 0) continue;

            for (int j = 0; j < l.size(); j++) {
                // avoid picking the same element twice:
                if (j == i) continue;
                // skip lines with only spaces / no content:
                if (l.get(j).trim().length() == 0) continue;

                if (lengthOfStringsIsSame(l.get(i), l.get(j), s)) {
                    String c = l.get(i) + l.get(j);

                    if (c.equals(s)) {
                        count++;
                        System.out.println("for line " + lineNrStringToCheck + " '" + s + "' found combination on line " + (i + 1) + " '" + l.get(i) + "' + line " + (j + 1) + " '" + l.get(j) +"'");
                    }
                }
            }
        }
        return count;
    }

    boolean lengthOfStringsIsSame(String s1, String s2, String main) {
        return s1.length() + s2.length() == main.length();
    }
}
