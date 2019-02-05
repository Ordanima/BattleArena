package bohdan.homework.com.Arena;

import bohdan.homework.com.Fighters.Base.Actions.ActionPostFight;
import bohdan.homework.com.Fighters.Base.Actions.ActionPreFight;
import bohdan.homework.com.Fighters.Base.Actions.FightBreakAction;
import bohdan.homework.com.Fighters.Base.ArenaFighter;

public class Arena { //TODO: rewrite


    public ArenaFighter fight(ArenaFighter arenaFighterOne, ArenaFighter arenaFighterTwo) {
        int round = 0;

        final ArenaFighter[] winner = {null};
        do {
            preRoundActions(arenaFighterOne,arenaFighterTwo, winner1 -> winner[0] = winner1);
            if(winner[0] != null) return winner[0];
            preRoundActions(arenaFighterTwo, arenaFighterOne, winner1 -> winner[0] = winner1);
            if(winner[0] != null) return winner[0];

            int takeDamageOne = arenaFighterTwo.takeDamage(arenaFighterOne.getDamage());
            int takeDamageTwo = arenaFighterOne.takeDamage(arenaFighterTwo.getDamage());

            postRoundActions(arenaFighterOne,arenaFighterTwo,takeDamageTwo );
            postRoundActions(arenaFighterTwo,arenaFighterOne, takeDamageOne);

            if (arenaFighterOne.isAlive() && arenaFighterTwo.isAlive())
                round++;
            else if (arenaFighterOne.isAlive()) {
                System.out.println("Winner = " + arenaFighterOne.getName() + "  " + arenaFighterOne.getHealth());
                return arenaFighterOne;
            }
            else if (arenaFighterTwo.isAlive()) {
                System.out.println("Winner = " + arenaFighterTwo.getName() + "  " + arenaFighterTwo.getHealth());
                return arenaFighterTwo;
            }
            else return null;

        } while (round < 10);

    return arenaFighterOne; // )ftw!!!!! rewrite
    }
    public void preRoundActions (ArenaFighter arenaFighterOne, ArenaFighter arenaFighterTwo, FightBreakAction.FightCallBack callBack) {
        if(arenaFighterOne instanceof ActionPreFight)
            ((ActionPreFight) arenaFighterOne).actionWithFight(arenaFighterTwo);
        if(arenaFighterOne instanceof FightBreakAction)
            ((FightBreakAction) arenaFighterOne).actionWithFight(arenaFighterTwo, callBack);
    }

    public void postRoundActions (ArenaFighter arenaFighterOne, ArenaFighter arenaFighterTwo, int damageTakeByArenaFightTwo) {
        if (arenaFighterOne instanceof ActionPostFight)
            ((ActionPostFight) arenaFighterOne).action(arenaFighterTwo,damageTakeByArenaFightTwo);
    }

}

/*

        do {
                arenaFighterOne.damageArenaFighter(arenaFighterTwo);
                arenaFighterTwo.damageArenaFighter(arenaFighterOne);
                round++;
        } while (arenaFighterOne.isAlive() && arenaFighterTwo.isAlive() && round < 10);

        ((ActionPreFight) arenaFighterOne).doActionBeforeFight();
        ((ActionPreFight) arenaFighterTwo).doActionBeforeFight();


        arenaFighterOne.doActionPostFight(arenaFighterOne.getDamage(),arenaFighterOne.getName());
        arenaFighterTwo.doActionPostFight(arenaFighterTwo.getDamage(), arenaFighterTwo.getName());



  System.out.println("Fight is over");

        if (arenaFighterOne.isAlive()) {
            System.out.println(arenaFighterOne.getName() + " won");
        } else if (arenaFighterTwo.isAlive()) {
            System.out.println(arenaFighterTwo.getName() + " won");
        } else
            System.out.println("Both are dead.");
            */