public interface Stock {
    String getSymbol();
    double getPrice();
    int getVolume();
    String getExchangeName();

    void calculateMarketValue();
    void upDatePrice();
    String getStockType();       
}
  


