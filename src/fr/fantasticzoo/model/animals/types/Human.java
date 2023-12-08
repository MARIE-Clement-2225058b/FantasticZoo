package fr.fantasticzoo.model.animals.types;

import fr.fantasticzoo.model.animals.characteristics.SexType;

public abstract class Human {

    public String name;
    public SexType sex;
    public int age;

    /**
     * return age + 1
     */
    public void aging() {
        this.age = this.age + 1;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     * set name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return age
     */
    public SexType getSex() {
        return sex;
    }

    /**
     * @param sex
     */
    public void setSex(SexType sex) {
        this.sex = sex;
    }

}

