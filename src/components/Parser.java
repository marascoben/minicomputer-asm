package components;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Parser {

    public Parser() {
    }

    public Map<String, Character> findLabels(File file) throws Exception {
        Map<String, Character> labelMap = new HashMap<String, Character>();

        // Current location in memory
        char loc = (char) 0;

        // Current line in file
        int lineNo = 1;

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();

        while (line != null) {
            Token token = new Token(line, lineNo);

            if (token.isLabel()) {
                System.out.println(token);
                labelMap.put(token.first(), loc);
            } else if (token.toKeyword() == Keyword.LOC) {
                loc = (char) token.getLocation();
            } else if (!token.isComment()) {
                loc++;
            }

            lineNo++;
            line = reader.readLine();
        }

        reader.close();

        return labelMap;
    }

    /**
     * Tokenizes a line of assembly code into the individual components
     * 
     * @param line The line of assembly code to tokenize
     * @return An array of tokens
     */
    public String[] tokenize(String line) {
        return line.trim().split("[\\s,]+");
    }

}