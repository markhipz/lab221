import java.util.Date;

public class Food {
  public int id;
  public String name;
  public int weight;
  public String type;
  public String place;
  public Date expiredDate;

  public Food() {
  }

  public Food(int id, String name, int weight, String type, String place, Date expiredDate) {
    this.id = id;
    this.name = name;
    this.weight = weight;
    this.type = type;
    this.place = place;
    this.expiredDate = expiredDate;
  }

  public int getID() {
    return id;
  }

  public void setID(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getPlace() {
    return place;
  }

  public void setPlace(String place) {
    this.place = place;
  }

  public Date getExpiredDate() {
    return expiredDate;
  }

  public void setExpiredDate(Date expiredDate) {
    this.expiredDate = expiredDate;
  }

  @Override
  public String toString() {
    return "Food [ID=" + id + ", name=" + name + ", Weight=" + weight + ", type=" + type + ", place=" + place
        + ", expiredDate=" + expiredDate + "]";
  }
}
