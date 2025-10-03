package Labs_solutions.lab2.prob2B;

class OrderLine {
    private Order order;
    private double price;

    OrderLine(double price,Order order) {
        this.price=price;
        this.order = order;
    }

    public double getPrice() {
        return price;
    }
    @Override
    public String toString(){
        return "price : "+price;
    }
}
