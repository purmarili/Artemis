from board import Board
from pieces import *


class Chess:
    def __init__(self):
        self.board = Board()
        self.currentPlayer = "White"

    def swapPlayers(self):
        if self.currentPlayer == "White":
            self.currentPlayer = "Black"
        else:
            self.currentPlayer = "White"

    def isStringValidMove(self, moveStr):
        if len(moveStr) != 5 or moveStr[2] != ' ':
            return False
        if moveStr[0] not in ('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'):
            return False
        if moveStr[3] not in ('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'):
            return False
        if int(moveStr[1]) not in (1, 2, 3, 4, 5, 6, 7, 8):
            return False
        if int(moveStr[4]) not in (1, 2, 3, 4, 5, 6, 7, 8):
            return False
        return True

    def play(self):
        inp = ''
        while True:
            self.board.displayBoard()
            while True:
                print(self.currentPlayer)
                print("Input 'EXIT' to finish the game.")
                inp = input("Please input your move: ")
                if inp == 'EXIT':
                    print("Thanks for playing")
                    return
                if not self.isStringValidMove(inp):
                    print("Invalid move")
                    continue
                startPosition = (inp[0], int(inp[1]))
                endPosition = (inp[3], int(inp[4]))
                if not self.board.makeMove(startPosition, endPosition, self.currentPlayer):
                    print("Invalid move")
                    continue
                if self.isPawnPromoted(endPosition, self.currentPlayer):
                    while True:
                        toChange = input("Input piece to revive:")
                        if toChange in ('Queen', 'Rook', 'Bishop', 'Knight'):
                            if toChange == 'Queen':
                                self.board.setPiece(endPosition, Queen(self.currentPlayer, self.board, endPosition))
                            if toChange == 'Rook':
                                self.board.setPiece(endPosition, Rook(self.currentPlayer, self.board, endPosition))
                            if toChange == 'Bishop':
                                self.board.setPiece(endPosition, Bishop(self.currentPlayer, self.board, endPosition))
                            if toChange == 'Knight':
                                self.board.setPiece(endPosition, Knight(self.currentPlayer, self.board, endPosition))
                            break
                        print("Invalid piece")
                self.swapPlayers()
                break

    def isPawnPromoted(self, endPosition, player):
        if player == "Black":
            if endPosition[1] == 1:
                if self.board.getPiece(endPosition) is Pawn:
                    return True
        else:
            if endPosition[1] == 8:
                if self.board.getPiece(endPosition) is Pawn:
                    return True
        return False


if __name__ == "__main__":
    game = Chess()
    game.play()
