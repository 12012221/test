import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

public class Nums {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Please input the function num:");
            System.out.println("1 - get even numbers");
            System.out.println("2 - get odd numbers");
            System.out.println("3 - get prime numbers");
            System.out.println("4 - get prime numbers that are bigger than 5");
            System.out.println("0 - quit");
            int fun = input.nextInt();
            if (fun == 0)
                break;
            System.out.println("Input the size:");
            int size = input.nextInt();
            System.out.println("Input elements of the list:");
            int[] arr = new int[size];
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                arr[i] = input.nextInt();
            }
            switch (fun) {
                case 1 -> {
                    eval(arr, n -> n % 2 == 0, arrayList);
                }
                case 2 -> {
                    eval(arr, n -> n % 2 == 1, arrayList);
                }
                case 3 -> {
                    eval(arr, n -> {
                        for (int i = 2; i < n; i++) {
                            if (n % i == 0) return false;
                        }
                        return true;
                    }, arrayList);
                }
                case 4 -> {
                    eval(arr, n -> {
                        for (int i = 2; i < n; i++) {
                            if (n % i == 0) return false;
                        }
                        return n > 5;
                    }, arrayList);
                }
                case 0 -> {
                }
            }
            System.out.println(arrayList);
        }
    }
    public static void eval(int[] arr, Predicate<Integer> predicate, ArrayList<Integer> arrayList) {
        for(Integer n: arr) {
            if(predicate.test(n)) {
                arrayList.add(n);
            }
        }
    }
}
