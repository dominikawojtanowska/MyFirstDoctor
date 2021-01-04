package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadDataset {
    File file;
    Scanner in;
    ArrayList<SymptomLeaf> leaves = new ArrayList<>();
    
    ReadDataset(File data) throws FileNotFoundException {
        this.file = file;
        in = new Scanner(file);
        prepareData();
    }

    private void prepareData(){
        String line = in.nextLine();
        String[] names =  line.split(";");
        for (int i=0; i<names.length-1; i++){
            leaves.add(new SymptomLeaf(names[i],null, null));

        }
        while(in.hasNextLine()){
            line = in.nextLine();

        }

    }
}
