package uniquefinder;

import java.util.ArrayList;
import java.util.List;

public class UniqueFinder {

    public List<Character> getUniqueChars (String string){
        List<Character> cList = new ArrayList<>();
        if (string == null){
            throw new IllegalArgumentException("Text is null.");
        }

        for (Character c: string.toCharArray()){
            if (!cList.contains(c)){
                cList.add(c);
            }
        }
        return cList;
    }
}
