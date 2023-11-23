package fr.fantasticzoo.model;

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

