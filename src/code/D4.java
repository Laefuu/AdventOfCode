package code;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class D4 implements DayCode{

    private int day;
    private List<String> elements;

    public D4(){
        day = 4;
    }

    public void setPath(String filename) throws IOException {
        elements = DayCode.loadFile(filename);
    }

    public int getDay() {
        return day;
    }

    public Optional part1() {
        int count = 0, valid;
        String pass = "";

        for (int i=0; i<=elements.size(); i++) {
            if (i == elements.size() ||elements.get(i).isEmpty()){
                valid = 0;
                for (String s : pass.split(" ")){
                    valid = (testPresent(s)) ? valid + 1:valid;
                }
                count = (valid == 7) ? count + 1:count;
                pass = "";
            }
            else{
                pass += " "+elements.get(i);
            }
        }
        return Optional.of(count);
    }

    public Optional part2() {
        HashMap<String, String> credentials = new HashMap<String, String>();
        int count = 0, valid;
        String pass = "";

        for (int i=0; i<=elements.size(); i++) {
            if (i == elements.size() ||elements.get(i).isEmpty()){
                valid = 0;
                for (String s : pass.split(" ")){
                    valid = (testPresent(s)) ? valid + 1:valid;
                    String[] split = s.split(":");
                    credentials.put(split[0],split[1]);
                }
                count = (valid == 7 && testValid(credentials)) ? count + 1: count;
                credentials = new HashMap<>();
                pass = "";
            }
            else{
                pass += elements.get(i) + " ";
            }
        }
        return Optional.of(count);
    }

    private boolean testPresent(String s){
        return (s.contains("byr") || s.contains("iyr") || s.contains("eyr") || s.contains("hgt") || s.contains("hcl") || s.contains("ecl") || s.contains("pid"));
    }

    private boolean testValid(HashMap<String, String> map){
        boolean byr, iyr, eyr, hgt = false, hcl, ecl, pid;
        byr = (Integer.parseInt(map.get("byr"))>=1920 && Integer.parseInt(map.get("byr"))<=2002);
        iyr = (Integer.parseInt(map.get("iyr"))>=2010 && Integer.parseInt(map.get("iyr"))<=2020);
        eyr = (Integer.parseInt(map.get("eyr"))>=2020 && Integer.parseInt(map.get("eyr"))<=2030);
        String height = map.get("hgt");
        if (height.endsWith("cm")) {
            int height_int = Integer.parseInt(height.replace("cm",""));
            hgt = (height_int >=150 && height_int <=193);
        } else if (height.endsWith("in")) {
            int height_int = Integer.parseInt(height.replace("in",""));
            hgt = (height_int >=59 && height_int <=76);
        }
        Pattern pattern = Pattern.compile("^#[0-9a-fA-F]{6}");
        Matcher matcher = pattern.matcher(map.get("hcl"));
        hcl = matcher.matches();
        ecl =   (map.get("ecl").equals("amb") ||
                map.get("ecl").equals("blu") ||
                map.get("ecl").equals("brn") ||
                map.get("ecl").equals("gry") ||
                map.get("ecl").equals("grn") ||
                map.get("ecl").equals("hzl") ||
                map.get("ecl").equals("oth"));
        pid = map.get("pid").length() == 9;
        return byr && iyr && eyr && hgt && hcl && ecl && pid;
    }
}
