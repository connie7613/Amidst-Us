package Module6.HW05;

public class Gameplay {
    public static void main(String[] args) {
        BlueAstronaut blue1 = new BlueAstronaut("Bob", 20, 6, 30);
        BlueAstronaut blue2 = new BlueAstronaut("Heath", 30, 3, 21);
        BlueAstronaut blue3 = new BlueAstronaut("Albert", 44, 2, 0);
        BlueAstronaut blue4 = new BlueAstronaut("Angel", 0, 1, 0);
        RedAstronaut red1 = new RedAstronaut("Liam", 19, "experienced");
        RedAstronaut red2 = new RedAstronaut("Suspicious Person", 100, "expert");
        // System.out.println(blue1.toString());
        // System.out.println(blue4.toString());
        red1.sabotage(blue1);
        // System.out.println(blue1.toString());
        // System.out.println(red2.isFrozen());
        red1.freeze(red2);
        // System.out.println(red2.isFrozen());
        // System.out.println(red1.getSusLevel());
        // System.out.println(blue3.isFrozen());
        red1.freeze(blue3);
        // System.out.println(red1.getSusLevel());
        // System.out.println(blue3.isFrozen());
        blue3.emergencyMeeting();
        red2.emergencyMeeting();
        // System.out.println(red2.isFrozen());
        blue1.emergencyMeeting();
        // System.out.println(red2.isFrozen());

        blue2.completeTask();
        // System.out.println(blue2.getNumTasks());
        // System.out.println(blue2.getSusLevel());
        blue2.completeTask();

        red1.freeze(blue4);
        // System.out.println(blue4.isFrozen());
        // System.out.println(red1.getSusLevel());

        // System.out.println(blue1.getSusLevel());
        red1.sabotage(blue1);
        // System.out.println(blue1.getSusLevel());
        red1.sabotage(blue1);
        // System.out.println(blue1.getSusLevel());

        red1.freeze(blue1);
        // System.out.println(blue1.isFrozen());

        // blue4.emergencyMeeting();
        // System.out.println(red1.isFrozen());

        red1.sabotage(blue2);
        red1.sabotage(blue2);
        red1.sabotage(blue2);
        red1.sabotage(blue2);
        red1.sabotage(blue2);

        red1.freeze(blue2);
        // System.out.println(blue2.isFrozen());
    }
}
