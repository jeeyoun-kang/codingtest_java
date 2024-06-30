package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class basic_pg {
    public static void main(String[] args) {
        ArrayList<Integer> w = new ArrayList<>();
        ArrayList<Integer> copy_w = new ArrayList<>(w);
        copy_w.addAll(w);

        List<String> list = new ArrayList<>();
        Collections.sort(list);
    }
}
