class ReconciliationLedger {
    private int[] lineItemPrices;

    public ReconciliationLedger(int[] lineItemPrices) {
        this.lineItemPrices = lineItemPrices;
    }

    public int calculateGrossTotal() {
        int total = 0;
        for (int price : lineItemPrices) {
            total += price;
        }
        return total;
    }

    public double calculateAverageOrder() {
        if (lineItemPrices.length == 0) return 0;
        return (double) calculateGrossTotal() / lineItemPrices.length;
    }
}