package software.project;

public class Washing_Machine extends Machine {

	int cycles;

    public Washing_Machine(int id, boolean status) {
        super(id, status);
    }
	
	
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
