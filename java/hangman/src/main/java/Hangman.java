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
        Status[] currentStatus = {Status.PLAYING};
        boolean[] hasError = {false};
        String[] errorMessage = {""};

        List<Output> outputs = new ArrayList<>();

        secret.subscribe(s -> {
            outputs.add(new Output(
                    String.join("", secretWord),
                    String.join("", discoveredLetters),
                    guessesSet,
                    missesSet,
                    parts,
                    currentStatus[0])
            );
        });

        guesses.subscribe(
                new Observer<>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String letter) {
                        if (guessesSet.contains(letter) || missesSet.contains(letter)) {
                            onError(new IllegalArgumentException("Letter " + letter + " was already played"));
                        } else {

                            if (secretWord.contains(letter)) {

                                for (int i = 0; i < secretWord.size(); i++) {
                                    if (secretWord.get(i).equals(letter)) {
                                        discoveredLetters.set(i, letter);
                                        guessesSet.add(letter);

                                        if (!discoveredLetters.contains("_")) {
                                            currentStatus[0] = Status.WIN;
                                        }
                                    }
                                }

                            } else {
                                missesSet.add(letter);
                                parts.add(allParts.poll());

                                if (allParts.isEmpty()) {
                                    currentStatus[0] = Status.LOSS;
                                }
                            }
                        }

                        outputs.add(new Output(
                                String.join("", secretWord),
                                String.join("", discoveredLetters),
                                guessesSet,
                                missesSet,
                                parts,
                                currentStatus[0]
                        ));
                    }

                    @Override
                    public void onError(Throwable e) {
                        hasError[0] = true;
                        errorMessage[0] = e.getMessage();
                    }

                    @Override
                    public void onComplete() {

                    }
                }
        );

        if (hasError[0]) {
            return Observable.error(new IllegalArgumentException(errorMessage[0]));
        }

        return Observable.fromIterable(outputs);
    }

}