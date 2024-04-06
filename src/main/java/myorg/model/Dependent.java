/**
 * @author <Do Xuan Gia Bao - s3932184>
 */

package myorg.model;

public class Dependent extends Customer {

    public Dependent(String id, String fullName, String insuranceCardId) {
        super(id, fullName, insuranceCardId);
    }

    @Override
    public String toString() {
        return "Dependent{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", insuranceCardId='" + insuranceCardId + '\'' +
                '}';
    }
}