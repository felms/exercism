import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Hangman {


    public Observable<Output> play(Observable<String> secret, Observable<String> guesses) {

        List<String> secretWord = List.of(secret.blockingFirst().split(""));
        List<String> discoveredLetters = new ArrayList<>(Collections.nCopies(secretWord.size(), "_"));
        Set<String> guessesSet = new HashSet<>();
        Set<String> missesSet = new HashSet<>();
        List<Part> parts = new ArrayList<>();
        Queue<Part> allParts = new ArrayDeque<>(List.of(Part.values()));
        List<Status> currentStatus = new ArrayList<>();
        currentStatus.add(Status.PLAYING);

        guesses.subscribe(
                new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                          
                    }

                    @Override
                    public void onNext(String s) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                }
        );

        return Observable.just(new Output(
                String.join("", secretWord),
                String.join("", discoveredLetters),
                guessesSet,
                missesSet,
                parts,
                currentStatus.get(0)
        ));
    }
}