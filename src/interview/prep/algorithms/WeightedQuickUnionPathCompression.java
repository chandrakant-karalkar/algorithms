package interview.prep.algorithms;

import java.util.Arrays;

public class WeightedQuickUnionPathCompression {

    private int[] ids;
    private int[] treeSize;

    private WeightedQuickUnionPathCompression(int numberOfItems) {
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
            ids[n] = ids[ids[n]];  // Making current root point to parent root.
            return getRoot(ids[n]);
        }
    }

    @Override
    public String toString() {
        return "WeightedQuickUnionPathCompression{" +
                "ids=" + Arrays.toString(ids) +
                ", treeSize=" + Arrays.toString(treeSize) +
                '}';
    }

    public static void main(String[] args) {
        WeightedQuickUnionPathCompression weightedQuickUnionPathCompression = new WeightedQuickUnionPathCompression(10);
        weightedQuickUnionPathCompression.union(0, 5);
        weightedQuickUnionPathCompression.union(5, 6);
        weightedQuickUnionPathCompression.union(6, 1);
        weightedQuickUnionPathCompression.union(1, 2);
        weightedQuickUnionPathCompression.union(2, 7);
        weightedQuickUnionPathCompression.union(8, 3);
        weightedQuickUnionPathCompression.union(3, 4);
        weightedQuickUnionPathCompression.union(4, 9);
        System.out.println(weightedQuickUnionPathCompression);
        System.out.println(weightedQuickUnionPathCompression.find(0, 7));
        System.out.println(weightedQuickUnionPathCompression.find(8, 6));
    }

}
