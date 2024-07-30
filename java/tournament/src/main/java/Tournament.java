import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import java.util.stream.Collectors;

class Tournament {

    private Map<String, Team> teams;

    public Tournament() {
        this.teams = new HashMap<>();
    }

    String printTable() {
        String header = "Team                           | MP |  W |  D |  L |  P";

        String table = this.teams.values().stream()
                .sorted().map(this::printTeam).collect(Collectors.joining("\n"));

        return header + "\n" + (table.isBlank() ? "" : table + "\n");
    }

    void applyResults(String resultString) {
        Arrays.stream(resultString.split("\n")).forEach(this::applyResult);
    }

    private void applyResult(String matchResult) {
        String[] match = matchResult.split(";");

        String teamA = match[0];
        String teamB = match[1];
        String result = match[2];

        Team a = this.teams.getOrDefault(teamA, new Team(teamA));
        Team b = this.teams.getOrDefault(teamB, new Team(teamB));
        a.addMatch();
        b.addMatch();

        if (result.equals("win")) {
            a.addWin();
            b.addLoss();
        } else if (result.equals("loss")) {
            a.addLoss();
            b.addWin();
        } else {
            a.addDraw();
            b.addDraw();
        }

        teams.put(teamA, a);
        teams.put(teamB, b);
    }

    private String printTeam(Team team) {
        return String.format("%s|%s |%s |%s |%s |%s",
                String.format("%-31s", team.getName()), 
                String.format("%3d", team.getMatches()), 
                String.format("%3d", team.getWins()), 
                String.format("%3d", team.getDraws()), 
                String.format("%3d", team.getLosses()), 
                String.format("%3d", team.getPoints()));
    }
}
