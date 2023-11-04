package io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class InstructionWriter {

    private File file;

    private final FileWriter writer;

    public InstructionWriter(File file) throws IOException {
        this.file = file;
        this.writer = new FileWriter(file, false);
    }

    public void close() throws IOException {
        writer.close();
    }

    public void write(char location, char instruction) {
        try {
            writer.write(String.format("%04X %04X\n", (int) location, (int) instruction));
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
