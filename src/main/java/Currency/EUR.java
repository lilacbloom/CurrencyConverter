package Currency;

import java.io.Serializable;


// Bonus question 5 - add third coin for EURO

public class EUR extends Coin  implements Serializable
{private final double value = 4.23;

    // Method getValue
    // Gets no parameter
    // Returns the value of the coin
    @Override
    public double getValue() {
        return value;
    }

    // Method calculate
    // Gets coin amount
    // Returns the converted value of the coin
    @Override
    public double calculate(double input)
    {
        return input/getValue();
    }

}