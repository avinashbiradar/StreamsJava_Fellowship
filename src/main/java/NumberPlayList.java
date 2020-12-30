import java.util.ArrayList;
import java.util.List;

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
    }
}