import java.util.HashMap;
import java.util.Map;

public class DialingCodes {

    private final Map<Integer, String> codes;
    public DialingCodes() {
        this.codes = new HashMap<>();
    }

    public Map<Integer, String> getCodes() {
        return this.codes;
    }

    public void setDialingCode(Integer code, String country) {
        this.codes.put(code, country);
    }

    public String getCountry(Integer code) {
        return this.codes.get(code);
    }

    public void addNewDialingCode(Integer code, String country) {
        if (!this.codes.containsKey(code)
                && !this.codes.containsValue(country)) {
            this.setDialingCode(code, country);
        }
    }

    public Integer findDialingCode(String country) {

        return this.codes.entrySet().stream()
                .filter(entry -> entry.getValue().equals(country))
                .map(Map.Entry::getKey).findFirst().orElse(null);

    }

    public void updateCountryDialingCode(Integer code, String country) {
        if (this.codes.containsValue(country)) {
            this.codes.remove(this.findDialingCode(country));
            this.codes.put(code, country);
        }
    }
}
