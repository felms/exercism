import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class GrepTool {

    public String grep(String pattern, List<String> flags, List<String> files) {
        StringBuilder sb = new StringBuilder();

        for (String fileName : files) {
            try {
                Scanner scanner = new Scanner(new File(fileName));
                int lineNumber = 1;
                while(scanner.hasNext()) {
                    String line = scanner.nextLine();
                    String searchedString = line;
                    String match = "";

                    if (flags.contains("-i")) {
                        searchedString = searchedString.toLowerCase();
                        pattern = pattern.toLowerCase();
                    }

                    if (flags.contains("-v")) {
                        if (flags.contains("-x") && !searchedString.equals(pattern)) {
                            match = line + "\n";
                        } else if (!searchedString.contains(pattern)) {
                            match = line + "\n";
                        }
                    } else {
                        if (flags.contains("-x") && searchedString.equals(pattern)) {
                            if (flags.contains("-l")) {
                                match = fileName + "\n";
                            } else if (flags.contains("-n")) {
                                match = String.format("%d:%s\n", lineNumber, line);
                            } else {
                                match = line + "\n";
                            }
                        } else if (!flags.contains("-x") && searchedString.contains(pattern)) {
                            if (flags.contains("-l")) {
                                match = fileName + "\n";
                            } else if (flags.contains("-n")) {
                                match = String.format("%d:%s\n", lineNumber, line);
                            } else  {
                                match = line + "\n";
                            }
                        }
                    }

                    String prefix = match.length() > 0 && files.size() > 1 && !flags.contains("-l")
                            ? fileName + ":" : "";
                    String m = prefix + match;

                    if (!sb.toString().contains(m)) {
                        sb.append(m);
                    }
                    lineNumber++;
                }

                scanner.close();

            } catch (FileNotFoundException fnfe) {
                fnfe.printStackTrace();
            }
        }

        return sb.toString().trim();
    }
}