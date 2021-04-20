""" I2C Midterm Exam 

* Solutions should be written in the appropriate functions.
* Helper functions can be defined if needed.
* Using class materials is allowed.
* Sharing solutions with others is considered as plagiarism!

"""

from itertools import *
from functools import *

""" Task #1 (3 points)
Write a function `tripleAverage` which takes 3 integers as arguments and 
returns their average.
Ex.:
1 2 2 -> 1.6666666666666667
2.5 3.2 9.1 -> 4.933333333333334
2 0.5 0.5 -> 1.0
"""


def tripleAverage(a, b, c):
    return float((a + b + c) / 3)


""" Task #2 (3 points)
Write a function `rangeList` which takes two integer arguments L and R and
returns list of numbers from L to R (both endpoints are included). If L is
greater than R return empty list.
Ex.:
1 5 -> [1,2,3,4,5]
6 7 -> [6,7]
5 5 -> [5]
4 3 -> []
-1 1 -> [-1,0,1]
"""


def rangeList(L, R):
    pass


""" Task #3 (3 points)
Write a function `leapYearCount` which takes one argument `start_year` and
countes how many leap years have occured since `start_year` until 2021.
(Both endpoints are included). 

Year is a leap year if it is divisible by 400 or if it is divisble by 4, but
not by 100.

For example: 2016 is a leap year as it is divisble by 4, but not by 100. 2021
is not a leap year as it is not divisble by 4. 1900 is not also a leap year
as it is divisible by 100 and by 4, but it is not divisible by 400. 2000 is a
leap year as it is divisible by 400.

Your function should return one number, how many leap years have occured
since the given start year. You should NOT return list of leap years.

Ex.:
2021 -> 0 (2021 is not a leap year)
2015 -> 2 (only 2016 and 2020 are leap years)
1899 -> 30
1121 -> 219
"""


def leapYearCount(start_year):
    pass


""" Task #4 (3 points)
Write a function `almostMax` which takes a list of numbers as an argument
and finds the second maximum in the list. The second maximum is a number
which is equal or greater than every number except the maximum.

For example, if the list is [1,2,3,4,5], maximum is 5 and the second maximum
is 4.

IF YOU USE `sorted` or `sort` FUNCTION YOU WILL GET ONLY 2 OUT OF 3 POINTS.

Ex.:
[1,2,3,4,5] -> 4
[2,-1,4] -> 2
[-3,4,2,4,1] -> 4
[1,5,2,1,3,3] -> 3
"""


def almostMax(lst):
    pass


""" Task #5 (4 points)
Write a function `oddCheck` which takes the list of numbers and checks if 
all odd numbers from that list are greater than 15.

You should solve the problem using HOFs: takewhile, dropwhile, zip, filter,
map, reduce, enumerate, any, all, sum, len.

YOU WILL GET 4 POINTS IF YOU SOLVE PROBLEM USING ONLY GIVEN HOFs. OTHERWISE
YOU WILL GET AT MOST 2 POINTS.

Ex.:
[2,17,12,21,101] -> True
[103] -> True
[15] -> False (15 is not greater than 15)
[20] -> True (There are no odd numbers)
[1, 2, 4, 21] -> False (1 is not greater than 15)
"""


def oddCheck(lst):
    return reduce(lambda x, y: x and y,
                  (map(lambda x: (True if x > 15 else False), filter(lambda x: x % 2 == 1, lst))), True)


print(oddCheck([2, 17, 21, 4]))

""" Task #6 (4 points)
Write a function `diagonalMatrixGenerator` which is given the number N as
an argument and creates NxN diagonal matrix, where first diagonal is filled
with 1s, second is filled 2s and so on. Diagonals are numbered from left
bottom corner to rigth top corner. Function should return list of lists
(matrix). See examples for clarification:

N = 1 -> 1

N = 2 -> 2 3
         1 2

N = 3 -> 3 4 5
         2 3 4
         1 2 3

N = 4 -> 4 5 6 7
         3 4 5 6 
         2 3 4 5  
         1 2 3 4

Ex.:
1 -> [[1]]
2 -> [[2,3],[1,2]]
3 -> [[3,4,5],[2,3,4],[1,2,3]]
4 -> [[4,5,6,7],[3,4,5,6],[2,3,4,5],[1,2,3,4]]
"""


def diagonalMatrixGenerator(N):
    res = []
    for i in range(N):
        r = []
        for j in range(N):
            r.append(N - i + j)
        res.append(r)

    for i in res:
        print(i)


diagonalMatrixGenerator(4)
