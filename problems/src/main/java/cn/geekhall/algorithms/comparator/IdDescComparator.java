package cn.geekhall.algorithms.comparator;

import cn.geekhall.bean.Student;

import java.util.Comparator;

/**
 * IdDescComparator.java
 *
 * @author yiny
 */
public class IdDescComparator extends IdComparator implements Comparator<Student> {
    public IdDescComparator() {
        super(Order.DESC);
    }

    @Override
    public int compare(Student t1, Student t2) {
        return super.compare(t1, t2);
    }
}
