package interview.prep.algorithms;

import java.util.Arrays;

public class WeightedQuickUnion {

    private int[] ids;
    private int[] treeSize;

    private WeightedQuickUnion(int numberOfItems) {
        ids = new int[numberOfItems];
        treeSize = new int[numberOfItems];
        for (int i = 0; i < numberOfItems; i++) {
            ids[i] = i;
            treeSize[i] = 1;
        }
    }

    public boolean find(int p, int q) {
        return getRoot(p) == getRoot(q);
    }

    public void union(int p, int q) {
        final int pRoot = getRoot(p);
        final int qRoot = getRoot(q);
        if (pRoot == qRoot) {
            return;
        }
        if (treeSize[p] < treeSize[q]) {
            ids[p] = q;
            treeSize[q] = treeSize[q] + treeSize[p];
        } else {
            ids[q] = p;
            treeSize[p] = treeSize[p] + treeSize[q];
        }
    }

    private int getRoot(int n) {
        if (ids[n] == n) {
            return n;
        } else {
            return getRoot(ids[n]);
        }
    }

    @Override
    public String toString() {
        return "WeightedQuickUnion{" +
                "ids=" + Arrays.toString(ids) +
                ", treeSize=" + Arrays.toString(treeSize) +
                '}';
    }

    public static void main(String[] args) {
        WeightedQuickUnion weightedQuickUnion = new WeightedQuickUnion(10);
        weightedQuickUnion.union(0, 5);
        weightedQuickUnion.union(5, 6);
        weightedQuickUnion.union(6, 1);
        weightedQuickUnion.union(1, 2);
        weightedQuickUnion.union(2, 7);
        weightedQuickUnion.union(8, 3);
        weightedQuickUnion.union(3, 4);
        weightedQuickUnion.union(4, 9);
        System.out.println(weightedQuickUnion);
        System.out.println(weightedQuickUnion.find(0, 7));
        System.out.println(weightedQuickUnion.find(8, 6));
    }
}
