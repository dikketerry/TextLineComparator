package be.intecbrussel;

import be.intecbrussel.services.LineComparator;
import be.intecbrussel.services.MyFileReader;

import java.io.*;
import java.util.List;

// TODO: Dependency injection
// TODO: interface approach
// TODO: automated testing implementation

public class App {
    // read file
    // convert to list
    // select line from list
    // pick (sensible?) duo combinations (concatenations) of other lines
    // compare combis with selected line, return result

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("testfile.txt");
        MyFileReader fr = new MyFileReader();

        List<String> lineList = fr.convertFileToList(file);
        for (String s : lineList) {
            System.out.println(s);
        }

        LineComparator lc = new LineComparator();
//        lc.compareElement(lineList);
        lc.setFullList(lineList);
        lc.runThroughFileAndCheckCombinations();
    }
}
