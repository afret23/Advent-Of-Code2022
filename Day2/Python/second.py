# opponent A: rock; B: paper; C: Scissors
# me: X: lose; Y: draw; Z: win 
# score: 1: rock; 2: paper; 3: scissors + (0: loss; 3: draw; 6: win)

matches= []
score = 0
with open("../../input_files/day2.txt", "r") as file:
    for lines in file:
        matches.append(lines.strip().split())

player = {
    "A":1,
    "B":2,
    "C":3
}
counter = {
    "A":"B",
    "B":"C",
    "C":"A"
}
lose = {
    "A":"C",
    "B":"A",
    "C":"B"
}

def matchek(ellenfel, sajat):
    if sajat == "X":
        return [lose[ellenfel], 0]
    if sajat == "Y":
        return [ellenfel, 3]
    if sajat == "Z":
        return [counter[ellenfel], 6]


for match in matches:
   play = matchek(match[0], match[1])
   score = play[1] + player[play[0]] + score

print(score)