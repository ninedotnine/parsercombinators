import java.text.StringCharacterIterator;
import java.util.*;
public class UpperAlphaParser implements Parser {
    public String parse(StringCharacterIterator input) {
        char ch = input.current();
        if (Character.isUpperCase(ch)) {
            input.next();
            return "" + ch;
        }
        return null;
    }
}
