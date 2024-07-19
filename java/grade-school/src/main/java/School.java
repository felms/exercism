import java.util.HashMap;
import java.util.List;
import java.util.Map;

class School {

    private Map<String, Integer> roster;
    public School() {
        this.roster = new HashMap<>();
    }

    boolean add(String student, int grade) {
        if(this.roster.containsKey(student)) {
            return false;
        }

        this.roster.put(student, grade);
        return true;
    }

    List<String> roster() {
        return this.roster.entrySet().stream()
                    .sorted((a, b) -> { 
                        int res = a.getValue() - b.getValue();
                        return res == 0 ? a.getKey().compareTo(b.getKey()) : res;
                    })
                    .map(s -> s.getKey()).toList();
    }

    List<String> grade(int grade) {
        return this.roster.entrySet().stream()
                .filter(student -> student.getValue() == grade)
                .map(student -> student.getKey())
                .sorted(String::compareTo).toList();
    }

}
