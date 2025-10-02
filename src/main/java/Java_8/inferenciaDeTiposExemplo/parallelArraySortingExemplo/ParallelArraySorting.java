package Java_8.inferenciaDeTiposExemplo.parallelArraySortingExemplo;

public class ParallelArraySorting{

    public static void main(String[] args) {
        // exemplo de uso de parallelSort
        int[] array = {5, 3, 8, 1, 2, 7, 4, 6};
        System.out.println("Array original:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        // ordenação paralela do array
        java.util.Arrays.parallelSort(array);

        System.out.println("Array ordenado:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

}
