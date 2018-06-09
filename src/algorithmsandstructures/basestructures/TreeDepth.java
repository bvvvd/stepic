package algorithmsandstructures.basestructures;

import java.util.Scanner;

public class TreeDepth {
    public static void main(String[] args) {
        System.out.println(
                getMaxDepth(
                        getNodes()));
    }

    private static int getMaxDepth(int[] parentLinks) {
        int maxDepth = 1;

        for (int i = 0; i < parentLinks.length; i++) {
            maxDepth = Math.max(maxDepth, getCurrentLinkDepth(parentLinks, i));
        }

        return maxDepth;
    }

    private static int[] getNodes() {
        Scanner scanner = new Scanner(System.in);

        int capacity = scanner.nextInt();
        int[] parentLinks = new int[capacity];

        for (int i = 0; i < capacity; i++) {
            parentLinks[i] = scanner.nextInt();
        }

        return parentLinks;
    }

    private static int getCurrentLinkDepth(int[] parentLinks, int i) {
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
