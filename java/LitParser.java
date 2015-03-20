import java.text.StringCharacterIterator;
public class LitParser implements Parser {
    private char ch;

    public LitParser(char ch) {
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
