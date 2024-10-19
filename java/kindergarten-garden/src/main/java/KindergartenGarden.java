import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

class KindergartenGarden {

    private static final List<String> students = List.of(
            "Alice", "Bob", "Charlie", "David", "Eve", "Fred",
            "Ginny", "Harriet", "Ileana", "Joseph", "Kincaid", "Larry" );

    private final String garden;

    KindergartenGarden(String garden) {
        this.garden = garden;
    }

    List<Plant> getPlantsOfStudent(String student) {
        int studentIndex = students.indexOf(student);
        return Arrays.stream(this.garden.split("\n"))
                .flatMap(row -> row.substring(studentIndex * 2, studentIndex * 2 + 2).chars().mapToObj(c -> Plant.getPlant((char) c)))
                .toList();
    }

}