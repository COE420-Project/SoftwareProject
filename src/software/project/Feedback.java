package software.project;

import java.util.ArrayList;
import java.util.List;

public class Feedback extends javax.swing.JFrame{
    private static List<String> feedbackList = new ArrayList<>();

    public static void retrieveAllFeedback() {
        DBconnection con = new DBconnection();
        feedbackList = con.getAllFeedback();      
    }
    
    public static void printAllFeedback(ArrayList<String> feedbackList) {
        DBconnection con = new DBconnection();
        con.printFeedback(feedbackList);
    }
    
}
