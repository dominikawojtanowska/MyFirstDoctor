package sample;

public class SymptomNode implements Comparable<SymptomNode> {
    String name;
    SymptomLeaf parent;
    SymptomLeaf child;
    double density;

    SymptomNode(String name, SymptomLeaf parent, SymptomLeaf child){
        this.name = name;
        this.parent = parent;
        this.child = child;
        this.density = 0;
    }

    SymptomNode(String name){
        this(name, null, null);
    }

    public void setChild(SymptomLeaf child) {
        this.child = child;
    }

    public void setParent(SymptomLeaf parent) {
        this.parent = parent;
    }

    public boolean equals(Object obj) {
        return ((SymptomNode)obj).name.equals(name);
    }

    @Override
    public int compareTo(SymptomNode symptomNode) {
        return 0;
    }
}
