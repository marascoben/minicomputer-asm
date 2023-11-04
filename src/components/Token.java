package components;

import java.util.Map;

public class Token {

    private String token;

    private String[] lexemes;

    private int lineNo;

    public Token(String token, int lineNo) {
        this.token = token.trim();
        this.lineNo = lineNo;

        // Parse the token into lexemes, removing any whitespace or commas
        this.lexemes = this.token.split("[\\s,]+");
        for (int i = 0; i < lexemes.length; i++) {
            lexemes[i] = lexemes[i].trim();
        }
    }

    public Token applyLabels(Map<String, Character> labelMap) {
        for (int i = 1; i < lexemes.length; i++) {
            if (labelMap.containsKey(lexemes[i].trim())) {
                lexemes[i] = Integer.toString(labelMap.get(lexemes[i]));
            }
        }

        return this;
    }

    public String getToken() {
        return token;
    }

    public int getLineNo() {
        return lineNo;
    }

    /**
     * Check if the token is a label.
     * 
     * @return True if the token is a label, false otherwise
     */
    public boolean isLabel() {
        if (lexemes.length > 0) {
            return lexemes[0].endsWith(":");
        } else {
            return false;
        }
    }

    public boolean isComment() {
        return token.startsWith(";");
    }

    /**
     * Gets the first lexeme of the token.
     * 
     * @return The first lexeme of the token
     */
    public String first() {
        if (lexemes[0] == null) {
            return "";
        } else {
            return lexemes[0].trim();
        }
    }

    /**
     * Gets the label of the token, assuming the token is a label. Otherwise
     * returns null.
     * 
     * @return The label of the token, or null if the token is not a label.
     */
    public String getLabel() {
        if (isLabel()) {
            return first().replace(':', ' ').trim();
        } else {
            return null;
        }
    }

    /**
     * Gets the keyword of the token, assuming the first lexeme is a keyword.
     * Otherwise
     * returns null.
     * 
     * @return The keyword of the token, or null if the first lexeme is not a
     *         keyword.
     */
    public Keyword toKeyword() {
        try {
            return Keyword.valueOf(first().toUpperCase());
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Gets the memory address set by LOC if the token is a LOC command.
     * 
     * @return The memory address set by LOC, or 0 if the token is not a LOC.
     */
    public int getLocation() {
        if (lexemes.length > 1) {
            return Integer.parseInt(lexemes[1]);
        } else {
            return 0;
        }
    }

    /**
     * Gets the data set by DATA if the token is a DATA command.
     * 
     * @return The data set by DATA, or 0 if the token is not a DATA.
     */
    public char getData() {
        if (lexemes.length > 1) {
            return (char) Integer.parseInt(lexemes[1]);
        } else {
            return 0;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(" + lineNo + ") ");

        for (String lexeme : lexemes) {
            sb.append("(" + lexeme + ") ");
        }

        return sb.toString().trim();
    }

}
