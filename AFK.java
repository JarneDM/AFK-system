import java.awt.*;
import java.util.Random;
import java.util.Scanner;

import static java.awt.event.KeyEvent.*;

public class AFK {
    public static void main(String[] args) throws NoSuchFieldException, AWTException, IllegalAccessException, InterruptedException {
        boolean running = true;
        // Scanner scanner = new Scanner(System.in);
        char ch;
        char st;
        do {


            Random rand = new Random();
            char[] letters = {'w', 'a', 's', 'd'};
            int randomIndex = rand.nextInt(letters.length);

            ch = letters[randomIndex];
            switch (ch) {
                case 'w':
                    doType(VK_W);
                    break;
                case 'a':
                    doType(VK_A);
                    break;
                case 's':
                    doType(VK_S);
                    break;
                case 'd':
                    doType(VK_D);
                    break;
                default:
                    throw new IllegalArgumentException("Cannot type character " + ch);
            }
            Thread.sleep(3000);
            // st = scanner.nextLine().charAt(0);d
        } while (running);

    }

    private static void doType(int vk) throws InterruptedException {
        Robot robot;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
            return;
        }

        long pressTime = System.currentTimeMillis();
        robot.keyPress(vk);
        Thread.sleep(2500);
        robot.keyRelease(vk);
        long releaseTime = System.currentTimeMillis();

        long duration = releaseTime - pressTime;
        if (duration >= 2400 && duration <= 2600) {
            System.out.println("Key was pressed for approximately 2.5 seconds.");
        } else {
            System.out.println("Key was not pressed for 2.5 seconds.");
        }
    }

}

