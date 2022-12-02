public class Match{
    private int points = 0;
    private int points_elf = 0;
    private char choose;
    private char choose_elf;

    public Match(char choose, char choose_elf) {
        this.choose = choose;
        this.choose_elf = choose_elf;
        //firstStar();
        secondStar();
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

    public void secondStar(){
        if (choose == 'X'){ //loose
            if (choose_elf == 'A') points += 3;
            if (choose_elf == 'B') points += 1;
            if (choose_elf == 'C') points += 2;
        }else if(choose == 'Y'){ //draw
            points += 3;
            if (choose_elf == 'A') points += 1;
            if (choose_elf == 'B') points += 2;
            if (choose_elf == 'C') points += 3;
        }else{ //win
            points += 6;
            if (choose_elf == 'A') points += 2;
            if (choose_elf == 'B') points += 3;
            if (choose_elf == 'C') points += 1;
        }
    }

    public void firstStar(){
        //draw
        if ((choose == 'X' && choose_elf == 'A') || (choose == 'Y' && choose_elf == 'B') || (choose == 'Z' && choose_elf == 'C') ){
            points += 3;
            points_elf += 3;
            if (choose == 'X') points += 1;
            if (choose == 'Y') points += 2;
            if (choose == 'Z') points += 3;
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
}