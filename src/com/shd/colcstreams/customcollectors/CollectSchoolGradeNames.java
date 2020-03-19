package com.shd.colcstreams.customcollectors;
import com.shd.data.Student;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
/*
 * Interface Collector<T,A,R>
    Type Parameters:
        T - the type of input elements to the reduction operation == Student
        A - the mutable accumulation type of the reduction operation
        (often hidden as an implementation detail). HashMap<school,HashMap<grade,List<Stud>>
        R - the result type of the reduction operation HashMap<Student,HashMap<grade,lis<Stud>>>
*/
public class CollectSchoolGradeNames implements Collector<Student, Map<String, Map<String, List<Student>>>, Map<String, Map<String, List<Student>>>> {
    /*
     * Supplier<A> where A is the HashMap<str school, HashMap<gradelevel,<Student>>>	supplier()
     * Supplier<A> supplier();
     * A function that creates and returns a new mutable accumulation result type container.
     */
    @Override
    public Supplier<Map<String, Map<String, List<Student>>>> supplier() {
        return () -> {
            return new HashMap<String, Map<String, List<Student>>>();
        };
    }
    //
    /*
     * BiConsumer<A,T> 	accumulator()
     *	A function that folds a T value into a mutable result container <A>.
     *  where A is the HashMap<str school, HashMap<gradelevel,<Student>>>
     *  and T is the Student
     */
    @Override
    public BiConsumer<Map<String, Map<String, List<Student>>>, Student> accumulator() {
        return (mapSchool, stud) -> {
            Map<String, List<Student>> mapGradeAndStudist = mapSchool.get(stud.getSchoolName());
            System.out.println("mapGradeAndStudist  test =" + mapGradeAndStudist);
            if (mapGradeAndStudist == null) {
                mapGradeAndStudist = new HashMap<String, List<Student>>();
                mapSchool.put(stud.getSchoolName(), mapGradeAndStudist);
            }
            List<Student> lisOfStud = mapGradeAndStudist.get(stud.getGradeLevelStr());
            if (lisOfStud == null) {
                lisOfStud = new ArrayList();
                mapGradeAndStudist.put(stud.getGradeLevelStr(),lisOfStud);
            }
            lisOfStud.add(stud);
            System.out.println("lisOfStud.add =" + stud.toString());
        };
    }
//	@Override
    /*   combiner
     * How to merge different accumulator objects together. In Case Of Parallel streams
     * BinaryOperator<A> 	combiner() where A is the HashMap<scholl,HashMap<grad studentLis>>
     * A function that accepts two partial results and merges them.
     * here Accepts 2 As and return A as a BinaryOperator
     */
    @Override
    public BinaryOperator<Map<String, Map<String, List<Student>>>> combiner() {
        return (m1, m2) ->
        {
            m1.putAll(m2);
            return m1;
        };
    }
    /*
     * Function<A,R> 	finisher()
     *	Perform the final transformation from the intermediate accumulation type A/HashMap to the final result type R/HashMap.
     */
    @Override
    public Function<Map<String, Map<String, List<Student>>>, Map<String, Map<String, List<Student>>>> finisher() {
        return (mx) ->
        {
            return mx;
        };
    }
    //Optional Set Characteristics of from Enumerated CONCURRENT,UNORDERED, and IDENTITY_FINISH
    @Override
    public Set<Characteristics> characteristics() {
        // Special characteristics of this  Collector is empty.
        return Collections.emptySet();
    }
}