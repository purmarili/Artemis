def is_reachable(world:list, x:int, y:int, x1:int, y1:int):
	if x < 0 or y < 0 or x >= len(world) or y >= len(world):
		return False
	if world[x][y] == 0:
		return False
	if x == x1 and y == y1:
		return True
	world[x][y] = 0
	return is_reachable(world,x,y-1,x1,y1) or is_reachable(world,x,y+1,x1,y1) or is_reachable(world,x-1,y,x1,y1) or is_reachable(world,x+1,y,x1,y1)

# 1 0 0 0
# 1 1 1 0
# 1 1 0 1
# 1 1 1 1

if __name__ == '__main__':
	world = [[1,0,0,0], [1,1,1,0], [1,1,0,1], [1,1,1,1]]
	rows = 4
	cols = 4

	# for i in range(rows):
	# 	col = []
	# 	for j in range(cols):
	# 		col.append(int(input()))
	# 	world.append(col)

	x = 0
	y = 0
	x1 = 0
	y1 = 3
	print(is_reachable(world=world, x=x, y=y, x1=x1, y1=y1))