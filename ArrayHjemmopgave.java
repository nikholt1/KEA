import java.util.Arrays;

public class ArraysHjemmeopgave {
    public static void main(String[] args) {
        // opg 1
        // array med int data type
        int[] numbers = {1,2,3,5,5,6,7};
        // call printReverse method
        printReverse(numbers);
        // Next line for visuals
        System.out.println();


        // opg 2
        // call method "count" og print result af method return.
        System.out.println(count(numbers, 5));
        System.out.println(count(numbers, 7));
        System.out.println(count(numbers, 10));


        // opg 3
        // initializer array
        String[] names = {"john", "Jane", "Michael", "unknown"};
        // caller method og parser arguments til method
        replaceAll(names, "unknown", "Luca");
        // printer den opdaterede array
        System.out.println(Arrays.toString(names));


        // opg 4
        // initializer array
        String[] strArr = {"hello", "world", "from", "an", "array"};
        // printer result af method call der finder index af given String i array
        System.out.println(indexOf(strArr, "an"));
        System.out.println(indexOf(strArr, "arrays"));



        // caller method oddnumbers med specificerede range
        oddNumberAndGenerilization(-6, 38);
        // caller method evenNumbers med specificerede range
        evenNumberAndGenerilization(-5, 39);



    }
    // method printReverse til opg 1, med void data type (grundet print i method)
    // med array parameter
    public static void printReverse(int[] arr) {
        // for loop, hvor pointer starter i slutning af array, og iterater bagud,
        // printer for hver decrement.
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
    }

    // method count til opg 2, return data type int, med array og integer parameter
    public static int count(int[] arr, int target) {
        // sætter count
        int count = 0;
        // for loop der iterater med igennem array og incrementer count med 1
        for (int i = 0; i < arr.length; i++) {
            if (target == arr[i]) {
                count++;
            }
        }
        // returner count result
        return count;
    }

    // method replaceAll til opg 3, sat til void da vi initializer i main, med array og 2 String parametre
    public static void replaceAll(String[] arr, String target, String replacement) {
        // for loop der iterater igennem array
        for (int i = 0; i < arr.length; i++) {
            // når vi finder "target" værdi
            // ændrer vi index valuen på target til replacement
            if (arr[i].equals(target)) {
                arr[i] = replacement;
            }
        }

    }
    // method indexOf til opg 4 med return type int, med array og 1 String parameter
    public static int indexOf(String[] arr, String target) {
        // for loop, iterate igennem array
        for (int i = 0; i < arr.length; i++) {
            // hvis index value = target returner vi index tallet
            if (arr[i].equals(target)) {
                return i;
            }

        }
        // ellers return -1
        return -1;
    }

    // method oddNumberAndGenerilization til opg 5, med return type void da vi printer i method.
    // med start og slut parametre af data type int. (-6, 38)
    public static void oddNumberAndGenerilization(int a, int b) {
        // sæt count
        int count = 0;
        // for loop, iterate igennem range fra a til b
        for (int i = a; i <= b; i++) {
            // hvis det er et ulige nummer, skal vi increment count med 1.
            if (i % 2 != 0) {
                count++;
            }
        }
        // initialize oddNum array med index range tilsvarende count
        int[] oddNum = new int[count];

        // sæt index så vi kan iterate igennem fra a til b
        int index = 0;
        // brug for loop til at iterate igennem fra a til b, og tilføje ulige tal til oddNum array
        for (int i = a; i <= b; i++) {
            if (i % 2 != 0) { 
                oddNum[index] = i;
                index++;
            }
        }
        // print odd num
        System.out.println(Arrays.toString(oddNum));
    }

    // method evenNumberAndGenerilization til opg 6, return type void, og to int parametrer
    // for start og slut range, (-5 39)
    public static void evenNumberAndGenerilization(int a, int b) {
        // sætter count
        int count = 0;

        // for loop der iterater igennem range fra a til b
        for (int i = a; i <= b; i++) {
            // hvis det er et lige nummer, increemnter vi count med 1
            if (i % 2 == 0) {
                count++;
            }
        }
        // initializer array evenNum med index range svarende til count
        int[] evenNum = new int[count];
        // sætter index
        int index = 0;

        // for loop der iterater i a til b range
        for (int i = a; i <= b; i++) {
            // hvis det er et lige nummer tilføjer vi nummeret til evenNum og
            // incrementer index med 1.
            if (i % 2 == 0) {
                evenNum[index] = i;
                index++;
            }
        }
        // print evenNum
        System.out.println(Arrays.toString(evenNum));
    }
}
