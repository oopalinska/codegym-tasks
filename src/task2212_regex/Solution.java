package task2212_regex;

/*
Phone number verification

*/
public class Solution {
    public static boolean checkPhoneNumber(String phoneNumber) {
        if (phoneNumber == null) return false;
        //Make patterns for all the possible valid versions
        if (phoneNumber.matches("\\+\\d{12}")) return true; //+380501234567
        if (phoneNumber.matches("^\\+\\d{2}\\(\\d{3}\\)\\d{7}")) return true; //+38(050)1234567
        if (phoneNumber.matches("^\\+\\d{8}-\\d{2}-\\d{2}")) return true; //+38050123-45-67
        return phoneNumber.matches("^\\d{6}-\\d{4}"); //050123-4567
    }

    public static void main(String[] args) {

    }
}
