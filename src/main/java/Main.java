import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
//        CompletableFuture<Object> future = CompletableFuture.supplyAsync(() -> {
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            throw new RuntimeException();
//        }).exceptionally(throwable -> {
//            System.out.println(throwable.getCause());
//            throw new NullPointerException("hello world");
//        });
//
//        Object s = null;
//        try {
//            s = future.get(2000, TimeUnit.MILLISECONDS);
//        } catch (TimeoutException e) {
//            System.out.println("some gets wrong");
//            throw new TimeoutException();
//        }
//        System.out.println(s);
        CreditType cashOnCard = CreditType.valueOf("CashOnCard");
        System.out.println(cashOnCard);
    }
}
enum CreditType {
    CASH_ON_CARD("CashOnCard");

    private final String value;

    CreditType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}