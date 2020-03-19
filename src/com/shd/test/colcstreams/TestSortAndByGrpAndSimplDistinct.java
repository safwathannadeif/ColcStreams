package com.shd.test.colcstreams;
import com.shd.colcstreams.sortandgroup.SortAndByGrpAndSimplDistinct;
import com.shd.data.Student;

import java.util.ArrayList;
import java.util.List;
public class TestSortAndByGrpAndSimplDistinct {
    public static void main(String... arg) {
        TestSortAndByGrpAndSimplDistinct simpleTest = new TestSortAndByGrpAndSimplDistinct() ;
        simpleTest.testNoStream();
    }
    public void testManyWithstream() {
        Student studentRef = new Student() ;
        SortAndByGrpAndSimplDistinct sortAndByGrpAndSimplDistinct = new SortAndByGrpAndSimplDistinct() ;
        List<Student> lisOfallLis = new ArrayList() ;
        lisOfallLis.addAll(studentRef.makeList1()) ;
        lisOfallLis.addAll(studentRef.makeList2()) ;
        sortAndByGrpAndSimplDistinct.sortAndDistinctAndGrpBy(lisOfallLis);
        System.out.println();
    }
    public void testNoStream() {
        Student studentRef = new Student() ;
        SortAndByGrpAndSimplDistinct sortAndByGrpAndSimplDistinct = new SortAndByGrpAndSimplDistinct() ;
        List<Student> lisOfallLis = new ArrayList() ;
        lisOfallLis.addAll(studentRef.makeList1()) ;
        lisOfallLis.addAll(studentRef.makeList2()) ;
        sortAndByGrpAndSimplDistinct.sortAndDistinctAndGrpBy(lisOfallLis);
        System.out.println();
    }
}
