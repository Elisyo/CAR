public class Calculatrice {

	public int calculer(String calcul, Integer ans) {
		int result = 0;
		String[] tab = calcul.split(" ");
		if(tab.length==1){
			return Integer.parseInt(tab[0]);
		}else if(tab.length==2){
			switch (tab[0]) {
			case ("+"):
				try {
					return ans + Integer.parseInt(tab[1]);
				} catch (Exception e) {
					break;
				}
			case ("-"):
				try {
					return ans - Integer.parseInt(tab[1]);
				} catch (Exception e) {
					break;
				}
			case ("/"):
				try {
					return ans / Integer.parseInt(tab[1]);
				} catch (Exception e) {
					break;
				}
			case ("*"):
				try {
					return ans * Integer.parseInt(tab[1]);
				} catch (Exception e) {
					break;
				}
			}
		}else{
			switch (tab[0]) {
			case ("+"):
				try {
					return Integer.parseInt(tab[1]) + Integer.parseInt(tab[2]);
				} catch (Exception e) {
					break;
				}
			case ("-"):
				try {
					return Integer.parseInt(tab[1]) - Integer.parseInt(tab[2]);
				} catch (Exception e) {
					break;
				}
			case ("/"):
				try {
					return Integer.parseInt(tab[1]) / Integer.parseInt(tab[2]);
				} catch (Exception e) {
					break;
				}
			case ("*"):
				try {
					return Integer.parseInt(tab[1]) * Integer.parseInt(tab[2]);
				} catch (Exception e) {
					break;
				}
			}
		}
		return result;
	}

}
