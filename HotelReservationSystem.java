import java.util.ArrayList;
import java.util.Scanner;

class Room {
    int roomNumber;
    String category;
    boolean isBooked;

    Room(int roomNumber, String category) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.isBooked = false;
    }
}

public class HotelReservationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Room> rooms = new ArrayList<>();

        // Pre-populating rooms
        rooms.add(new Room(101, "Standard"));
        rooms.add(new Room(102, "Standard"));
        rooms.add(new Room(201, "Deluxe"));
        rooms.add(new Room(202, "Deluxe"));

        int choice;

        do {
            System.out.println("\n=== HOTEL RESERVATION SYSTEM ===");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\n--- Available Rooms ---");
                    for (Room room : rooms) {
                        String status = room.isBooked ? "Booked" : "Available";
                        System.out.println("Room " + room.roomNumber + " [" + room.category + "] - " + status);
                    }
                    break;

                case 2:
                    System.out.print("Enter Room Number to book: ");
                    int bookNum = scanner.nextInt();
                    boolean foundBook = false;
                    for (Room room : rooms) {
                        if (room.roomNumber == bookNum) {
                            foundBook = true;
                            if (!room.isBooked) {
                                room.isBooked = true;
                                System.out.println("Room " + bookNum + " booked successfully!");
                            } else {
                                System.out.println("Sorry, room is already booked.");
                            }
                            break;
                        }
                    }
                    if (!foundBook) System.out.println("Room not found!");
                    break;

                case 3:
                    System.out.print("Enter Room Number to cancel booking: ");
                    int cancelNum = scanner.nextInt();
                    boolean foundCancel = false;
                    for (Room room : rooms) {
                        if (room.roomNumber == cancelNum) {
                            foundCancel = true;
                            if (room.isBooked) {
                                room.isBooked = false;
                                System.out.println("Booking for Room " + cancelNum + " cancelled.");
                            } else {
                                System.out.println("Room was not booked.");
                            }
                            break;
                        }
                    }
                    if (!foundCancel) System.out.println("Room not found!");
                    break;

                case 4:
                    System.out.println("Thank you for using Hotel Reservation System!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 4);

        scanner.close();
    }
}