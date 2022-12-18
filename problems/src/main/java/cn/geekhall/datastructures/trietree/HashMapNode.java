package cn.geekhall.datastructures.trietree;

import java.util.HashMap;

public class HashMapNode {
    public int pass;
    public int end;
    public HashMap<Integer, HashMapNode> nexts;

    public HashMapNode() {
        pass = 0;
        end = 0;
        nexts = new HashMap<>();
    }


}
