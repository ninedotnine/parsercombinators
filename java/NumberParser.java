import java.text.StringCharacterIterator;
public class NumberParser implements Parser {
    public String parse(StringCharacterIterator input) {
        char ch = input.current();
        if (! Character.isDigit(ch)) {
            return null;
        }
        input.next();
        String result =  "" + ch;
        ch = input.current();
        while (Character.isDigit(ch)) {
            result =  result + ch;
            ch = input.next();
        }
        return result;
    }
}
