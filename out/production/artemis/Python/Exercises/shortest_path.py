def shortest_path(world: list, x: int, y: int, x1: int, y1: int, count: int):
    if x < 0 or y < 0 or x >= len(world) or y >= len(world):
        return 999999

    if world[x][y] == 0:
        return 999999

    if x == x1 and y == y1:
        return count

    world[x][y] = 0
    return min(shortest_path(world, x, y - 1, x1, y1, count + 1), shortest_path(world, x, y + 1, x1, y1, count + 1),
               shortest_path(world, x - 1, y, x1, y1, count + 1), shortest_path(world, x + 1, y, x1, y1, count + 1))


# 1 0 0 0
# 1 1 1 0
# 1 1 0 1
# 1 1 1 1

if __name__ == '__main__':
    world = [[1, 0, 0, 0], [1, 1, 1, 0], [1, 1, 0, 1], [1, 1, 1, 1]]
    rows = 4
    cols = 4
    x = 0
    y = 0
    x1 = 2
    y1 = 3
    ans = shortest_path(world, x, y, x1, y1, 0)
    if ans == 999999:
        print("გზა ვერ მოიძებნა")
    else:
        print(ans)
