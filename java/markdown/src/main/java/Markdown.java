import java.util.Arrays;
import java.util.stream.Collectors;

class Markdown {

    String parse(String markdown) {
        return Arrays.stream(markdown.split("\\n"))
                .map(this::parseLine)
                .collect(Collectors.joining())
                .replaceAll("</ul><ul>", "");
    }

    private String parseLine(String line) {
        if (line.matches("^#{1,6}\\s.*")) {
            return parseHeader(line);
        }

        String result = parseBoldAndItalics(line);

        if (result.startsWith("*")) {
            return parseListItem(result);
        }

        return parseParagraph(result);
    }

    private String parseHeader(String markdown) {
        int count = markdown.split("\\s")[0].length();
        return "<h" + count + ">" + markdown.substring(count + 1) + "</h" + count + ">";
    }

    private String parseListItem(String markdown) {
        return "<ul><li>" + markdown.substring(2) + "</li></ul>";
    }

    private String parseParagraph(String markdown) {
        return "<p>" + markdown + "</p>";
    }

    private String parseBoldAndItalics(String markdown) {
        return markdown.replaceAll("__(.+)__", "<strong>$1</strong>")
                .replaceAll("_(.*)_", "<em>$1</em>");
    }
}
