interface BillingDocument {
    void generate();
}

// 2. Concrete Products
class CorporateTaxInvoice implements BillingDocument {
    @Override
    public void generate() {
        System.out.println("Generating Corporate Tax Invoice...");
    }
}

class RetailReceipt implements BillingDocument {
    @Override
    public void generate() {
        System.out.println("Generating Retail Receipt...");
    }
}

// 3. The Creator (Factory)
class DocumentFactory {
    public BillingDocument createDocument(String clientType) {
        if (clientType == null) {
            return null;
        }
        if (clientType.equalsIgnoreCase("B2B")) {
            return new CorporateTaxInvoice();
        } else if (clientType.equalsIgnoreCase("B2C")) {
            return new RetailReceipt();
        }
        return null;
    }
}