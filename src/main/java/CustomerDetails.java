public class CustomerDetails {
    private String CourseName;
    private String PurchasedDate;
    private int Amount;
    private String Location;

    public String getPurchasedDate() {
        return PurchasedDate;
    }

    public void setPurchasedDate(String purchasedDate) {
        this.PurchasedDate = purchasedDate;
    }



    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        this.CourseName = courseName;
    }



}
