package com.river;

import java.util.ArrayList;
import java.util.List;

public class SuperClass {
    protected List<Integer> func() throws Throwable {
        return new ArrayList<>();
    }
}

class SubClass extends SuperClass {
    @Override
    protected List<Integer> func() throws Exception {
        return new ArrayList<>();
    }
}
