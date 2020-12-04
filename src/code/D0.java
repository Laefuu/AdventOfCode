package code;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class D0 implements DayCode{

    private int day;
    private List<String> elements;

    public D0(){
        day = 0;
    }

    public void setPath(String filename) throws IOException {
        elements = DayCode.loadFile(filename);
    }

    public int getDay() {
        return day;
    }

    public Optional part1() {
        return Optional.of(0);
    }

    public Optional part2() {
        return Optional.of(0);
    }
}
