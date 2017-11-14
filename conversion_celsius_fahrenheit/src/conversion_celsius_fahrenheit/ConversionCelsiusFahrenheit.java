package conversion_celsius_fahrenheit;

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
}
