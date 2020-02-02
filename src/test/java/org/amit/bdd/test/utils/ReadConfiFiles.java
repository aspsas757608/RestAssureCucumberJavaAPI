package org.amit.bdd.test.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import org.apache.commons.configuration2.INIConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

public class ReadConfiFiles {

    public static Map letsReadConfiFile(String configFilePath, String configFileName) {

        Map<String, String> configValuesMap = new HashMap<String, String>();

        File myConfigFile = new File(configFilePath+configFileName);

        String singleLine;

        try {
            Scanner sc = new Scanner(myConfigFile);

            while(sc.hasNextLine()) {

                //System.out.println(sc.nextLine());
                singleLine = sc.nextLine();
                String [] wordsInSingleLine = singleLine.split("=");
                if(wordsInSingleLine.length ==2) {

                    configValuesMap.put(wordsInSingleLine[0],wordsInSingleLine[1]);
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return configValuesMap;
    }

    public static List<String> getAllPropertyNames(String configFilePath, String configFileName, String configSection) {

        Configurations configs = new Configurations();
        List<String> allProperties = new ArrayList<>();

        try {
            INIConfiguration config = configs.ini(configFilePath+configFileName);
            Iterator<String> keys = config.getKeys(configSection.toLowerCase());

            while(keys.hasNext()) {
                String [] key = keys.next().split("\\.");
                allProperties.add(key[1]);
            }
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }


        return allProperties;
    }

    public static Map<String,String> getAllPropertyAndValues(String configFilePath, String configFileName, String configSection) {

        Map<String,String> propertyValueHashMap = new HashMap<String, String>();

        Configurations configs = new Configurations();

        try {
            INIConfiguration config = configs.ini(configFilePath+configFileName);
            Iterator<String> propertyKeys = config.getKeys(configSection.toLowerCase());
            while(propertyKeys.hasNext()) {
                String [] propertiesArray = propertyKeys.next().split("\\.");
                //String [] words = propertiesArray[1].split("=");
                propertyValueHashMap.put(propertiesArray[1],"Value could not be extracted by Program");



            }
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }


        return propertyValueHashMap;
    }

    public static String getValueOfGivenProperty(String configFilePath, String configFileName, String propertyName) {
        return getValueOfGivenSectionAndProperty(configFilePath, configFileName, null, propertyName);
    }

    public static String getValueOfGivenSectionAndProperty(String configFilePath, String configFileName, String configSection, String propertyName) {

        String columnName = null;
        try {
            propertyName = propertyName.trim();
            Configurations configs = new Configurations();
            INIConfiguration iniConfig = configs.ini(configFilePath+configFileName);
            if(configSection != null && iniConfig.getProperty(configSection.toLowerCase() + "."+propertyName.toLowerCase()) != null)
            {

            }
            else if(iniConfig.getProperty(propertyName.toLowerCase()) != null) {
                String value = (String) iniConfig.getProperty(propertyName.toLowerCase().toString());

                if(!value.isEmpty()) {
                    columnName = (String) iniConfig.getProperty(propertyName.toString());
                }
            }

        }
        catch (Exception e) {

        }

        return columnName;
    }

    }
