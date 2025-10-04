package practice.factory.problem1;

class Item {
    private final String name;
    private final String itemCode;

    // Constructor is package-private
    Item(String name, String itemCode) {
        this.name = name;
        this.itemCode = itemCode;
    }

    public String getName() { return name; }
    public String getItemCode() { return itemCode; }
}