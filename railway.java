
import java.util.ArrayList;
import java.util.Scanner;

class Train {
    private String trainNumber;
    private String trainName;
    private int seatsAvailable;

    public Train(String trainNumber, String trainName, int seatsAvailable) {
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.seatsAvailable = seatsAvailable;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public String getTrainName() {
        return trainName;
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    public void bookSeat() {
        if (seatsAvailable > 0) {
            seatsAvailable--;
            System.out.println("Seat booked successfully on " + trainName);
        } else {
            System.out.println("No seats available on " + trainName);
        }
    }
}

public class railway {
    private ArrayList<Train> trains;

    public railway() {
        trains = new ArrayList<>();
        trains.add(new Train("12345", "Express Train", 10));
        trains.add(new Train("67890", "Local Train", 5));
    }

    public void displayTrains() {
        System.out.println("Available Trains:");
        for (Train train : trains) {
            System.out.println("Train Number: " + train.getTrainNumber() + ", Train Name: " + train.getTrainName() + ", Seats Available: " + train.getSeatsAvailable());
        }
    }

    public void bookTicket(String trainNumber) {
        for (Train train : trains) {
            if (train.getTrainNumber().equals(trainNumber)) {
                train.bookSeat();
                return;
            }
        }
        System.out.println("Train not found.");
    }

    public static void main(String[] args) {
        railway railwaySystem = new railway();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            railwaySystem.displayTrains();
            System.out.println("Enter train number to book a ticket (or 'exit' to quit): ");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            railwaySystem.bookTicket(input);
        }

        scanner.close();
    }
}



