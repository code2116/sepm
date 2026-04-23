public class BillingSystemLab {
    public static void main(String[] args) {
        // The Facade hides the Factory and Ledger logic
        BillingFacade billingService = new BillingFacade();

        System.out.println("--- Facade Output (Document Generation) ---");
        billingService.processDocument("B2B");
        billingService.processDocument("B2C");

        System.out.println("\n--- Facade Output (Financial Audit) ---");
        int[] transactions = {85, 85, 85}; 
        billingService.performAudit(transactions);
    }
}