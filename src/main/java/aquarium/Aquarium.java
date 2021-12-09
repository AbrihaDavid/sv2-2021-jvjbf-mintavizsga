package aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {

    private List<Fish> fishList = new ArrayList<>();
    final static int CAPACITY = 20;

    public void addFish(Fish fish){
        if (fishList.size() * 5 > 15){
            throw new IllegalStateException("Can not add fish because there is no more space.");
        }
        fishList.add(fish);
    }

    public void feed(){
        for (Fish f: fishList){
            f.feed();
        }
    }

    public void removeFish(int maxWeight){
        List<Fish> fishToRemove = new ArrayList<>();
        for (Fish f: fishList){
            if(f.getWeight() >maxWeight){
                fishToRemove.add(f);
            }
        }
        fishList.removeAll(fishToRemove);
    }

    public List<String> getStatus(){
        List<String> status = new ArrayList<>();
        for (Fish f: fishList){
            status.add(f.getStatus());
        }
        return status;
    }

    public int getNumberOfFishWithMemoryLoss(){
        int counter = 0;
        for (Fish f: fishList){
            if (f.hasMemoryLoss()){
                counter++;
            }
        }
        return counter;
    }

    public boolean isThereFishWithGivenColor(String color){
        for (Fish f: fishList){
            if (f.getColor().equals(color)){
                return true;
            }
        }
        return false;
    }

    public Fish getSmallestFish(){
        Fish fish = null;
        for (Fish f: fishList){
            if (fish == null || f.getWeight() < fish.getWeight()){
                fish = f;
            }
        }
        return fish;
    }
}
