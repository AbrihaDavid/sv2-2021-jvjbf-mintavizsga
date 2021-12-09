package owlcounter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class OwlCounter {

    private List<String> owlList = new ArrayList<>();

    public void readFromFile(Path path){
        try {
            Files.readAllLines(path);
            owlList = Files.readAllLines(path);
        }
        catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.", ioe);
        }
    }

    public int getNumberOfOwls(String name){
        for (String s: owlList){
            if (s.startsWith(name)){
                String[] temp = s.split("=");
                return Integer.parseInt(temp[1]);
            }
        }
        throw new IllegalArgumentException("No such county in Hungary!");
    }

    public int getNumberOfAllOwls(){
        int counter = 0;
        for (String s: owlList){
            String[] temp = s.split("=");
            counter += Integer.parseInt(temp[1]);
        }
        return counter;
    }

    public static void main(String[] args) {

        OwlCounter owlCounter = new OwlCounter();
        Path path = Paths.get("src/test/resources/owls.txt");
        owlCounter.readFromFile(path);
        System.out.println(owlCounter.getNumberOfOwls("Zala"));
    }
}
