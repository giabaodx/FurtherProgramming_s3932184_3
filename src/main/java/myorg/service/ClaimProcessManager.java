/**
 * @author <Do Xuan Gia Bao - s3932184>
 */

package myorg.service;


import myorg.model.Claim;
import java.util.List;

/**
 * Interface for managing the claim processes in the insurance system.
 */
public interface ClaimProcessManager {
    /**
     * Retrieves a list of all existing claims.
     *
     * @return A list of Claim objects representing all claims.
     */
    List<Claim> getAll();
    /**
     * Retrieves a specific claim by its unique identifier.
     *
     * @param claimId The unique identifier of the claim to retrieve.
     * @return The Claim object if found, otherwise null.
     */
    Claim getOne(String claimId);
    /**
     * Adds a new claim to the system.
     *
     * @param claim The Claim object representing the new claim to be added.
     */
    void addClaim(Claim claim);
    /**
     * Updates an existing claim with the provided information.
     *
     * @param claimId The unique identifier of the claim to update.
     * @param updatedClaim The Claim object containing the updated information.
     */
    void updateClaim(String claimId, Claim updatedClaim);
    /**
     * Deletes a claim from the system.
     *
     * @param claimId The unique identifier of the claim to delete.
     * @return True if the claim was successfully deleted, otherwise false.
     */
    boolean deleteClaim(String claimId);



}