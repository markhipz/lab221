// Cao Nguyen Hoang Hiep . SE160050

import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Manager extends ArrayList<Food> {
  private final String FILENAME = "food.dat";

  private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

  public Manager() {

  }

  public void addFood(Food food) {
    this.add(food);
  }

  public Food searchByID(String id) {
    for (Food food : this) {
      if (food.getID().equals(id)) {
        return food;
      }
    }
    return null;
  }

  private void printItem(Food food) {
    System.out.format("|%8s|%20s|%10d(g)|%15s|%10s|%12s|\n", food.getID(), food.getName(), food.getWeight(),
        food.getType(), food.getPlace(), dateFormat.format(food.getExpiredDate()));
  }

  public void searchByName(String name) {
    ArrayList<Food> searchedList = new ArrayList<Food>();
    for (Food food : this) {
      if (food.getName().equals(name))
        searchedList.add(food);
    }
    if (searchedList.isEmpty()) {
      System.out.println("This food does not exist!");
    } else {
      searchedList.forEach(food -> printItem(food));
    }
  }

  private void sortList() {
    Comparator<Food> comparator = (c1, c2) -> {
      return c1.getExpiredDate().compareTo(c2.getExpiredDate());
    };
    Collections.sort(this, comparator.reversed());
  }

  public void printDescendingList() {
    sortList();
    System.out.println("DESCENDING LIST: ");
    System.out.println("=====================================================================================");
    System.out.format("|%8s|%20s|%13s|%15s|%10s|%12s|\n", "ID", "Name", "Weight", "Type", "Place", "Expired By");
    this.forEach(food -> {
      printItem(food);
    });
    System.out.println("=====================================================================================");
  }

  public void saveToFile() {
    try {
      FileWriter writer = new FileWriter(FILENAME);
      for (Food food : this) {
        writer.write(food.getID() + "|" + food.getName() + "|" + food.getWeight() + "(g)|" + food.getType() + "|"
            + food.getPlace() + "|" + dateFormat.format((food.getExpiredDate())));
        writer.close();
      }
    } catch (IOException e) {
      System.out.println("Something went wrong");
    }
  }
}
