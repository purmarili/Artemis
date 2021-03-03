class Node:
    def __init__(self, depth: int, value: int):
        if depth != 0:
            self.value = value
            self.left = Node(depth - 1, value + 1)
            self.middle = Node(depth - 1, value + 1)
            self.right = Node(depth - 1, value + 1)
        else:
            self.value = value
            self.left = None
            self.middle = None
            self.right = None


def find_sum(head: Node):
    if head is None:
        return 0
    elif head.left is None:
        return head.value
    return find_sum(head.left) + find_sum(head.middle) + find_sum(head.right) + head.value


def find_left_sum(head: Node, is_left: bool):
    if head is None:
        return 0
    elif head.left is None:
        if is_left:
            return head.value
        else:
            return 0
    curr = 0
    if is_left:
        curr = head.value
    return find_left_sum(head.left, True) + find_left_sum(head.middle, False) + find_left_sum(head.right, False) + curr


def find_right_middle_sum(head: Node, is_left: bool):
    if head is None:
        return 0
    elif head.left is None:
        if not is_left:
            return head.value
        else:
            return 0
    curr = 0
    if not is_left:
        curr = head.value
    return find_right_middle_sum(head.left, True) + find_right_middle_sum(head.middle, False) + find_right_middle_sum(
        head.right, False) + curr


if __name__ == '__main__':
    head = Node(2, 1)
    print(find_sum(head))
    print(find_left_sum(head, False))
    print(find_right_middle_sum(head, False))

#           1
#  2        2        2
# 3 3 3   3 3 3    3 3 3
