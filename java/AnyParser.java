/* 
 * this parser applies the provided parser zero or more times
 * returns empty string if it can't parse any instances of it
 * i.e. this parser should never return null!
 */

import java.text.StringCharacterIterator;
public class AnyParser implements Parser {
    private Parser p;

    public AnyParser(Parser p) {
        this.p = p;
    }

    public String parse(StringCharacterIterator input) {
        String str = "";
        String str2;
        while ((str2 = p.parse(input)) != null) {
            str = str + str2;
        }
        return str;
    }
}
