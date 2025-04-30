package allquestions.q2;

import java.util.Date;

public class ResidentialLand extends Land{
    private int residentialUnits;

    public ResidentialLand(String landId, String ownerName, String location, double sizeInAcres, Date registrationDate, String landUseStatus, int residentialUnits) {
        super(landId, ownerName, location, sizeInAcres, registrationDate, landUseStatus);
        this.residentialUnits = residentialUnits;
    }

    @Override
    public boolean validateOwnership() {
        return isOwnerValid();
    }

    @Override
    public boolean checkZoningCompliance() {
        return residentialUnits <= sizeInAcres * 2;
    }

    @Override
    public double calculateTax() {
        return sizeInAcres * 8000 * 0.015;
    }

    @Override
    public void generateLandReport() {
        System.out.println("----- Residential Land Report -----");
        System.out.println("Land ID: " + landId);
        System.out.println("Owner: " + ownerName);
        System.out.println("Location: " + location);
        System.out.println("Size: " + sizeInAcres + " acres");
        System.out.println("Residential Units: " + residentialUnits);
        System.out.println("Type: Residential");
        System.out.println("Tax: $" + calculateTax());
        System.out.println("Ownership Valid: " + validateOwnership());
        System.out.println("Zoning Compliance: " + checkZoningCompliance());
        System.out.println("Use Status: " + landUseStatus);
        System.out.println("------------------------------------");
    }

}
