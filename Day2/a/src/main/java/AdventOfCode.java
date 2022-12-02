import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AdventOfCode {

    public static void main(String[] args){
        try{
            File input = new File("/Users/matepolocz/Desktop/Advent-Of-Code2022/input_files/day2.txt");
            Scanner scan = new Scanner(input);
            List list = new ArrayList<String>();
            while (scan.hasNextLine()){
                list.add(scan.nextLine());
            }
            System.out.println(firstStar(list));
        }catch (FileNotFoundException f){
            System.out.println("File not found!");
            f.printStackTrace();
        }
    }

    private static int firstStar(List<String> list){
        int points = 0;
        for(String match : list){
            System.out.println(match);
            Match m = new Match(match.charAt(0), match.charAt(2));
            points += m.getPoints();
        }
        return points;
    }
}
