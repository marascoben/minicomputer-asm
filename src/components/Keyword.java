package components;

public enum Keyword {
    LOC     ((byte) 0xb00000), // Location
    DATA    ((byte) 0xb00000), // Set value
    HLT     ((byte) 0xb00000), //  Halt
    LDR     ((byte) 0b000001), // Load register from memory
    STR     ((byte) 0b000010), // Store register to memory
    LDA     ((byte) 0b000011), // Load register with address
    LDX     ((byte) 0b100001), // Load index register from memory
    STX     ((byte) 0b100010), // Store index register to memory
    JZ      ((byte) 0xb00000), // Jump if zero
    JNE     ((byte) 0xb00000), // Jump if not zero
    JCC     ((byte) 0xb00000), // Jump if condition code
    JMA     ((byte) 0xb00000), // Jump always
    JSR     ((byte) 0xb00000), // Jump to subroutine
    RFS     ((byte) 0xb00000), // Return from subroutine
    SOB     ((byte) 0xb00000), // Subtract one and branch
    JGE     ((byte) 0xb00000), // Jump if greater than or equal to
    AMR     ((byte) 0xb00000), // Add memory to register
    SMR     ((byte) 0xb00000), // Subtract memory from register
    AIR     ((byte) 0xb00000), // Add immediate to register
    SIR     ((byte) 0xb00000), // Subtract immediate from register
    MLT     ((byte) 0xb00000), // Multiply register by register
    DVD     ((byte) 0xb00000), // Divide register by register
    TRR     ((byte) 0xb00000), // Test the equality of two registers
    AND     ((byte) 0xb00000), // Logical AND of register and register
    ORR     ((byte) 0xb00000), // Logical OR of register and register
    NOT     ((byte) 0xb00000), // Logical NOT of register and register
    TRP     ((byte) 0xb00000); // Trap

    // The opcode of the instruction
    public final byte opcode;

    private Keyword(byte opcode) {
        this.opcode = opcode;
    }

}
