import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SgfParsing {

    public SgfNode parse(String input) throws SgfParsingException {

        if (input.equals("")) {
            throw new SgfParsingException("tree missing");
        }

        String n = input.replaceAll("^\\(|\\)$", "");
        if (n.equals("")) {
            throw new SgfParsingException("tree with no nodes");
        }

        if (n.length() == input.length()) {
            throw new SgfParsingException("tree missing");
        }

        List<String> characters = Arrays.stream(n.split(""))
                .collect(Collectors.toList());

        SgfNode rootNode = this.getNode(characters);

        while(!characters.isEmpty()) {
            rootNode.appendChild(this.getNode(characters));
        }

        return rootNode;
    }

    private SgfNode getNode(List<String> input) throws SgfParsingException {

        input.remove(0);
        SgfNode node = new SgfNode();

        Map<String, List<String>> properties = new HashMap<>();
        while (!input.isEmpty() && !input.get(0).equals(";")) {

            String key = this.getKey(input);

            if (input.isEmpty()) {
                throw new SgfParsingException("properties without delimiter");
            }
            List<String> values = new ArrayList<>();

            while (!input.isEmpty() && !input.get(0).equals(";")) {

                if (input.get(0).equals(")")) {
                    input.remove(0);
                    break;
                }

                values.addAll(this.getValues(input));

                if (!input.isEmpty() && !input.get(0).equals("[")
                        && !input.get(0).equals(";")) {

                    if (input.get(0).equals("(")) {
                        input.remove(0);
                        node.appendChild(this.getNode(input));
                    } else {
                        properties.put(key, values);
                        key = this.getKey(input);
                        values = new ArrayList<>();
                    }
                }

            }

            properties.put(key, values);

        }

        node.setProperties(properties);
        return node;
    }

    private String getKey(List<String> input) throws SgfParsingException {

        StringBuilder key = new StringBuilder();
        while(!input.isEmpty() && !input.get(0).equals("[")) {
            String s = input.remove(0);
            if (!s.toUpperCase().equals(s)) {
                throw new SgfParsingException("property must be in uppercase");
            }
            key.append(s);
        }

        return key.toString();
    }

    private List<String> getValues(List<String> input) {
        List<String> values = new ArrayList<>();
        if (input.get(0).equals("[")) {
            input.remove(0);
        }

        StringBuilder currentValue = new StringBuilder();
        do {
            String s = input.remove(0);
            if (s.equals("\\")) {
                s = input.remove(0);
            }
            currentValue.append(s);
        } while (!input.get(0).equals("]") && !input.get(0).equals(")"));

        while(!input.isEmpty() && (input.get(0).equals("]")
                || input.get(0).equals("(") || input.get(0).equals(")"))) {
            input.remove(0);
        }

        values.add(currentValue.toString());
        return values;
    }
}