import java.util.ArrayList;
import java.util.List;

public class Dominoes {

    private List<Domino> chain;

    public Dominoes() {
        this.chain = new ArrayList<>();
    }

    public List<Domino> formChain(List<Domino> dominoesList) throws ChainNotFoundException {

        if (dominoesList.isEmpty()) {
            return this.chain;
        }

        if (!this.formDominoChain(new ArrayList<>(), new ArrayList<>(dominoesList))) {
            throw new ChainNotFoundException("No domino chain found.");
        }

        Domino first = this.chain.get(0);
        Domino last = this.chain.get(this.chain.size() - 1);
        if (first.getLeft() != last.getRight()
                || this.chain.size() != dominoesList.size()) {
            throw new ChainNotFoundException("No domino chain found.");
        }

        return this.chain;
    }

    private boolean formDominoChain(List<Domino> currentChain, List<Domino> remainingDominoes) {

        // Retorna caso tenha conseguido inserir
        // todos os dominós
        if (remainingDominoes.isEmpty()) {
            this.chain = new ArrayList<>(currentChain);
            return true;
        }

        // Tenta todos os dominós um por um
        for (int i = 0; i < remainingDominoes.size(); i++) {
            Domino domino = remainingDominoes.remove(i);
            List<Domino> newChain = new ArrayList<>(currentChain);

            // Tenta inserir um dominó
            if (insertInChain(newChain, domino)) {
                if (formDominoChain(newChain, remainingDominoes)) {
                    return true;
                }
            }

            // Caso chegue a um dead end desfaz o que foi feito
            // nessa iteração e parte para a próxima
            remainingDominoes.add(i, domino);
        }

        // Passou todos as possibilidades e não
        // conseguiu criar: falha
        return false;
    }

    // Insere um dominó na lista fornecida
    private boolean insertInChain(List<Domino> chainToInsert, Domino domino) {

        if (chainToInsert.isEmpty()) {
            chainToInsert.add(domino);
            return true;
        }

        // Tenta inserir o dominó
        Domino first = chainToInsert.get(0);
        if (domino.getRight() == first.getLeft()) {
            chainToInsert.add(0, domino);
            return true;
        }

        Domino last = chainToInsert.get(chainToInsert.size() - 1);
        if (last.getRight() == domino.getLeft() ) {
            chainToInsert.add(domino);
            return true;
        }

        // Inverte o dominó e tentar inserir assim
        domino = flipDomino(domino);
        if (domino.getRight() == first.getLeft()) {
            chainToInsert.add(0, domino);
            return true;
        }

        if (last.getRight() == domino.getLeft() ) {
            chainToInsert.add(domino);
            return true;
        }

        return false;
    }

    private Domino flipDomino(Domino domino) {
        return new Domino(domino.getRight(), domino.getLeft());
    }
}
