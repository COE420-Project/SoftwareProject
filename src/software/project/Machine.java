package software.project;

abstract public class Machine {
int id;
int cost ;
boolean status;
int powerConsumption;

Machine(){
}
Machine(int id, boolean status ){
    this.id = id;
    this.status = status;
 
}
public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public boolean getStatus() {	
return status;
}

public void setStatus(boolean status) {
	this.status = status;
}

int calculateCost(int c_d) {
	return c_d*100;
}
void start() {
}

void stop() {
}



}


