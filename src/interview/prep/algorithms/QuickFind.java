package interview.prep.algorithms;

import java.util.Arrays;

public class QuickFind {
    private int[] nodes;

    public QuickFind(int n) {
        nodes = new int[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = i;
        }
    }

    public boolean find(int node1, int node2) {
        return nodes[node1] == nodes[node2];
    }

    public void union(int node1, int node2) {
        final int initialConnection = nodes[node1];
        final int finalConnection = nodes[node2];
        if (initialConnection == finalConnection) {
            return;
        }
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] == initialConnection) {
                nodes[i] = finalConnection;
            }
        }
    }

    @Override
    public String toString() {
        return "QuickFind{" +
                "nodes=" + Arrays.toString(nodes) +
                '}';
    }

    public static void main(String[] args) {
        QuickFind quickFind = new QuickFind(10);
        quickFind.union(0, 5);
        quickFind.union(5, 6);
        quickFind.union(6, 1);
        quickFind.union(1, 2);
        quickFind.union(2, 7);
        quickFind.union(8, 3);
        quickFind.union(3, 4);
        quickFind.union(4, 9);
        System.out.println(quickFind);
        System.out.println(quickFind.find(0, 7));
        System.out.println(quickFind.find(8, 6));
    }
}