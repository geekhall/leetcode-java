package cn.geekhall.datastructures.trietree;

public class HashMapTrieTree {
    private HashMapNode root;
    public HashMapTrieTree(){
        root = new HashMapNode();
    }

    /**
     * 前缀树中插入字符串word
     * @param word
     */
    public void insert(String word) {
        if (word == null)
            return;
        char[] chars = word.toCharArray();
        HashMapNode node = root;
        node.pass++;
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            index = (int) chars[i];
            if (!node.nexts.containsKey(index)) {
                node.nexts.put(index, new HashMapNode());
            }
            node = node.nexts.get(index);
            node.pass++;
        }
        node.end++;
    }

    /**
     * 前缀树中查找字符串word出现的次数。
     * @param word
     * @return
     */
    public int search(String word) {
        if (word == null)
            return 0;
        char[] chars = word.toCharArray();
        HashMapNode node = root;
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            index = chars[i] - 'a';
            if (!node.nexts.containsKey(index)){
                return 0;
            }
            node = node.nexts.get(index);
        }
        return node.end;
    }

    /**
     * 前缀树中查找以pre开头的字符串出现的次数。
     * @param pre
     * @return
     */
    public int prefixNumber(String pre){
        if (pre == null)
            return 0;
        char[] chars = pre.toCharArray();
        HashMapNode node = root;
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            index = chars[i] - 'a';
            if (!node.nexts.containsKey(index)) {
                return 0;
            }
            node = node.nexts.get(index);
        }
        return node.pass;
    }


    /**
     * 前缀树中删除字符串word。
     * @param word
     */
    public void delete(String word) {
        if (search(word)!=0) {
            char[] chars = word.toCharArray();
            HashMapNode node = root;
            node.pass--;
            int index = 0;
            for(int i = 0; i < chars.length; i++) {
                index = (int) chars[i];
                if (--node.nexts.get(index).pass == 0) {
                    node.nexts.remove(index);
                    return;
                }
                node = node.nexts.get(index);
            }
            node.end--;
        }
    }



}
