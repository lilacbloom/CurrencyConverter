package Currency;

// Creates coin objects
public class CoinFactory
{
    public static Coin getCoinInstance (Coins coinType)
    {
        if (coinType == null)
        {
            return null;
        }
        switch (coinType)
      {
          case ILS:
              return new ILS();

          case USD:
              return new USD();

          case EUR:
              return new EUR();

      }

      return null;




    }

}
