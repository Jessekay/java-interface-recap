public interface Stock {
    String getSymbol();
    double getPrice();
    int getVolume();
    String getExchangeName();

    void calculateMarketValue() throws Exception;
    void upDatePrice(double percentageChange);
    String getStockType();       
}
  


