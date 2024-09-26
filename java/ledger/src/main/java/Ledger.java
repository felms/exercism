import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols; 
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Ledger {

    private static final String US_LOCALE = "en-US";
    private static final String NL_LOCALE = "nl-NL";

    private static final String USD_CURRENCY = "USD";
    private static final String EUR_CURRENCY = "EUR";

    public LedgerEntry createLedgerEntry(String d, String desc, int c) {
        return new LedgerEntry(LocalDate.parse(d), desc, c);
    }

    public String format(String cur, String loc, LedgerEntry[] entries) {

        if (!cur.equals(USD_CURRENCY) && !cur.equals(EUR_CURRENCY)) {
            throw new IllegalArgumentException("Invalid currency");
        } 

        if (!loc.equals(US_LOCALE) && !loc.equals(NL_LOCALE)) {
            throw new IllegalArgumentException("Invalid locale");
        } 

        String header = loc.equals(US_LOCALE) 
        ? "Date       | Description               | Change       "
        : "Datum      | Omschrijving              | Verandering  ";

        String curSymb = cur.equals(USD_CURRENCY) ? "$" : "€";
        String datPat = loc.equals(US_LOCALE) ? "MM/dd/yyyy" : "dd/MM/yyyy";
        char decSep = loc.equals(US_LOCALE) ? '.' : ',';
        char thSep = loc.equals(US_LOCALE) ? ',' : '.';

        return header + "\n" +

        Arrays.stream(entries)
        .sorted((o1, o2) -> (o1.change() == o2.change()) 
            ? o1.localDate().compareTo(o2.localDate()) 
            : Double.compare(o1.change(), o2.change()))
        .map((e) -> {
            // Date
            String date = e.localDate().format(DateTimeFormatter.ofPattern(datPat));

            // Descritpion
            String desc = e.description();
            if (desc.length() > 25) {
                desc = desc.substring(0, 22);
                desc = desc + "...";
            }

            // Change
            DecimalFormat formatter = null;

            if (loc.equals(NL_LOCALE)) { 
                formatter = new DecimalFormat(curSymb + " #,##0.00 ;" + curSymb + " -#,##0.00 ");
            } else {
                formatter = new DecimalFormat(curSymb + "#,##0.00 ;(" + curSymb + "#,##0.00)");
            } 

            DecimalFormatSymbols symbols = formatter.getDecimalFormatSymbols();
            symbols.setDecimalSeparator(decSep);
            symbols.setGroupingSeparator(thSep);
            formatter.setDecimalFormatSymbols(symbols);

            String amount = formatter.format(e.change() / 100);

            return String.format("%s | %-25s | %13s", date, desc, amount);

        }).collect(Collectors.joining("\n"));

    }

    public record LedgerEntry (LocalDate localDate, String description, double change) {
    }

}
