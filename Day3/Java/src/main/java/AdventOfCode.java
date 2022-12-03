import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AdventOfCode {

    public static void main(String[] args){
        try{
            File input = new File("/Users/matepolocz/Desktop/Advent-Of-Code2022/input_files/day3.txt");
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

    private static int secondStar(List<String> list) {
        int sumPriorities = 0;
        boolean isInThere = false;
        boolean done = false;
        boolean doneThird = false;
        for (int i = 0; i < list.size(); i = i + 3){ //iterate through the list
            for (int j = 0; j < list.get(i).length(); j++){ //first
                for (int k = 0; k < list.get(i+1).length(); k++){
                    if (list.get(i).charAt(j) == list.get(i+1).charAt(k) && !done){
                        isInThere = true;
                        done = true;
                    }
                }
                if (isInThere && done){
                    for (int l = 0; l < list.get(i+2).length(); l++){
                        if (list.get(i).charAt(j) == list.get(i+2).charAt(l) && !doneThird){
                            if ((int)list.get(i).charAt(j) > 91){
                                sumPriorities += (int)list.get(i).charAt(j) - 96;
                                doneThird = true;
                            }else if ((int)list.get(i).charAt(j) < 91){
                                sumPriorities += (int)list.get(i).charAt(j) - 38;
                                doneThird = true;
                            }
                        }
                    }
                }
            }
            isInThere = false;
            done = false;
            doneThird = false;
        }
        return sumPriorities;
    }

    private static int firstStar(List<String> list){
        int sumPriorities = 0;
        boolean done = false;
        for (String data : list){
            int dataLength;
            String firstHalf, secondHalf;
            dataLength = data.length();
            firstHalf = data.substring(0,(dataLength/2));
            secondHalf = data.substring(dataLength/2);

            for (int i = 0; i < firstHalf.length(); i++){
                for (int j = 0; j < secondHalf.length(); j++){
                    if (firstHalf.charAt(i) == secondHalf.charAt(j)){
                        if ((int)firstHalf.charAt(i) > 91 && !done){
                            sumPriorities += (int)firstHalf.charAt(i) - 96;
                            done = true;
                        }else if ((int)firstHalf.charAt(i) < 91 && !done){
                            sumPriorities += (int)firstHalf.charAt(i) - 38;
                            done = true;
                        }
                    }
                }
            }
            done = false;
        }
        return sumPriorities;
    }
}
