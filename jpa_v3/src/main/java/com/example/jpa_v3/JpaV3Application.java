package com.example.jpa_v3;

import com.example.jpa_v3.entitites.Coffee;
import com.example.jpa_v3.repositories.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
//public class JpaV3Application implements CommandLineRunner {
    public class JpaV3Application {

    @Autowired
    private CoffeeRepository coffeeRepository;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(JpaV3Application.class, args);
        CoffeeRepository coffeeRepository = context.getBean(CoffeeRepository.class);

        System.out.println("Tìm coffee với price trong khoảng (50-100)");
        System.out.println("findAllByPriceBetween: ");
        coffeeRepository.findAllByPriceBetween(50, 100)
                        .forEach(System.out::println);

        System.out.println("===========================================");
        System.out.println("Tìm coffee với price trong khoảng lớn hơn 70");
        System.out.println("findAllByPriceGreaterThan: ");
        coffeeRepository.findAllByPriceGreaterThan(70)
                        .forEach(System.out::println);

        System.out.println("===========================================");
        System.out.println("Tìm coffee với name = Traditional Coffee");
        System.out.println("findAllByName: ");
        coffeeRepository.findAllByName("Traditional Coffee")
                        .forEach(System.out::println);

        System.out.println("===========================================");
        System.out.println("Tìm coffee với price = 50");
        System.out.println("SELECT c FROM Coffee c WHERE c.price = :price");
        Coffee coffee = coffeeRepository.findCoffeeByPrice(50);
        System.out.println("Coffee = " + coffee);
    }

//    @Override
//    public void run(String... args) throws Exception {
//        Coffee coffee = new Coffee();
//        coffee.setName("Traditional Coffee");
//        coffee.setPrice(50);
//        coffeeRepository.save(coffee);
//
//        Coffee latte = new Coffee();
//        latte.setName("Latte");
//        latte.setPrice(70);
//        coffeeRepository.save(latte);
//
//        Coffee cappuccino = new Coffee();
//        cappuccino.setName("Cappuccino");
//        cappuccino.setPrice(80);
//        coffeeRepository.save(cappuccino);
//
//        Coffee dark = new Coffee();
//        dark.setName("Dark Coffee");
//        dark.setPrice(90);
//        coffeeRepository.save(dark);
//
//        Coffee espresso = new Coffee();
//        espresso.setName("Espresso");
//        espresso.setPrice(60);
//        coffeeRepository.save(espresso);
//
//        Coffee mocha = new Coffee();
//        mocha.setName("Mocha");
//        mocha.setPrice(100);
//        coffeeRepository.save(mocha);
//    }
}
