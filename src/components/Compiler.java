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
                break;
            case DATA:
                System.out.println(Integer.toString(labeledToken.getData()));
                machineCode[1] = labeledToken.getData();
                break;
            case DVD:
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
                break;
            case LDR:
                // Apply register, index register, indirect bit, and address to the instruction
                instruction |= labeledToken.getRegister() << 8;
                instruction |= labeledToken.getIndexRegister() << 7;
                instruction |= 1 << 5;
                
                // APPLY ONLY 6 BITS FROM THE ADDRESS
                instruction |= labeledToken.getAddress() & 0b111111;
                machineCode[1] = instruction;
                break;
            case LDX:
                break;
            case LOC:
                break;
            case MLT:
                break;
            case NOT:
                break;
            case ORR:
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
                break;
            case STX:
                break;
            case TRP:
                break;
            case TRR:
                break;
            default:
                break;

        }

        System.out.println("Instruction: " + String.format("%16s", Integer.toBinaryString(instruction)).replace(" ", "0"));

        return machineCode;
    }
}
