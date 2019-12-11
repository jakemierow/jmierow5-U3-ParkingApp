public class SpecialEventFeeStrategy implements PaymentType
{
    /**
     * Special Event Fee Strategy
     */

    double eventFee = 20.00;


    public double getFee()
    {
        return eventFee;
    }

    @Override
    public double getPaymentTotal(int time) {
        return 0;
    }
}
