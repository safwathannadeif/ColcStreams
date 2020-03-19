package com.shd.colcstreams.intersecmatch.simple;
import java.util.List;
        import java.util.function.BiPredicate;
        import java.util.stream.Collectors;
public class SimpleMatch2Lists<XElm>  {
    // For Short list this simple match is Ok. For Long Lists with a million of records,
    // LongListsMatchingAndDistinct generic implemented in this package is the right one
    @FunctionalInterface
    public interface Matching2ListsFunction<XElm> {
        XElm matchLists(XElm a1, XElm a2, BiPredicate a3);
        //List<XElm> matchLists(List<XElm> a1, List<XElm> a2, BiPredicate a3);
    }
    //Matching2ListsFunction is a Generic Function for simple Matching
    //Function implementations for any Type/XElm is implemented here and var parameter instance passed as implemented function (BiPredicate)
    // for Example Student Type call this function with List1<Student> , List2<Student> ,  and BiPredicate instance function
    public Matching2ListsFunction<List<XElm>> matching2ListsFunction = (lis1, lis2, biPredicatei) ->
    {
        List<XElm>  xRet = lis1.stream().filter((elmOfLis1 -> (lis2.stream().anyMatch(elmOfLis2 -> biPredicatei.test(elmOfLis1, elmOfLis2))))).collect(Collectors.toList());
        return xRet ;
    } ;
}