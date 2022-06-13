class Markdown {

    String parse(String markdown) {
        String[] lines = markdown.split("\n");
        String result = "";
        boolean activeList = false;

        for (int i = 0; i < lines.length; i++) {

            String theLine = parseHeader(lines[i]);

            if (theLine == null) {
              theLine = parseListItem(lines[i]);
            }

            if (theLine == null) {
                theLine = parseParagraph(lines[i]);
            }

            if (theLine.matches("(<li>).*") 
                    && !theLine.matches("(<h).*") 
                    && !theLine.matches("(<p>).*") 
                    && !activeList) {
                activeList = true;
                result = result + "<ul>";
                result = result + theLine;
            } else if (!theLine.matches("(<li>).*") 
                                                && activeList) {
                activeList = false;
                result = result + "</ul>";
                result = result + theLine;
            } else {
              result = result + theLine;
            }
        }

        if (activeList) {
            result = result + "</ul>";
        }

        return result;
    }

    private String parseHeader(String markdown) {
        
        if (!markdown.matches("#+.+")) {
            return null;
        }

        int count = 0;

        while (count < markdown.length() 
                    && markdown.charAt(count) == '#') {
            count++;
        }

        return "<h" + Integer.toString(count) + ">" 
                    + markdown.substring(count + 1) 
                    + "</h" + Integer.toString(count)+ ">";
    }

    private String parseListItem(String markdown) {
        
        if (!markdown.startsWith("*")) {
            return null;
        }

        String skipAsterisk = markdown.substring(2);
        String listItemString = parseInlineSymbols(skipAsterisk);
        return "<li>" + listItemString + "</li>";
    }

    private String parseParagraph(String markdown) {
        return "<p>" + parseInlineSymbols(markdown) + "</p>";
    }

    private String parseInlineSymbols(String markdown) {

        String lookingFor = "__(.+)__";
        String update = "<strong>$1</strong>";
        String workingOn = markdown.replaceAll(lookingFor, update);

        lookingFor = "_(.+)_";
        update = "<em>$1</em>";
        return workingOn.replaceAll(lookingFor, update);
    }
}
