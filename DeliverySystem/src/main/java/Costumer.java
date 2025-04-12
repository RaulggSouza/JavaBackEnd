public class Costumer {
    private String cpf;
    private String name;
    private String address;
    private String contactPhone;

    public Costumer(String cpf, String name, String address, String contactPhone) {
        this.cpf = setCpf(cpf);
        this.name = name;
        this.address = address;
        setContactPhone(contactPhone);
    }

    public String asString(){
        return String.format("CPF: %s Name: %s Address: %s Contact Phone: %s", getCpf(), getName(), getAddress(), getContactPhone());
    }

    private String setCpf(String cpf){
        if (cpf == null || cpf.isBlank()) return "Default";
        String aux = cpf.replace(".", "").replace("-", "");
        return (aux.length() == 11 ? aux : "Default");
    }
    public String getCpf() {
        return cpf;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = (contactPhone != null && !contactPhone.isBlank() ? contactPhone : "Default");
    }
}
