package practice.factory.problem1;


class CustomerOrderFactory {
    public static Order createOrder(Customer c){
        Order o = new Order();
        c.addOrder(o);
        return o;
    }
    public static Item createItem(Order o, String name, String itemCode){
        Item item = new Item(name,itemCode);
        o.addItem(item);
        return  item;
    }
}
