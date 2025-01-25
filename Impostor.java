package Module6.HW05;

// This file defines an interface with the name Impostor. 
// Impostors will be able to mess with Players through 
// sabotage and freeze tagging them.

public interface Impostor {
    public void freeze(Player p);

    public void sabotage(Player p);
}
