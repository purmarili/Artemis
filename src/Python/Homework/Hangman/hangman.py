from random import randint  # Do not delete this line


def getString(word):
    paintings = {'welcome': [0, 24], 'lost': (100, 113), 'won': (191, 203), 5: (24, 33), 4: (37, 46), 3: (50, 59),
                 2: (63, 72), 1: (76, 85), 0: (89, 98)}

    start = paintings[word][0]
    stop = paintings[word][1]
    with open("hangman-ascii.txt", "r") as f:
        lines = f.readlines()
        for i, line in enumerate(lines[start:stop]):
            print(line[:-1])


def displayIntro():
    getString('welcome')


def displayEnd(result):
    getString(result)


def displayHangman(state):
    getString(state)


def getWord():
    with open("hangman-words.txt", "r") as f:
        lines = f.readlines()
    ind = randint(0, len(lines))
    return lines[ind][:-1]


def valid(c):
    if len(c) == 1 and c.isalpha():
        return True
    return False


def changeWord(word, change, c):
    st = ""
    for i in range(len(change)):
        if word[i] == c:
            st += c
        elif change[i] == '_':
            st += '_'
        else:
            st += change[i]
    return st


def play():
    word = getWord()
    guess = ""
    for i in range(len(word)):
        guess += '_'
    print(word, guess)
    lives = 5
    while lives > 0:
        displayHangman(lives)
        print("Guess the word: " + guess)
        print("Enter the letter: ")
        c = input()
        if not valid(c):
            continue
        if word.__contains__(c):
            guess = changeWord(word, guess, c[0])
            if not guess.__contains__('_'):
                print("Hidden word was: " + word)
                return True
        else:
            lives -= 1
            continue
    displayHangman(0)
    print("Hidden word was:" + word)
    return False


def hangman():
    while True:
        displayIntro()
        result = play()
        if result:
            displayEnd('won')
        else:
            displayEnd('lost')
        print("Do you want to play again? (yes/no)")
        s = input()
        while not s == 'yes' and not s == 'no':
            print("Invalid input, Please input only 'yes', 'no'")
            s = input()
        if s == 'yes':
            continue
        if s == 'no':
            break


if __name__ == "__main__":
    hangman()
