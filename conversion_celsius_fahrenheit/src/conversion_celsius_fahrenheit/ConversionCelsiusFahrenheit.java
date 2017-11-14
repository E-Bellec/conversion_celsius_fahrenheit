package conversion_celsius_fahrenheit;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConversionCelsiusFahrenheit {
	
	/**
	 * Function main 
	 * @param args
	 */
	public static void main(String[] args) {
		
		boolean programClose = false;
		Scanner scanner = new Scanner(System.in);
		String conversion[] = {
			"Conversion Celsius > Fahrenheit",
			"Conversion Fahrenheit > Celsius"
		};
		
		System.out.println(
				"CONVERTISSEUR DEGRÉS CELSIUS ET DEGRÉS FAHRENHEIT\n"
				+ "-------------------------------------------------\n"
		);
		
		// As long as the user does not close the program
		while ( !programClose ) {
		
			// We ask the user what conversion he wants to make
			System.out.println(
					"Quelle conversion souhaitez-vous faire ?\n"
					+ "\t1 - " + conversion[0] + "\n"
					+ "\t2 - " + conversion[1]
			);
		
			// call of the function that retrieves the user input
			String responseUser = getConversionTheUserWantToMake( scanner ); // return 1 or 2 only
			
			System.out.println(
				responseUser
			);
			
			switch ( responseUser ) {
			case "1": // If the response is authorized
				
				// Call the conversion function with the type in parameter
				temperatureConversion(scanner, 1);
				
				// ask If The Program Should Be Closed
				programClose = askIfTheProgramShouldBeClosed(scanner); // Return for the loop
				break;
			case "2":// If the response is authorized
			    
				// Call the conversion function with the type in parameter
				temperatureConversion(scanner, 2);
				
				// ask If The Program Should Be Closed
				programClose = askIfTheProgramShouldBeClosed(scanner); // Return for the loop
				break;
			default: // If the response NOT authorized
				System.out.println("Response not authorized");

		} // END switch
			
		} // END while program close = false
		
		System.out.println("Closure of the program");
		scanner.close();
		System.exit(0); // close the program without error
			
	} // END main
	
	/**
	 * get type of conversion the user want to make
	 * @return the conversion type 1 or 2 only
	 */
	public static String getConversionTheUserWantToMake ( Scanner scanner ) {
		String result = new String();
		boolean userInputIsCorrect = false;

		// As long as the entry is not admissible
		while (!userInputIsCorrect) {

			// get user response
			String getResponse = new String( scanner.nextLine() );

			// If the response is authorized
			if ( getResponse.equals("1") ||   getResponse.equals("2") ) {

				result = new String(getResponse); // We add the answer in the return variable
				userInputIsCorrect = true; // We allow the program out of the loop
			} else {
				// If the entry is not allowed

				result = new String(); // we empty the variable
			}

		} // END while userInputIsCorrect
		
		return result;
	} // END getConversionTheUserWantToMake
	
	/**
	 * function temperatureConversion
	 * @param formula 1 or 2 only
	 * 1 : Conversion Celsius to Fahrenhei
	 * 2 : Conversion Fahrenhei > Celsius
	 */
	public static void temperatureConversion ( Scanner scanner, int formulaIndex ) {
		
		System.out.println("Température à convertir :");
		double response;
		
		try {
			response = scanner.nextDouble();
			scanner.nextLine(); // Empty the read line
			double result = 0d;
			
			switch ( formulaIndex ) {
				case 1: // Conversion Celsius > Fahrenheit
					
					// Process conversion
					result = ( (9d/5d) * response)  + 32d;
					
					// Print the round result
					System.out.println( 
						round( response, 2 )  + "°C correspond à " + round( result, 2 ) + "°F"
					);
					
					break;
				case 2:// Conversion  Fahrenheit > Celsius
					
					// Process conversion
					result = ( (response - 32d) * 5d) / 9d;
					
					// Print the round result
					System.out.println( 
						round( response, 2 ) + "°F correspond à " + round( result, 2 ) + "°C"
					);
					
					break;
				default: // If the formulaIndex NOT authorized
					System.out.println("temperatureConversion : Parameter not authorized");
			}
			
		} catch (InputMismatchException e){
			System.out.println(scanner.next()+" n'est pas une valeur valide");
			// recall function
			temperatureConversion ( scanner, formulaIndex );
		}
		
	} // END temperatureConversion
	
	/**
	 * @param A
	 * @param B
	 * @return round result
	 */
	public static double round(double A, int B) {
		return (double) ( 
			(int) (
				A * Math.pow(10, B) + .5
			)
		) / Math.pow(10, B);
	}
	
	/**
	 * function ask If The Program Should Be Closed
	 * @return boolean true = close
	 */
	public static boolean askIfTheProgramShouldBeClosed (Scanner scanner) {
		boolean result = false;
		char response;
		
		//  print ask If The Program Should Be Closed
		System.out.println( 
			"Souhaitez-vous convertirune autre température ? \n"
			+ "\t N : Close program\n"
			+ "\t Ohter key : Restart program\n"
		);
		
		// Get response user
		String responseString  = scanner.nextLine(); 
		
		// If response is empty
		if ( responseString.equals("") ) {
			response = 'o';
		} else {
			// if response is not empty
			response = responseString.charAt(0);
		}

		// If the program must be closed
		if (  response == 'N' || response == 'n' ) {
			result = true;
		}
		
		return result;
	} // END getConversionTheUserWantToMake
}
