import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class NumberPlayList {
    public static void main(String[] args) {

        //creating sample collection
        List<Integer> myNumberList = new ArrayList<Integer>();
        for (int i = 0; i < 5; i++) {
            myNumberList.add(i);
        }
        //Method-1 processing the stream
        myNumberList.stream().forEach(n -> {
            System.out.println("METHOD1:Stream forEach Value::" + n);
        });
        //predicate even or odd
        Predicate<Integer> isEvenFunction = n -> n > 0 && n % 2 == 0;
        myNumberList.forEach(n -> {
            System.out.println("method: forEach value of " + n + " check for even: " + isEvenFunction.test(n));
        });
        //Method-2 - process stream , apply operation ,and then store result
        Function<Integer, Double> toDoubleFunction = Integer::doubleValue;
              List<Double>streamList=myNumberList.stream().filter(isEvenFunction).map(toDoubleFunction).
                collect(Collectors.toList());
        System.out.println("METHOD2:Printing double list " + streamList);
    }
}