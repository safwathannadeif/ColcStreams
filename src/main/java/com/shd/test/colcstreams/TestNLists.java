package com.shd.test.colcstreams;
import com.shd.colcstreams.intersecmatch.nlists.NListsMatching;
import com.shd.data.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;
public class TestNLists extends NListsMatching<Student> {
    public Function<Student, String> xElmMakeKeyFunci =  (std) -> {
        String retStr = UUID.nameUUIDFromBytes((std.getName() + std.getScore()).getBytes()).toString().replaceAll("-", "");
        return retStr ;
    };
    @Override
    public Function<Student, String> getxElmMakeKeyFunci() {
        return xElmMakeKeyFunci;
    }
    public static void main(String... str) {
        TestNLists nLists = new TestNLists() ;
        nLists.testNList();
    }
    public void testNList()
    {
        Student studentRef = new Student() ;
       // List<List<Student>>  lisOfLis = Arrays.asList(studentRef.makeList1(),studentRef.makeList2() );
        List<List<Student>> lisOfLis = new ArrayList<>() ;
        lisOfLis.add(studentRef.makeList1()) ;
        lisOfLis.add(studentRef.makeList2()) ;
        System.out.println("Size of lisoflis =" +lisOfLis.size() ) ;
        TestNLists  nlistTesti = new TestNLists() ;
        nlistTesti.setxElmMakeKeyFunci(xElmMakeKeyFunci);
       // List<Student> outLis =nlistTesti.matchNLsits(lisOfLis) ;
        List<Student> outLis =nlistTesti.distinctNLsits(lisOfLis) ;
        outLis.stream().forEach(System.out::println);
        System.out.println("End NList .................");
    }
}