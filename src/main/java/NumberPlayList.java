import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
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
        //Method-2 - process stream , apply operation ,and then store result
        Function<Integer, Double> toDoubleFunction = Integer::doubleValue;
              List<Double>streamList=myNumberList.stream().map(toDoubleFunction).
                collect(Collectors.toList());
        System.out.println("METHOD2:Printing double list " + streamList);
    }
}