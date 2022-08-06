export class Change {
  calculate(coinArray, target) {
    if (target < 0) {
      throw new Error('Negative totals are not allowed.');
    }
    if (target == 0) {
      return [];
    }
    if (coinArray.includes(target)) {
      return [target];
    }

    let coins = [...coinArray];
    coins.sort((a, b) => a - b);

    let solution = this.computeChange(target, coins);

    // Retorna erro não tenha sido encontrada nenhuma solução
    if (solution === null) {
      throw new Error(`The total ${target} cannot be represented in the given currency.`);
    }

    solution.sort((a, b) => a - b);
    return solution;
  }

  // Computa as combinaçãoes de moedas possíveis com as
  // moedas fornecidas partindo dos menores casos
  // reutilizando as soluções dos mesmos para
  // casos maiores
  computeChange(amount, coins) {

    // Cria e inicializa um mapa com as soluções iniciais
    let list = [];
    for (let i = 0; i <= amount; i++) {
      list.push(amount + 1);
    }

    let dp = new Map();
    for (let i = 0; i <= amount; i++) {
      dp.set(i, [...list]);
    }

    dp.set(0, []);

    for (let i = 0; i <= amount; i++) {
      for (let coin of coins) {
        if (coin <= i) { // Se a moeda for menor que o valor atual sendo calculado
          let solForI = dp.get(i); // A solução atual para o valor 'i'

          // Pego a melhor solução para o caso de valor
          // de ('i' - 'moedaAtual')
          let newL = [...dp.get(i - coin)];
          // Adiciono a moeda à soma para gerar a solução para
          // o valor atual
          newL.push(coin);

          // Testo se a solução gerada é melhor que a solução existente
          if (solForI.length > newL.length) {
            dp.set(i, newL);
          }
        }
      }
    }

    let sum = dp.get(amount).reduce((a, b) => a + b, 0);
    return sum > amount ? null : dp.get(amount);
  }
}
