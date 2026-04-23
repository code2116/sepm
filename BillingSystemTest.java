public class BillingSystemTest {

    public static void main(String[] args) {
        BillingSystemTest tester = new BillingSystemTest();
        
        System.out.println("Running Manual Test Suite...");
        try {
            // Factory Tests
            tester.testFactoryB2BCreation();
            tester.testFactoryB2CCreation();
            tester.testFactoryInvalidInput();
            
            // Ledger Tests
            tester.testLedgerGrossTotal();
            tester.testLedgerAverageOrder();
            tester.testLedgerEmptyArray();
            
            System.out.println("\n✅ ALL TESTS PASSED!");
        } catch (Exception e) {
            System.err.println("\n❌ TEST FAILED: " + e.getMessage());
        }
    }

    // Helper method to act like JUnit's assertEquals
    private void assertEquals(Object expected, Object actual, String message) {
        if (!expected.equals(actual)) {
            throw new RuntimeException(message + " (Expected: " + expected + ", Actual: " + actual + ")");
        }
    }

    private void assertTrue(boolean condition, String message) {
        if (!condition) throw new RuntimeException(message);
    }

    // --- TEST CASES ---

    public void testFactoryB2BCreation() {
        DocumentFactory factory = new DocumentFactory();
        BillingDocument doc = factory.createDocument("B2B");
        assertTrue(doc instanceof CorporateTaxInvoice, "Should be CorporateTaxInvoice");
    }

    public void testFactoryB2CCreation() {
        DocumentFactory factory = new DocumentFactory();
        BillingDocument doc = factory.createDocument("B2C");
        assertTrue(doc instanceof RetailReceipt, "Should be RetailReceipt");
    }

    public void testFactoryInvalidInput() {
        DocumentFactory factory = new DocumentFactory();
        assertTrue(factory.createDocument("INVALID") == null, "Should return null for invalid types");
    }

    public void testLedgerGrossTotal() {
        ReconciliationLedger ledger = new ReconciliationLedger(new int[]{85, 85, 85});
        assertEquals(255, ledger.calculateGrossTotal(), "Gross total sum error");
    }

    public void testLedgerAverageOrder() {
        ReconciliationLedger ledger = new ReconciliationLedger(new int[]{85, 85, 85});
        assertEquals(85.0, ledger.calculateAverageOrder(), "Average calculation error");
    }

    public void testLedgerEmptyArray() {
        ReconciliationLedger ledger = new ReconciliationLedger(new int[]{});
        assertEquals(0, ledger.calculateGrossTotal(), "Empty total should be 0");
        assertEquals(0.0, ledger.calculateAverageOrder(), "Empty average should be 0.0");
    }
}