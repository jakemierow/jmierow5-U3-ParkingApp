import java.io.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class ParkingGarage {
    private static ParkingGarage instance = null;
    private Random r = new Random();
    Ticket currentTicket = new Ticket();
    MinMaxFeeStrategy MinMaxFeeStrategy = new MinMaxFeeStrategy();
    SpecialEventFeeStrategy SpecialEventFeeStrategy = new SpecialEventFeeStrategy();
    LostTicketFeeStrategy LostTicketFeeStrategy = new LostTicketFeeStrategy();

    public ParkingGarage() {
        printCheckInMenu();
    }

    /**
     * Display checkin menu to the user
     */
    public void printCheckInMenu() {
        System.out.println("\nBest Value Parking Garage");
        System.out.println("=========================");
        System.out.println("1 - Check/In");
        System.out.println("2 - Close Garage");

        Scanner keyboard = new Scanner(System.in);
        String s = keyboard.nextLine();
        int choice = Integer.parseInt(s);
        switch (choice) {
            case 1:
                currentTicket.checkIn();
                System.out.println("\nBest Value Parking Garage");
                System.out.println("Check-in");
                System.out.println("=========================");
                System.out.println("1 - Ticket");
                System.out.println("2 - Special Event");
                String TicketType = keyboard.nextLine();
                int tType = Integer.parseInt(TicketType);
                switch (tType) {
                    case 1:
                        System.out.println("Vehicle checked in.");
                        printCheckOutMenu();
                        break;
                    case 2:
                        System.out.println("\nReceipt for a vehicle id" + " " + currentTicket.getId());
                        System.out.println("\nSpecial Event");
                        System.out.println("\n$" + SpecialEventFeeStrategy.getFee() + "0");
                        printCheckInMenu();
                        break;

                }
                String num = keyboard.nextLine();
                int c = Integer.parseInt(num);
                switch (c) {
                    case 1:
                        System.out.println("Receipt for a vehicle id" + " " + currentTicket.getId());
                        currentTicket.checkOut();
                        currentTicket.setPaymentType(new MinMaxFeeStrategy());
                        currentTicket.calculateHoursParked();
                        System.out.println("\n" + currentTicket.getHoursParked() + " hours parked ");
                        System.out.println("\n$" + currentTicket.getTotal() + "0");
                        printCheckInMenu();
                        break;
                    case 2:
                        System.out.println("Receipt for a vehicle id" + " " + currentTicket.getId());
                        System.out.println("\nLost Ticket");
                        System.out.println("\n$" + LostTicketFeeStrategy.getFee() + "0");
                        printCheckInMenu();

                }
                break;
            case 2:
                closeGarage();

        }
    }

    /**
     * Display Checkout menu to the user
     */
    public void printCheckOutMenu() {
        System.out.println("\nBest Value Parking Garage");
        System.out.println("=========================");
        System.out.println("1 - Check/Out");
        System.out.println("2 - Lost Ticket");
    }

    /**
     * Closes the garage
     */
    public void closeGarage()
    {
        System.exit(0);
    }

    /**
     * Singleton design pattern
     * @return new parking garage
     */
    public static ParkingGarage getInstance()
    {
        if(instance == null)
        {
            instance = new ParkingGarage();
        }
        return instance;
    }

}









