package conversion_celsius_fahrenheit;

import java.util.Scanner;

public class ConversionCelsiusFahrenheit {
	
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
