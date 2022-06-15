import java.util.*;
import java.util.stream.Collectors;

public class School {

    private final Map<Integer, List<String>> students;

    public School() {
        this.students = new HashMap<>();
    }

    public void add(String student, int gradeNumber) {
        List<String> grade = this.students.get(gradeNumber);

        if (grade == null) {
            grade = new ArrayList<>();
        }

        grade.add(student);
        Collections.sort(grade);
        this.students.put(gradeNumber, grade);
    }

    public List<String> roster() {
        return this.students
                .values().stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    public List<String> grade(int gradeNumber) {
        return this.students.getOrDefault(gradeNumber, new ArrayList<>());

    }
}
