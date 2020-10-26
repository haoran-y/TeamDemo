package CSCE247Porject;
public class Listing {

    private String name;
    private int numBedroom;
    private int numBathroom;
    private int numAvail;
    private boolean walkToCampus;
    private boolean hasWasherDryer;
    private boolean hasPool;
    private boolean hasGym;
    private boolean hasWifi;
    private boolean isPetFriendly;
    private boolean isFurnished;
    private double price;

    /**
     * object needed to be created with basic information like name, bedroom, bathroom and price
     * all other attributes are default false
     * if the officer indicates the attribute
     * use setter to set it to true
     * @param name
     * @param numBedroom
     * @param numBathroom
     * @param numAvail
     * @param price
     */
    public Listing(String name, int numBedroom, int numBathroom, int numAvail, double price) {
        this.name = name;
        this.numBedroom = numBedroom;
        this.numBathroom = numBathroom;
        this.numAvail = numAvail;
        this.price = price;
        walkToCampus = false;
        hasWasherDryer = false;
        hasGym = false;
        hasPool = false;
        hasWifi = false;
        isFurnished = false;
        isPetFriendly = false;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isFurnished() {
        return isFurnished;
    }

    public boolean isHasGym() {
        return hasGym;
    }

    public boolean isHasPool() {
        return hasPool;
    }

    public boolean isHasWasherDryer() {
        return hasWasherDryer;
    }

    public boolean isHasWifi() {
        return hasWifi;
    }

    public boolean isPetFriendly() {
        return isPetFriendly;
    }

    public boolean isWalkToCampus() {
        return walkToCampus;
    }

    public double getPrice() {
        return price;
    }

    public int getNumAvail() {
        return numAvail;
    }

    public int getNumBathroom() {
        return numBathroom;
    }

    public int getNumBedroom() {
        return numBedroom;
    }

    public void setFurnished(boolean furnished) {
        isFurnished = furnished;
    }

    public void setHasGym(boolean hasGym) {
        this.hasGym = hasGym;
    }

    public void setHasPool(boolean hasPool) {
        this.hasPool = hasPool;
    }

    public void setHasWasherDryer(boolean hasWasherDryer) {
        this.hasWasherDryer = hasWasherDryer;
    }

    public void setHasWifi(boolean hasWifi) {
        this.hasWifi = hasWifi;
    }

    public void setNumAvail(int numAvail) {
        this.numAvail = numAvail;
    }

    public void setNumBathroom(int numBathroom) {
        this.numBathroom = numBathroom;
    }

    public void setNumBedroom(int numBedroom) {
        this.numBedroom = numBedroom;
    }

    public void setPetFriendly(boolean petFriendly) {
        isPetFriendly = petFriendly;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setWalkToCampus(boolean walkToCampus) {
        this.walkToCampus = walkToCampus;
    }
}