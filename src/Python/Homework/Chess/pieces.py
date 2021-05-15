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

    def checkPiece(self, piece):
        if piece is None:
            return True
        if piece is King or piece.color == self.color:
            return False
        return True


class Knight(Piece):
    def checkMove(self, dest):
        move = [abs(ord(dest[0]) - ord(self.position[0])), abs(dest[1] - self.position[1])]

        if not (move[0] == 1 and move[1] == 2 or move[0] == 2 and move[1] == 1):
            return False
        piece = self._Piece__board.getPiece(dest)
        if not self.checkPiece(piece):
            return False
        return True


class Rook(Piece):
    def checkMove(self, dest):
        move = [abs(ord(dest[0]) - ord(self.position[0])), abs(dest[1] - self.position[1])]

        if not ((move[0] == 0 and move[1] != 0) or (move[0] != 0 and move[1] == 0)):
            return False
        piece = self._Piece__board.getPiece(dest)
        if not self.checkPiece(piece):
            return False
        return True


class Bishop(Piece):
    def checkMove(self, dest):
        move = [abs(ord(dest[0]) - ord(self.position[0])), abs(dest[1] - self.position[1])]

        if move[0] != move[1]:
            return False
        piece = self._Piece__board.getPiece(dest)
        if not self.checkPiece(piece):
            return False
        return True


class Queen(Piece):
    def checkMove(self, dest):
        move = [abs(ord(dest[0]) - ord(self.position[0])), abs(dest[1] - self.position[1])]

        if not (((move[0] == 0 and move[1] != 0) or (move[0] != 0 and move[1] == 0)) or (move[0] == move[1])):
            return False
        piece = self._Piece__board.getPiece(dest)
        if not self.checkPiece(piece):
            return False
        return True


class King(Piece):

    def checkMove(self, dest):
        move = [abs(ord(dest[0]) - ord(self.position[0])), abs(dest[1] - self.position[1])]

        if move[0] <= 1 and move[1] <= 1:
            return True

        if move[0] == 0 and move[1] == 2:
            if self[1] == Player(1) and position == (0, 4) or self[1] == Player(2) and position == (7, 4):
                return True

        return False


class Pawn(Piece):

    def checkMove(self, dest):
        move = [abs(ord(dest[0]) - ord(self.position[0])), abs(dest[1] - self.position[1])]

        if move[0] != 0 or move[1] > 2:
            return False

        if self.color == "White":
            if move[1] == 2:
                if not (self.position[1] == 2 and dest[1] > self.position[1]):
                    return False
            if move[1] == 1:
                if dest[1] <= self.position[1]:
                    return False
        else:
            if move[1] == 2:
                if not (self.position[1] == 7 and dest[1] < self.position[1]):
                    return False
            if move[1] == 1:
                if dest[1] >= self.position[1]:
                    return False
        piece = self._Piece__board.getPiece(dest)
        if not self.checkPiece(piece):
            return False
        return True
