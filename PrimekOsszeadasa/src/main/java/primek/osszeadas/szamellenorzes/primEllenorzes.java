package primek.osszeadas.szamellenorzes;

public class primEllenorzes {
	
	// eldönti a beadott számról hogy az prímszám -e 
	public static boolean PrimVizsgalat(int szam) {
	    for (int i = 2; i < szam; i++) {
	        if (szam % i == 0) {
	            return false;
	        }
	    }
	    return true;
	}

}
