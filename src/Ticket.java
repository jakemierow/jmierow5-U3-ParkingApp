import java.time.LocalTime;
import java.util.Random;
import java.time.Duration;
import static java.time.temporal.ChronoUnit.MINUTES;

public class Ticket
{
    private Random r = new Random();
    private int id;
    private int count = 1;
    LocalTime CheckInTime;
    LocalTime CheckOutTime;
    private double total;
    private PaymentType paymentType;

    public Ticket()
    {

    }

    public Ticket(double total, PaymentType paymentType)
    {
        this.total = total;
        this.paymentType = paymentType;
    }

public Ticket(PaymentType paymentType)
{
    this.paymentType = paymentType;
}
    /**
     * Creates a ticket with an id and checkin time between 7am and noon
     */
    public void checkIn()
    {
        CheckInTime = LocalTime.of(r.nextInt(6)+7, r.nextInt(60));
        id = count++;
    }

    /**
     * Generates checkout time
     */
    public void checkOut()
    {
      CheckOutTime =  LocalTime.of(r.nextInt(13)+8, r.nextInt(60));
    }

    /**
     * Calculates the total duration that a car was parked and the payment total
     */
    public void calculateHoursParked()
    {
        int hour = (int) Duration.between(CheckInTime, CheckOutTime).toHours();
        total = paymentType.getPaymentTotal(hour);
    }

    /**
     * Displays the number of hours parked to the user
     * @return Hours Parked
     */
    public int getHoursParked()
    {
        return (int) Duration.between(CheckInTime, CheckOutTime).toHours();
    }

    /**
     * Returns the id of the current car
     * @return id
     */
    public int getId()
    {
        return id;
    }

    /**
     * Returns the total amount due
     * @return total
     */
    public double getTotal()
    {
        return total;
    }

    public PaymentType getPaymentType()
    {
        return paymentType;
    }

    /**
     * Set the payment type
     * @param paymentType
     */
    public void setPaymentType(PaymentType paymentType)
    {
        this.paymentType = paymentType;
    }





}
