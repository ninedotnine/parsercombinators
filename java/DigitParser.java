import java.text.StringCharacterIterator;
public class DigitParser implements Parser {
    public String parse(StringCharacterIterator input) {
        char ch = input.current();
        if (Character.isDigit(ch)) {
            input.next();
            return "" + ch;
        }
        return null;
    }
}
