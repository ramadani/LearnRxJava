import io.reactivex.Flowable;

/**
 * Created by dani on 5/28/17.
 */
public class Main {
    public static void main(String[] args) {
        Flowable.just("Hello World").subscribe(System.out::println);
    }
}
