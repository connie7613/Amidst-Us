package Module6.HW05;

import java.util.Arrays;

public class BlueAstronaut extends Player implements Crewmate {
    private int numTasks;
    private int taskSpeed;
    private static final int DEFAULT_SUSLEVEL = 15;
    private static final int DEFAULT_NUMTASKS = 6;
    private static final int DEFAULT_TASKSPEED = 10;

    // constructor
    public BlueAstronaut(String name) {
        this(name, DEFAULT_SUSLEVEL, DEFAULT_NUMTASKS, DEFAULT_TASKSPEED);

    }

    public BlueAstronaut(String name, int susLevel, int numTasks, int taskSpeed) {
        super(name, susLevel);
        this.numTasks = numTasks;
        this.taskSpeed = taskSpeed;

    }

    @Override
    public void emergencyMeeting() {
        if (!this.isFrozen()) {
            Player[] players = getPlayers();
            Arrays.sort(players);
            int outPlayerIndex = players.length - 1;

            for (int i = players.length - 1; i >= 0; i--) {
                if (!players[i].isFrozen() && (!this.equals(players[i]))) {
                    outPlayerIndex = i;
                    break;
                }
            }

            // search if there is another nonfrozen player has same suslevel in the array;
            int impostorSuslevel = players[outPlayerIndex].getSusLevel();
            int count = 0;
            for (Player player : players) {
                if (!player.isFrozen() && player.getSusLevel() == impostorSuslevel) {
                    count++;
                }
            }

            if (count < 2) {
                // freeze players[outPlayerIndex];
                players[outPlayerIndex].setFrozen(true);
            }
            gameOver();
        }
    }

    @Override
    public void completeTask() {
        if (!this.isFrozen()) {
            while (numTasks > 0) {
                if (taskSpeed > 20) {
                    numTasks = numTasks - 2;
                } else {
                    numTasks = numTasks - 1;
                }

                if (numTasks < 0) {
                    numTasks = 0;
                }

                if (numTasks == 0) {
                    System.out.println("I have completed all my tasks");
                    this.setSusLevel((int) (this.getSusLevel() * 0.5));
                }
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof BlueAstronaut) {
            BlueAstronaut player = (BlueAstronaut) o;
            return super.equals(player) && this.numTasks == player.numTasks && this.taskSpeed == player.taskSpeed;
        }
        return false;
    }

    @Override
    public String toString() {
        if (this.getSusLevel() > 15) {
            return ((super.toString() + " I have " + this.numTasks + " left over.").toUpperCase());
        } else {
            return super.toString() + " I have " + this.numTasks + " left over.";
        }
    }

    public int getNumTasks() {
        return numTasks;
    }

    public void setNumTasks(int numTasks) {
        if (numTasks >= 0) {
            this.numTasks = numTasks;
        } else {
            this.numTasks = DEFAULT_NUMTASKS;
        }
    }

    public int getTaskSpeed() {
        return taskSpeed;
    }

    public void setTaskSpeed(int taskSpeed) {
        if (taskSpeed > 0) {
            this.taskSpeed = taskSpeed;
        } else {
            this.taskSpeed = DEFAULT_TASKSPEED;
        }
    }

}
