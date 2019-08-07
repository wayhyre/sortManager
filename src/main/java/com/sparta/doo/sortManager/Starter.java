package com.sparta.doo.sortManager;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.util.Scanner;


/**
 * Hello world!
 */
public class Starter {
    
    static final String LOG_PROPERTIES_FILE = "resources/log4j.properties";
    static Logger log = Logger.getLogger(Starter.class.getName());
    
    public static void main(String[] args) {
        initialiseLogging();
        Scanner myScanner = new Scanner(System.in);  // Create a Scanner object to take user input
        System.out.println("Enter sort type: 1 For Bubble sort, 2 for Merge Sorter ");
        


        //We force the input to be an int because in this scenario we assume the user input should be always numbers
        int sortType = Integer.parseInt(myScanner.nextLine());
        SortManager sortManager = new SortManager();
        sortManager.runSort(sortType);
    }
    
    public static void initialiseLogging(){
        PropertyConfigurator.configure(LOG_PROPERTIES_FILE);
        log.debug("Logging initialised.");
    }

}


