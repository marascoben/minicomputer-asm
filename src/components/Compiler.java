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

        switch (keyword) {
            case AIR:
                break;
            case AMR:
                break;
            case AND:
                break;
            case DATA:
                break;
            case DVD:
                break;
            case HLT:
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

        return machineCode;
    }
}