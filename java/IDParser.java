/* 
 * this parser tries to match a legal java identifier
 * one lowercase letter, followed by zero or more letters, digits, or '_'
 */

import java.text.StringCharacterIterator;
public class IDParser implements Parser {
    private final Parser p = new AndParser(
        new LowerAlphaParser(),
        new AnyParser(
            new OrParser(
                new AlphaNumericParser(),
                new CharParser('_'))
            )
        );


    public IDParser() {
    } // nothing to do

    public String parse(StringCharacterIterator input) {
        String str = "";
        String str2;
        while ((str2 = p.parse(input)) != null) {
            str = str + str2;
        }
        return str;
    }
}
