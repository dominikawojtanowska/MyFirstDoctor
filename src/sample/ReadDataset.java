package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadDataset {
    File file;
    Scanner in;
    ArrayList<SymptomLeaf> leaves = new ArrayList<>();
    ArrayList<Diagnosis> diagnoses = new ArrayList<>();
    ArrayList<Referral> referrals = new ArrayList<>();
    
    ReadDataset(File data) throws FileNotFoundException {
        this.file = file;
        in = new Scanner(file);
        prepareData();
    }

    private void prepareData(){
        String line = in.nextLine();
        String[] names =  line.split(";");
        String[] symptomps = null;
        for (int i=0; i<names.length-1; i++){
            leaves.add(new SymptomLeaf(names[i],null, null));
        }
        while(in.hasNextLine()){
            line = in.nextLine();
            symptomps = line.split(";");
            for (int i=0; i<names.length-1; i++){
                SymptomNode node = new SymptomNode(symptomps[i]);
                leaves.get(i).addNode(node);
            }
            Referral referral = new Referral(symptomps[symptomps.length-1]);
            if(!referrals.contains(referral)) referrals.add(referral);
            else referrals.get(referrals.indexOf(referral)).counter++;
            diagnoses.add(new Diagnosis(symptomps));
        }
    }

    public void createTree(){
        //obliczamy I(P)
        double iP = 0 ;
        for(Referral referral : referrals){
            iP += ((double)referral.counter/diagnoses.size()) * Math.log((double)referral.counter/diagnoses.size());
        }

        //obliczmy przyrost informacji
        Double[] infGain = new Double[leaves.size()];
        for (int i = 0; i< infGain.length ; i++){
            Integer[][] wyn = new Integer[referrals.size()][leaves.get(i).getNodes().size()];
            Double [] gains = new Double[leaves.get(i).getNodes().size()];
            for(int j = 0; j<wyn.length ; j++){
                
            }

        }


    }

    private class Referral implements Comparable<Referral> {
        String name;
        int counter;
        Referral(String name){
            this.name = name;
            counter = 0;
        }

        @Override
        public int compareTo(Referral referral) {
            return 0;
        }

        public boolean equals(Object obj){
            return ((Referral)obj).name.equals(name);
        }
    }
}
