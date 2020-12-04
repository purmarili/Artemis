package Car_Park;

public class CarParkManager {

    public static void main(String[] args) {

        LicensePlate plateA = new LicensePlate("GE", "AA", 11);
        LicensePlate plateB = new LicensePlate("GE", "BB", 31);

        Car carA = new Car("VolksWagen", plateA);
        Car carB = new Car("Mercedes", new LicensePlate("GE", "CC", 42));

        CarPark cp = new CarPark(2);
        cp.park(carA);
        System.out.println(cp.driveOff(plateB));

//		// License Plate Demo
//		LicensePlate plateA;
//		plateA = new LicensePlate("GE","AA",17);
//		if(plateA.getDigits() == 112) { // plateA.digits
//			// DO SMTH
//		}
//		
//		plateA = new LicensePlate("GE","BB",11);
//		
//		
//		// 'System.out.println' is same as 'write'
//		System.out.println(plateA.toString());
//		
//		LicensePlate plateB = new LicensePlate("GE","AB",420);
//		LicensePlate plateC = new LicensePlate("GE","AB",420);
//		if(plateA.isEqual(plateB))
//			System.out.println("plateA equals plateB");
//		else 
//			System.out.println("plateA doesn't equal plateB");
//		if(plateC.isEqual(plateB))
//			System.out.println("plateC equals plateB");
//		else 
//			System.out.println("plateC doesn't equal plateB");
//		
//		// Car Demo
//		Car carA = null;
//		carA = new Car("Tesla",plateA);
//		System.out.println(carA.toString());
//		
//		// Get and set object attributes
//		System.out.println("carA's brand is " + carA.getBrand());
//		carA.setBrand("VolksWagen");
//		System.out.println("carA's brand is " + carA.getBrand());
//		
//		
//		Car carB = carA;
//		System.out.println("'carA' : " + carA.toString());
//		System.out.println("'carB' : " + carB.toString());
//		
//		// Unlike primitive types objects are not copied in Java
//		// Both carA and carB point to the same object in memory
//		// and changing one affects another too.
//		carB.setBrand("BMW");
//		System.out.println("'carA' : " + carA.toString());
//		System.out.println("'carB' : " + carB.toString());
//		
//		// New objects are created only with 'new' keyword.
//		// When creating a new variable chassis number is
//		// increased and is visible for every object of
//		// same class as it's static.
//		carB = new Car(carA.getBrand(), plateB);
//		System.out.println("'carA' : " + carA.toString());
//		System.out.println("'carB' : " + carB.toString());
//		
//		// CarPark demo
//		CarPark carPark = new CarPark(2);
//		carPark.park(carA);
//		if(carPark.search(carA.getLicensePlate()) != -1)
//			System.out.println("'carA' is in the car park.");
//		else 
//			System.out.println("'carA' is not in the car park.");
//		
//		if(carPark.park(carB) != -1) 
//			System.out.println("new car was parked");
//		else 
//			System.out.println("new car was not parked");
//		
//		if(carPark.park(new Car("Vaz",new LicensePlate("GE","ZZ",12))) != -1) 
//			System.out.println("new car was parked");
//		else 
//			System.out.println("new car was not parked");

    }

}
