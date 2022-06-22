import java.util.ArrayList;
import java.util.List;

class KindergartenGarden {

	private final String[] garden;

    public KindergartenGarden(String garden) {
		this.garden = garden.split("\\s+");
    }

    public List<Plant> getPlantsOfStudent(String student) {
		
		int pos = getStudentPosition(student);
		List<Plant> plants = new ArrayList<>();
		plants.add(Plant.getPlant(this.garden[0].charAt(pos)));
		plants.add(Plant.getPlant(this.garden[0].charAt(pos + 1)));
		plants.add(Plant.getPlant(this.garden[1].charAt(pos)));
		plants.add(Plant.getPlant(this.garden[1].charAt(pos + 1)));
		
		return plants;
	}
	
	private int getStudentPosition(String student){
		
		switch(student) {
			case "Alice":
				return 0;
			case "Bob":
				return 2;
			case "Charlie":
				return 4;
			case "David":
				return 6;
			case "Eve":
				return 8;
			case "Fred":
				return 10;
			case "Ginny":
				return 12;
			case "Harriet":
				return 14;
			case "Ileana":
				return 16;
			case "Joseph":
				return 18;
			case "Kincaid":
				return 20;
			case "Larry":
				return 22;

		}
		
		return -1;

    }

}
