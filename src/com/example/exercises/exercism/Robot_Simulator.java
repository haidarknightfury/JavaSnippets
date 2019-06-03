package com.example.exercises.exercism;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class Robot_Simulator {

    enum command {
        R, A, L;
    }

    class Coordinate {
        int x = 0;
        int y = 0;
        int dx = 0;
        int dy = 0;

        @Override
        public String toString() {
            return "Coordinate [x=" + this.x + ", y=" + this.y + ", dx=" + this.dx + ", dy=" + this.dy + "]";
        }

    }

    class Grid {
        Coordinate coordinate = new Coordinate();
        Map<command, Consumer<Coordinate>> commandMap = new HashMap<Robot_Simulator.command, Consumer<Coordinate>>();

        public Grid() {
            this.commandMap.put(command.R, (coord) ->
                {
                    coord.dy = 0;
                    coord.dx += 1;
                });

            this.commandMap.put(command.L, (coord) ->
                {
                    coord.dy = 0;
                    coord.dx -= 1;
                });

            this.commandMap.put(command.A, (coord) ->
                {
                    this.coordinate.x += this.coordinate.dx;
                    this.coordinate.y += this.coordinate.dy;
                });

        }

        public void applyCommand(command com) {
            this.commandMap.get(com).accept(this.coordinate);
        }

    }

    public static void main(String[] args) {
        Grid grid = new Robot_Simulator().new Grid();
        grid.applyCommand(command.R);
        grid.applyCommand(command.A);
        grid.applyCommand(command.A);
        System.out.println(grid.coordinate);

    }

}
