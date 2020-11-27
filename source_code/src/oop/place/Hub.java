package oop.place;

import oop.character.NPC;

public class Hub extends Place {

    public Hub(NPC npc, String name) {
        super(npc, name);
    }

    public Hub(NPC npc) {
        super(npc, "Hub");
    }
}