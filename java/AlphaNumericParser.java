import java.text.StringCharacterIterator;
import java.util.*;
public class AlphaNumericParser implements Parser {
    public String parse(StringCharacterIterator input) {
        Parser p = new OrParser(new AlphaParser(), new DigitParser());
        return p.parse(input);
    }
}
