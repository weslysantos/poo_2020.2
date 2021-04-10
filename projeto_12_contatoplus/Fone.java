public class Fone {
	private String label;
	private String num;
	public Fone(String label, String num) {
		if(!validarNum(num)) {
			throw new RuntimeException("Número Inválido");
		}
		this.label = label;
		this.num = num;
	}
	public String getLabel() {
		return this.label;
	}
	public String getNum() {
		return this.num;
	}
	public static boolean validarNum(String num) {
		String solve = "0123456789()-";
		for(int i = 0; i < num.length(); i++) {
			if(solve.indexOf(num.charAt(i)) == -1) {
				return false;
			}
		}
		return true;
	}
	public String toString() {
		return this.label + ":" + this.num;
	}
}


