import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicReference;

public class Te {

    private static List<String> list = new ArrayList<>(List.of("hello"));

    private static volatile String val = null;

    public static void main(String[] args) throws InterruptedException {

        for (int j = 0; j < 100000; j++) {
            ExecutorService executorService = Executors.newCachedThreadPool();
            for (int i = 0; i < 3; i++) {
                executorService.execute(() -> {
                    String value = getValue();
                    if (!value.equals("hello")) {
                        System.out.println("hello err");
                    }
                    if (list != null) {
                        System.out.println("list err");
                    }
                });

            }

            executorService.shutdown();
            executorService.awaitTermination(1, TimeUnit.DAYS);
        }


        System.out.println("done");
    }


    public static String getValue() {
        if (val != null) {
            return val;
        }

        synchronized (Te.class) {
            if (val != null) return val;

            val = String.join(",", list);
            list = null;
        }

        return val;
    }

}
