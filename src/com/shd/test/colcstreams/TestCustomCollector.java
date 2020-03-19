package com.shd.test.colcstreams;
import com.shd.colcstreams.customcollectors.CollectSchoolGradeNames;
import com.shd.data.Student;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class TestCustomCollector {
    public static void main(String... arg) {
        TestCustomCollector testcusCollect = new TestCustomCollector() ;
        testcusCollect.test();
    }
    /* generic Merge
        List<Integer> joinedList = joinLists(list1, list2, list3, list4);
        public static <T> List<T> joinLists(List<T>... lists) {
        return Arrays.stream(lists).flatMap(Collection::stream).collect(Collectors.toList());
        }
     */
    public void test() {
        Student studentRef = new Student() ;
        List<Student> lisOfAll = Stream.of(studentRef.makeList1(),studentRef.makeList2()).flatMap(Collection::stream).collect(Collectors.toList()) ;
        Map<String, Map<String, List<Student>>> collectedLis =
        lisOfAll.stream().collect(new CollectSchoolGradeNames());

        System.out.println("Start Custom Collect for School Grade Names: ") ;
        collectedLis.forEach((schol, mapgrdStud) -> {
            mapgrdStud.forEach((grade, studLis) -> {
                                System.out.println("School:" + schol+ "\tGrade:" + grade );
                                studLis.forEach(studElm -> System.out.println("\t"+studElm)) ;
                                System.out.println("-".repeat(90));
                            }
                    );
                }
        );
        System.out.println("End Custom Collect for School Grade Names ===========================================================================================");
    }
}
