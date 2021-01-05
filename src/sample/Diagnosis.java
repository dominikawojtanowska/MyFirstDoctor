package sample;

final class Diagnosis {
    String[] symptoms;   //Lista odpowiedzi na symptomy
    String referral;

    public Diagnosis(String[] symptoms) {
        this.symptoms = new String[symptoms.length-1];
        for(int i=0; i<this.symptoms.length; i++){
            this.symptoms[i] = symptoms[i];
        }
        referral = symptoms[symptoms.length-1];
    }
}
