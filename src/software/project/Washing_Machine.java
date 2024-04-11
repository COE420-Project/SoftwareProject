package software.project;

public class Washing_Machine extends Machine {

	int cycles;
	
	
	int calulateCost(int power) {
		return cycles * power;
	}

	public int getCycles() {
		return cycles;
	}

	public void setCycles(int cycles) {
		this.cycles = cycles;
	}
	
	


}
