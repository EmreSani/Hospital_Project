package Hastane_projesi;

import java.util.Scanner;

public class HastaneService {
    private static HastaneService hastane = new HastaneService();

    static Scanner scan = new Scanner(System.in);

    public void showHospitalMenu() {
        DoctorService doktorservice = new DoctorService();

        doktorservice.firstList();
        doktorservice.menu();

    }

    public static void slowPrint(String message, int delay) {
        for (char c : message.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
