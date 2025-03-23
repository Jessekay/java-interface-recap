public class TechStock implements Stock{
    private String symbol;
    private double price;
    private int volume;
    private String exchangeName;
    private int innovationIndex;

    public TechStock(String symbol, double price, int volume, String exchangeName, int innovationIndex) {
        if (!symbol.matches("[A-Z]{3,5}")) throw new IllegalArgumentException("Invalid symbol format.");
        if (price <= 0) throw new IllegalArgumentException("Price must be positive.");
        if (volume < 0) throw new IllegalArgumentException("Volume can not be negative");
        if (!exchangeName.equalsIgnoreCase("NYSE") && !exchangeName
        .equalsIgnoreCase("NASDAQ") && !exchangeName.equalsIgnoreCase("LSE")) throw new IllegalArgumentException("Invalid exchange name.");
        if (innovationIndex < 0 || innovationIndex > 100) throw new IllegalArgumentException("Innovation index must be between 0-100.");

        this.symbol = symbol;
        this.price = price;
        this.volume = volume;
        this.exchangeName = exchangeName;
        this.innovationIndex = innovationIndex;
    }

    @Override
    public String getSymbol() { return symbol; }

    @Override
    public double getPrice() { return price;}

    @Override
    public int getVolume() { return volume; }

    @Override
    public String getExchangeName() { return exchangeName; }

    @Override
    public void calculateMarketValue() throws Exception {
        if (price == 0 || volume == 0) throw new Exception("Price or volume cannot be zero");
        System.out.println("Market Value: " + (price * volume));
    }

    @Override
    public void upDatePrice(double percentageChange) {
        price += price * (percentageChange / 100);
        if (price < 0) price = 0;
        if (innovationIndex < 30) price -= 0.5 * price;         
    }

    @Override
    public String getStockType() { 
        return "TechStock";
     }

}
