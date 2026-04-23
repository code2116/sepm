class BillingFacade {
    private DocumentFactory factory;

    public BillingFacade() {
        this.factory = new DocumentFactory();
    }

    // Method to handle document generation logic
    public void processDocument(String type) {
        BillingDocument doc = factory.createDocument(type);
        if (doc != null) {
            doc.generate();
        } else {
            System.out.println("Error: Invalid document type.");
        }
    }

    // Method to handle financial auditing logic
    public void performAudit(int[] transactions) {
        ReconciliationLedger ledger = new ReconciliationLedger(transactions);
        System.out.println("Total: " + ledger.calculateGrossTotal());
        System.out.println("Average: " + (int) ledger.calculateAverageOrder());
    }
}