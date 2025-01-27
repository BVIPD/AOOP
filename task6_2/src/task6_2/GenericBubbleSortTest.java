package task6_2;
public class GenericBubbleSortTest {

    public static void main(String[] args) {
        // Integer Array Example
        Integer[] intArray = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        BubbleSort.bubbleSort(intArray);
        System.out.println("Sorted Integer Array: ");
        for (Integer num : intArray) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Double Array Example
        Double[] doubleArray = {2.5, 3.8, 1.2, 5.6, 4.3};
        BubbleSort.bubbleSort(doubleArray);
        System.out.println("Sorted Double Array: ");
        for (Double num : doubleArray) {
            System.out.print(num + " ");
        }
        System.out.println();

        // String Array Example
        String[] stringArray = {"Banana", "Apple", "Cherry", "Mango", "Peach"};
        BubbleSort.bubbleSort(stringArray);
        System.out.println("Sorted String Array: ");
        for (String str : stringArray) {
            System.out.print(str + " ");
        }
    }
}
