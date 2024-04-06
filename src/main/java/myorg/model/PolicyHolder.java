/**
 * @author <Do Xuan Gia Bao - s3932184>
 */

package myorg.model;

import java.util.ArrayList;
import java.util.List;

public class PolicyHolder extends Customer {
    // A list of dependents that are covered under this policy holder's insurance policies.
    private List<Dependent> dependents = new ArrayList<>();
    /**
     * Constructor for the PolicyHolder class.
     *
     * @param id The unique identifier for the Policy Holder.
     * @param fullName The full name of the Policy Holder.
     * @param insuranceCardId The ID of the Policy Holder's insurance card.
     */
    public PolicyHolder(String id, String fullName, String insuranceCardId) {
        super(id, fullName, insuranceCardId);
    }

    public void addDependent(Dependent dependent) {
        this.dependents.add(dependent);
    }

    public List<Dependent> getDependents() {
        return dependents;
    }

    /**
     * Overrides the toString() method to provide a string representation of the Policy Holder object.
     *
     * @return A string representation of the Policy Holder object in the format:
     *         PolicyHolder{id='...', fullName='...', insuranceCardId='...', dependents=[...]}
     */
    @Override
    public String toString() {
        return "PolicyHolder{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", insuranceCardId='" + insuranceCardId + '\'' +
                ", dependents=" + dependents +
                '}';
    }
}
