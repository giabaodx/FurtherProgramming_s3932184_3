/**
 * @author <Do Xuan Gia Bao - s3932184>
 */

package myorg.model;

import java.util.Date;

/**
 * Represents an insurance card in the insurance system.
 */
public class InsuranceCard {
    private String cardNumber;
    private String cardHolderId;
    private String policyOwnerId;
    private final Date expirationDate;

    /**
     * Constructs a new `InsuranceCard` instance.
     *
     * @param cardNumber     Unique identifier for the card itself.
     * @param cardHolderId   ID of the customer who carries this card.
     * @param policyOwnerId  ID of the person who owns the insurance policy.
     * @param expirationDate The date when the card and potentially the coverage expires.
     */
    public InsuranceCard(String cardNumber, String cardHolderId, String policyOwnerId, Date expirationDate) {
        this.cardNumber = cardNumber;
        this.cardHolderId = cardHolderId;
        this.policyOwnerId = policyOwnerId;
        this.expirationDate = expirationDate;
    }

    // The Getters
    public String getCardNumber() { return cardNumber; }
    public Date getExpirationDate() { return expirationDate; }

    // The Setters
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setCardHolderId(String cardHolderId) {
        this.cardHolderId = cardHolderId;
    }

    public void setPolicyOwnerId(String policyOwnerId) {
        this.policyOwnerId = policyOwnerId;
    }

    /**
     * Creates a human-readable string representation of the `InsuranceCard`.
     *
     * @return A string containing details about the card.
     */
    @Override
    public String toString() {
        return "InsuranceCard{" +
                "cardNumber='" + cardNumber + '\'' +
                ", cardHolderId='" + cardHolderId + '\'' +
                ", policyOwnerId='" + policyOwnerId + '\'' +
                ", expirationDate=" + (expirationDate != null ? expirationDate.toString() : "null") +
                '}';
    }
}