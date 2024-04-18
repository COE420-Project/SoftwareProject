package software.project;

public class Dying_Machine extends Machine {

	
    int duration;
    
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
