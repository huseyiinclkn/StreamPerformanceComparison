import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int size = 10_000;
        List<Integer> list = new ArrayList<Integer>(size);

        Random random = new Random();
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(100));
        }
        long startStream = System.currentTimeMillis();
        int sum1 = list.stream()
                .map(n -> {
                    try {

                        Thread.sleep(1);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    return n * 2;

                })
                .mapToInt(n -> n)
                .sum();
        long endStream = System.currentTimeMillis();

        long startParelleStream = System.currentTimeMillis();
        int sum2 = list.parallelStream()
                .map(n -> {
                    try {

                        Thread.sleep(1);
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    return n * 2;

                })
                .mapToInt(n -> n)
                .sum();
        long endParelleStream = System.currentTimeMillis();

        System.out.println("Processing Time " + (endStream - startStream));
        System.out.println("sum1" + " = " + sum1);
        System.out.println("*********");
        System.out.println("Processing Time " +(endParelleStream - startParelleStream));
        System.out.println("sum2" + " = " + sum2);


    }
}