export const answer = (string) => {
  
  try{

    let result = 0;

    let operation = string.replace("What is ", "");
    operation = operation.replace(/by/g, "");
    let tokens = operation.split(/\s+/);

    if (tokens.length === 1) {
      let number = tokens[0].replace(/[^\d]/g, "");
      result = parseInt(number);
    } else if (tokens.length === 2) {

      if (tokens[1] === "plus?" || tokens[1] === "minus?"
            || tokens[1] === "multiplied?" || tokens[1] === "divided?"
            || tokens[1] === "is?") {
        throw new Error('Syntax error');
      } else {
        throw new Error('Unknown operation');
      }

      
    } else if (tokens.length === 3) {
      let firstNumber = parseInt(tokens[0]);

      if (!(/plus|minus|multiplied|divided/.test(tokens[1]))) {
        throw new Error('Syntax error');
      }

      let oper = tokens[1];
      let secondNumber = parseInt(tokens[2].replace(/[^-\d]/g, ""));

      result = applyOperation(firstNumber, secondNumber, oper);
    } else if (tokens.length === 4) {
      throw new Error('Syntax error');
    } else if (tokens.length === 5) {
      let firstNumber = parseInt(tokens[0]);
      let firstOper = tokens[1];
      let secondNumber = parseInt(tokens[2]);
      let secondOper = tokens[3];
      let thirdNumber = parseInt(tokens[4].replace(/[^-\d]/g, ""));

      result = applyOperation(firstNumber, secondNumber, firstOper);
      result = applyOperation(result, thirdNumber, secondOper);
    } else {
      throw new Error("Unknown operation");
    }


    return result;
  } catch (error) {
    throw error;
  }

};

const applyOperation = (firstNumber, secondNumber, operation) => {

  let result = 0;

  switch(operation) {
    case "plus":
      result = firstNumber + secondNumber;
      break;
    case "minus":
      result = firstNumber - secondNumber;
      break;
    case "multiplied":
      result = firstNumber * secondNumber;
      break;
    case "divided":
      result = firstNumber / secondNumber;
      break;
  }

  return result;
}