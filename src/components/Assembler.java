package components;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Assembler {

    // Map of labels to their addresses
    public Map<String, Character> labelTable;

    public Assembler() {
        this.labelTable = new HashMap<String, Character>();
    }

    public void Assemble(File file) {
        Parser parser = new Parser();

        try {
            labelTable = parser.findLabels(file);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
