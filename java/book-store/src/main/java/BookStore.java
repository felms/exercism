import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BookStore {

    private final double BASE_PRICE = 8.00;

    public double calculateBasketCost(List<Integer> books) {
      double dCost = dumbCost(books);
      double bCost = balancedCost(books);
    
      // Retorna o menor valor entre os dois custos
      return Math.min(dCost, bCost);
    }

    private double getDiscount(int items) {

        switch(items) {
            case 2:
              return BASE_PRICE * 0.05;
            case 3:
              return BASE_PRICE * 0.1;
            case 4:
              return BASE_PRICE * 0.2;
            case 5:
              return BASE_PRICE * 0.25;
            default:
              return 0;
          }
    }


    // Tenta distribuir os livros em grupos de forma 
    // balanceada antes de calcular o custo
    private double balancedCost(List<Integer> books) {

      // Cópia do array só pra não mudar o que é passado
      List<Integer> booksBought = new ArrayList<>(books);
      Collections.sort(booksBought);

      // Calculo da qtde de grupos (Sets) necessários
      Map<Integer, Integer> counts = new HashMap<>();
      booksBought.forEach(book -> {
        if (counts.containsKey(book)) {
          int b = counts.get(book);
          b++;
          counts.put(book, b);
        } else {
          counts.put(book, 1);
        }
      });

      int numberOfGroups = counts.values()
                          .stream()
                          .mapToInt(Integer::intValue)
                          .max().orElse(0);

      // Cada set desse array vai conter um 'grupo' de livros para calcular o desconto
      List<Set<Integer>> setArray = new ArrayList<>();

      // Cria os grupos
      for (int i = 0; i < numberOfGroups; i++) {
        setArray.add(new HashSet<>());
      }

      // Distribui os items
      for (int i = 0; i < booksBought.size(); i++){
        setArray.get(i % numberOfGroups).add(booksBought.get(i));
      }

      // Calcula o custo para cada grupo e soma tudo
      double sum = 0;
      for (Set<Integer> group : setArray) {
        int items = group.size();
        double discount = getDiscount(items);
        sum += items * (BASE_PRICE - discount);
      }

      return sum;

    };

    private double dumbCost(List<Integer> books) {

        // Cada set desse array vai conter um 'grupo' de livros para calcular o desconto
        List<Set<Integer>> setArray = new ArrayList<>();
        
        // Cópia do array só pra não mudar o que é passado
        List<Integer> booksBought = new ArrayList<>(books);
      
        // Enquanto ainda houver algum item não agrupado no array eu continuo repetindo
        while(booksBought.size() > 0) {
      
            List<Integer> booksBought2 = new ArrayList<>(booksBought); // Faço as alterçãoes em um array e depois copio para o outro 
          
            Set<Integer> currentSet = new HashSet<>();

            booksBought.forEach(book -> {
                if (!currentSet.contains(book)) {
                  currentSet.add(book);
                  int pos = booksBought2.indexOf(book);
                  booksBought2.remove(pos);
                }
            });

            booksBought = new ArrayList<>(booksBought2);
            setArray.add(currentSet);
            
        }
      
        // Calcula o custo para cada grupo e soma tudo
        double sum = 0;
        for (Set<Integer> group : setArray) {
            int items = group.size();
            double discount = getDiscount(items);
            sum += items * (BASE_PRICE - discount);
        }

        return sum;
    }


}