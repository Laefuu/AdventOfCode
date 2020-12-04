package code;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

public interface DayCode {
    int getDay();
    void setPath(String a) throws IOException;
    Optional part1();
    Optional part2();

    static List<String> loadFile(String filename) throws IOException {
        Path path = Paths.get(filename);
        List<String> allLines;
        try{
            allLines = Files.readAllLines(path, StandardCharsets.UTF_8);
        }catch (IOException e){
            System.out.println("Erreur code.D1 : Chargement du fichier");
            throw new IOException();
        }
        return (allLines!=null)?allLines:null;
    }
}
