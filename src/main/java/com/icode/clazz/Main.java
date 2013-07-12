package com.icode.clazz;

/**
 * Created with IntelliJ IDEA.
 * User: ZhongGang
 * Date: 13-7-12
 * Time: 下午2:29
 */
public class Main {

    public static void main(String[] args) {
        Animal dog = new Dog();

        Animal chicken = new Chicken();

        System.out.println(dog instanceof Animal);
        System.out.println(dog instanceof Dog);
        System.out.println(dog instanceof Chicken);
        System.out.println(dog.getClass() == Animal.class);
        System.out.println(dog.getClass() == Dog.class);
        System.out.println(dog.getClass() == Chicken.class);
    }
}
