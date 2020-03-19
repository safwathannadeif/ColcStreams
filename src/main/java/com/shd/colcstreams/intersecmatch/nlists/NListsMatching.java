package com.shd.colcstreams.intersecmatch.nlists;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
public class NListsMatching<NXElm> {
    int sizeToComapre =  -1 ;
    public Function<NXElm, String> xElmMakeKeyFunci = (xElm) -> xElm.toString();
    protected Function<NXElm, String> getxElmMakeKeyFunci() {
        return xElmMakeKeyFunci;
    }
    protected void setxElmMakeKeyFunci(Function<NXElm, String> xElmMakeKeyFuncii) {
        xElmMakeKeyFunci = xElmMakeKeyFuncii ;
    }
    private final BiConsumer<NXElm, Map<String, List<NXElm>>>  accumMatchi = (nxelm, mapLis) -> {
            String keyStr = getxElmMakeKeyFunci().apply(nxelm);
            List<NXElm> lisOFXelm = mapLis.get(keyStr);
            if (lisOFXelm == null) {
                lisOFXelm = new ArrayList<NXElm>();
                mapLis.put(keyStr, lisOFXelm);
            }
            lisOFXelm.add(nxelm);
        } ;
    public List<NXElm> matchNLsits(List<List<NXElm>> listOfLists) {
        sizeToComapre = listOfLists.size();
        slectedFiteri=matchFilteri ;
        return (matchOrDistinctNListsFunic2.matchNLsits(listOfLists));
    }
    public List<NXElm> distinctNLsits(List<List<NXElm>> listOfLists) {
        sizeToComapre = 1 ;
        slectedFiteri=distinctFilteri ;
        return (matchOrDistinctNListsFunic2.matchNLsits(listOfLists));
    }
    // For Short list this simple match is Ok. For Long Lists with a million of records,
    // LongListsMatchingAndDistinct generic implemented in this package is the right one
    @FunctionalInterface
    public interface MatchingNListsFunction<NXElm> {
        List<NXElm> matchNLsits(List<List<NXElm>> lisOfLis);
    }
    private final Predicate<Integer>  matchFilteri =iSize -> {
        return ((iSize >= sizeToComapre) ? true : false);
    };
    private final Predicate<Integer>  distinctFilteri =iSize -> {
        return ((iSize == sizeToComapre) ? true : false);
    };
    private  Predicate<Integer>  slectedFiteri ;
    //Matching2ListsFunction is a Generic Function for simple Matching
    //Function implementations for any Type/XElm is implemented here and var parameter instance passed as implemented function (BiPredicate)
    // for Example Student Type call this function with List1<Student> , List2<Student> ,  and BiPredicate instance function
    //public MatchingNListsFunction <NXElm>  matchingNListsFunction  = this::matchNLsits;
    private  MatchingNListsFunction <NXElm> matchOrDistinctNListsFunic2 = (listOfLists) ->
    {
        Map<String, List<NXElm>> map4StudLis = new HashMap();
        listOfLists.stream().flatMap(xxx -> xxx.stream()).forEach(nxelm-> accumMatchi.accept(nxelm,map4StudLis));

        return (map4StudLis.entrySet().stream().map(inp -> inp.getValue())
               //  .peek(ll-> System.out.println(ll.size()))
                //.filter( (lis->(lis.size()) >= sizeToComapre ))
                .filter( (lis->(slectedFiteri.test(lis.size())) ))
                .flatMap(x -> x.stream()).collect(Collectors.toList())) ;
    };
}

















