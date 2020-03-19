package com.shd.test.colcstreams;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.IntStream;
public class TestByCollectJDKIFBuiltIn {
/* JDK Collector Interface
 * public interface Collector<T, A, R> { // T: Type of the data stream,
 *                                      // A: Accumulation type, to store the intermediate results.
 * 										//R: Return type, this is return type.
 * Supplier<A> supplier();
 * * BiConsumer<A, T> accumulator();
 * * BinaryOperator<A> combiner();
 * * Function<A, R> finisher();
 * * Set<Characteristics> characteristics(); }
 * The interface Collector provides the static method Collector.of(...) to create a Collector in a more functional way.
 * helping us to reduce the need for an extra class. here is example for using this interfcae
 */
    public static void main(String[] args) {

        final List<Integer> result1 = IntStream.of(1, 2, 3, 4, 3, 4, 5)
                .boxed()
                .collect(uniqueCollector()); //distinct
        System.out.println("result1:" + result1);
        CharSequence charSeq1 = " " ;
        String result2 = IntStream.of(1, 2, 3, 4, 3, 4, 5)
                .boxed()
                .map(i -> String.valueOf(i))
                .collect(joineCollector(charSeq1));
        System.out.println("result2:" + result2);
    }

    public static <T> Collector<T, Set<T>, List<T>> uniqueCollector() { //This is a genric Distinct
        return Collector.of( () -> {
                   return  new HashSet<T>() ;        // supplier
                }  ,
                Set::add,                            // accumulator
                (result1, result2) -> {              // combiner/merge for parallel/CONCURRENT
                    result1.addAll(result2);
                    return result1;
                },
                ArrayList::new,                        //// finisher result Accumulated
                Collector.Characteristics.CONCURRENT,
                Collector.Characteristics.UNORDERED);
        }
    //Simple more:
    public static Collector<CharSequence, StringJoiner, String> joineCollector(CharSequence delimiter) {
        return Collector.of(() -> new StringJoiner(delimiter), // supplier
                StringJoiner::add,                 // accumulator
                StringJoiner::merge,               // combiner
                StringJoiner::toString);           // finisher
    }

}
