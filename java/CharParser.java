import java.text.StringCharacterIterator;
public class CharParser implements Parser {
    private char ch;

    public CharParser(char ch) {
        this.ch = ch;
    }

    public String parse(StringCharacterIterator input) {
        if (input.current() == ch) {
            input.next();
            return "" + ch;
        }
        return null;
    }
}
