package components;

import java.util.Map;

public class Compiler {

    Map<String, Character> labelMap;

    public Compiler(Map<String, Character> labelMap) {
        this.labelMap = labelMap;
    }

    public char[] translate(Token token, char location, Keyword keyword) {
        if (keyword == null) {
            return null;
        }

        char[] machineCode = new char[2];
        machineCode[0] = location;

        Token labeledToken = token.applyLabels(labelMap);
        System.out.println(labeledToken);

        char instruction = (char) 0;

        // Apply the opcode to the instruction by left shifting it 10 bits
        instruction |= keyword.opcode << 10;
        machineCode[1] = instruction;

        switch (keyword) {
            case AIR:
                break;
            case AMR:
                break;
            case AND:
                // Apply two registers to the instruction specified in lexemes 1 and 2
                instruction |= labeledToken.getRegister() << 8;
                instruction |= labeledToken.getIndexRegister() << 6;

                machineCode[1] = instruction;
                break;
            case DATA:
                System.out.println(Integer.toString(labeledToken.getData()));
                machineCode[1] = labeledToken.getData();
                break;
            case DVD:
                // Apply two registers to the instruction specified in lexemes 1 and 2
                instruction |= labeledToken.getRegister() << 8;
                instruction |= labeledToken.getIndexRegister() << 6;

                machineCode[1] = instruction;
                break;
            case HLT:
                machineCode[1] = instruction;
                break;
            case JCC:
                break;
            case JGE:
                break;
            case JMA:
                break;
            case JNE:
                break;
            case JSR:
                break;
            case JZ:
                break;
            case LDA:
                // Apply register, index register, indirect bit, and address to the instruction
                instruction |= labeledToken.getRegister() << 8;
                instruction |= labeledToken.getIndexRegister() << 6;
                instruction |= 1 << 5;

                // APPLY ONLY 5 BITS FROM THE ADDRESS
                instruction |= labeledToken.getAddress() & 0b11111;

                machineCode[1] = instruction;
                break;
            case LDR:
                // Apply register, index register, indirect bit, and address to the instruction
                instruction |= labeledToken.getRegister() << 8;
                instruction |= labeledToken.getIndexRegister() << 6;
                instruction |= 1 << 5;

                // APPLY ONLY 5 BITS FROM THE ADDRESS
                instruction |= labeledToken.getAddress() & 0b11111;

                machineCode[1] = instruction;
                break;
            case LDX:
                // Apply index register, indirect bit, and address to the instruction, taking only 
                // two bits from the index register
                instruction |= labeledToken.getIndexRegister() << 6;
                instruction |= 1 << 5;

                // APPLY ONLY 5 BITS FROM THE ADDRESS
                instruction |= labeledToken.getAddress() & 0b11111;

                machineCode[1] = instruction;
                break;
            case LOC:
                break;
            case MLT:
                // Apply two registers to the instruction specified in lexemes 1 and 2
                instruction |= labeledToken.getRegister() << 8;
                instruction |= labeledToken.getIndexRegister() << 6;

                machineCode[1] = instruction;
                break;
            case NOT:
                // Apply two registers to the instruction specified in lexemes 1 and 2
                instruction |= labeledToken.getRegister() << 8;
                instruction |= labeledToken.getIndexRegister() << 6;

                machineCode[1] = instruction;
                break;
            case ORR:
                // Apply two registers to the instruction specified in lexemes 1 and 2
                instruction |= labeledToken.getRegister() << 8;
                instruction |= labeledToken.getIndexRegister() << 6;

                machineCode[1] = instruction;
                break;
            case RFS:
                break;
            case SIR:
                break;
            case SMR:
                break;
            case SOB:
                break;
            case STR:
                // Apply register, index register, indirect bit, and address to the instruction
                instruction |= labeledToken.getRegister() << 8;
                instruction |= labeledToken.getIndexRegister() << 6;
                instruction |= 1 << 5;

                // APPLY ONLY 5 BITS FROM THE ADDRESS
                instruction |= labeledToken.getAddress() & 0b11111;

                machineCode[1] = instruction;
                break;
            case STX:
                break;
            case TRP:
                break;
            case TRR:
                // Apply two registers to the instruction specified in lexemes 1 and 2
                instruction |= labeledToken.getRegister() << 8;
                instruction |= labeledToken.getIndexRegister() << 6;
                break;
            default:
                break;

        }

        System.out.println(
                "Instruction: " + String.format("%16s", Integer.toBinaryString(instruction)).replace(" ", "0"));

        return machineCode;
    }
}
