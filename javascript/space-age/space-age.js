//
// This is only a SKELETON file for the 'Space Age' exercise. It's been provided as a
// convenience to get you started writing code faster.
//

export const age = (planet, ageInSeconds) => {
  const earthYear = 31557600;

  let age = 0.0;

  switch(planet){
    case "earth":
      age = (ageInSeconds / earthYear) / 1.0;
      break;  
    case "mercury":
      age = (ageInSeconds / earthYear) / 0.2408467;
      break;  
    case "venus":
      age = (ageInSeconds / earthYear) / 0.61519726;
      break;  
    case "mars":
      age = (ageInSeconds / earthYear) / 1.8808158;
      break;  
    case "jupiter":
      age = (ageInSeconds / earthYear) / 11.862615;
      break;  
    case "saturn":
      age = (ageInSeconds / earthYear) / 29.447498;
      break;  
    case "uranus":
      age = (ageInSeconds / earthYear) / 84.016846;
      break;  
    case "neptune":
      age = (ageInSeconds / earthYear) / 164.79132;
      break;
    }

    return Number(age.toFixed(2));
  
};
