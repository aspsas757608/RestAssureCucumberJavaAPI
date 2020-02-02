package org.amit.bdd.test.testcases;

import org.amit.bdd.test.utils.ReadConfiFiles;
import org.testng.annotations.Test;

import java.util.Map;

public class TestConfigFileRead {

@Test
    public void testReadConfifFile(){

    Map m1 = ReadConfiFiles.letsReadConfiFile("/Users/amitsaxena/Desktop/","data1.csv","");

    }
}
