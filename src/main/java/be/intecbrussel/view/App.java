package be.intecbrussel.view;

import be.intecbrussel.services.LineComparator;
import be.intecbrussel.services.MyFileReader;

import java.io.*;
import java.util.List;

// TODO: automated testing implementation

// app that reads a txt file, takes a line element from it and checks if the
// line element corresponds to the combination of 2 other line elements in
// the file

public class App {

    public static void main(String[] args) {

        File file = new File("testfile.txt");
        MyFileReader fr = new MyFileReader();
        List<String> lineList = fr.convertFileToList(file);

        LineComparator lc = new LineComparator();
        lc.setFullList(lineList);
        lc.runThroughListCheckCombinations();
    }
}
