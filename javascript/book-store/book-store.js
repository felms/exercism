const basePrice = 800;

const getDiscont = (items) => {
  switch(items) {
    case 2:
      return basePrice * 0.05;
    case 3:
      return basePrice * 0.1;
    case 4:
      return basePrice * 0.2;
    case 5:
      return basePrice * 0.25;
    default:
      return 0;
  }
};

export const cost = (books) => {

  let dCost = dumbCost(books);
  let bCost = balancedCost(books);

  // Retorna o menor valor entre os dois custos
  return Math.min(dCost, bCost);
};

// Tenta distribuir os livros em grupos de forma 
// balanceada antes de calcular o custo
const balancedCost = (books) => {

  // Cópia do array só pra não mudar o que é passado
  let booksBought = [...books];
  booksBought = booksBought.sort();

  // Calculo da qtde de grupos (Sets) necessários
  const counts = {};
  booksBought.forEach(book => {
    counts[book] = counts[book] ? counts[book] + 1 : 1;
  });

  let numberOfGroups = Object.values(counts).reduce((a, b) => Math.max(a, b), -Infinity);

  // Cada set desse array vai conter um 'grupo' de livros para calcular o desconto
  let setArray = [];

  // Cria os grupos
  for (let i = 0; i < numberOfGroups; i++) {
    setArray.push(new Set());
  }

  // Distribui os items
  for (let i = 0; i < booksBought.length; i++){
    setArray[i % numberOfGroups].add(booksBought[i]);
  }

  // Calcula o custo para cada grupo e soma tudo
  let sum = 0;
  setArray.forEach(group => {
    let items = group.size;
    let discount = getDiscont(items);
    sum += items * (basePrice - discount);
  });

  return sum;

};

// Calcula o custo fazendo um agrupamento simples dos livros
const dumbCost = (books) => {

  // Cada set desse array vai conter um 'grupo' de livros para calcular o desconto
  let setArray = [];
  
  // Cópia do array só pra não mudar o que é passado
  let booksBought = [...books];

  // Enquanto ainda houver algum item não agrupado no array eu continuo repetindo
  while(booksBought.length > 0) {

    let booksBought2 = [...booksBought]; // Faço as alterçãoes em um array e depois copio para o outro 
    
    let currentSet = new Set();

    booksBought.forEach(book => {
      if (!currentSet.has(book)) {
        currentSet.add(book);
        let pos = booksBought2.indexOf(book);
        booksBought2.splice(pos, 1);
      }
    });    

    booksBought = [...booksBought2];
    setArray.push(currentSet);
    currentSet = new Set();
  }

  // Calcula o custo para cada grupo e soma tudo
  let sum = 0;
  setArray.forEach(group => {
    let items = group.size;
    let discount = getDiscont(items);
    sum += items * (basePrice - discount);
  });

  return sum;

};
