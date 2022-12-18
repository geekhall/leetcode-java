package cn.geekhall.datastructures.trietree;

/**
 * 前缀树
 * 单个字符串中，字符从前到后加到一棵多叉树上；
 * 字符放在路上，节点上有专属的数据项（常见的是pass和end值）；
 * 所有样本都这样添加的，如果没有路就新建，如果有路就复用；
 * 沿途节点的pass值增加1，每个字符串结束时来到的节点end值增加1。
 */
public class TrieTree {
    private Node root;

    public TrieTree(){
        root = new Node();
    }

    /**
     * 将字符串word插入到前缀树中。
     *
     * @param word
     */
    public void insert(String word) {
        if (word == null) {
            return;
        }

        char[] chars = word.toCharArray();
        Node node = root;
        node.pass++;
        int index = 0;
        for (int i = 0; i < chars.length; i++) { // 从左往右遍历字符
            index = chars[i] - 'a';
            if (node.nexts[index] == null) {
                node.nexts[index] = new Node();
            }
            node = node.nexts[index];
            node.pass++;
        }
        node.end++;
    }

    public int search(String word) {
        if (word == null)
            return 0;
        char[] chars = word.toCharArray();
        Node node = root;
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            index = chars[i] - 'a';
            if (node.nexts[index] == null) {
                return 0;
            }
        }
        return node.end;
    }
    /**
     * 从前缀树中删除word。
     * @param word
     */
    public void delete(String word) {
        if (search(word) != 0) {
            char[] chars = word.toCharArray();
            Node node = root;
            int index = 0;
            for (int i = 0; i < chars.length; i++) {
                index = chars[i] - 'a';
                if (--node.nexts[index].pass == 0) { // 若节点pass值--后已经为零，则置空该节点及以下的节点
                    node.nexts[index] = null;
                    return;
                }
                node = node.nexts[index];
            }
            node.end--;
        }
    }

    /**
     * 所有加入的字符串中，有几个是以pre这个字符串作为前缀的。
     * @param pre
     * @return
     */
    public int prefixNumber(String pre) {
        if (pre == null)
            return 0;
        char[] chars = pre.toCharArray();
        Node node = root;
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            index = chars[i] - 'a';
            if (node.nexts[index] == null) {
                return 0;
            }
            node = node.nexts[index];
        }
        return node.pass;
    }




}
