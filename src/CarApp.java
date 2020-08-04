import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CarApp {
	private static Scanner scnr = new Scanner(System.in);
	private static List<Car> cars = new ArrayList<>();

	public static void main(String[] args) {

		System.out.println("Welcome to the Grand Circus Motors admin console!");
		System.out.print("How many cars are you entering: ");
		int numOfCars = scnr.nextInt();

		scnr.nextLine();

		addCar(numOfCars);

		System.out.println("Current Inventory: \n");
		listCars();

	}

	public static void addCar(int numOfCars) {
		for (int i = 1; i <= numOfCars; i++) {
			scnr.nextLine();
			Car car = new Car();
			System.out.println("Enter Car #" + i + " Make: ");
			String make = scnr.nextLine();

			car.setMake(make);
			// scnr.nextLine();
			System.out.println("Enter Car #" + i + " Model: ");
			String model = scnr.nextLine();

			car.setModel(model);
			// scnr.nextLine();
			//System.out.println("Enter Car #" + i + "Year: ");
			//int year = scnr.nextInt();
			int year=Validator.getPositiveInt(scnr,"Enter Car #" + i + "Year: " );
			car.setYear(year);
			// scnr.nextLine();
			//System.out.println("Enter Car #" + i + "Price: ");
			//Double price = scnr.nextDouble();
			Double price=Validator.getDouble(scnr, "Enter Car #" + i + "Price: ");
			car.setPrice(price);
			cars.add(car);
			scnr.nextLine();
		}
	}

	public static void listCars() {
		for (int i = 0; i < cars.size(); i++) {

			// System.out.println("Car "+(i+1)+": "+cars.get(i));
			// System.out.println(cars.get(i).getMake()+" "+cars.get(i).getModel()+"
			// "+cars.get(i).getYear()+" "+cars.get(i).getPrice());
			System.out.printf("%-10s%-10s%-10d%-1s%-10.2f%n", cars.get(i).getMake(), cars.get(i).getModel(),
					cars.get(i).getYear(), "$", cars.get(i).getPrice());
		}
	}
}
