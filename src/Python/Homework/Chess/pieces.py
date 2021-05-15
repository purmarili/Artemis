blackIcons = {"Pawn": "♙", "Rook": "♖", "Knight": "♘", "Bishop": "♗", "King": "♔", "Queen": "♕"}
whiteIcons = {"Pawn": "♟", "Rook": "♜", "Knight": "♞", "Bishop": "♝", "King": "♚", "Queen": "♛"}


class Piece:

    def __init__(self, color, board, position):
        self.__color = color
        self.__board = board
        self.__position = position

    @property
    def color(self):
        return self.__color

    @property
    def position(self):
        return self.__position

    @position.setter
    def position(self, position):
        self.__position = position

    def checkMove(self, dest):
        return False

    def move(self, dest):
        if self is Piece:
            return False
        self.__position = dest
        return True

    def getName(self):
        return type(self).__name__

    def getIcon(self):
        if self.color == "White":
            return whiteIcons[self.getName()]
        else:
            return blackIcons[self.getName()]

    def checkValidPos(self, dest):
        if dest[0] not in ('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'):
            return False
        if dest[1] not in (1, 2, 3, 4, 5, 6, 7, 8):
            return False
        return True

    def checkPiece(self, piece):
        if piece is None:
            return True
        if piece is King or piece.color == self.color:
            return False
        return True


class Knight(Piece):
    def checkMove(self, dest):
        if not self.checkValidPos(dest):
            return False
        piece = self.__board.getPiece(dest)
        move = [abs(dest[0] - self.position[0]), abs(dest[1] - self.position[1])]

        if not (move[0] == 1 and move[1] == 2 or move[0] == 2 and move[1] == 1):
            return False
        if not checkPiece(piece):
            return False
        return True


class Rook(Piece):
    def checkMove(self, dest):
        move = [dest[0] - position[0], dest[1] - position[1]]

        if move[0] == 0 or move[1] == 0:
            return True

        return False


class Bishop(Piece):
    def checkMove(self, dest):
        move = [abs(dest[0] - position[0]), abs(dest[1] - position[1])]

        if move[0] == move[1]:
            return True

        return False


class Queen(Piece):
    def checkMove(self, dest):
        move = [abs(dest[0] - position[0]), abs(dest[1] - position[1])]
        if move[0] == move[1] or move[0] == 0 or move[1] == 0:
            return True

        return False


class King(Piece):

    def checkMove(self, dest):
        move = [abs(dest[0] - position[0]), abs(dest[1] - position[1])]

        if move[0] <= 1 and move[1] <= 1:
            return True

        if move[0] == 0 and move[1] == 2:
            if self[1] == Player(1) and position == (0, 4) or self[1] == Player(2) and position == (7, 4):
                return True

        return False


class Pawn(Piece):

    def checkMove(self, dest):
        move = [dest[0] - self.position[0], dest[1] - position[1]]

        if self[1] == Player(1) and abs(move[1]) == move[0] == 1:
            return True

        if self[1] == Player(2) and abs(move[1]) == 1 and move[0] == -1:
            return True

        if self[1] == Player(1) and position[0] == 1 and move[1] == 0 and move[0] == 2:
            return True

        if self[1] == Player(2) and position[0] == 6 and move[1] == 0 and move[0] == -2:
            return True

        if self[1] == Player(1) and move[1] == 0 and move[0] == 1:
            return True

        if self[1] == Player(2) and move[1] == 0 and move[0] == -1:
            return True

        return False
