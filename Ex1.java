public class Ex1
{

public static int number2Int(String num)
{
    if (!isNumber(num))
    {
        return -1;
    }

    int bIndex = num.indexOf('b');
    if (bIndex == -1 || bIndex == 0 || bIndex == num.length() - 1)
    {
        return -1;
    }

    String numberPart = num.substring(0, bIndex);
    String basePart = num.substring(bIndex + 1);
    int base = extractBase(basePart);

    if (base < 2 || base > 16) {
        return -1;
    }

    int decimalValue = 0;
    for (int i = 0; i < numberPart.length(); i++) {
        char c = numberPart.charAt(i);
        int numericValue;

        if (c >= '0' && c <= '9') {
            numericValue = c - '0';
        } else if (c >= 'A' && c <= 'G') {
            numericValue = (c - 'A') + 10;
        } else {
            return -1;
        }

        if (numericValue >= base) {
            return -1;
        }

        decimalValue = decimalValue * base + numericValue;
    }

    return decimalValue;
}





/**
 * This static function checks if the given String (g) is in a valid "number" format.
 * @param a a String representing a number
 * @return true iff the given String is in a number format
 */
public static boolean isNumber(String a)
{
    if (a == null || a.isEmpty())
    {
        return false;
    }

    int delimiter = a.indexOf('b');
    if (delimiter == -1) {
        return false;
    }
    if(delimiter!=a.length()-2)
    {
        return false;
    }

    String numberPart = a.substring(0, delimiter);
    String basePart = a.substring(delimiter + 1);

    if (numberPart.isEmpty() || basePart.isEmpty())
    {
        return false;
    }

    int base = extractBase(basePart);
    if (base == -1) {
        return false;
    }

    for (int i = 0; i < numberPart.length(); i++) {
        char c = numberPart.charAt(i);
        int numericValue;

        if (c >= '0' && c <= '9') {
            numericValue = c - '0';
        } else if (c >= 'A' && c <= 'G') {
            numericValue = (c - 'A') + 10;
        } else {
            return false;
        }

        if (numericValue >= base) {
            return false;
        }
    }

    return true;
}





/**
 * Calculate the number representation (in basis base)
 * of the given natural number (represented as an integer).
 * If num<0 or base is not in [2,16] the function should return "" (the empty String).
 * @param num the natural number (include 0).
 * @param base the basis [2,16]
 * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
 */
public static String int2Number(int num, int base)
{
    if (num < 0 || base < 2 || base > 16) {
        return "";
    }

    String result = "";
    while (num > 0) {
        int remainder = num % base;
        if (remainder < 10) {
            result = (char) ('0' + remainder) + result;
        } else {
            result = (char) ('A' + (remainder - 10)) + result;
        }
        num /= base;
    }

    if (result.isEmpty()) {
        result = "0";
    }
    String str=result+"b";
    str = str.concat(fromIntToChar(base));
    return str;

}
public static String fromIntToChar(int base) {
    if (base >= 2 && base <= 9) {
        return String.valueOf(base);
    } else if (base == 10) {
        return "A";
    } else if (base == 11) {
        return "B";
    } else if (base == 12) {
            return "C";
        } else if (base == 13) {
        return "D";
    } else if (base == 14) {
        return "E";
    } else if (base == 15) {
        return "F";
    } else if (base == 16) {
        return "G";
    } else {
        return null;
    }
}
/**
 * Checks if the two numbers have the same value.
 * @param n1 first number
 * @param n2 second number
 * @return true iff the two numbers have the same values.
 */
public static boolean equals(String n1, String n2) {
    if (n1 == null || n2 == null) {
        return false;
    }
    return number2Int(n1) == number2Int(n2);
}

/**
 * This static function search for the array index with the largest number (in value).
 * In case there are more than one maximum - returns the first index.
 * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
 * @param arr an array of numbers
 * @return the index in the array in with the largest number (in value).
 *
 */


public static int maxIndex(String[] arr)
{
    int maxIndex = 0;
    int maxValue = number2Int(arr[0]);

    for (int i = 1; i < arr.length; i++)
    {
        int currentValue = number2Int(arr[i]);
        if (currentValue > maxValue)
        {
            maxValue = currentValue;
            maxIndex = i;
        }
    }
    return maxIndex;
}




public static int extractBase(String basePart)
{
    if (basePart.length() != 1) return -1;
    char c = basePart.charAt(0);
    if (c >= '2' && c <= '9') return c - '0';
    if (c >= 'A' && c <= 'G') return c - 'A' + 10;
    return -1;
}
}