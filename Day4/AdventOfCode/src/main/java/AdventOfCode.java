import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdventOfCode {

    public static void main(String[] args){
        try{
            File input = new File("/Users/matepolocz/Desktop/Advent-Of-Code2022/input_files/day4.txt");
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
        int numberOfOverlapping = 0;
        for(String data : list){
            int delimiter = data.indexOf(',');
            String first = data.substring(0,delimiter);
            String second = data.substring(delimiter+1);
            List<Integer> firstList = getNumbers(first);
            List<Integer> secondList = getNumbers(second);
            if (isOverlapping(firstList,secondList) || isOverlapping(secondList,firstList)) numberOfOverlapping++;
        }

        return numberOfOverlapping;
    }

    private static List<Integer> getNumbers(String data){
        int delimiter = data.indexOf('-');
        List<Integer> list = new ArrayList<Integer>();
        for (int i = Integer.valueOf(data.substring(0,delimiter)); i <= Integer.valueOf(data.substring(delimiter+1)); i++){
            list.add(i);
        }
        return list;
    }

    private static boolean isOverlapping(List<Integer> first, List<Integer> second){
        boolean overlapping = true;
        for (int i = first.get(0); i <= first.get(first.size()-1); i++){
            if (!second.contains(i)) overlapping = false;
        }

        return overlapping;
    }
}
