package util;

public class ParserUtils {

    /**
     * Check if the given line of tokens is a label or not
     * 
     * @param tokens The line of tokens to check
     * @return True if the line is a label, false otherwise
     */
    public static boolean isLabel(String[] tokens) {
        if (tokens.length != 0) {
            return tokens[0].trim().endsWith(":");
        }

        return false;
    }

    /**
     * Get the label from the given line of tokens
     * 
     * @param tokens The line of tokens to get the label from
     * @return The label
     */
    public static String getLabel(String[] tokens) {
        return tokens[0].substring(0, tokens[0].length() - 1);
    }

}
