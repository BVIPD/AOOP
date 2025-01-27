package task6_1;

public class GenericArrayTest {

    public static void main(String[] args) {
        ArrayOperations<Integer> intOps = new ArrayOperations<>();
        Integer[] intArray = {3, 7, 1, 9, 5};
        System.out.println("Integer Array - Max: " + intOps.findMax(intArray) + ", Min: " + intOps.findMin(intArray));

        ArrayOperations<String> strOps = new ArrayOperations<>();
        String[] strArray = {"Apple", "Banana", "Mango", "Peach"};
        System.out.println("String Array - Max: " + strOps.findMax(strArray) + ", Min: " + strOps.findMin(strArray));

        ArrayOperations<Character> charOps = new ArrayOperations<>();
        Character[] charArray = {'Z', 'A', 'C', 'M'};
        System.out.println("Character Array - Max: " + charOps.findMax(charArray) + ", Min: " + charOps.findMin(charArray));

        ArrayOperations<Float> floatOps = new ArrayOperations<>();
        Float[] floatArray = {2.5f, 3.8f, 1.2f, 5.6f};
        System.out.println("Float Array - Max: " + floatOps.findMax(floatArray) + ", Min: " + floatOps.findMin(floatArray));
    }
}