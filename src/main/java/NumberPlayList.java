import java.util.ArrayList;
import java.util.Comparator;
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
              List<Double>streamList=myNumberList.stream()
                                      .filter(isEvenFunction)
                                      .map(toDoubleFunction)
                                      .collect(Collectors.toList());
        System.out.println("METHOD2:Printing double list " + streamList);

        //method3 - to find the next peek of even number
        Integer first = myNumberList.stream().
                         filter(isEvenFunction)
                        .peek(n-> System.out.println("peak even number "+n))
                        .findFirst().orElse(null);
        System.out.println("first even "+first);

        //method4 - find minimum from stream
        Integer min = myNumberList.stream()
                .filter(isEvenFunction)
                .min(Comparator.comparing(Integer::intValue))
                .orElse(null);
        System.out.println(" min value" +min);

        //method5 - find maximum from stream
        Integer max = myNumberList.stream()
                .filter(isEvenFunction)
                .max(Comparator.comparing(Integer::intValue))
                .orElse(null);
            System.out.println(" max value" +max);

        //method6-average from the number stream
        Integer sum =myNumberList.stream().
                reduce(0,Integer::sum);
        long count = myNumberList.stream().count();
        System.out.println("Average is "+sum+"/"+count+"="+sum/count);
    }
}
