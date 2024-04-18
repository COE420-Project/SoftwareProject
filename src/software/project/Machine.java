package software.project;

abstract public class Machine {
String id;
int cost ;
boolean status;
int powerConsumption;


public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public Boolean getStatus() {	
return status;
}

public void setStatus(boolean status) {
	this.status = status;
}

int calculateCost(int power) {
	return 0;
}
void start() {
}

void stop() {
}



}


