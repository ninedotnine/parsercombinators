/* 
 * this parser applies the provided parser one or more times
 * returns null if it can't parse any instances of it
 */
import java.text.StringCharacterIterator;
public class ManyParser implements Parser {
    private Parser p;

    public ManyParser(Parser p) {
        this.p = p;
    }

    public String parse(StringCharacterIterator input) {
        String first = p.parse(input);
        if (first == null) {
            return null;
        }
        Parser more = new AnyParser(p);
        String rest = more.parse(input);
        return first + rest;
    }
}
