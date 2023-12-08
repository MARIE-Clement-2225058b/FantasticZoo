package fr.fantasticzoo.model.employee;

import fr.fantasticzoo.model.animals.Creature;
import fr.fantasticzoo.model.animals.characteristics.SexType;
import fr.fantasticzoo.model.animals.types.Human;
import fr.fantasticzoo.model.enclosure.Enclosure;

public class ZooMaster extends Human {
    public ZooMaster() {
        super();
    }

    public void examinateEnclosure(Enclosure enclosure) {
        System.out.println(enclosure.getDescription());
    }

    public void cleanEnclosure(Enclosure enclosure) {
        enclosure.clean();
    }

    public void feedCreaturesInEnclosure(Enclosure enclosure) {
        enclosure.feedAllCreatures();
    }

    public void moveAnimalFromEnclosure(Creature creature, Enclosure enclosure1, Enclosure enclosure2) {
        enclosure1.transfertCreature(enclosure2, creature);

    }

    /**
     *
     */
    @Override
    public void aging() {
        super.aging();
    }

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
