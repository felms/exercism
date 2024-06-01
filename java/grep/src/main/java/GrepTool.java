import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class GrepTool {

    String grep(String pattern, List<String> flags, List<String> files) {
        boolean searchMultipleFiles = files.size() > 1;
        return files.stream().map(file -> searchFile(pattern, flags, file, searchMultipleFiles))
                .collect(Collectors.joining())
                .trim();
    }

    private String searchFile(String pattern, List<String> flags, String file, boolean searchMulipleFiles) {
        StringBuilder res = new StringBuilder();
        try (Scanner scanner = new Scanner(new File(file))){
            int index = 1;
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                boolean matchedLine = isMatchedLine(pattern, flags, line);

                if (matchedLine && flags.contains("-l")) {
                    return file + "\n";
                }
                if (matchedLine) {
                    if (searchMulipleFiles) {
                        res.append(file).append(":");
                    }
                    if (flags.contains("-n")){
                        res.append(index).append(":").append(line).append("\n");
                    }
                    else {
                        res.append(line).append("\n");
                    }
                }
                index++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return res.toString();
    }

    private boolean isMatchedLine(String pattern, List<String> flags, String line) {
        boolean matchedLine = false;
        String searchPattern = flags.contains("-x")
                ? "^" + pattern + "$"
                : ".*" + pattern + ".*";

        if (flags.contains("-i")) {
            String str = line.toLowerCase();
            String sp = searchPattern.toLowerCase();
            matchedLine =  str.matches(sp);
        }

        if ((line.matches(searchPattern) && !flags.contains("-v"))
                || (!line.matches(searchPattern) && flags.contains("-v"))) {
            matchedLine = true;
        }
        return matchedLine;
    }

}