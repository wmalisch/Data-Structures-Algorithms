package Structures;

import java.util.Map;

abstract class AbstractGraphNode {
    String name;
    int val;
    boolean visited;

    abstract int getVal();

    abstract String getName();

    abstract void setVal(int v);

    abstract void setName(String name);

    abstract boolean wasVisited();

    abstract void setVisited(boolean visit);

}
