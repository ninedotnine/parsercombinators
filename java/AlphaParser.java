/*
 * parses a letter, regardless of case
 */

import java.text.StringCharacterIterator;
import java.util.*;
public class AlphaParser implements Parser {
    private final Parser p = new OrParser(
        new LowerAlphaParser(),
        new UpperAlphaParser());

    public String parse(StringCharacterIterator input) {
        return p.parse(input);
    }
}
