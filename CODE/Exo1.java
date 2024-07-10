import java.util.*;

public class OrderSystem {
    private final Map<Integer, List<Order>> ordersByCustomer;

    public OrderSystem() {
        this.ordersByCustomer = new HashMap<>();
    }

    public void addNewOrder(Integer customerID, String itemName) {
        validateCustomerID(customerID);
        validateItemName(itemName);

        Order order = new Order(itemName);
        List<Order> orders = ordersByCustomer.getOrDefault(customerID, new ArrayList<>());
        orders.add(order);
        ordersByCustomer.put(customerID, orders);
    }

    public void modifyOrder(Integer customerID, Integer orderIndex, String newItemName) {
        validateCustomerID(customerID);
        validateItemName(newItemName);
        validateOrderIndex(customerID, orderIndex);

        List<Order> orders = ordersByCustomer.get(customerID);
        orders.get(orderIndex).setItemName(newItemName);
    }

    public void removeOrder(Integer customerID, Integer orderIndex) {
        validateCustomerID(customerID);
        validateOrderIndex(customerID, orderIndex);

        List<Order> orders = ordersByCustomer.get(customerID);
        orders.remove(orderIndex);
    }

    public void printOrders() {
        for (Map.Entry<Integer, List<Order>> entry : ordersByCustomer.entrySet()) {
            Integer customerID = entry.getKey();
            List<Order> orders = entry.getValue();
            System.out.println("Customer ID: " + customerID);
            for (Order order : orders) {
                System.out.println(" - Item: " + order.getItemName());
            }
            System.out.println();
        }
    }

    private void validateCustomerID(Integer customerID) {
        if (customerID == null || customerID < 0) {
            throw new IllegalArgumentException("Invalid customer ID.");
        }
    }

    private void validateItemName(String itemName) {
        if (itemName == null || itemName.trim().isEmpty()) {
            throw new IllegalArgumentException("Item name cannot be null or empty.");
        }
    }

    private void validateOrderIndex(Integer customerID, Integer orderIndex) {
        List<Order> orders = ordersByCustomer.get(customerID);
        if (orders == null || orderIndex < 0 || orderIndex >= orders.size()) {
            throw new IllegalArgumentException("Invalid order index.");
        }
    }

    private static class Order {
        private String itemName;

        public Order(String itemName) {
            this.itemName = itemName;
        }

        public String getItemName() {
            return itemName;
        }

        public void setItemName(String itemName) {
            validateItemName(itemName);
            this.itemName = itemName;
        }

        private void validateItemName(String itemName) {
            if (itemName == null || itemName.trim().isEmpty()) {
                throw new IllegalArgumentException("Item name cannot be null or empty.");
            }
        }
    }
}
