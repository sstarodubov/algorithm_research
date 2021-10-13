package haxul.sec01;

import org.apache.commons.lang3.text.StrBuilder;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.io.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

public class FileService {
    private final String url = "/home/haxul/Development/workspaces/java/algorithm_tasks_solving/java/src/com/company/reactor/src/main/resources";

    public static void main(String[] args) {
        var fs = new FileService();

        Mono<String> mono = fs.read("hello.txt");
        mono
                .subscribe(System.out::println);
        System.out.println("end");
    }


    public Mono<Void> write(String content, String filename) {
        return Mono.fromRunnable(() -> {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(url + "/" + filename))) {
                writer.write(content);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public Mono<String> read(String filename) {
        return Mono.fromFuture(
                CompletableFuture.supplyAsync(() -> {
                    System.out.println(Thread.currentThread().getName());
                    try (BufferedReader reader = new BufferedReader(new FileReader(url + "/" + filename))) {
                        StringBuilder sb = new StringBuilder();
                        while (true) {
                            var curLine = reader.readLine();
                            if (curLine == null) break;
                            sb.append(curLine);
                        }
                        return sb.toString();
                    } catch (Exception e) {
                        return e.getMessage();
                    }
                })
        );
    }
}
