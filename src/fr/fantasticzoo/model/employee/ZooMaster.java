package fr.fantasticzoo.model.employee;

import fr.fantasticzoo.model.Creature;
import fr.fantasticzoo.model.Food;
import fr.fantasticzoo.model.Human;
import fr.fantasticzoo.model.SexType;
import fr.fantasticzoo.model.enclosure.Enclosure;

public class ZooMaster extends Human {
    public ZooMaster() {

    }

    public void examinateEnclosure(Enclosure enclosure) {
        System.out.println(enclosure.toString());
    }

    public void cleanEnclosure(Enclosure enclosure) {
        enclosure.clean();
    }

    public void feedCreaturesInEnclosure(Enclosure enclosure) {
        enclosure.feedAllCreatures();
    }

    public void moveAnimalFromEnclosure(Creature creature, Enclosure enclosure1, Enclosure enclosure2) {
        if( enclosure1.transfertCreature(enclosure2, creature))
            System.out.println(super.getName()
                    + " a déplacé " + creature.getName()
                    + " de l'enclos " + enclosure1.getName()
                    + " à l'enclos " + enclosure2.getName());
    }

    /**
     *
     */
    @Override
    public void aging() {
        super.aging();
    }

    /**
     * @return
     */
    @Override
    public String getName() {
        return super.getName();
    }

    /**
     * @param name
     */
    @Override
    public void setName(String name) {
        super.setName(name);
    }

    /**
     * @return
     */
    @Override
    public SexType getSex() {
        return super.getSex();
    }

    /**
     * @param sex
     */
    @Override
    public void setSex(SexType sex) {
        super.setSex(sex);
    }

}
