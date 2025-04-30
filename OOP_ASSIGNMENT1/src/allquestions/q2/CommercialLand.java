package allquestions.q2;

import java.util.Date;

public class CommercialLand extends Land{
    private boolean isZonedCommercial;

    public CommercialLand(String landId, String ownerName, String location, double sizeInAcres, Date registrationDate, String landUseStatus, boolean isZonedCommercial) {
        super(landId, ownerName, location, sizeInAcres, registrationDate, landUseStatus);
        this.isZonedCommercial = isZonedCommercial;
    }

    @Override
    public boolean validateOwnership() {
        return isOwnerValid();
    }

    @Override
    public boolean checkZoningCompliance() {
        return isZonedCommercial;
    }

    @Override
    public double calculateTax() {
        return sizeInAcres * 10000 * 0.025;
    }

    @Override
    public void generateLandReport() {
        System.out.println("----- Commercial Land Report -----");
        System.out.println("Land ID: " + landId);
        System.out.println("Owner: " + ownerName);
        System.out.println("Location: " + location);
        System.out.println("Size: " + sizeInAcres + " acres");
        System.out.println("Type: Commercial");
        System.out.println("Tax: $" + calculateTax());
        System.out.println("Ownership Valid: " + validateOwnership());
        System.out.println("Zoning Compliance: " + checkZoningCompliance());
        System.out.println("Use Status: " + landUseStatus);
        System.out.println("------------------------------------");
    }
}
