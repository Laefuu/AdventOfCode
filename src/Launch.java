import code.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

public class Launch {
    public static void main(String[] args) throws Exception {

        // JOUR 1
        execute(new D1());

        // JOUR 2
        execute(new D2());

        // JOUR 3
        execute(new D3());

        // JOUR 4
        execute(new D4());

        System.out.println(Color.ANSI_BOLD+"======================");

    }

    public static void execute(DayCode code) throws Exception {
        try {
            code.setPath("src/resource/input_d" + code.getDay() + ".txt");
        }catch (IOException e){
            throw new Exception();
        }
        Optional result;
        long time;

        System.out.println(Color.ANSI_BOLD+"======================");
        System.out.println(Color.ANSI_BLUE+"Day "+code.getDay()+" - Part 1"+Color.ANSI_CYAN);

        time = System.nanoTime();
        result = code.part1();
        time = System.nanoTime()-time;
        System.out.println("Résultat : "+result.get());


        System.out.println(Color.ANSI_PURPLE+"Exécuté en : "+time+"ns");
        System.out.println(Color.ANSI_BOLD+"----------------------");
        System.out.println(Color.ANSI_BLUE+"Day "+code.getDay()+" - Part 2"+Color.ANSI_CYAN);


        time = System.nanoTime();
        result = code.part2();
        time = System.nanoTime()-time;
        System.out.println("Résultat : "+result.get());

        System.out.println(Color.ANSI_PURPLE+"Exécuté en : "+time+"ns"+Color.ANSI_RESET);
    }
}
