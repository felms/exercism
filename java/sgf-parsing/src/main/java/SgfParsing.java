import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SgfParsing {

    public SgfNode parse(String input) throws SgfParsingException {

        if (input.equals("") || !input.matches("^\\(.*\\)$")) {
            throw new SgfParsingException("tree missing");
        }

        String n = input.replaceAll("^\\(|\\)$", "");
        if (n.equals("")) {
            throw new SgfParsingException("tree with no nodes");
        }

        SgfNode rootNode = new SgfNode();

        List<String> characters = Arrays.stream(n.split(""))
                .collect(Collectors.toList());
        Map<String, List<String>> properties = new HashMap<>();
        while (!characters.isEmpty()) {

            if (characters.get(0).equals(";")) {
                characters.remove(0);

                if (!characters.isEmpty()) {
                    StringBuilder key = new StringBuilder();
                    while(!characters.isEmpty() && !characters.get(0).equals("[")) {
                        String s = characters.remove(0);
                        if (!s.toUpperCase().equals(s)) {
                            throw new SgfParsingException("property must be in uppercase");
                        }
                        key.append(s);
                    }

                    if (characters.isEmpty()) {
                        throw new SgfParsingException("properties without delimiter");
                    }
                    List<String> values = new ArrayList<>();

                    while (!characters.isEmpty() && !characters.get(0).equals(";")) {
                        if (characters.get(0).equals("[")) {
                            characters.remove(0);
                        }

                        StringBuilder currentValue = new StringBuilder();
                        do {
                            currentValue.append(characters.remove(0));
                        } while (!characters.get(0).equals("]"));
                        characters.remove(0);

                        values.add(currentValue.toString());

                        if (!characters.isEmpty() && !characters.get(0).equals("[")) {
                            properties.put(key.toString(), values);
                            key = new StringBuilder();
                            while(!characters.get(0).equals("[")) {
                                String s = characters.remove(0);
                                if (!s.toUpperCase().equals(s)) {
                                    throw new SgfParsingException("property must be in uppercase");
                                }
                                key.append(s);
                            }
                            values = new ArrayList<>();
                        }

                    }

                    properties.put(key.toString(), values);
                }

            }
        }

        rootNode.setProperties(properties);
        return rootNode;
    }
}