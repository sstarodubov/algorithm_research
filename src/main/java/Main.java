import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
    }
}

interface Service<E extends Root> {

    void send(E root);
}

class ChildService implements Service<Child1>{

    @Override
    public void send(Child1 root) {

    }
}

class Child2Service implements Service<Child2> {

    @Override
    public void send(Child2 root) {
        System.out.println(root.middlename);
    }
}
class Root {
    public String name;
}

class Child1 extends Root {
    public String surname;
}

class Child2 extends Root {
    public String middlename;
}