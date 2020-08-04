import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CarAppPart2 {
	private static Scanner scnr = new Scanner(System.in);
	private static List<Car> cars = new ArrayList<>();
	private static Map<Integer, Car> carMap = new HashMap<>();

	static {
		cars.add(new Car("Subaru", "Impreza", 2018, 24000.00));
		cars.add(new Car("Ford", "Focus RS", 2019, 45000.00));
		cars.add(new Car("Mitsubishi", "Lancer", 2019, 2000.00));
		cars.add(new UsedCar("Toyota", "Rav4", 2009, 5000.00, 19000.00));
		cars.add(new UsedCar("Nissan", "Cube", 2000, 2.00, 300.00));
		cars.add(new UsedCar("Subaru", "Crossover", 1999, 6000.00, 13000.00));
		cars.add(new Car("Quit", "", 0, 0.0));
	}

	public static void main(String[] args) {

		try {

			carMapping();

			System.out.println("\n");
			System.out.println("Which car would you like? ");

			int carNumber = scnr.nextInt();
			quitCarApp(carNumber);
			displaySelectedCar(carNumber);
			scnr.nextLine();

			boolean valid = Validator.getYesNo(scnr, "Would you like to buy this car?");
			while (valid) {

				buyCar(carNumber);

				System.out.println("Excellent! Our finance department will be in touch shortly. \n");
				carMapping();

				System.out.print("Which car would you like? ");
				carNumber = scnr.nextInt();
				scnr.nextLine();
				quitCarApp(carNumber);
				displaySelectedCar(carNumber);
				// valid=false;

				valid = Validator.getYesNo(scnr, "Would you like to buy this car?");

			}
		} catch (Exception e) {
			System.out.println("Invalid Input");
		}

		// listCars();
	}

	private static void quitCarApp(int carNumber) {
		if (cars.size() == carNumber) {
			System.out.println("Have a great day!");
			System.exit(0);
		}
	}

	public static void carMapping() {
		carMap.clear();
		for (int i = 0; i < cars.size(); i++) {
			carMap.put(i, cars.get(i));

		}
		String make = "";
		String model = "";
		String year = "";
		String price = "";
		// String mileage = "";

		for (Map.Entry<Integer, Car> entry : carMap.entrySet()) {
			if (cars.get(entry.getKey()).getClass().equals(Car.class)) {
				make = entry.getValue().getMake();
				model = entry.getValue().getModel();
				price = entry.getValue().getMake().equalsIgnoreCase("quit") ? ""
						: "$" + String.valueOf(entry.getValue().getPrice());
				year = entry.getValue().getMake().equalsIgnoreCase("quit") ? ""
						: String.valueOf(entry.getValue().getYear());

				/*
				 * System.out.printf("%-10d%-20s%-20s%-20d%-1s%-10.2f%n", entry.getKey() + 1,
				 * entry.getValue().getMake(), entry.getValue().getModel(),
				 * entry.getValue().getYear(), "$", entry.getValue().getPrice());
				 */
				// System.out.printf("%-10d%-20s%-20s%-20d%-1s%-10.2f%n", entry.getKey() + 1,
				// make, model, year, "$",
				// price);
				System.out.printf("%-10d%-20s%-20s%-20s%-10s%n", entry.getKey() + 1, make, model, year, price);

			} else if (cars.get(entry.getKey()).getClass().equals(UsedCar.class)) {
				double mileage = ((UsedCar) cars.get(entry.getKey())).getMileage();
				System.out.printf("%-10d%-20s%-20s%-20d%-1s%-10.2f%-1s%-10.2f%n", entry.getKey() + 1,
						entry.getValue().getMake(), entry.getValue().getModel(), entry.getValue().getYear(), "$",
						entry.getValue().getPrice(), "(Used)", mileage);
			}
		}
	}

	public static void displaySelectedCar(int carNumber) {

		if (cars.get(carNumber - 1).getClass().equals(Car.class)) {
			System.out.printf("%-20s%-20s%-20d%-1s%-10.2f%n", carMap.get(carNumber - 1).getMake(),
					carMap.get(carNumber - 1).getModel(), carMap.get(carNumber - 1).getYear(), "$",
					carMap.get(carNumber - 1).getPrice());
		}
		// else if(cars.get(carNumber) instanceof UsedCar)
		else if (cars.get(carNumber - 1).getClass().equals(UsedCar.class)) {
			double mileage = ((UsedCar) cars.get(carNumber - 1)).getMileage();
			// map.get(carNumber).get
			System.out.printf("%-10s%-10s%-10d%-1s%-1.2f%-1s%-1.2f%n", carMap.get(carNumber - 1).getMake(),
					carMap.get(carNumber - 1).getModel(), carMap.get(carNumber - 1).getYear(), "$",
					carMap.get(carNumber - 1).getPrice(), "(Used)", mileage);
		}
	}

	public static void showCarById(int id) {
		System.out.println(cars.get(id - 1));
	}

	public static void buyCar(int id) {
		cars.remove(id - 1);

	}
}
