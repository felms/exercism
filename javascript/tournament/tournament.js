let teams;
let header = 'Team                           | MP |  W |  D |  L |  P';

export const tournamentTally = (games) => {

  teams = new Map();

  if (games.length === 0) {
    return header;
  }

  let gamesList = games.split(/\n/);
  gamesList.forEach(game => processGame(game));

  return printTable();

};

const printTable = () => {

  let results = header + '\n';

  let teamsArray = [...teams.entries()].sort(comparingFunction);
  teamsArray.forEach(team => {
    results += `${team[0].padEnd(31)}|${team[1].mp}.toString().padStart(3)} ` 
      + `|${team[1].w}.toString().padStart(3)} |${team[1].d.toString().padStart(3)} ` 
      + `|${team[1].l}.toString().padStart(3)} |${team[1].p.toString().padStart(3)}\n`;
  });

  return results.trim();

};

const processGame = (game) => {

  let tokens = game.split(';');
  let team0;
  let team1;

  if (teams.has(tokens[0])) {
    team0 = teams.get(tokens[0]); 
  } else {
    team0 = {mp: 0, w: 0, d: 0, l: 0, p: 0};
  }

  if (teams.has(tokens[1])) {
    team1 = teams.get(tokens[1]); 
  } else {
    team1 = {mp: 0, w: 0, d: 0, l: 0, p: 0};
  }

  team0.mp = team0.mp + 1;
  team1.mp = team1.mp + 1;

  switch(tokens[2]) {
    case 'win':
      team0.w = team0.w + 1;
      team0.p = team0.p + 3;
      team1.l = team1.l + 1;
      break;
    case 'loss':
      team0.l = team0.l + 1;
      team1.w = team1.w + 1;
      team1.p = team1.p + 3;
      break;
    default:
      team0.d = team0.d + 1;
      team0.p = team0.p + 1;
      team1.d = team1.d + 1;
      team1.p = team1.p + 1; 
      break;
  }

  teams.set(tokens[0], team0);
  teams.set(tokens[1], team1);

};

const comparingFunction = (a, b) => {
  if (a[1].p === b[1].p) {
    if (a[0] > b[0]) {
      return 1;
    }

    if (a[0] < b[0]) {
      return -1;
    }

    return 0;
  }

  if (a[1].p > b[1].p) {
    return -1;
  }

  if (a[1].p < b[1].p) {
    return 1;
  }
};
