package be.intecbrussel.services;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MyFileReader {

    List<String> textLineList = new ArrayList<>();
    int lines = 0;

    public List<String> convertFileToList(File file) {

        try {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    textLineList.add(line);
                    lines++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return textLineList;
    }
}
