package components;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import io.InstructionWriter;

public class Assembler {

    public Assembler() {
    }

    public void run(File input, File output) throws Exception {
        Parser parser = new Parser();

        char loc = (char) 0;

        Compiler compiler = new Compiler(parser.findLabels(input));

        InstructionWriter writer = new InstructionWriter(output);

        BufferedReader reader = new BufferedReader(new FileReader(input));
        String line = reader.readLine();

        for (int lineNo = 1; line != null; lineNo++) {
            Token token = new Token(line, lineNo);

            // Do nothing if the line is a comment or a label
            if (token.isLabel() || token.isComment()) {
                line = reader.readLine();
                continue;
            }

            // Set the location if the line is a location directive
            if (token.toKeyword() == Keyword.LOC) {
                loc = (char) token.getLocation();
                line = reader.readLine();
                continue;
            }

            char[] machineCode = compiler.translate(token, loc, token.toKeyword());

            if (machineCode != null) {
                writer.write(machineCode[0], machineCode[1]);
            }

            loc++;
            line = reader.readLine();
        }

        writer.close();
        reader.close();
    }

}
