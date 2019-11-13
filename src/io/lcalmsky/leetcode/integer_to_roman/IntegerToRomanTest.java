package io.lcalmsky.leetcode.integer_to_roman;

public class IntegerToRomanTest {
    public static void main(String[] args) {
        IntegerToRomanTest integerToRomanTest = new IntegerToRomanTest();
        System.out.println(integerToRomanTest.intToRoman(3));
        System.out.println(integerToRomanTest.intToRoman(4));
        System.out.println(integerToRomanTest.intToRoman(9));
        System.out.println(integerToRomanTest.intToRoman(58));
        System.out.println(integerToRomanTest.intToRoman(1994));
    }

//    public String intToRoman(int num) {
//        TreeMap<Integer, String> map = new TreeMap<>();
//
//        map.put(1000, "M");
//        map.put(900, "CM");
//        map.put(500, "D");
//        map.put(400, "CD");
//        map.put(100, "C");
//        map.put(90, "XC");
//        map.put(50, "L");
//        map.put(40, "XL");
//        map.put(10, "X");
//        map.put(9, "IX");
//        map.put(5, "V");
//        map.put(4, "IV");
//        map.put(1, "I");
//
//        StringBuilder result = new StringBuilder();
//
//        int key = 0;
//        while (num > 0) {
//            key = map.floorKey(num);
//            result.append(map.get(key));
//            num -= key;
//        }
//
//        return result.toString();
//    }

    public String intToRoman(int num) {
        String[] str = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] val = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < val.length; i++) {
            while (num >= val[i]) {
                num -= val[i];
                sb.append(str[i]);
            }
        }
        return sb.toString();
    }
}
