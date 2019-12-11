public class MinMaxFeeStrategy implements PaymentType {

    /**
     * Min/Max Fee Strategy
     * @param time total duration of time parked
     * @return Parking Fee
     */

    @Override
    public double getPaymentTotal(int time) {
        if (time <= 3) {
            return 5;
        } else {
            double parkingFee = 5 + (time - 3);

            return (int) Math.max(5, Math.min(15, parkingFee));

        }
    }
}
