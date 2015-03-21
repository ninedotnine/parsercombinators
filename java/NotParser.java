/* 
 * this parser succeeds with empty string when the provided parser fails
 * otherwise returns null
 * is this useful? shrug
 */

import java.text.StringCharacterIterator;
public class NotParser implements Parser {
    private Parser p;

    public NotParser(Parser p) {
        this.p = p;
    }

    public String parse(StringCharacterIterator input) {
        if (p.parse(input) == null) {
            return "";
        } else {
            return null;
        }
    }
}
