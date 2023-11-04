package components;

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
            return lexemes[0];
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
            return lexemes[0].substring(0, lexemes[0].length() - 1);
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

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(" + lineNo + ") ");

        for (String lexeme : lexemes) {
            sb.append("(" + lexeme + ") ");
        }

        return sb.toString().trim();
    }

}
