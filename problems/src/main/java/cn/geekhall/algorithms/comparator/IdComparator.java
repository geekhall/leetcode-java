package cn.geekhall.algorithms.comparator;

import cn.geekhall.bean.Student;

/**
 * IdComparator.java
 * 比较器实际上就等同于C++中的重载比较运算符。
 *
 * @author yiny
 */
public class IdComparator {
    private Order order;
    public IdComparator(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    /**
     * 比较器
     *     规则：
     *     - 返回负数的时候第一个参数排在前面
     *     - 返回正数的时候第二个参数排在前面
     *
     * @param t1
     * @param t2
     * @return
     */
    public int compare(Student t1, Student t2) {
        int id1 = Integer.parseInt(t1.getId());
        int id2 = Integer.parseInt(t2.getId());
        if (order == Order.ASC) {
            return id1 - id2;
        } else {
            return id2 - id1;
        }
    }
}
