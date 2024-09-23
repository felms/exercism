import re


def tally(rows):

    teams = dict()
    result = ["Team                           | MP |  W |  D |  L |  P"]

    for row in rows:
        process_row(row, teams)

    matches = sorted(teams.values(), key=lambda elem: (-elem['p'], elem['name']))
    result.extend([print_team(team) for team in matches])

    return result


def process_row(row, teams):
    team0, team1, result = re.findall("(.*);(.*);(.*)", row)[0]

    team0Data = teams.get(team0, {'name': team0, 'mp': 0, 'w': 0, 'd': 0, 'l': 0, 'p': 0})
    team1Data = teams.get(team1, {'name': team1, 'mp': 0, 'w': 0, 'd': 0, 'l': 0, 'p': 0})

    team0Data['mp'] += 1
    team1Data['mp'] += 1

    if result == 'win':
        team0Data['w'] += 1
        team0Data['p'] += 3
        team1Data['l'] += 1
    elif result == 'draw':
        team0Data['d'] += 1
        team0Data['p'] += 1

        team1Data['d'] += 1
        team1Data['p'] += 1
    else:
        team1Data['w'] += 1
        team1Data['p'] += 3
        team0Data['l'] += 1

    teams[team0] = team0Data
    teams[team1] = team1Data


def print_team(team):

    return f"{team['name']:31}|{team['mp']:3} |{team['w']:3} |{team['d']:3} |{team['l']:3} |{team['p']:3}"
