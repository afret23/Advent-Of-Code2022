import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AdventOfCode {


    public static void main(String[] args){
        try{
            File input = new File("/Users/matepolocz/Desktop/Advent-Of-Code2022/input_files/day1.txt");
            Scanner scan = new Scanner(input);
            List list = new ArrayList<String>();
            while (scan.hasNextLine()){
                list.add(scan.nextLine());
            }
            System.out.println(firstStar(list));
            System.out.println(secondStar(list));

        }catch (FileNotFoundException f){
            System.out.println("File not found!");
            f.printStackTrace();
        }
    }

    private static int firstStar(List<String> list){
        int max = 0, sum = 0, num;
        for(String data : list){
            if(data.equals("")){
                sum = 0;
            }else {
                num = Integer.valueOf(data);
                sum += num;
                if (sum > max) max = sum;
            }
        }
        return max;
    }

    private static int secondStar(List<String> list){
        int topThree[];
        topThree = new int[]{0,0,0};
        int num = 0, sum = 0;
        for(String data : list){
            if (data.equals("")){
                Arrays.sort(topThree);
                if (topThree[0] < sum) topThree[0] = sum;
                sum = 0;
            }
            else {
                num = Integer.valueOf(data);
                sum += num;
            }
        }
        return topThree[0] + topThree[1] + topThree[2];
    }
}
