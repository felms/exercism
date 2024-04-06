export const tournamentTally = (input) => {

    let header = 'Team                           | MP |  W |  D |  L |  P';
    if (!input) {
        return header;
    }

    return header + '\n' + 
        Object.entries(input.split('\n').reduce(parseGame, {}))
                .toSorted(sortingFunction)
                .map(toString) .join('\n');

};

const parseGame = (tournament, game) => {
    let [teamA, teamB, result] = game.split(';')

    let stateA = tournament[teamA] ? tournament[teamA] : { mp: 0, w: 0, d: 0, l: 0 , p: 0};
    let stateB = tournament[teamB] ? tournament[teamB] : { mp: 0, w: 0, d: 0, l: 0 , p: 0};
    stateA.mp++;
    stateB.mp++;

    switch(result) {
        case 'win':
            stateA.w++;
            stateA.p += 3;
            stateB.l++;
            break;
        case 'draw':
            stateA.d++;
            stateA.p++;
            stateB.d++;
            stateB.p++;
            break;
        case 'loss':
            stateA.l++;
            stateB.w++;
            stateB.p += 3;
            break;
    }

    return {...tournament, [teamA]: stateA, [teamB]: stateB};

};

const sortingFunction = ([nameA, stateA], [nameB, stateB]) => {
    if (stateA.p === stateB.p) {
        return nameA < nameB ? -1 : nameA > nameB ? 1 : 0;
    }

    return stateB.p - stateA.p;
};

const toString = ([teamName, {mp, w, d, l, p}]) => {
    let teamHeaderLength = 'Team                           '.length;
    let name = teamName.padEnd(teamHeaderLength, ' ');
    let points = p.toString().padStart(3, ' ');

    return `${name}|  ${mp} |  ${w} |  ${d} |  ${l} |${points}`;
};
