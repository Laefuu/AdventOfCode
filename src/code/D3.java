package code;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class D3 implements DayCode{

    private int day;
    private List<String> elements;

    public D3(){
        day = 3;
    }

    public void setPath(String filename) throws IOException {
        elements = DayCode.loadFile(filename);
    }

    public int getDay() {
        return day;
    }

    public Optional part1() {
        int x=1,y=1, count=0;
        for (int i=1; i<elements.size(); i++){
            x = (x+3>31) ? (x+4)%32:x+3;
            y++;
            if (elements.get(i).charAt(x-1) == '#')
                count++;
        }
        return Optional.of(count);
    }

    public Optional part2() {
        int x, y, xlist, ylist, count;
        long pdt = 1;
        int [][] list = {{1,1},{3,1},{5,1},{7,1},{1,2}};
        for (int i=0; i<list.length; i++){
            xlist = list[i][0];
            ylist = list[i][1];
            x = 0;
            y = 0;
            count = 0;
            for (int k=ylist; k<elements.size(); k+=ylist) {
                x = (x+xlist)%31;
                y += ylist;
                if (elements.get(k).charAt(x) == '#')
                    count++;
            }
            pdt *= count;
        }
        return Optional.of(pdt);
    }
}