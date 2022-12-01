file = open("data.txt", "r")
osszeg2 = 0
elfek = {}
i = 0

for line in file:
    if line == '\n':
        elfek[f'{i}. elf'] = osszeg2
        osszeg2 = 0
        i = i+1
    else:
        osszeg2 += int(line)

print({k: v for k, v in  sorted(elfek.items(), key=lambda x: x[1])})
#for elf, calorie in elfek.items():
#      print(f"{elf} - {calorie}")

