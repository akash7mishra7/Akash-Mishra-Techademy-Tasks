import reactor.core.publisher.Flux;

public class ReactiveApplication {
    public static void main(String[] args) {
        // A Flux is a stream of multiple items, data is processed as it becomes available.
        Flux<String> names = Flux.just("Akash", "Rahul", "Anjali", "Ravi", "Amit");

        names
                .map(String::toUpperCase)
                .filter(name -> name.startsWith("A"))
                .subscribe(                      // the pipeline doesn't run without it,
                                                // used to consume the incoming data
                        name -> System.out.println("Name: " + name),
                        err -> System.err.println("Error: " + err),
                        () -> System.out.println("✅ Done")
                );
    }
}
