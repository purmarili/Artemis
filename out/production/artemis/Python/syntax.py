a = 5
b = "hello"
c = 'hello'
d = True
k = ['hello', 5, 'welcome', True] # list
k.insert(0, 'gamarjoba')

p = ('hello', '4', 'welcome') # tuple

dic = {'brand':'mercedes', 'year':2000, 'country':'germany'} # dictionary
dic['created'] = 1900

# for i in dic:
# 	print(i + ' ' + str(dic[i]))

# for i, line in enumerate(p):
# 	print(str(i) + ' ' + line)

def get_num():
	return 1, 'hello', 'gamarjoba'

num, hel, gam = get_num()
print(num)
print(hel)
print(gam)

def hello(welcome:str):
	for i in range(0, 10, 3):
		print(str(i) + ' ' + welcome)

		if i == 3:
			print(str(i) + ' ' + welcome)
	

# hello(c)

if __name__ == '__main__':
	hello('welcome')	
