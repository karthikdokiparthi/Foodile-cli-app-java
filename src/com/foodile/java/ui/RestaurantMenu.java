package com.foodile.java.ui;

import com.foodile.java.controller.RestaurantController;
import com.foodile.java.exceptions.DishNotFoundException;
import com.foodile.java.exceptions.RestarantNotFoundException;
import com.foodile.java.exceptions.RestaurantExistsException;
import com.foodile.java.model.Dish;
import com.foodile.java.model.Restaurants;
import com.foodile.java.service.RestaurantService;
import com.foodile.java.util.Factory;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RestaurantMenu extends Menu{

    private RestaurantController restaurantController;

    public RestaurantMenu() {
        this.restaurantController = Factory.getRestaurantController();
    }

    @Override
    public void displayMenu() {
        try {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                displayMenuHeader("WELCOME TO RESTAURANT SECTION");
                System.out.println();
                System.out.println("Please select the option !");
                System.out.println("--------------------------");
                System.out.println("1. Add New Restaurant");
                System.out.println("2. View All Restaurants");
                System.out.println("3. Search Restaurant");
                System.out.println("4. Update Restaurant ");
                System.out.println("5. Delete Restaurant");
                System.out.println("6. Exit");

                System.out.println("Please enter your choice (1-6)");

                int input = scanner.nextInt();
                switch (input) {
                    case 1 -> newRestaurantForm();
                    case 2 -> displayRestaurants();
                    case 3 -> restaurantSearchForm();
                    case 4 -> restaurantUpdateForm();
                    case 5 -> restaurantDeleteForm();
                    case 6 -> {
                        System.out.println("Thank you , See you again !");
                        super.displayMenu();
                    }
                    default -> System.out.println("Invalid Input. Please enter the valid input from(1-7)");

                }
            }
        } catch (Exception e) {
            System.out.println("Some internal error occurred. Please try again !");
            displayMenu();
        }
    }

    public void restaurantDeleteForm() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the following details to delete the Restaurant\n");
            System.out.println("Enter Id");
            String id = scanner.nextLine();
            restaurantController.deleteRestaurant(id);
            System.out.println("Restaurant Deleted Successfully");
        } catch (RestarantNotFoundException e) {
            System.out.println(e.getMessage());
            displayMenu();
        }
    }

    public void restaurantUpdateForm() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please Update entering the following details\n");
            System.out.println("Enter Restaurant Id");
            String id = scanner.nextLine();
            System.out.println("Enter Name");
            String name = scanner.nextLine();
            System.out.println("Enter Address");
            String address = scanner.nextLine();
            System.out.println("Enter Menu Dish Items separated by : (D101:D102)");
            String menu = scanner.nextLine();
            Restaurants restaurant = new Restaurants();
            restaurant.setName(name)
                    .setAddress(address)
                    .setMenu(Arrays.asList(menu.split(":")));

            Restaurants updatedRestaurant = restaurantController.updateRestaurant(restaurant);
            System.out.println("Restaurant Updated Successfully");
            displayRestaurant(updatedRestaurant);

        } catch (RestarantNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Some internal error occurred. Please try again !");
            restaurantUpdateForm();
        }
    }

    public void restaurantSearchForm() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the following details to search for Restaurant \n");
            System.out.println("Enter Id");
            String id = scanner.nextLine();
            Restaurants restaurant = restaurantController.getRestaurantById(id);
            displayRestaurant(restaurant);
        } catch (RestarantNotFoundException e) {
            System.out.println(e.getMessage());
            displayMenu();
        }
    }

    public void newRestaurantForm() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the following details\n");
            System.out.println("Enter Id");
            String id = scanner.nextLine();
            System.out.println("Enter Name");
            String name = scanner.nextLine();
            System.out.println("Enter Address");
            String address = scanner.nextLine();
            System.out.println("Enter Dishes for Menu separated by : (D010:D009)");
            String menu = scanner.nextLine();
            Restaurants restaurant = new Restaurants();
            restaurant.setId(id)
                    .setName(name)
                    .setAddress(address)
                    .setMenu(Arrays.asList(menu.split(":")));
            Restaurants savedRestaurant = restaurantController.saveRestaurant(restaurant);
            displayRestaurant(savedRestaurant);
        } catch (RestaurantExistsException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Some internal error occurred. Please try again !");
            newRestaurantForm();
        }
    }


    public void displayRestaurants() {
        List<Restaurants> restaurantList = this.restaurantController.getRestaurantList();
        displayMenuHeader("Restaurants");
        System.out.printf("%-10s %-30s %-80s %-30s\n", "Id", "Name", "Address", "Menu Items");
        printDashLine();
        restaurantList.forEach(restaurant -> {
            System.out.printf("%-10s %-30s %-80s %-30s\n", restaurant.getId(), restaurant.getName(), restaurant.getAddress(), String.join(":", restaurant.getMenu()));
        });
    }

    public void displayRestaurant(Restaurants restaurant) {
        displayMenuHeader("Restaurant Details");
        System.out.printf("%-10s %-30s %-80s %-30s\n", "Id", "Name", "Address", "Menu Items");
        printDashLine();
        System.out.printf("%-10s %-30s %-80s %-30s\n", restaurant.getId(), restaurant.getName(), restaurant.getAddress(), String.join(":", restaurant.getMenu()));
    }

    public void displayMenuItems(String restaurantId) throws RestarantNotFoundException, DishNotFoundException {
        displayMenuHeader("Dishes Menu Details");
        System.out.printf("%-10s %-30s %-80s %-10s\n", "Id", "Name", "Description", "Price");
        printDashLine();
        RestaurantService restaurantService = Factory.getRestaurantService();
        List<Dish> dishItems = restaurantService.getDishItems(restaurantId);
        for(Dish dish : dishItems){
            System.out.printf("%-10s %-30s %-80s %-10s\n", dish.getId(), dish.getName(), dish.getDescription(), String.format("$%.2f", dish.getPrice()));
        }
    }

}
