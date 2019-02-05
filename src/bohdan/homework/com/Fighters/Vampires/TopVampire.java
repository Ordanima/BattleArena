package bohdan.homework.com.Fighters.Vampires;

import bohdan.homework.com.Fighters.Base.Actions.ActionPreFight;
import bohdan.homework.com.Fighters.Base.ArenaFighter;

import java.util.Random;

public class TopVampire extends Vampire implements ActionPreFight {

    Random random = new Random();

    int randomElement = random.nextInt(elements.length);

    public TopVampire(String name, int health, int damage, double defense) {
        super(name, health, damage, defense);
    }

    @Override
    public int getElement() {
        return randomElement;
    }


    @Override //FIXME: Remake method, check damage later
    public void actionWithFight(ArenaFighter arenaFighter) {

        getСomparisonElementEnemy(arenaFighter.getElement());

        if (getHealth() <= getFullHP() - getDamage()) {
            setHealth(getDamage());
            setDamage(getDamage() / 2);

        }
    }


    public int getСomparisonElementEnemy(int element) {
        int defaultElement = this.getElement() ^ element;
        int tempDefaultElement = ~defaultElement;
        int reversElements = tempDefaultElement | element;
        int sumElements = ~ reversElements;
        int count = 1;
        for (int e : elements) {
            count += (sumElements & e) > 0 ? 2 : 0;
        }
        return count;
    }
}
