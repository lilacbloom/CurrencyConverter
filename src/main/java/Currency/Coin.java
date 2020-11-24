package Currency;


public abstract class Coin implements ICalculate
{
    // Method getValue
    // Gets no parameter
    // Returns the value of the coin
    public abstract double getValue();

    // Method calculate
    // Gets coin amount
    // Returns the converted value of the coin
    public abstract double calculate(double value);
}





