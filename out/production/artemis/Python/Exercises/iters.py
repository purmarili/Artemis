from functools import reduce


def met(x, y, *elems):
    # return x + y + [i for i in elems]
    for i in elems:
        print(i)


def reduce_fun(fun, lst, base=0):
    if len(lst) == 2:
        return fun(lst[0], lst[1])
    return base + fun(lst[0], lst[1]) + reduce_fun(fun, lst[2:], base)


def ragaca(x):
    res = []
    for i in range(1, x + 1):
        if x % i == 0:
            res.append(i)
    return x, res


if __name__ == '__main__':
    # print(dict(map(lambda x: ragaca(x), [1, 2, 3, 4])))
    # lst = ["hello", "nika", "giorgi", "asd", "b"]
    # print(dict(map(lambda x: (x, [i for i in x]), lst)))
    # print(len(list(filter(lambda x: x % 2 == 1, numbers))))
    numbers = [5, 2, 3, 4, 5, 6, 7]
    print(reduce(lambda count, x: count + (1 if x % 2 == 1 else 0), numbers, 0))
    # print(reduce(lambda x,y: x + 1, filter(lambda x: x % 2 == 1, numbers), 0))
    # print(reduce(lambda x,y: x+y, filter(lambda x: x % 2 == 1, numbers), 0))
    # t = [i for i in range(10)]
    # print(t)
    # print(i for i in range(1,6))

    # met(1,2,3,4,5,6,7)
    #
    # print(reduce_fun(lambda x, y: x + y, [1, 2, 3, 4, 5, 6]))
    # a = [1, 2, 3, 4, 5, 6]
    # b = [5, 6 ,7, 4, "hello"]
    # z = zip(a,b)
    # print([i for i in z])
