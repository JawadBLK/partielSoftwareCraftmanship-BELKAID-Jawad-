public class OrderProcessor {
    private final Database database;
    private final EmailService emailService;
    private final InventorySystem inventorySystem;
    private final DiscountService discountService;

    public OrderProcessor(Database database, EmailService emailService, InventorySystem inventorySystem, DiscountService discountService) {
        this.database = database;
        this.emailService = emailService;
        this.inventorySystem = inventorySystem;
        this.discountService = discountService;
    }

    public void processOrder(Order order) throws ItemNotAvailableException {
        // Vérifier la disponibilité des articles en stock
        checkInventory(order);

        // Enregistrer la commande dans la base de données
        database.saveOrder(order);

        // Envoyer un e-mail de confirmation au client
        sendOrderConfirmation(order);

        // Mettre à jour l'inventaire
        updateInventory(order);

        // Appliquer une remise pour les clients fidèles
        applyDiscountIfLoyal(order);
    }

    private void checkInventory(Order order) throws ItemNotAvailableException {
        for (Item item : order.getItems()) {
            if (!inventorySystem.isItemAvailable(item)) {
                throw new ItemNotAvailableException("Item not available in inventory: " + item.getName());
            }
        }
    }

    private void sendOrderConfirmation(Order order) {
        String message = "Your order has been received and is being processed.";
        emailService.sendEmail(order.getCustomerEmail(), "Order Confirmation", message);
    }

    private void updateInventory(Order order) {
        for (Item item : order.getItems()) {
            inventorySystem.updateInventory(item, item.getQuantity() * -1);
        }
    }

    private void applyDiscountIfLoyal(Order order) {
        if (order instanceof LoyalCustomerOrder) {
            discountService.applyDiscount((LoyalCustomerOrder) order);
        }
    }
}

public class DiscountService {
    public void applyDiscount(LoyalCustomerOrder order) {
        order.setTotalPrice(order.getTotalPrice() * 0.9); // Appliquer une remise de 10%
    }
}
