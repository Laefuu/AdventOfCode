package code;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class D2 implements DayCode{

    private int day;
    private List<String> elements;

    public D2(){
        day = 2;
    }

    public void setPath(String filename) throws IOException {
        elements = DayCode.loadFile(filename);
    }

    public int getDay() {
        return day;
    }

    public Optional part1(){
        int valid = 0;
        for (int i=0; i<elements.size(); i++){
            String[] splitted = elements.get(i).split(" ");
            int[] interval = {Integer.parseInt((splitted[0].split("-"))[0]),Integer.parseInt((splitted[0].split("-"))[1])};
            char letter = splitted[1].charAt(0);
            int occurs = 0;

            for (int j=0; j<splitted[2].length(); j++){
                if (splitted[2].charAt(j) == letter){
                    occurs++;
                }
            }
            if (occurs>=interval[0] && occurs<=interval[1]){
                valid ++;
            }
        }
        return Optional.of(valid);
    }

    public Optional part2() {
        int valid = 0;
        for (int i = 0; i < elements.size(); i++) {
            String[] splitted = elements.get(i).split(" ");
            int[] interval = {Integer.parseInt((splitted[0].split("-"))[0])-1, Integer.parseInt((splitted[0].split("-"))[1])-1};
            char letter = splitted[1].charAt(0);

            if ((splitted[2].charAt(interval[0]) == letter ^ splitted[2].charAt(interval[1]) == letter)) {
                valid++;
            }
        }
        return Optional.of(valid);
    }

}