#!/usr/bin/python3
failure = False
position = 0
input_string = "abcdefghhhhhh[9]"

def getch():
    return input_string[position]

def adv():
    global position
    position += 1

def getpos():
    return position

def setpos(x):
    global position
    position = x

def a():
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

def lit(ch): 
    def func():
        ch2 = getch()
        if ch == ch2:
            adv()
            return ch
        else:
            return failure
    return func

def pcOr(parser0, parser1):
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
    def func():
        res = parser()
        if res == failure:
            return failure
        else:
            return f(res)
    return func

def main():
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
