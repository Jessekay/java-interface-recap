public class DividendStock implements Stock{
    private String symbol;
    private double price;
    private int volume;
    private String exchangeName;
    private double dividendYield;

    public DividendStock(String symbol, double price, int volume, String exchangeName, double dividendYield) {
        if (!symbol.matches("[A-Z]{3,5}")) throw new IllegalArgumentException("Invalid symbol format.");
        if (price <= 0) throw new IllegalArgumentException("Price must be positive.");
        if (volume < 0) throw new IllegalArgumentException("Volume can not be negative");
        if (!exchangeName.equalsIgnoreCase("NYSE") && !exchangeName
        .equalsIgnoreCase("NASDAQ") && !exchangeName.equalsIgnoreCase("LSE")) throw new IllegalArgumentException("Invalid exchange name.");
        if (dividendYield < 0 || dividendYield > 15) throw new IllegalArgumentException("Dividend yield must be between 0% 15%.");

        this.symbol = symbol;
        this.price = price;
        this.volume = volume;
        this.exchangeName = exchangeName;
        this.dividendYield = dividendYield;
    }

    @Override
    public String getSymbol() { return symbol; }

    @Override
    public double getPrice() { return price; }

    @Override
    public int getVolume() { return volume; }

    @Override
    public String getExchangeName() { return exchangeName; }

    @Override
    public void calculateMarketValue() throws Exception {
        if (price == 0 || volume == 0) throw new IllegalArgumentException("Price or volume cannot be 0");
        System.out.println("Market Value: " + (price * volume));
    }

    @Override
    public void upDatePrice(double percentageChange) {
        price += price * (percentageChange / 100);
        if (price < 0) price = 0;
    }

    @Override
    public String getStockType() {
        return "DividendStock";
    }

}
