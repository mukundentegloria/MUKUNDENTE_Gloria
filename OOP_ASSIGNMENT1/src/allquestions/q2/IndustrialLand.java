package allquestions.q2;

import java.util.Date;

public class IndustrialLand extends Land{
    private boolean hasEnvironmentalClearance;
    public IndustrialLand(String landId, String ownerName, String location, double sizeInAcres, Date registrationDate, String landUseStatus, boolean hasEnvironmentalClearance) {
        super(landId, ownerName, location, sizeInAcres, registrationDate, landUseStatus);
        this.hasEnvironmentalClearance = hasEnvironmentalClearance;
    }

    @Override
    public boolean validateOwnership() {
        return isOwnerValid();
    }

    @Override
    public boolean checkZoningCompliance() {
        return hasEnvironmentalClearance;
    }

    @Override
    public double calculateTax() {
        return sizeInAcres * 12000 * 0.03;
    }

    @Override
    public void generateLandReport() {
        System.out.println("----- Industrial Land Report -----");
        System.out.println("Land ID: " + landId);
        System.out.println("Owner: " + ownerName);
        System.out.println("Location: " + location);
        System.out.println("Size: " + sizeInAcres + " acres");
        System.out.println("Type: Industrial");
        System.out.println("Tax: $" + calculateTax());
        System.out.println("Ownership Valid: " + validateOwnership());
        System.out.println("Zoning Compliance: " + checkZoningCompliance());
        System.out.println("Use Status: " + landUseStatus);
        System.out.println("------------------------------------");
    }

}
