package br.com.aab;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MySetTest {
    public static void main(String[] args) {
        Set mySetStringArray = new HashSet<String[]>() {{
            add(new String[] {"oracle", "aws", "Redhat"});
            add(new String[] {"equip"});
            add(new String[] {"point"});
            add(new String[] {"oracle", "aws", "Redhat"});
            add(new String[] {"equip"});
            add(new String[] {"point"});
        }};
        System.out.println("mySetStringArray ---> " + mySetStringArray);

        List<String> oracleAwsRedHat1List = Arrays.asList("oracle", "aws", "Redhat");
        List<String> oracleAwsRedHat2List = Arrays.asList("oracle", "aws", "Redhat");
        List<String> oracleAwsRedHat3List = Arrays.asList("oracle", "aws", "Redhat");

        System.out.println("oracleAwsRedHat1List -> "+ System.identityHashCode(oracleAwsRedHat1List));
        System.out.println("oracleAwsRedHat2List -> "+ System.identityHashCode(oracleAwsRedHat2List));
        System.out.println("oracleAwsRedHat3List -> "+ System.identityHashCode(oracleAwsRedHat3List));

        Set mySetStringArray2 = new HashSet<List<String>>() {{
            add(oracleAwsRedHat1List);
            add(oracleAwsRedHat2List);
            add(oracleAwsRedHat3List);
        }};
        System.out.println("mySetStringArray2 ---> " + mySetStringArray2);
    }
}
