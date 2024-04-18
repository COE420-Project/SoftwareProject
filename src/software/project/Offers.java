package software.project;

import java.util.ArrayList;

public class Offers {
String offers;
ArrayList <String> DiscountCode;
Client client;
Offers(Client client ){
	this.client = client;
}

boolean CheckUserType(){
	
//	if(client.getType()=='r') {
//		return true;
//	}
	
	return false;
}

void DisplayOffers() {
	for (String element : DiscountCode) {
		// display gui
    }
}



}
