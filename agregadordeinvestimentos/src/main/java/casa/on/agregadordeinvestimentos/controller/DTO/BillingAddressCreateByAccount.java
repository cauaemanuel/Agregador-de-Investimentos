package casa.on.agregadordeinvestimentos.controller.DTO;

import casa.on.agregadordeinvestimentos.entity.Account;

import java.util.UUID;

public record BillingAddressCreateByAccount(Account account, String street, Integer number) {
}
