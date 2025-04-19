package casa.on.agregadordeinvestimentos.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tb_billingAddress" )
public class BillingAddress {

    @Id
    @Column(name = "account_id")
    private UUID account_id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "account_id")
    private Account account;

    @Column(name = "street")
    private String street;

    @Column(name = "number")
    private String number;

    public BillingAddress(){}

    public BillingAddress(UUID account_id, String street, String number) {
        this.account_id = account_id;
        this.street = street;
        this.number = number;
    }

    public UUID getAccount_id() {
        return account_id;
    }

    public void setAccount_id(UUID account_id) {
        this.account_id = account_id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
