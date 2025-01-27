package task6_1;

interface ComparableArray<T extends Comparable<T>> {
    T findMax(T[] array);
    T findMin(T[] array);
}
