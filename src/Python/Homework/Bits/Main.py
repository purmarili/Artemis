# 5 = (1 * 2^2) + (0 * 2^1) + (1 * 2^0)
# 101
# [1] - Bit
# [][][][][][][][] - Byte
# 1024 * Byte - Kilobyte
# 1024 * kilobyte - Megabyte
# 1024 * Megabyte - Gegabyte

def isSecondBitOn(n, exp=2):
    i = 1 << exp

    if ((n & i) == (2 ** (exp))):
        return True
    else:
        return False


if __name__ == '__main__':
    print(2 ** 3)
    print(isSecondBitOn(9, 3))
