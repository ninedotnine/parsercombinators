/* 
 * this parser skips over input until the provided parser succeeds
 * returns all the stuff skipped concatenated to the result of the parser
 * this parser should never return null! (excluding EOF or something.)
 * this is useful for implementing comments, for example
 */

import java.text.StringCharacterIterator;
public class SkipToParser implements Parser {
    private Parser p;

    public SkipToParser(Parser p) {
        this.p = p;
    }

    public String parse(StringCharacterIterator input) {
        String skipping = "";
        String end;
        while ((end = p.parse(input)) == null) {
            skipping += input.current();
            input.next();
        }
        return skipping + end;
    }
}
