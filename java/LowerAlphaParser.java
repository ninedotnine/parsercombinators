/*
 * parses a lowercase letter
 */

import java.text.StringCharacterIterator;
import java.util.*;
public class LowerAlphaParser implements Parser {
    public String parse(StringCharacterIterator input) {
        char ch = input.current();
        if (Character.isLowerCase(ch)) {
            input.next();
            return "" + ch;
        }
        return null;
    }
}
