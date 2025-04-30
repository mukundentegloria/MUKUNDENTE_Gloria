package allquestions.q2;

import java.util.Date;

public class AgriculturalLand extends Land{
    public AgriculturalLand(String landId, String ownerName, String location, double sizeInAcres, Date registrationDate, String landUseStatus) {
        super(landId, ownerName, location, sizeInAcres, registrationDate, landUseStatus);
    }

    @Override
    public boolean validateOwnership() {
        return isOwnerValid();
    }

    @Override
    public boolean checkZoningCompliance() {
        return sizeInAcres >= 1 && location.toLowerCase().contains("farming");
    }

    @Override
    public double calculateTax() {
        return sizeInAcres * 5000 * 0.01; // 1% of land value
    }

    @Override
    public void generateLandReport() {
        System.out.println("----- Agricultural Land Report -----");
        System.out.println("Land ID: " + landId);
        System.out.println("Owner: " + ownerName);
        System.out.println("Location: " + location);
        System.out.println("Size: " + sizeInAcres + " acres");
        System.out.println("Type: Agricultural");
        System.out.println("Tax: $" + calculateTax());
        System.out.println("Ownership Valid: " + validateOwnership());
        System.out.println("Zoning Compliance: " + checkZoningCompliance());
        System.out.println("Use Status: " + landUseStatus);
        System.out.println("------------------------------------");
    }

}
