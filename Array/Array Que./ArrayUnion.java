package Array;

import java.util.*;

public class ArrayUnion {
    public static ArrayList<Integer> findUnion(int[] a, int[] b) {
        // By Using HashSet
        HashSet<Integer> st = new HashSet<>();

        for (int num : a)
            st.add(num);

        for (int num : b)
            st.add(num);

        ArrayList<Integer> res = new ArrayList<>(st);

        return res;
    }
}
