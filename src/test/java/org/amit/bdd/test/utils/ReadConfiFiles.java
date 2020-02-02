package org.amit.bdd.test.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ReadConfiFiles {

    public static Map letsReadConfiFile(String configFilePath, String configFileName, String configSection) {

        Map<String, String> configValuesMap = new HashMap<String, String>();

        File myConfigFile = new File(configFilePath+configFileName);

        try {
            Scanner sc = new Scanner(myConfigFile);

            while(sc.hasNextLine()) {

                System.out.println(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    }
