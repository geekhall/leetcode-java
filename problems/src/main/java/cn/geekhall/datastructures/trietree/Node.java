package cn.geekhall.datastructures.trietree;

public class Node {
    public int pass;
    public int end;
    public Node[] nexts;

    public Node() {
        pass = 0;
        end = 0;
        nexts = new Node[26];
    }
}
