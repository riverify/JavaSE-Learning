package com.river;


import java.util.HashSet;

public class EqualExample {

    private int x;
    private int y;
    private int z;

    public EqualExample(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EqualExample that = (EqualExample) o; // 对 Object o 进行转型

        if (x != that.x) return false;
        if (y != that.y) return false;
        return z == that.z;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        result = 31 * result + z;
        return result;
    }

    public static void main(String[] args) {
        EqualExample e1 = new EqualExample(1, 1 ,1);
        EqualExample e2 = new EqualExample(1, 1 ,1);
        System.out.println(e1.equals(e2)); // true ---- Because we have overridden the method of 'equals()', the result is true.
        HashSet<EqualExample> set = new HashSet<>();
        set.add(e1);
        set.add(e2);
        System.out.println(set.size());    // 2 ---- Since we did not override the hashCode() method, e1 & e2 are detected as two different objects.
    }
}
