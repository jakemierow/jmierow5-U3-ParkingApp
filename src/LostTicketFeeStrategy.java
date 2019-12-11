public class LostTicketFeeStrategy implements PaymentType
{
    /**
     * Lost Ticket Fee Strategy
     */
    double LostFee = 25.00;

    public double getFee()
    {
        return LostFee;
    }

    @Override
    public double getPaymentTotal(int time) {
        return 0;
    }
}
