package com.shd.test.colcstreams;
import com.shd.colcstreams.intersecmatch.simple.SimpleMatch2Lists;
import com.shd.data.Student;

import java.util.List;
import java.util.function.BiPredicate;
public class TestSimpleMatch {
    public static void main(String[] args) {
        TestSimpleMatch testSimpleMatchi = new TestSimpleMatch() ;
        testSimpleMatchi.test();
    }
    public void test() {
        Student studentRef = new Student() ;
         final BiPredicate<Student, Student> studCompare = (elm1, elm2) -> {
        return ((elm1.getAge()==elm2.getAge()
        && elm1.getGradeLevel()== elm2.getGradeLevel()) ? Boolean.TRUE:Boolean.FALSE );
//             Passing the next BiPredicate will give runtime err for casting
//             final BiPredicate<String, String> studCompare = (elm1, elm2) -> {
//                 return true ;
        };
        SimpleMatch2Lists<Student> simpleMatch2ListsStudTest = new SimpleMatch2Lists<Student>() ;
        List<Student>  outLis = simpleMatch2ListsStudTest.matching2ListsFunction.matchLists(studentRef.makeList1(),studentRef.makeList2(),studCompare);
        System.out.println("Start TestSimpleMatch:");
        outLis.stream().forEach(System.out::println);
        System.out.println("End TestSimpleMatch:");
        }
    }

