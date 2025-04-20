package casa.on.agregadordeinvestimentos.entity;

import casa.on.agregadordeinvestimentos.controller.DTO.BillingAddressCreateByAccount;
import casa.on.agregadordeinvestimentos.controller.DTO.CreateAccountDto;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tb_billingaddress" )
public class BillingAddress {

    @Id
    @Column(name = "account_id")
    private UUID id;

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "account_id")
    private Account account;

    @Column(name = "street")
    private String street;

    @Column(name = "number")
    private Integer number;

    public BillingAddress(){}

    public BillingAddress(UUID account_id, Account account, String street, Integer number) {
        this.id = account_id;
        this.account = account;
        this.street = street;
        this.number = number;
    }

    public static BillingAddress of(BillingAddressCreateByAccount ac) {
        BillingAddress billingAddress = new BillingAddress();
        billingAddress.setAccount(ac.account());
        billingAddress.setStreet(ac.street());
        billingAddress.setNumber(ac.number());
        return billingAddress;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public UUID getAccount_id() {
        return id;
    }

    public void setAccount_id(UUID account_id) {
        this.id = account_id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
