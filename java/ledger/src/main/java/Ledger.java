import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Ledger {
    public LedgerEntry createLedgerEntry(String d, String desc, double c) {
        return new LedgerEntry(LocalDate.parse(d), desc, c);
    }

    public String format(String cur, String loc, LedgerEntry[] entries) {

        if (!cur.equals("USD") && !cur.equals("EUR")) {
            throw new IllegalArgumentException("Invalid currency");
        }

        if (!loc.equals("en-US") && !loc.equals("nl-NL")) {
            throw new IllegalArgumentException("Invalid locale");
        }

        Metadata metadata = getMetadata(loc, cur);

        return metadata.header + Arrays.stream(entries)
                .sorted(Comparator.comparing(LedgerEntry::localDate)
                        .thenComparing(LedgerEntry::description)
                        .thenComparing(LedgerEntry::change))
                .map(ledgerEntry -> formatEntry(ledgerEntry, metadata))
                .collect(Collectors.joining());
    }

    private static String formatEntry(LedgerEntry ledgerEntry, Metadata metadata) {

        String date = ledgerEntry.localDate().format(DateTimeFormatter.ofPattern(metadata.datPat));

        String desc = ledgerEntry.description();
        if (desc.length() > 25) {
            desc = desc.substring(0, 22);
            desc = desc + "...";
        }

        String amount = formatAmount(ledgerEntry, metadata);

        return String.format("\n%s | %-25s | %13s", date, desc, amount);
    }

    private static String formatAmount(LedgerEntry e, Metadata metadata) {
        String converted = String.format("%.02f", Math.abs(e.change()));

        String[] parts = converted.split("\\.");
        StringBuilder amount = new StringBuilder();
        int count = 1;
        for (int ind = parts[0].length() - 1; ind >= 0; ind--) {
            if (((count % 3) == 0) && ind > 0) {
                amount.insert(0, metadata.thSep + parts[0].charAt(ind));
            } else {
                amount.insert(0, parts[0].charAt(ind));
            }
            count++;
        }

        amount = new StringBuilder(metadata.curSymb + amount + metadata.decSep + parts[1]);

        if (e.change() < 0) {
            amount.insert(0, "-");
        }
        return amount.toString();
    }

    private Metadata getMetadata (String loc, String cur) {
        String curSymb;
        if (cur.equals("USD")) {
            curSymb = "$";
        } else {
            curSymb = "€";
        }

        switch (loc) {
            case "en-US":
                return new Metadata("Date       | Description               | Change       ",
                        "MM/dd/yyyy", ".",  ",", curSymb);
            case "nl-NL":
                return new Metadata("Datum      | Omschrijving              | Verandering  ",
                        "dd/MM/yyyy", ",", ".", curSymb);
        }

        throw new IllegalArgumentException("Invalid locale");
    }

    record Metadata (String header, String datPat, String decSep, String thSep, String curSymb){}

    record LedgerEntry (LocalDate localDate, String description, double change) {}

}
