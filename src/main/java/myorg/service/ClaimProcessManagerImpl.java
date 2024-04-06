/**
 * @author <Do Xuan Gia Bao - s3932184>
 */

package myorg.service;

import myorg.model.Claim;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the ClaimProcessManager interface.
 */

public class ClaimProcessManagerImpl implements ClaimProcessManager {
    private List<Claim> claims = new ArrayList<>();

    // Get all claims
    @Override
    public List<Claim> getAll() {
        return new ArrayList<>(claims);
    }

    // Get claim by ID
    @Override
    public Claim getOne(String claimId) {
        return claims.stream().filter(claim -> claim.getId().equals(claimId)).findFirst().orElse(null);
    }

    // Add a new claim
    @Override
    public void addClaim(Claim claim) {
        claims.add(claim);
    }

    // Update claim by ID
    @Override
    public void updateClaim(String claimId, Claim updatedClaim) {
        for (int i = 0; i < claims.size(); i++) {
            if (claims.get(i).getId().equals(claimId)) {
                claims.set(i, updatedClaim);
                return;
            }
        }
        System.out.printf("I'm sorry! Claim with ID %s cannot found.%n", claimId);
    }

    // Delete claim by ID
    @Override
    public boolean deleteClaim(String claimId) {
        for (int i = 0; i < claims.size(); i++) {
            if (claims.get(i).getId().equals(claimId)) {
                claims.remove(i);
                return true;
            }
        }
        return false;
    }




}