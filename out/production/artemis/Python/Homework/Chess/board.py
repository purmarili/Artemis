from pieces import *


class Board:

    def __init__(self):
        self.__pieces = []
        self.placePieces()

    def getPieces(self):
        return self.__pieces

    def placePieces(self):
        for i in range(8):
            self.__pieces.append([])
            for j in range(8):
                self.__pieces[i].append(None)
        for i in range(8):
            if i == 1 or i == 6:
                if i == 1:
                    for j in range(8):
                        self.__pieces[i][j] = Pawn("White", self, (chr(ord('A') + j), i + 1))
                if i == 6:
                    for j in range(8):
                        self.__pieces[i][j] = Pawn("Black", self, (chr(ord('A') + j), i + 1))

            elif i == 0 or i == 7:
                if i == 0:
                    for j in range(8):
                        if j == 0 or j == 7:
                            self.__pieces[i][j] = Rook("White", self, (chr(ord('A') + j), i + 1))
                        if j == 1 or j == 6:
                            self.__pieces[i][j] = Knight("White", self, (chr(ord('A') + j), i + 1))
                        if j == 2 or j == 5:
                            self.__pieces[i][j] = Bishop("White", self, (chr(ord('A') + j), i + 1))
                        if j == 3:
                            self.__pieces[i][j] = King("White", self, (chr(ord('A') + j), i + 1))
                        if j == 4:
                            self.__pieces[i][j] = Queen("White", self, (chr(ord('A') + j), i + 1))

                if i == 7:
                    for j in range(8):
                        if j == 0 or j == 7:
                            self.__pieces[i][j] = Rook("Black", self, (chr(ord('A') + j), i + 1))
                        if j == 1 or j == 6:
                            self.__pieces[i][j] = Knight("Black", self, (chr(ord('A') + j), i + 1))
                        if j == 2 or j == 5:
                            self.__pieces[i][j] = Bishop("Black", self, (chr(ord('A') + j), i + 1))
                        if j == 3:
                            self.__pieces[i][j] = King("Black", self, (chr(ord('A') + j), i + 1))
                        if j == 4:
                            self.__pieces[i][j] = Queen("Black", self, (chr(ord('A') + j), i + 1))
            else:
                for j in range(8):
                    self.__pieces[i][j] = None

    def setPiece(self, position, piece):
        self.__pieces[int(position[1]) - 1][ord(position[0]) - ord('A')] = piece

    def getPiece(self, position):
        return self.__pieces[position[1] - 1][ord(position[0]) - ord('A')]

    def makeMove(self, startPosition, endPosition, player):
        piece = self.getPiece(startPosition)
        if piece is None or piece.color != player:
            return False
        if piece.checkMove(endPosition):
            piece.move(endPosition)
            self.setPiece(endPosition, piece)
            self.setPiece(startPosition, None)
            return True
        return False

    def displayBoard(self):
        c = ord('A')
        print('   ({})({})({})({})({})({})({})({})'.format(chr(c), chr(c + 1), chr(c + 2), chr(c + 3), chr(c + 4),
                                                           chr(c + 5), chr(c + 6), chr(c + 7)))
        for i in range(8):
            print(f'({8 - i})', end='')
            for j in range(8):
                if self.__pieces[7 - i][j] is None:
                    print('[ ]', end='')
                else:
                    print(f'[{self.__pieces[7 - i][j].getIcon()}]', end='')
            print()
