package algorithmsandstructures.basestructures;

import java.util.*;

public class TreeDepth {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int capacity = scanner.nextInt();
        int[] parentLinks = new int[capacity];

        for (int i = 0; i < capacity; i++) {
            parentLinks[i] = scanner.nextInt();
        }

        int maxDepth = 1;

        for (int i = 0; i < parentLinks.length; i++) {
            maxDepth = Math.max(maxDepth, getDepthCurrentLink(parentLinks, i));
        }

        System.out.println(maxDepth);
    }

    private static int getDepthCurrentLink(int[] parentLinks, int i) {
        if (parentLinks[i] == -1) {
            return 1;
        }

        int currentNodeDepth = 0;

        while (i != -1) {
            currentNodeDepth++;
            if (parentLinks[i] == -1) {
                break;
            }
            i = parentLinks[i];
        }

        return currentNodeDepth;
    }


}
