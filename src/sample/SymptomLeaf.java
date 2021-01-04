package sample;

import java.util.ArrayList;

public class SymptomLeaf {
    private String name;
    private SymptomNode parent;
    private SymptomNode[] nodes;
    private String question;
    static SymptomLeaf firstLeaf;

    SymptomLeaf(String name, SymptomNode parent, SymptomNode[] nodes){
        this.name = name;
        this.parent = parent;
        this.nodes = nodes;
        question = "Is this symptom present: " + name + "?";
        if(parent == null){
            firstLeaf = this;
        }
    }

    public String getName(){
        return name;
    }
    public SymptomNode getParent() {
        return parent;
    }
    public SymptomNode[] getNodes() {
        return nodes;
    }
    public String getQuestion() {
        return question;
    }
    public void addNodes(SymptomNode[] nodes){
        this.nodes = nodes;
    }

}
