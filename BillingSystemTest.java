import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BillingSystemTest {

    // ==========================================
    // DEV 1: FACTORY PATTERN TEST CASES
    // ==========================================

    @Test
    public void testFactoryB2BCreation() {
        DocumentFactory factory = new DocumentFactory();
        BillingDocument doc = factory.createDocument("B2B");
        assertTrue(doc instanceof CorporateTaxInvoice, "Factory should return a CorporateTaxInvoice for B2B");
    }

    @Test
    public void testFactoryB2CCreation() {
        DocumentFactory factory = new DocumentFactory();
        BillingDocument doc = factory.createDocument("B2C");
        assertTrue(doc instanceof RetailReceipt, "Factory should return a RetailReceipt for B2C");
    }

    @Test
    public void testFactoryInvalidInput() {
        DocumentFactory factory = new DocumentFactory();
        BillingDocument doc = factory.createDocument("INVALID_TYPE");
        assertNull(doc, "Factory should return null for unknown document types");
    }

    // ==========================================
    // DEV 2: INFORMATION EXPERT TEST CASES
    // ==========================================

    @Test
    public void testLedgerGrossTotal() {
        int[] transactions = {85, 85, 85};
        ReconciliationLedger ledger = new ReconciliationLedger(transactions);
        
        int expectedTotal = 255;
        assertEquals(expectedTotal, ledger.calculateGrossTotal(), "Gross total should accurately sum the array");
    }

    @Test
    public void testLedgerAverageOrder() {
        int[] transactions = {85, 85, 85};
        ReconciliationLedger ledger = new ReconciliationLedger(transactions);
        
        double expectedAverage = 85.0;
        assertEquals(expectedAverage, ledger.calculateAverageOrder(), "Average should be the sum divided by length");
    }

    @Test
    public void testLedgerEmptyArray() {
        int[] emptyTransactions = {};
        ReconciliationLedger ledger = new ReconciliationLedger(emptyTransactions);
        
        assertEquals(0, ledger.calculateGrossTotal(), "Total should be 0 for an empty array");
        assertEquals(0.0, ledger.calculateAverageOrder(), "Average should be 0.0 for an empty array to prevent DivisionByZero");
    }
}