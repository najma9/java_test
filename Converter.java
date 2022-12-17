//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.TreeMap;

public class Converter {
    TreeMap<Character, Integer> romanKeyMap = new TreeMap<>();
    TreeMap<Integer, String> arabianKeyMap = new TreeMap<>();

    public Converter() {
        this.romanKeyMap.put('I', 1);
        this.romanKeyMap.put('V', 5);
        this.romanKeyMap.put('X', 10);
        this.arabianKeyMap.put(10, "X");
        this.arabianKeyMap.put(9, "IX");
        this.arabianKeyMap.put(5, "V");
        this.arabianKeyMap.put(4, "IV");
        this.arabianKeyMap.put(1, "I");
    }

    public boolean isRoman(String number) {
        return this.romanKeyMap.containsKey(number.charAt(0));
    }

    public String intToRoman(int number) {
        StringBuilder roman = new StringBuilder();

        do {
            int arabianKey = this.arabianKeyMap.floorKey(number);
            roman.append(this.arabianKeyMap.get(arabianKey));
            number -= arabianKey;
        } while(number != 0);

        return roman.toString();
    }

    public int romanToInt(String s) {
        int end = s.length() - 1;
        char[] arr = s.toCharArray();
        int result = this.romanKeyMap.get(arr[end]);

        for(int i = end - 1; i >= 0; --i) {
            int arabian = this.romanKeyMap.get(arr[i]);
            if (arabian < this.romanKeyMap.get(arr[i + 1])) {
                result -= arabian;
            } else {
                result += arabian;
            }
        }

        return result;
    }
}
