package bohdan.homework.com.Fighters.Dragons;

import bohdan.homework.com.Fighters.Base.ArenaFighter;

public class Dragon extends ArenaFighter {


    public int element;


    public Dragon(String name, int health, int damage, double defense, int element) {
        super(name, health, damage, defense);
        this.element = element;
    }


    public int getElement() {
        return element;
    }


    @Override
    public void damageArenaFighter(ArenaFighter arenaFighter) {
        int damage = bonusDamage(arenaFighter);
        arenaFighter.takeDamage(damage);
    }

    int bonusDamage(ArenaFighter arenaFighter) {
        int bonusDamage = getСomparisonElementEnemy(arenaFighter instanceof Dragon ? arenaFighter.getElement() : 0);
        return arenaFighter.getDamage() * bonusDamage;
    }


    public int getСomparisonElementEnemy(int element) {
        int defaultElement = this.getElement() ^ element;
        int tempDefaultElement = ~defaultElement;
        int reversElements = tempDefaultElement | element;
        int sumElements = ~ reversElements;
        int count = 1;
        for (int e : elements) {
            count += (sumElements & e) > 0 ? 1 : 0;
        }
        return count;
    }


}