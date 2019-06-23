package lesson1.competitors;

public class Team implements Competitor {
    String nameTeam;
    String[] name;

    int[] maxRunDistance;
    int[] maxSwimDistance;
    int[] maxJumpHeight;

    boolean active;

        public Team(String nameTeam, String[] name, int[] maxRunDistance, int[] maxSwimDistance, int[] maxJumpHeight) {
        this.nameTeam = nameTeam;
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
        this.maxJumpHeight = maxJumpHeight;
        this.active = active;
    }



    @Override
    public void run(int dist) {
        for (int i = 0; i < name.length; i++) {
            if (dist <= maxRunDistance[i]) {
                System.out.println(name[i] + " run ok ");
            } else {
                System.out.println( name[i] + " run Not ");
                active = false;
            }
        }
        
    }

    @Override
    public void swim(int dist) {
        for (int i = 0; i < name.length; i++) {
            if (dist <= maxSwimDistance[i]) {
                System.out.println(name[i] + " swim ok ");
            } else {
                System.out.println(name[i] + " swim Not ");
                active = false;
            } 
        }
        
    }

    @Override
    public void jump(int height) {
        for (int i = 0; i < name.length; i++) {
            if (height <= maxJumpHeight[i]) {
                System.out.println(name[i] + " jump ok ");
            } else {
                System.out.println(name[i] + " jump Not ");
                active = false;
            } 
        }
        
    }

    @Override
    public boolean isOnDistance() {

            return active;

    }

    @Override
    public void info() {

            System.out.println(nameTeam + " "+ active);

        
    }


}
