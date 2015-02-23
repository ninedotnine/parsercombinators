#!/usr/bin/python3
failure = False
position = 0
input_string = "abcdefghhhhhh[9]"

def getch():
    """gets the character at the current position"""
    return input_string[position]

def adv():
    """advances the position in the input by one character"""
    global position
    position += 1

def getpos():
    """gets the current position in the input stream"""
    return position

def setpos(x):
    """sets the current position in the input stream"""
    global position
    position = x

def a():
    """returns 'a' and advances the input stream if the current character
        matches 'a'
        otherwise returns failure and does not advance input stream"""
    if getch() == 'a':
        adv()
        return 'a'
    else:
        return failure

def b():
    if getch() == 'b':
        adv()
        return 'b'
    else:
        return failure
    """returns 'b' and advances the input stream if the current character
        matches 'b'
        otherwise returns failure and does not advance input stream"""

def lit(ch): 
    """returns a function that: 
        returns ch and advances the input stream if the current character
        matches ch
        otherwise returns failure and does not advance input stream"""
    def func():
        ch2 = getch()
        if ch == ch2:
            adv()
            return ch
        else:
            return failure
    return func

def pcOr(parser0, parser1):
    """returns a function that:
        takes two parsers, runs the first one on the input stream.
        if that parser returns failure, 
            we run the second and return the result"""
    def func():
        res0 = parser0()
        if res0 != failure:
            return res0
        res1 = parser1()
        if res1 != failure:
            return res1
        return failure
    return func

def pcAnd(parser0, parser1):
    """returns a function that:
        takes two parsers, runs both on the input stream.
        if either parser returns failure, 
            return failure without advancing the input stream.
        otherwise return a list containing both results"""
    def func():
        pos = getpos()
        res0 = parser0()
        if res0 == failure:
            setpos(pos)
            return failure
        res1 = parser1()
        if res1 == failure:
            setpos(pos)
            return failure
        return [res0, res1]
    return func

def pcMany(parser):
    """returns a function that:
        takes one parser and runs it on the input stream.
        if the parser returns failure, 
            return failure without advancing the input stream.
        otherwise run the parser again until it returns failure, 
        then return a list containing all results"""
    def func():
        res = parser()
        if res == failure:
            return failure
        results = [res]
        while True:
            res = parser()
            if res == failure:
                return results
            results.append(res)
    return func

def pcBetween(parser1, parser2, parser3):
    """returns a function that:
        takes three parsers and runs all of them on the input stream.
        if any parser returns failure, 
            return failure without advancing the input stream.
        otherwise return the return value of the middle parser"""
    def func():
        start = parser1()
        if start == failure:
            return failure
        result = parser2()
        if result == failure:
            return failure
        end = parser3()
        if end == failure:
            return failure
        return result
    return func

def pcApply(f, parser):
    """returns a function that:
        takes one function and one parser 
        and runs the parser on the input stream.
        if the parser returns failure, 
            return failure without advancing the input stream.
        otherwise return the result of applying the function to
            the return value of the middle parser"""
    def func():
        res = parser()
        if res == failure:
            return failure
        else:
            return f(res)
    return func

def main():
    # for testing and demo purposes
    parser = a
    print(parser())
    print(b())
    parser = lit('c')
    print(parser())
    parser = lit('d')
    print(parser())
    parser1 = lit('e')
    parser2 = lit('q')
    parser = pcOr(parser1, parser2)
    print(parser())
    parser1 = lit('f')
    parser2 = lit('g')
    parser = pcAnd(parser1, parser2)
    print(parser())
    parser1 = lit('h')
    parser = pcMany(parser1)
    print(parser())
    parser1 = lit('[')
    parser2 = lit('9')
    parser3 = lit(']')
    parser = pcBetween(parser1, parser2, parser3)
    print(parser())

if __name__ == '__main__':
    main()
