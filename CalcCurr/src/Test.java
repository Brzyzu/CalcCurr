//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public Test() {
    }

    public static void main(String[] args) {
        showFile("eurofxref-daily.xml");
        String input1 = "PlN";
        String input2 = "US";
        String input3 = "";
        String input4 = "exIt";
        System.out.println("Czy waluta?");
        System.out.println(IsCurrency(input1));
        System.out.println(IsCurrency(input2));
        System.out.println(IsCurrency(input3));
        System.out.println(IsCurrency(input4));
        System.out.println("Czy exit?");
        System.out.println(IsExit(input4));
        System.out.println(IsExit(input2));
        String input5 = "2000000";
        String input6 = "20.";
        String input7 = "20,01";
        String input8 = "645120.09";
        String input9 = "0";
        String input10 = "-20";
        System.out.println("Czy wartosc?");
        System.out.println(IsValue(input5));
        System.out.println(IsValue(input6));
        System.out.println(IsValue(input7));
        System.out.println(IsValue(input8));
        System.out.println(IsValue(input9));
        System.out.println(IsValue(input10));
    }

    public static void showFile(String file) {
        HashMap<String, Double> currenciesMap = (new ReadFile()).parseToMap(file);
        Iterator var2 = currenciesMap.keySet().iterator();

        while(var2.hasNext()) {
            String key = (String)var2.next();
            System.out.println("currency: " + key + ", rate: " + currenciesMap.get(key));
        }

    }

    public static boolean IsCurrency(String input) {
        HashMap<String, Double> currenciesMap = (new ReadFile()).parseToMap("eurofxref-daily.xml");
        return currenciesMap.containsKey(input.toUpperCase());
    }

    public static boolean IsExit(String input) {
        return input.equalsIgnoreCase("exit");
    }

    public static boolean IsValue(String input) {
        Pattern pattern = Pattern.compile("\\d+[.].\\d{0,2}|\\d+");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
