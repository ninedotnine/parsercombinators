import java.text.StringCharacterIterator;
import java.util.*;
public class AlphaParser implements Parser {
    public String parse(StringCharacterIterator input) {
        char ch = input.current();
        if (Character.isLetter(ch)) {
            input.next();
            return "" + ch;
        }
        return null;
    }
}
