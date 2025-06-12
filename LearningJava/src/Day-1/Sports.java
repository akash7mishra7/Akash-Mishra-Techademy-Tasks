import java.util.Scanner;

interface Playable {
    void play();
}

class Football implements Playable {
    @Override
    public void play() {
        System.out.println("Playing football");
    }
}

class Cricket implements Playable {
    @Override
    public void play() {
        System.out.println("Playing cricket");
    }
}

class Tennis implements Playable {
    @Override
    public void play() {
        System.out.println("Playing tennis");
    }
}

public class Sports {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose a sport to play: \n1. Football 2. Cricket 3. Tennis");
        int choice = sc.nextInt();
        Playable selectedSport = null;

        switch (choice) {
            case 1:
                selectedSport = new Football();
                break;
            case 2:
                selectedSport = new Cricket();
                break;
            case 3:
                selectedSport = new Tennis();
                break;
            default:
                System.out.println("Invalid choice!");
                System.exit(0);
        }
        System.out.println("\nGame action:");
        selectedSport.play();

        sc.close();
    }
}