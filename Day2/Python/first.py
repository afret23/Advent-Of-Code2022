# opponent A: rock; B: paper; C: Scissors
# me: X: rock; Y: paper; Z: Scissors
# score: 1: rock; 2: paper; 3: scissors + (0: loss; 3: draw; 6: win)

matches= []
score = 0
with open("../../input_files/day2.txt", "r") as file:
    for lines in file:
        matches.append(lines.strip().split())

player = {
    "X":1,
    "Y":2,
    "Z":3
}

def matchek(ellenfel, sajat):
    opponent = {
        "A":"X",
        "B":"Y",
        "C":"Z"
    }

    if opponent[ellenfel] == sajat:
        return 3
    elif ellenfel == "A" and sajat == "Y":
        return 6
    elif ellenfel == "B" and sajat == "Z":
        return 6
    elif ellenfel == "C" and sajat == "X":
        return 6
    else:
        return 0


for match in matches:
   print(f"Opponent play: {match[0]} -- Your play: {match[1]}. You got: {matchek(match[0], match[1]) + player[match[1]]}")
   score = matchek(match[0], match[1]) + player[match[1]] + score
#   print(matchek(match[0], match[1]))
#   print(player[match[1]])

print(score)