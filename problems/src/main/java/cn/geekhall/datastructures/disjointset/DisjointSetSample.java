package cn.geekhall.datastructures.disjointset;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * DisjointSet.java
 *
 * @author yiny
 */
public class DisjointSetSample {
    public static class Node<T> {
        T value;
        public Node(T value) {
            this.value = value;
        }
    }

    public static class DisjointSet<T>{
        // T => 节点
        public HashMap<T, Node<T>> nodes;

        // parents节点映射表
        public HashMap<Node<T>, Node<T>> parents;

        // 头结点的size表
        public HashMap<Node<T>, Integer> sizeMap;

        public DisjointSet(List<T> values) {
            for (T value : values) {
                Node<T> node = new Node<>(value);
                nodes.put(value, node);
                parents.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        /**
         * 从当前节点cur开始向上查找其代表头结点。
         * （找帮主）
         * @param cur 当前节点
         * @return    帮主节点
         */
        public Node<T> findFather(Node<T> cur) {
            Stack<Node<T>> path = new Stack<>();
            while (cur != parents.get(cur)){
                path.push(cur);
                cur = parents.get(cur);
            }
            // 优化，将cur节点至头结点沿途的所有节点的parent都设置为找到的头结点。（扁平化）
            while(!path.isEmpty()) {
                parents.put(path.pop(), cur);
            }
            return cur;
        }

        /**
         * 查询两个元素a和b是否在同一个集合中
         * @param a 元素a
         * @param b 元素b
         * @return true：在同一个集合中，false：不在同一个集合中
         */
        public boolean isSameSet(T a, T b) {
            if (!nodes.containsKey(a) || !nodes.containsKey(b)) {
                return false;
            }
            return findFather(nodes.get(a)) == findFather(nodes.get(b));
        }

        /**
         * 把两个不相交的集合合并为一个集合。
         * @param a
         * @param b
         */
        public void union(T a, T b) {
            if (!nodes.containsKey(a) || !nodes.containsKey(b)) return;
            Node<T> ha = findFather(nodes.get(a));
            Node<T> hb = findFather(nodes.get(b));
            if (ha != hb) {
                int sizeA = sizeMap.get(ha);
                int sizeB = sizeMap.get(hb);
                if (sizeA >= sizeB) {
                    parents.put(hb, ha);
                    sizeMap.put(ha, sizeA + sizeB);
                    sizeMap.remove(hb);
                } else {
                    parents.put(ha, hb);
                    sizeMap.put(hb, sizeA + sizeB);
                    sizeMap.remove(ha);
                }
            }
        }
    }


}
