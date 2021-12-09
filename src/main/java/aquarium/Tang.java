package aquarium;

public class Tang extends Fish{

    public Tang(String name, int weight, String color) {
        super(name, weight, color);
        setShortTermMemoryLoss(true);
    }

    @Override
    public void feed() {
        setWeight(getWeight()+1);
    }
}
