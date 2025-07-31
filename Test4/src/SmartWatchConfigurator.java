// Product class
class SmartWatch {
    private final String brand;
    private final String model;
    private final boolean heartRateSensor;
    private final boolean gps;
    private final double screenSize;
    private final String strapType;
    private final double price;

    public SmartWatch(String brand, String model, boolean heartRateSensor, boolean gps,
                      double screenSize, String strapType, double price) {
        this.brand = brand;
        this.model = model;
        this.heartRateSensor = heartRateSensor;
        this.gps = gps;
        this.screenSize = screenSize;
        this.strapType = strapType;
        this.price = price;
    }

    public void getDetails() {
        System.out.println("SmartWatch Configuration:");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Heart Rate Sensor: " + (heartRateSensor ? "Yes" : "No"));
        System.out.println("GPS: " + (gps ? "Yes" : "No"));
        System.out.println("Screen Size: " + screenSize + " inches");
        System.out.println("Strap Type: " + strapType);
        System.out.println("Price: $" + price);
    }
}

// Builder class
class SmartWatchBuilder {
    private String brand;
    private String model;
    private boolean heartRateSensor;
    private boolean gps;
    private double screenSize;
    private String strapType;
    private double price;

    public SmartWatchBuilder setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public SmartWatchBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    public SmartWatchBuilder setHeartRateSensor(boolean heartRateSensor) {
        this.heartRateSensor = heartRateSensor;
        return this;
    }

    public SmartWatchBuilder setGPS(boolean gps) {
        this.gps = gps;
        return this;
    }

    public SmartWatchBuilder setScreenSize(double screenSize) {
        this.screenSize = screenSize;
        return this;
    }

    public SmartWatchBuilder setStrapType(String strapType) {
        this.strapType = strapType;
        return this;
    }

    public SmartWatchBuilder setPrice(double price) {
        this.price = price;
        return this;
    }

    public SmartWatch build() {
        return new SmartWatch(brand, model, heartRateSensor, gps, screenSize, strapType, price);
    }
}

// Client class
public class SmartWatchConfigurator {
    public static void main(String[] args) {
        SmartWatch myWatch = new SmartWatchBuilder()
                .setBrand("TechTime")
                .setModel("Xs")
                .setHeartRateSensor(true)
                .setGPS(true)
                .setScreenSize(2.15)
                .setStrapType("Leather")
                .setPrice(200.99)
                .build();

        myWatch.getDetails();
    }
}
