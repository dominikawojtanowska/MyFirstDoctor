package sample;

import java.util.ArrayList;

public class SymptomLeaf {
    private String name;
    private SymptomNode parent;
    private ArrayList<SymptomNode> nodes;
    private String question;
    static SymptomLeaf firstLeaf;

    SymptomLeaf(String name, SymptomNode parent, ArrayList<SymptomNode> nodes){
        this.name = name;
        this.parent = parent;
        this.nodes = nodes;
        question = "Is this symptom present: " + name + "?";
    }

    public String getName(){
        return name;
    }
    public SymptomNode getParent() {
        return parent;
    }
    public ArrayList<SymptomNode> getNodes() {
        return nodes;
    }
    public String getQuestion() {
        return question;
    }
    public void addNodes(ArrayList<SymptomNode> nodes){
        this.nodes = nodes;
    }

    public void addNode(SymptomNode node){
        if(!nodes.contains(node)){
            nodes.add(node);
            node.setParent(this);
        }
        else {
            nodes.get(nodes.indexOf(node)).density++;
        }
    }

}
