file = open("data.txt", "r")
vegosszeg = 0
osszeg2 = 0

for line in file:
    if line == '\n':
        print(f"{osszeg2} -  {vegosszeg}")
        if osszeg2 > vegosszeg:
            vegosszeg = osszeg2
        osszeg2 = 0
    else:
        osszeg2 += int(line)

print(vegosszeg)