import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers

/**
 * Created by dani on 5/28/17.
 */

fun main(args: Array<String>) {
    Flowable.just("Mantap Soul").subscribe(::println)

    Flowable.fromCallable {
        Thread.sleep(1500)
        return@fromCallable "Done"
    }
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.single())
            .subscribe(::println, Throwable::printStackTrace)

//    Thread.sleep(2000)

    val source: Flowable<String> = Flowable.fromCallable {
        Thread.sleep(1000)
        return@fromCallable "Selesai"
    }

    val runBackground: Flowable<String> = source.subscribeOn(Schedulers.io())
    val showForeground: Flowable<String> = runBackground.observeOn(Schedulers.single())
    showForeground.subscribe(::println, Throwable::printStackTrace)

    Thread.sleep(2000)
}