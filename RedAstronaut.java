package Module6.HW05;

import java.util.Arrays;

public class RedAstronaut extends Player implements Impostor {
    private String skill;
    private static final int DEFAULT_SUSLEVEL = 15;
    private static final String DEFAULT_SKILL = "experienced";

    // constructor
    public RedAstronaut(String name) {
        this(name, DEFAULT_SUSLEVEL, DEFAULT_SKILL);
    }

    public RedAstronaut(String name, int susLevel, String skill) {
        super(name, susLevel);
        String lowerCaseSkill = skill.toLowerCase();
        if (lowerCaseSkill.equals("inexperienced") || lowerCaseSkill.equals("experienced")
                || lowerCaseSkill.equals("expert")) {
            this.skill = lowerCaseSkill;
        } else {
            this.skill = DEFAULT_SKILL;
        }
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
    public void freeze(Player p) {
        // check if caller player is frozen
        // check if p is another impostor
        // check if p is already frozen
        if (!this.isFrozen() && !(p instanceof Impostor) && !p.isFrozen()) {

            if (this.getSusLevel() < p.getSusLevel()) {
                p.setFrozen(true);
            } else {
                this.setSusLevel(this.getSusLevel() * 2);
            }
            gameOver();
        }
    }

    @Override
    public void sabotage(Player p) {
        if (!this.isFrozen() && !(p instanceof Impostor) && !p.isFrozen()) {
            if (this.getSusLevel() < 20) {
                p.setSusLevel((int) (p.getSusLevel() * 1.5));
            } else {
                p.setSusLevel((int) (p.getSusLevel() * 1.25));
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof RedAstronaut) {
            RedAstronaut player = (RedAstronaut) o;
            return super.equals(player) && this.getSkill() == player.getSkill();
        }
        return false;
    }

    @Override
    public String toString() {
        if (this.getSusLevel() >= 15) {
            return (super.toString() + " I am an " + this.skill + " player!").toUpperCase();
        } else {
            return super.toString() + " I am an " + this.skill + " player!";
        }

    }

    // skill getter
    public String getSkill() {
        return this.skill;
    }

    // skill setter
    public void setSkill(String skill) {
        String lowerCaseSkill = skill.toLowerCase();
        if (lowerCaseSkill.equals("inexperienced") || lowerCaseSkill.equals("experienced")
                || lowerCaseSkill.equals("expert")) {
            this.skill = lowerCaseSkill;
        } else {
            this.skill = DEFAULT_SKILL;
        }
    }

    public static void main(String[] args) {
        RedAstronaut redas = new RedAstronaut("red1");
        redas.emergencyMeeting();

    }

}
