package casa.on.agregadordeinvestimentos.controller.DTO;

public class CreateAccountDto {
    private String description;
    private String street;
    private Integer number;

    public CreateAccountDto(String description, String street, Integer number) {
        this.description = description;
        this.street = street;
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
