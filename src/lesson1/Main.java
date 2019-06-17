package lesson1;

import lesson1.competitors.*;
import lesson1.obstacles.Cross;
import lesson1.obstacles.Obstacle;
import lesson1.obstacles.Wall;
import lesson1.obstacles.Water;

public class Main {
    public static void main(String[] args) {

        Competitor[] competitors={new Human("Bob"),new Human("Bobik"),
                new Cat("Vaska"), new Dog("Tuzik")};

        Competitor[] competitor = {new Team("team1",
                new String[]{"n1", "n2", "n3", "n4"},
                new int[]{500,450,380,510},
                new int[]{20,22,23,25,},
                new int[]{2,1,2,2}), new Team("team2",
                new String[]{"n1", "n2", "n3", "n4"},
                new int[]{550,450,480,530},
                new int[]{25,27,30,25,},
                new int[]{2,1,2,2})};

        Obstacle[] obstacles = {new Cross(80), new Wall(3), new Water(10)};
//
        for (Competitor c:competitors) {
            for (Obstacle o:obstacles) {
                o.doIt(c);
                if(!c.isOnDistance()){
                    break;
                }
            }
        }
//
        for (Competitor c:competitors) {
            c.info();
        }

        for (Competitor c: competitor) {
            for (Obstacle o: obstacles) {
                o.doIt(c);
//                if(!c.isOnDistance()){
//                    break;
//                }
            }
        }

        for (Competitor c:competitors) {
            c.info();
        }

    }
}
