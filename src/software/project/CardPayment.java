package software.project;

import java.awt.*; 
import javax.swing.*;
public class CardPayment {
private Machine machine;
private Client client; // Assuming you have a Client object associated with the payment
public CardPayment(Client client, Machine machine) {
this.client = client;
this.machine = machine;

}





void pay(int amount) {
    int cardno = client.getCardnum(); 
    int scode = client.getSecurityCode(); 
    String date = client.getExpDate(); 
    int balance = client.getBalance();
    //int price = machine.calulateCost();

//    if (CheckValidInfo(cardno, scode, date) == true ) {
//        
//    } else {
//    	
//    	//error print
//    }
}
double ChackOffer(String offer) {
	
	if (offer.equals("20% off")) {
		return 0.2;
	}
	
	if (offer.equals("50% off")) {
		return 0.5;
	}
	return 1.0;
	
}

}



