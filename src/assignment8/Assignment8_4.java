package assignment8;
class Passenger extends Thread 
{

	Reservation reserve;
	int requestedSeats;
	String passengerName;
	public Passenger(Reservation reserve, int requestedSeats, String passengerName) 
	{
		this.reserve = reserve;
		this.requestedSeats = requestedSeats;
		this.passengerName =passengerName;
	}
	// Invoke the reservation method
	public void run()
	{
		reserve.reserveSeat(requestedSeats,passengerName);
	}
}
class Reservation 
{

	static int availableSeats = 20;
	// synchronized reserveSeat method to book tickets.
	synchronized void reserveSeat(int requestedSeats,String passengerName) 
	{
		System.out.println("Available seats : " + availableSeats + " Requested setas : " + requestedSeats);
		//Book tickets if available seats are  greater that requested seats.
		if (availableSeats >= requestedSeats) 
		{
			System.out.println("Seat Available. Reserve now");
			try 	
			{
				Thread.sleep(100);
			} 
			catch (InterruptedException e) 
			{
				System.out.println("Thread interrupted");
			}
			System.out.println(requestedSeats + " seats is/are booked for "+passengerName);
			availableSeats = availableSeats - requestedSeats;
		} 
		else 
		{
			System.out.println("Requested seats not available");
		}
		System.out.println("----------------------------------------------");
	}
}
public class Assignment8_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Reservation reserve = new Reservation();
		// Invoke booking of first passenger
		Passenger passenger1 = new Passenger(reserve, 10, "Ram");
		passenger1.start();

		// Invoke booking of second passenger
		Passenger passenger2 = new Passenger(reserve, 8, "Shyam");
		passenger2.start();

		// Invoke booking of third passenger
		Passenger passenger3 = new Passenger(reserve, 4, "Meghna");
		passenger3.start();
	}

}
