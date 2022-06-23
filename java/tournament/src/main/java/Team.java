import java.util.Objects;

public class Team implements Comparable<Team>{
	
	private final String name;
	private int matches;
	private int wins;
	private int draws;
	private int losses;

	public Team(String name) {
		
		this.name = name;
		this.wins = 0;
		this.draws = 0;
		this.losses = 0;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getMatches(){
		return this.matches;
	}
	
	public void addMatch(){
		this.matches++;
	}

	public int getWins(){
		return this.wins;
	}
	
	public void addWin(){
		this.wins++;
	}

	public int getDraws(){
		return this.draws;
	}
	
	public void addDraw(){
		this.draws++;
	}

	public int getLosses(){
		return this.losses;
	}
	
	public void addLoss(){
		this.losses++;
	}

	public int getPoints(){
		return this.wins * 3 + this.draws;
	}

	@Override
	public boolean equals(Object other) {
	
		if (this == other) {
			return true;
		}

		if (other == null) {
			return false;
		}
		
		if (this.getClass() != other.getClass()) {
			return false;
		}
		
		Team otherTeam = (Team) other;

		return this.getName().equals(otherTeam.getName());

	}

	@Override
	public int hashCode(){
		return Objects.hash(this.name);
	}
	
	@Override
	public int compareTo(Team other) {

		if (this.getPoints() == other.getPoints()){				//  - Se os dois times tem os mesmos
			return this.getName().compareTo(other.getName());	// pontos desempata pelo nome
		} else if (this.getPoints() > other.getPoints()) {		//  - Quem tem mais pontos
			return -1;											// vem primeiro	
		} else {
			return 1;
		}
	}

}
