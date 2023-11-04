package components;

public enum Keyword {
    LOC,    // Location
    DATA,   // Set value
    HLT,    // Halt
    LDR,    // Load register from memory
    STR,    // Store register to memory
    LDA,    // Load register with address
    LDX,    // Load index register from memory
    STX,    // Store index register to memory
    JZ,     // Jump if zero
    JNE,    // Jump if not zero
    JCC,    // Jump if condition code
    JMA,    // Jump always
    JSR,    // Jump to subroutine
    RFS,    // Return from subroutine
    SOB,    // Subtract one and branch
    JGE,    // Jump if greater than or equal to
    AMR,    // Add memory to register
    SMR,    // Subtract memory from register
    AIR,    // Add immediate to register
    SIR,    // Subtract immediate from register
    MLT,    // Multiply register by register
    DVD,    // Divide register by register
    TRR,    // Test the equality of two registers
    AND,    // Logical AND of register and register
    ORR,    // Logical OR of register and register
    NOT,    // Logical NOT of register and register
    TRP     // Trap
}
