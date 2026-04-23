public class BillingSystemTest {

    public static void main(String[] args) {
        BillingSystemTest tester = new BillingSystemTest();
        
        System.out.println("Running Facade System Test Suite...");
        try {
            tester.testFacadeIntegration();
            tester.testLedgerLogic();
            
            System.out.println("\n✅ ALL SYSTEM TESTS PASSED!");
        } catch (Exception e) {
            System.err.println("\n❌ TEST FAILED: " + e.getMessage());
        }
    }

    private void testFacadeIntegration() {
        BillingFacade facade = new BillingFacade();
        // Since processDocument handles its own null checks and printing, 
        // we ensure it doesn't crash on various inputs
        facade.processDocument("B2B");
        facade.processDocument("INVALID");
        System.out.println("Integration Test: Document processing completed without errors.");
    }

    private void testLedgerLogic() {
        ReconciliationLedger ledger = new ReconciliationLedger(new int[]{85, 85, 85});
        if (ledger.calculateGrossTotal() != 255) throw new RuntimeException("Gross Total Mismatch");
        if (ledger.calculateAverageOrder() != 85.0) throw new RuntimeException("Average Mismatch");
        System.out.println("Integration Test: Financial logic verified.");
    }
}