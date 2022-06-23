import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Tournament {
	
	private List<Team> teams;

	public Tournament(){
		
		this.teams = new ArrayList<>();
	}	
	
	public void applyResults(String inputTable) {
		
		Arrays.asList(inputTable.split("\\n"))
					.stream()
					.forEach(this::processGame);
	}

	public String printTable(){
		
		Collections.sort(this.teams);
		StringBuilder sb = new StringBuilder();
		sb.append( "Team                           | MP |  W |  D |  L |  P\n");
		this.teams.forEach(t -> {
							sb.append(t.getName());
							sb.append("             ");
							sb.append("|  " + t.getMatches() + " ");
							sb.append("|  " + t.getWins() + " ");
							sb.append("|  " + t.getDraws() + " ");
							sb.append("|  " + t.getLosses() + " ");
							sb.append("|  " + t.getPoints() + "\n");
					});

		return sb.toString();
	}

	private void processGame(String game) {
		
		String[] tokens = game.split(";");
		Team team0 = new Team(tokens[0]);
		Team team1 = new Team(tokens[1]);

		int indexTeam0 = this.teams.indexOf(team0);
		if (indexTeam0 >= 0) {
			team0 = this.teams.get(indexTeam0);
		} else {
			this.teams.add(team0);
		}

		int indexTeam1 = this.teams.indexOf(team1);
		if (indexTeam1 >= 0) {
			team1 = this.teams.get(indexTeam1);
		} else {
			this.teams.add(team1);
		}
		
		team0.addMatch();
		team1.addMatch();

		switch(tokens[2]) {
			case "win":
				team0.addWin();
				team1.addLoss();
				break;
			case "loss":
				team0.addLoss();
				team1.addWin();
				break;
			default:
				team0.addDraw();
				team1.addDraw();
				break;
		}
	}

}	
