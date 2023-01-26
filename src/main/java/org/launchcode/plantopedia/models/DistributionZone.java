package org.launchcode.plantopedia.models;

import java.util.ArrayList;

public class DistributionZone extends TdwgUnit {
    private TdwgUnit parent;
    private ArrayList<TdwgUnit> children;

    public TdwgUnit getParent() {
        return parent;
    }

    public void setParent(TdwgUnit parent) {
        this.parent = parent;
    }

    public ArrayList<TdwgUnit> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<TdwgUnit> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "DistributionZone{" +
                "parent=" + parent +
                ", children=" + children +
                '}';
    }
}
