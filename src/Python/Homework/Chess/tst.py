class Test:
    def __init__(self, name):
        self.__name = name


class Tst(Test):
    def info(self):
        return self._Test__name


if __name__ == '__main__':
    t = Tst('hello')
    print(t.info())