import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.time.LocalTime;

import static org.junit.Assert.*;

public class TicketTest {



    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void ticketTest()
    {


    }


    @Test
    public void checkIn() {
    }

    @Test
    public void checkOut() {
    }

    @Test
    public void calculateHoursParked() {
        Ticket testLostTicket = new Ticket(new LostTicketFeeStrategy());
        Ticket testMinMaxTicket = new Ticket(new MinMaxFeeStrategy());
        Ticket testSpecialTicket = new Ticket(new SpecialEventFeeStrategy());
        testLostTicket.checkIn();
        testLostTicket.checkOut();
        testLostTicket.calculateHoursParked();
        testSpecialTicket.checkIn();
        testSpecialTicket.checkOut();
        testSpecialTicket.calculateHoursParked();
        testMinMaxTicket.checkIn();
        testMinMaxTicket.checkOut();
        testMinMaxTicket.calculateHoursParked();
    }

    @Test
    public void getHoursParked() {
    }

    @Test
    public void getId() {
    }

    @Test
    public void getTotal() {
    }

    @Test
    public void getPaymentType() {
    }

    @Test
    public void setPaymentType() {
    }
}