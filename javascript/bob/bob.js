//
// This is only a SKELETON file for the 'Bob' exercise. It's been provided as a
// convenience to get you started writing code faster.
//

export const hey = (message) => {
  message = message.trim();

  if (message === "") {
      return "Fine. Be that way!";
  }

  if (isQuestion(message)) {

      if (isAllSymbols(message)) {
          return "Sure.";
      }

      if (isUpperCase(message)) {
          return "Calm down, I know what I'm doing!";
      }
      
      return "Sure.";
  }

  if (isAllSymbols(message)) {
      return "Whatever.";
  }

  if (isUpperCase(message)) {
      return "Whoa, chill out!";
  }

  return "Whatever.";
};



function isQuestion(string) {
  return string[string.length - 1] == '?';
}

function isUpperCase(string) {

  for(let i = 0; i < string.length; i++) {
      if((/[a-z]/).test(string[i])) {
          return false;
      }
  }

  return true;
}

function isAllSymbols(string) {

  for (let i = 0; i < string.length; i++) {
      if ((/[a-zA-Z]/).test(string[i])) {
          return false;
      }
  }

  return true;
}
