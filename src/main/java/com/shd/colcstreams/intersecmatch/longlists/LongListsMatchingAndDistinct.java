package com.shd.colcstreams.intersecmatch.longlists;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.stream.Collectors;
public class LongListsMatchingAndDistinct<XElm> {
    protected   Function<XElm, String> xElmMakeKeyFunci =  (xElm) -> xElm.toString() ;
    protected Function<XElm, String> getxElmMakeKeyFunci() {
        return xElmMakeKeyFunci;
    }
    private final BiPredicate<XElm , Set<String>> uniqueXElmi = (elm, setkey) ->  {
        String keyStr = getxElmMakeKeyFunci().apply(elm) ;
        Boolean bRetUnique =  (setkey.contains(keyStr)) ? Boolean.FALSE:Boolean.TRUE ;
        System.out.println(bRetUnique+" XXXXXXXXXXX.................") ;
        if (bRetUnique) {
            setkey.add(keyStr);
            System.out.println(bRetUnique +" YYYYYYYYYYYYYYYYYYYY setkey.add(keyStr) Done.................") ;
        }
        return bRetUnique ;
    };
    protected void setxElmMakeKeyFunci(Function<XElm, String> xElmMakeKeyFunci) {
        this.xElmMakeKeyFunci = xElmMakeKeyFunci;
    }
    private final Function<List<XElm>, Map<String, XElm>> lis2MapX = (lis) -> {
        Map<String, XElm> map = lis.stream().collect(Collectors.toMap(XElm -> xElmMakeKeyFunci.apply(XElm), Function.identity(), (oldV, newV) -> newV));
        return map;
    };
    //
    private final Function<List<XElm>, Set<String>> lis2Set = (lis) -> {
        Set<String> map = lis.stream().map(xelm-> getxElmMakeKeyFunci().apply(xelm)).filter(xtr-> {
            Optional<String> optXtr = Optional.ofNullable(xtr) ;
            return( (optXtr.isPresent()) ? Boolean.TRUE: Boolean.FALSE) ; })
                .collect(Collectors.toSet());
        return map;
    };
    private final BiFunction<List<XElm>,Set<String>,List<XElm>> doMatchLists = (lis1, ls2Set) ->  {
        return (lis1.stream().filter(xelm -> ls2Set.contains(getxElmMakeKeyFunci().apply(xelm))).map(x -> (XElm) x).collect(Collectors.toList()));  //.collect(Collectors.toList()));
    };

    private final BiFunction<List<XElm>,Set<String> ,List<XElm>> doDistinctList  = (lisx,setKeyElm) -> {
        return (lisx.stream().filter(xElm -> uniqueXElmi.test(xElm,setKeyElm)).collect(Collectors.toList()));  //.collect(Collectors.toList()));
    };
    public final  BiFunction<List<XElm>, List<XElm>, List<XElm>> matchTwoLists = (lis1, lis2) -> {
        return( doMatchLists.apply(lis1,lis2Set.apply(lis2))) ;
    };

    public final  Function<List<XElm>, List<XElm>> distinctList  = (lisx) -> {

        return (doDistinctList.apply(lisx,new HashSet<String>())) ;
    };
}
