package cn.geekhall.datastructures.trietree;

import java.util.HashMap;

/**
 * 不使用前缀树的暴力方法，效率较差。
 */
public class Force {
    private HashMap<String, Integer> box;
    public Force(){
        box = new HashMap<>();
    }

    public void insert(String word) {
        if (!box.containsKey(word)) {
            box.put(word, 1);
        } else {
            box.put(word, box.get(word) + 1);
        }
    }

    public void delete(String word) {
        if (box.containsKey(word)) {
            if (box.get(word) == 1) {
                box.remove(word);
            } else {
                box.put(word, box.get(word) - 1);
            }
        }
    }

    public int search(String word) {
        if (!box.containsKey(word)) {
            return 0;
        } else {
            return box.get(word);
        }
    }

    public int prefixNumber(String pre) {
        int count = 0;
        for (String cur : box.keySet()) {
            if (cur.startsWith(pre)) {
                count += box.get(cur);
            }
        }
        return count;
    }
}
