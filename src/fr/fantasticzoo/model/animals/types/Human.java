package fr.fantasticzoo.model.animals.types;

import fr.fantasticzoo.model.animals.characteristics.SexType;

public abstract class Human {

    public String name;
    public SexType sex;
    public int age;

    public void aging() {
        this.age = this.age + 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SexType getSex() {
        return sex;
    }

    public void setSex(SexType sex) {
        this.sex = sex;
    }

}

