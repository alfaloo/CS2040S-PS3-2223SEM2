import java.util.Random;
public class SortingTester {

    public static boolean checkSort(ISort sorter, int size) {

        // Create a new array of KeyValuePair where each of the keys is a random int between 0 and 100
        Random random = new Random();
        int value = 0;
        KeyValuePair[] arr = new KeyValuePair[size];
        for(int i = 0; i < size; i++) {
            // Value will always be increasing order
            arr[i] = new KeyValuePair(random.nextInt(100), value);
            value++;
        }

//        debug printout
//        System.out.println("Random List");
//        for(KeyValuePair i : arr) {
//            System.out.println(i);
//        }

        sorter.sort(arr);

//        debug printout
//        System.out.println("Sorted List");
//        for(KeyValuePair i : arr) {
//            System.out.println(i);
//        }

        // Make sure everything is correctly sorted
        for(int i = 1; i < size; i++) {
            if(arr[i].getKey() < arr[i-1].getKey()) {
                return false;
            }
        }
        return true;
    }

    // slight change made to this method, returns String now instead to indicate whether its correct/stable
    public static String isStable(ISort sorter, int size) {
        // Create a new array of KeyValuePair where each of the keys is a random int between 0 and 100
        Random random = new Random();
        int value = 0;
        KeyValuePair[] arr = new KeyValuePair[size];
        for(int i = 0; i < size; i++) {
            // Value will always be increasing order
            arr[i] = new KeyValuePair(random.nextInt(100), value);
            value++;
        }

        sorter.sort(arr);

        // Check if the sorter is correct
        if(checkSort(sorter, size)) {
            // Check if the sorter is stable
            for (int i = 1; i < size; i++) {
                if (arr[i].getKey() == arr[i - 1].getKey() && arr[i].getValue() < arr[i - 1].getValue()) {
                    return "Not Stable";
                }
            }
            return "Correctly Sorted and Stable";
        } else {
            return "Not Correctly Sorted";
        }

    }

    public static KeyValuePair[] createArr(int[] arr) {
        KeyValuePair[] result = new KeyValuePair[arr.length];
        for(int i = 0; i < arr.length; i++) {
            result[i] = new KeyValuePair(arr[i], 0);
        }
        return result;
    }

