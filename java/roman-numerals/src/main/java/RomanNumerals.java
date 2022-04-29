public class RomanNumerals {
    private String[] units = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    private String[] tens = {"","X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    private String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    private String[] thousands = {"", "M", "MM", "MMM"};

    private final int number;

    public RomanNumerals(int number) {
        this.number = number;
    }

    public String getRomanNumeral() {
        String romanNumber = "";
        int n = this.number;
        
        int m = n / 1000;
        romanNumber = this.thousands[m];

        int c = (n % 1000) / 100;
        romanNumber += this.hundreds[c];

        int x = (n % 100) / 10;
        romanNumber += this.tens[x];

        int i = n % 10;
        romanNumber += this.units[i];
        
        return romanNumber;
    }
}