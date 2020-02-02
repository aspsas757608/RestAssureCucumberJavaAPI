package org.amit.bdd.test.testcases;

import org.amit.bdd.test.utils.ReadConfiFiles;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class TestConfigFileRead {


    @Test
    public void testReadConfifFile(){
        Map m1 = ReadConfiFiles.letsReadConfiFile("/Users/amitsaxena/IdeaProjects/RestAssureCucumberJavaAPI/configFiles/","configPropertiesFile");
        List l1 = ReadConfiFiles.getAllPropertyNames("/Users/amitsaxena/IdeaProjects/RestAssureCucumberJavaAPI/configFiles/","testDataFile","official details");
        Map m2 = ReadConfiFiles.getAllPropertyAndValues("/Users/amitsaxena/IdeaProjects/RestAssureCucumberJavaAPI/configFiles/","testDataFile","official details");
        String hostAddress = ReadConfiFiles.getValueOfGivenSectionAndProperty("/Users/amitsaxena/IdeaProjects/RestAssureCucumberJavaAPI/configFiles/","testDataFile","official details","City");

        System.out.println(m1);
        System.out.println(l1);
        System.out.println(m2);
        System.out.println(hostAddress);
    }
}
