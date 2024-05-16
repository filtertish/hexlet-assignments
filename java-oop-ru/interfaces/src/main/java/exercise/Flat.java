package exercise;

// BEGIN
class Flat implements Home {
    private final double area;
    private final double balconyArea;
    private final int floor;

    Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }

    public String toString() {
        return "Квартира площадью " + getArea() + " метров на " + floor + " этаже";
    }

    @Override
    public double getArea() {
        return area + balconyArea;
    }

    @Override
    public int compareTo(Home another) {
        return Double.compare(getArea(), another.getArea());
    }
}
// END
