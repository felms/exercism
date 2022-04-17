//
// This is only a SKELETON file for the 'Resistor Color Duo' exercise. It's been provided as a
// convenience to get you started writing code faster.
//

export const decodedValue = (colors) => {
  let colorCodes = ["black", "brown" ,"red", "orange",
                    "yellow", "green", "blue", "violet",
                    "grey", "white"];

  let a = colorCodes.indexOf(colors[0]);
  let b = colorCodes.indexOf(colors[1]);

  return a * 10 + b;
};
