/* 
 * this parser skips over any spaces
 * it returns all the spaces skipped
 * this parser should never return null! (excluding EOF or something.)
 */

import java.text.StringCharacterIterator;
public class SkipSpacesParser implements Parser {
    private final Parser p = new AnyParser(
        new OrParser(
            new OrParser(
                new LitParser(' '),
                new LitParser('\n')),
            new OrParser(
                new LitParser('\t'),
                new LitParser('\r'))
        )
    );

    public SkipSpacesParser() {
    } // nothing to do

    public String parse(StringCharacterIterator input) {
        return p.parse(input);
    }
}
