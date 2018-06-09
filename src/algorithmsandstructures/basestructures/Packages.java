package algorithmsandstructures.basestructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

public class Packages {
    private static Scanner scanner = new Scanner(System.in);
    private static int time = 0;
    private static List<Integer> log = new ArrayList<>();

    public static void main(String[] args) {
        int size = scanner.nextInt();
        int numberOfPackets = scanner.nextInt();

        if (numberOfPackets == 0) {
            return;
        }

        ArrayBlockingQueue<Package> packages = new ArrayBlockingQueue<>(size);
        for (int i = 0; i < numberOfPackets; i++) {
            int arrival = scanner.nextInt();
            int duration = scanner.nextInt();

            Package newPackage = new Package(arrival, duration);

            if (packages.size() < size) {
                int startTime = Math.max(time, newPackage.arrival);
                newPackage.finishTime = startTime + newPackage.duration;
                log.add(startTime);
                time = newPackage.finishTime;
                packages.add(newPackage);
            } else {
                if (packages.peek().finishTime <= newPackage.arrival) {
                    packages.poll();
                    int startTime = Math.max(time, newPackage.arrival);
                    newPackage.finishTime = startTime + newPackage.duration;
                    packages.add(newPackage);
                    log.add(startTime);
                    time = newPackage.finishTime;
                } else {
                    log.add(-1);
                }
            }
        }

        log.forEach(System.out::println);
    }

    private static class Package {
        private int arrival;
        private int duration;
        private int finishTime;

        public Package(int arrival, int duration) {
            this.arrival = arrival;
            this.duration = duration;
        }
    }
}
