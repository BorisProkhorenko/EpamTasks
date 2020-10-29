package state;

public class State {
    private Region[] regions;
    private City capital;
    private double area = 0;

    public State(Region[] regions, City capital) {
        this.regions = regions;
        this.capital = capital;
        for (int i = 0; i < regions.length; i++) {
            area += regions[i].getArea();
        }
    }
}
