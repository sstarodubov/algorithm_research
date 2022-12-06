import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.*;
import java.util.stream.Collectors;


class User{
    int age;
    String name;
    public User(int age, String name) {
        this.name = name;
        this.age = age;
    }
}


public class Main {
    public static void main(String[] args) {
        Main main = new Main();
    }

    private static void update(User user) {
        user.age = 99;
    }
    private static final RejectedExecutionHandler handler = (r, executor) -> {
        System.out.println("task rejected");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("try to take new one");
    };

    private int N = 10;
    private final ExecutorService observer = Executors.newSingleThreadExecutor();
    private final ExecutorService execSv = new ThreadPoolExecutor(
            N, N, 1000L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(N), handler
    );


    public Main() {
        observer.execute(() -> {
            int i = new Random().nextInt(2);
            for (;;) {
                execSv.execute(() -> {
                    takeTaskAndExecute(i);
                });
            }
        });
    }


    public void takeTaskAndExecute(int i) {
        try {
            System.out.println("");
            System.out.println("start " + i + " task: " + Thread.currentThread().getName());
            Thread.sleep(i * 1000);
            System.out.println("done " + i + " task: " + Thread.currentThread().getName());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
