import java.sql.SQLOutput;
import java.util.*;

public class Party {
    private List<Guest> guests = new ArrayList<>();
    private Set<String> meals = new HashSet<>();
    private Map<Integer, Guest>  phoneToGuest= new HashMap<>();

    Scanner scanner = new Scanner(System.in);

    public void addGuest() {
        System.out.println("Podaj imię gościa:");
        String name = scanner.nextLine();

        System.out.println("Podaj preferowany posiłek:");
        String meal = scanner.nextLine();

        System.out.println("Podaj numer telefonu:");
        int phoneNumber = Integer.valueOf(scanner.nextLine());

        System.out.println("Czy wegetarianin? (y/n):");
        String isVeganString = scanner.nextLine();

        boolean isVegan;

        if (isVeganString.equals("y")) {
            isVegan = true;
        } else {
            isVegan = false;
        }

        Guest guest = new Guest(name, meal, phoneNumber, isVegan);
        meals.add(meal);
        phoneToGuest.put(phoneNumber,guest);
        guests.add(guest);
    }

    public void displayMeals()
    {
        for(String meal : meals)
        {
            System.out.println(meal);
        }
    }

    public void displayGuestByPhoneNumber()
    {
        System.out.println("Podaj numer telefonu:");
        int phoneNumber = Integer.valueOf(scanner.nextLine());
        Guest guest = phoneToGuest.get(phoneNumber);

        guest.displayGuestInformaion();
    }

    public void displayGuests() {
        for (Guest guest : guests) {
            guest.displayGuestInformaion();
        }
    }
}
