/**
 * Listing object
 * @author LIMA group
 */
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
    private String address;
    private String ZIP;

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
    public Listing(String name, String address, String ZIP,
                   int numBedroom, int numBathroom, int numAvail, double price) {
        this.name = name;
        this.numBedroom = numBedroom;
        this.numBathroom = numBathroom;
        this.numAvail = numAvail;
        this.price = price;
        this.address = address;
        this.ZIP = ZIP;
        walkToCampus = false;
        hasWasherDryer = false;
        hasGym = false;
        hasPool = false;
        hasWifi = false;
        isFurnished = false;
        isPetFriendly = false;
    }

    /**
     * return an integer array for searching
     * @return
     */
    public int[] getSearchFilter (){
        return new int[] {numBedroom, numBathroom, booleanToInt(isPetFriendly), booleanToInt(hasWasherDryer),
         booleanToInt(isFurnished), booleanToInt(walkToCampus), booleanToInt(hasWifi), booleanToInt(hasPool),
                booleanToInt(hasGym)};
    }

    /**
     * convert boolean to int for the search
     * @param a
     * @return
     */
    public int booleanToInt (boolean a) {
        if (a) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * getters and setters
     */
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

    public String getAddress() {
        return address;
    }

    public String getZIP() {
        return ZIP;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setZIP(String ZIP) {
        this.ZIP = ZIP;
    }
    public String toString(){
        return "************* Property Details *************" +
                "\nProperty Name: "+this.name+" " +
                "\nNumber of Bedrooms: "+this.numBedroom+" " +
                "\nNumber of Bathrooms: "+this.numBathroom+
                "\nAvailabilities: "+this.numAvail+
                "\nPrice: $"+this.price+
                "\nAddress: "+this.address+
                "\nZIP Code: "+this.ZIP +
                "\nWalk to Campus: "+this.walkToCampus +
                "\nHas a Washer and Dryer: "+this.hasWasherDryer+
                "\nHas a Gym: "+this.hasGym+
                "\nHas a pool: "+this.hasPool+
                "\nHas WiFi: "+this.hasWifi+
                "\nIs Furnished: "+this.isFurnished+
                "\nIs Pet Friendly: "+this.isPetFriendly+
                "\n*********************************************\n";
    }
}