    public static void specificCheck(ISort sorter, int[] arr) {
        KeyValuePair[] test = createArr(arr);
        sorter.sort(test);
        for(KeyValuePair i : test) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {

        // creating the sorter objects
        ISort SA = new SorterA();
        ISort SB = new SorterB();
        ISort SC = new SorterC();
        ISort SD = new SorterD();
        ISort SE = new SorterE();
        ISort SF = new SorterF();

        System.out.println("SorterB - Dr. Evil : Try to sort {2, 1}");
        specificCheck(SB, new int[] {2, 1});

        // first check for correctness and stability
        System.out.println("\nCheck Correct / Stability:");
        System.out.println("Sorter A : " + isStable(SA, 1000));
        System.out.println("Sorter B : " + isStable(SB, 1000));
        System.out.println("Sorter C : " + isStable(SC, 1000));
        System.out.println("Sorter D : " + isStable(SD, 1000));
        System.out.println("Sorter E : " + isStable(SE, 1000));
        System.out.println("Sorter F : " + isStable(SF, 1000));

        // cost check for sorter A
        System.out.println("\nCost Check for Sorter A");
        System.out.println("Sorted Array : " + SA.sort(createArr(new int[] {0, 1, 2, 3, 4, 5, 6, 7})));
        System.out.println("Almost Sorted Array : " + SA.sort(createArr(new int[] {0, 1, 2, 3, 5, 4, 6, 7})));
        System.out.println("Random Array : " + SA.sort(createArr(new int[] {3, 1, 6, 4, 7, 2, 0, 5})));
        System.out.println("Reversed Array : " + SA.sort(createArr(new int[] {7, 6, 5, 4, 3, 2, 1, 0})));
        System.out.println("Duplicates Array : " + SA.sort(createArr(new int[] {1, 1, 1, 1, 1, 1, 1, 1})));
        // cost check for sorter B
        System.out.println("\nCost Check for Sorter B");
        System.out.println("Sorted Array : " + SB.sort(createArr(new int[] {0, 1, 2, 3, 4, 5, 6, 7})));
        System.out.println("Almost Sorted Array : " + SB.sort(createArr(new int[] {0, 1, 2, 3, 5, 4, 6, 7})));
        System.out.println("Random Array : " + SB.sort(createArr(new int[] {3, 1, 6, 4, 7, 2, 0, 5})));
        System.out.println("Reversed Array : " + SB.sort(createArr(new int[] {7, 6, 5, 4, 3, 2, 1, 0})));
        System.out.println("Duplicates Array : " + SB.sort(createArr(new int[] {1, 1, 1, 1, 1, 1, 1, 1})));
        // cost check for sorter C
        System.out.println("\nCost Check for Sorter C");
        System.out.println("Sorted Array : " + SC.sort(createArr(new int[] {0, 1, 2, 3, 4, 5, 6, 7})));
        System.out.println("Almost Sorted Array : " + SC.sort(createArr(new int[] {0, 1, 2, 3, 5, 4, 6, 7})));
        System.out.println("Random Array : " + SC.sort(createArr(new int[] {3, 1, 6, 4, 7, 2, 0, 5})));
        System.out.println("Reversed Array : " + SC.sort(createArr(new int[] {7, 6, 5, 4, 3, 2, 1, 0})));
        System.out.println("Duplicates Array : " + SC.sort(createArr(new int[] {1, 1, 1, 1, 1, 1, 1, 1})));
        // cost check for sorter D
        System.out.println("\nCost Check for Sorter D");
        System.out.println("Sorted Array : " + SD.sort(createArr(new int[] {0, 1, 2, 3, 4, 5, 6, 7})));
        System.out.println("Almost Sorted Array : " + SD.sort(createArr(new int[] {0, 1, 2, 3, 5, 4, 6, 7})));
        System.out.println("Random Array : " + SD.sort(createArr(new int[] {3, 1, 6, 4, 7, 2, 0, 5})));
        System.out.println("Reversed Array : " + SD.sort(createArr(new int[] {7, 6, 5, 4, 3, 2, 1, 0})));
        System.out.println("Duplicates Array : " + SD.sort(createArr(new int[] {1, 1, 1, 1, 1, 1, 1, 1})));
        // cost check for sorter E
        System.out.println("\nCost Check for Sorter E");
        System.out.println("Sorted Array : " + SE.sort(createArr(new int[] {0, 1, 2, 3, 4, 5, 6, 7})));
        System.out.println("Almost Sorted Array : " + SE.sort(createArr(new int[] {0, 1, 2, 3, 5, 4, 6, 7})));
        System.out.println("Random Array : " + SE.sort(createArr(new int[] {3, 1, 6, 4, 7, 2, 0, 5})));
        System.out.println("Reversed Array : " + SE.sort(createArr(new int[] {7, 6, 5, 4, 3, 2, 1, 0})));
        System.out.println("Duplicates Array : " + SE.sort(createArr(new int[] {1, 1, 1, 1, 1, 1, 1, 1})));
        // cost check for sorter F
        System.out.println("\nCost Check for Sorter F");
        System.out.println("Sorted Array : " + SF.sort(createArr(new int[] {0, 1, 2, 3, 4, 5, 6, 7})));
        System.out.println("Almost Sorted Array : " + SF.sort(createArr(new int[] {0, 1, 2, 3, 5, 4, 6, 7})));
        System.out.println("Random Array : " + SF.sort(createArr(new int[] {3, 1, 6, 4, 7, 2, 0, 5})));
        System.out.println("Reversed Array : " + SF.sort(createArr(new int[] {7, 6, 5, 4, 3, 2, 1, 0})));
        System.out.println("Duplicates Array : " + SF.sort(createArr(new int[] {1, 1, 1, 1, 1, 1, 1, 1})));

    }
}
