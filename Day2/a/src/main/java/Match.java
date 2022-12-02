public class Match{
    private int points = 0;
    private int points_elf = 0;
    private char choose;
    private char choose_elf;

    public Match(char choose, char choose_elf) {
        this.choose = choose;
        this.choose_elf = choose_elf;

        //draw
        if (choose == choose_elf){
            points += 3;
            points_elf += 3;
            if (choose == 'X') point += 1;
            if (choose == 'Y') point += 2;
            if (choose == 'Z') point += 3;
        }else{
            if (choose == 'X'){ //rocks
                points += 1;
                if (choose_elf == 'B') elfWon();
                if (choose_elf == 'C') iWon();
            }
            if (choose == 'Y'){ //paper
                points += 2;
                if (choose_elf == 'C') elfWon();
                if (choose_elf == 'A') iWon();
            }
            if (choose == 'Z'){ //scissors
                points += 3;
                if (choose_elf == 'A') elfWon();
                if (choose_elf == 'B') iWon();
            }
        }
    }

    public void elfWon(){
        points_elf += 6;
    }
    public void iWon(){
        points += 6;
    }

    public int getPoints() {
        return points;
    }

    public int getPoints_elf() {
        return points_elf;
    }
}