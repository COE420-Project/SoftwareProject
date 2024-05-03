package software.project;

public class Drying_Machine extends Machine {

	
    int duration;

    public Drying_Machine(int id, boolean status) {
        super(id, status);
    }
    
	int calulateCost(int power) {
		return duration * power;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
    
    
    
    
    
    

}
