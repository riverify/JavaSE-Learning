package com.river;

public class ArrayList  implements List {
    private transient Object[] elementData;
    private int size;

    public int size() {
        return size;
    }

    public Object get(int i) {
        return elementData[i];
    }

}
