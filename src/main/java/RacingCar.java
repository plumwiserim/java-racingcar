public class RacingCar {
    private final String name;
    private int step = 0;

    RacingCar(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getStep() {
        return step;
    }

    public void move(int randomNumber) {
        if (randomNumber >= 4) {
            this.step += 1;
        }
    }
}