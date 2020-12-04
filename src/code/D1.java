package code;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class D1 implements DayCode {

    private int day;
    private List<String> elements;
    private List<Integer> numbers;

    public D1(){
        day = 1;
    }

    public void setPath(String filename) throws IOException {
        elements = DayCode.loadFile(filename);
        numbers = elements.stream().map(x -> Integer.parseInt(x.trim())).collect(Collectors.toList());
    }

    public int getDay() {
        return day;
    }


    public Optional part1(){
        for (int i=0; i<numbers.size();i++){
            int temp = 2020 - numbers.get(i);
            if (numbers.contains(temp)){
                int a = numbers.get(i);
                int b = temp;
                System.out.println(a +" | "+b);
                return Optional.of(a*b);
            }
        }
        return Optional.of(0);
    }

    public Optional part2(){
        int a, b, c, temp;
        for (int i=0; i< numbers.size()-2; i++){
            a = numbers.get(i);
            for (int j=i+1; j<numbers.size()-1; j++){
                b = numbers.get(j);
                temp = a+b;
                c = 2020-temp;
                if (numbers.contains(c)){
                    System.out.println(a+" | "+b+" | "+c);
                    return Optional.of(a*b*c);
                }

            }
        }
        return Optional.of(0);
    }
}
