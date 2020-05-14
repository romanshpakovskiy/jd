package by.it.Shpakovskiy._tasks_.iojava;

import java.io.Serializable;

class Man implements Serializable {
    int id;
    String name;
    int age;

    Man(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Man{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
