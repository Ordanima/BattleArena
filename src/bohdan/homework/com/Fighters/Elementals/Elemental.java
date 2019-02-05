package bohdan.homework.com.Fighters.Elementals;

import bohdan.homework.com.Fighters.Base.Actions.ActionPreFight;
import bohdan.homework.com.Fighters.Base.ArenaFighter;

public class Elemental extends ArenaFighter implements ActionPreFight { // Class does't work!!!

    int element;
    boolean coincidenceElement = false;

    public Elemental(String name, int health, int damage, double defense, int element) {
        super(name, health, damage, defense);
        this.element = element;
    }

    @Override //TODO: method does't work correctly
    public void actionWithFight(ArenaFighter arenaFighter) {
        if (getElement() == arenaFighter.getElement()) {
            takeDamage(arenaFighter.getDamage() / 2);
            arenaFighter.takeDamage(setHealth(getDamage() * 2));
        }
    }


    @Override
    public int getElement() {
        return element;
    }
}
