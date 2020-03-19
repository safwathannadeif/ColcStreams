package com.shd.test.colcstreams;
import com.shd.colcstreams.intersecmatch.longlists.LongListsMatchingAndDistinct;
import com.shd.data.Student;
import com.shd.data.StudentOverideMatcingKey;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class TestLongListsMatchAndDistinct {
    public static void main(String... str) {
       TestLongListsMatchAndDistinct testLongLongListsMatchingi = new TestLongListsMatchAndDistinct() ;
      //    testLongLongListsMatchingi.testMatcingLongLists() ;
     testLongLongListsMatchingi.testMatcingAndDistinctLongListsOverRide() ;
    }
//Overide MatcingKey for Student testing
    public void testMatcingAndDistinctLongListsOverRide() {
        StudentOverideMatcingKey longMatcingOverRideKeyTesti = new StudentOverideMatcingKey() ;
       Student studentRef = new Student() ;
       System.out.println("Start Match longMatcingOverRideKeyTest:");
        List<Student>  mathOutLis = longMatcingOverRideKeyTesti.matchTwoLists.apply(studentRef.makeList1(),studentRef.makeList2());
        mathOutLis.stream().forEach(System.out::println);
        System.out.println("End Match longMatcingOverRideKeyTest:");

        System.out.println("Start Distinct longMatcingOverRideKeyTest:");
        List<Student> lisOfAll = Stream.of(studentRef.makeList1(),studentRef.makeList2()).flatMap(Collection::stream).collect(Collectors.toList()) ;
        List<Student>  distinctLs= longMatcingOverRideKeyTesti.distinctList.apply(lisOfAll) ;

       // Stream.of(studentRef.makeList1(),studentRef.makeList2()).flatMap(Collection::stream)
       distinctLs.stream().forEach(System.out::println);
        System.out.println("End Distinct longMatcingOverRideKeyTest:");
    }

//Default LongListsMatchingAndDistinct for Student
    public void testMatcingLongLists() {
        LongListsMatchingAndDistinct<Student> longMatcingTesti = new LongListsMatchingAndDistinct<Student>() ;
        Student studentRef = new Student() ;
       // List<Student> lisOfAll = Stream.of(studentRef.makeList1(),studentRef.makeList2()).flatMap(Collection::stream).collect(Collectors.toList()) ;
        List<Student>  mathOutLis = longMatcingTesti.matchTwoLists.apply(studentRef.makeList1(),studentRef.makeList2());
        System.out.println("Start Default longMatcingTesti:"); // No over Ride for Key(s)
        mathOutLis.stream().forEach(System.out::println);
        System.out.println("End Default longMatcingTesti:");

        System.out.println("Start Default Distinct longMatcingOverRideKeyTest:");
        List<Student> lisOfAll = Stream.of(studentRef.makeList1(),studentRef.makeList2()).flatMap(Collection::stream).collect(Collectors.toList()) ;
        List<Student>   distinctLs= longMatcingTesti.distinctList.apply(lisOfAll) ;
        distinctLs.stream().forEach(System.out::println);
        System.out.println("End Default Distinct longMatcingOverRideKeyTest:");
    }
}
