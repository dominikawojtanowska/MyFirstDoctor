package sample;

public class SymptomNode {
    String name;
    SymptomLeaf parent;
    SymptomLeaf child;
    double density;

    SymptomNode(String name, SymptomLeaf parent, SymptomLeaf child){
        this.name = name;
        this.parent = parent;
        this.child = child;
    }

    public void setChild(SymptomLeaf child) {
        this.child = child;
    }

    public void setParent(SymptomLeaf parent) {
        this.parent = parent;
    }

}
