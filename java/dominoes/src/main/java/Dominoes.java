import java.util.ArrayList;
import java.util.List;

public class Dominoes {

    private List<Domino> chain;

    public Dominoes() {
        this.chain = new ArrayList<>();
    }

    public List<Domino> formChain(List<Domino> dominoesList) throws ChainNotFoundException {

        if (dominoesList.isEmpty()) {
            return chain;
        }

        dominoesList.forEach(this::insertInChain);

        Domino first = this.chain.get(0);
        Domino last = this.chain.get(this.chain.size() - 1);
        if (first.getLeft() != last.getRight() 
                || this.chain.size() != dominoesList.size()) {
            throw new ChainNotFoundException("No domino chain found.");
        }

        return this.chain;
    }

    private boolean insertInChain(Domino domino) {

        if (this.chain.size() == 0) {
            this.chain.add(domino);
            return true;
        }

        // Tenta inserir o dominó
        Domino first = this.chain.get(0);
        if (domino.getRight() == first.getLeft()) {
            this.chain.add(0, domino);
            return true;
        }

        Domino last = this.chain.get(this.chain.size() - 1);
        if (last.getRight() == domino.getLeft() ) {
            this.chain.add(domino);
            return true;
        }

        // Inverte o dominó e tentar inserir assim
        domino = flipDomino(domino);
        if (domino.getRight() == first.getLeft()) {
            this.chain.add(0, domino);
            return true;
        }

        if (last.getRight() == domino.getLeft() ) {
            this.chain.add(domino);
            return true;
        }


        return false;

    }

    private Domino flipDomino(Domino domino) {
        return new Domino(domino.getRight(), domino.getLeft());
    }
}
