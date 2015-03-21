/*
 * a Parser is a function that takes an input stream and tries to parse it
 * if successful, it returns the parsed string and advances the stream
 * otherwise, it returns null and *does not* advance the stream
 */
import java.text.StringCharacterIterator;

public interface Parser {
    String parse(StringCharacterIterator input);
}
