package interview.prep.algorithms;

import java.util.Arrays;

public class QuickUnion {
    private int[] ids;

    public QuickUnion(int n) {
        ids = new int[n];
        for (int i = 0; i < n; i++) {
            ids[i] = i;
        }
    }

    public boolean find(int p, int q) {
        return getRoot(p) == getRoot(q);
    }

    public void union(int p, int q) {
        ids[getRoot(p)] = getRoot(q);
    }

    private int getRoot(int n) {
        if (ids[n] == n) {
            return n;
        } else {
            return getRoot(ids[n]);
        }
// Implementation in the course
//        while (n != ids[n]){
//            n = ids[n];
//        }
//        return n;
    }

    @Override
    public String toString() {
        return "QuickUnion{" +
                "ids=" + Arrays.toString(ids) +
                '}';
    }

    public static void main(String[] args) {
        QuickUnion quickUnion = new QuickUnion(10);
        quickUnion.union(0, 5);
        quickUnion.union(5, 6);
        quickUnion.union(6, 1);
        quickUnion.union(1, 2);
        quickUnion.union(2, 7);
        quickUnion.union(8, 3);
        quickUnion.union(3, 4);
        quickUnion.union(4, 9);
        System.out.println(quickUnion);
        System.out.println(quickUnion.find(0, 7));
        System.out.println(quickUnion.find(8, 6));
    }

}
