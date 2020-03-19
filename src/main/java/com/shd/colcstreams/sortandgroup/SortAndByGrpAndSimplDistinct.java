package com.shd.colcstreams.sortandgroup;
import com.shd.data.Student;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;
public class SortAndByGrpAndSimplDistinct {
    private static ConcurrentHashMap.KeySetView<String, Boolean> onlyOneKeyAllowedView = ConcurrentHashMap.newKeySet();
    public static Predicate<String> distinctStudentByName = s -> {
        Boolean retb = onlyOneKeyAllowedView.add(s);
        return retb;
    };
    public static Predicate<Optional<String>> studFilter = s -> {
        Boolean retb = s.isEmpty() || onlyOneKeyAllowedView.add(s.get());
        return retb;
    };
    private Comparator<Student> compareForSort = Comparator.comparing(Student::getGradeLevel)
            .thenComparing(Student::getName, Comparator.nullsFirst(String::compareTo))
            .thenComparing(Student::getAge);
    public Optional<String> getUniqueIdForDistinctElm(Student std) {
        Optional<String> rest = Optional.of(std.getLisId()).isPresent() ? Optional.of(std.getLisId() + std.getIdnStr()) : null;
        return rest;
    }
    public void sortAndDistinctAndGrpBy(List<Student> lisOfallLisInp) {
        List<Student> sordtedList =
                lisOfallLisInp.stream().sorted(compareForSort).collect(Collectors.toList());
        System.out.println("Start Sorted List");
        sordtedList.stream().forEach(System.out::println);
        System.out.println("End Sorted List=================================================================================================");
        List<Student> sordtedAndDistinctList =
                lisOfallLisInp.stream().sorted(compareForSort).filter(s -> distinctStudentByName.test(s.getName())).collect(Collectors.toList());
        System.out.println("Start Sordted And Distinct List");
        sordtedAndDistinctList.stream().forEach(System.out::println);
        System.out.println("End Sordted And Distinct List=====================================================================================");
        //// Needed >>>> Dual groupBy****
        Map<String, Map<String, List<Student>>> mapByGroupNameAndAge = lisOfallLisInp.stream().filter(Objects::nonNull)
                .collect(Collectors.groupingBy(Student::getGradeLevelStr, Collectors.groupingBy(Student::getName)));
        /* See the JDK Code for  cascading two groups collect :Here is the generic from the JDK code
         *  <R, A> R collect(Collector<? super T, A, R> collector);
         *  The ? super T
         */
        /* -------------------------------------------------------------------------------------------
         * cascading two groups Collections.sort(lisOfallLis, Comparator.comparing(StudentIdnt::getGrade)
         * .thenComparing(StudentIdnt::getName) .thenComparing(StudentIdnt::getAge))
         */
        System.out.println("Start Group by Grade and name") ;
        mapByGroupNameAndAge.forEach((grdLvl, map2) -> {
            map2.forEach((name, studLis) -> {
                        System.out.println("Grade:" + grdLvl+ "\tName:" + name );
                studLis.forEach(studElm -> System.out.println("\t"+studElm)) ;
                System.out.println("-".repeat(90));
                    }
            );
                }
        );
        System.out.println("End Group by Grade and name===========================================================================================");
//
//        mapByGroupNameAndAge.entrySet().stream().forEach(ent -> {
//                    ent.getValue().entrySet().stream().forEach(ent2 -> {
//                    System.out.println("Grade:" + ent.getKey() + "\ntName:" + ent2.getKey().toString() + "\nt" + ent2.getValue().toString());
//                    }
//                    );
//        });
//
//        for (String key : mapByGroupNameAndAge.keySet()) {
//            System.out.println(key + " - " + mapByGroupNameAndAge.get(key));
//            Map<String, List<Student>> map2 = mapByGroupNameAndAge.get(key);
//            for (String key2 : map2.keySet()) {
//                System.out.println(key2 + " - " + map2.get(key2).toString());
//            }
//            System.out.println();
//        }
    }
    public void simpleSortAndDistinct(List<Student> lisOfallLisInp) {
        List<Student> sordtedList =
                lisOfallLisInp.stream().sorted(Comparator.comparing(Student::getGradeLevelStr)
                        .thenComparing(Student::getName)
                        .thenComparing(Student::getAge)).filter(s -> distinctStudentByName.test(s.getName())).collect(Collectors.toList());
        sordtedList.stream().forEach(System.out::println);
        /*
         * Collections.sort(lisOfallLis, Comparator.comparing(StudentIdnt::getGrade)
         * .thenComparing(StudentIdnt::getName) .thenComparing(StudentIdnt::getAge))
         */
        System.out.println("sordtedList " + sordtedList.toString());
    }
}
