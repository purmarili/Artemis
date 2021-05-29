class Test:
    def __init__(self, name):
        self.__name = name

    class Ineer:
        def __init__(self):
            self.n = 5


class Tst(Test):
    def info(self):
        return self._Test__name


if __name__ == '__main__':
    inner = Test.Ineer()
    print(inner.n)
    # t = Tst('hello')
    # print(t.info())
