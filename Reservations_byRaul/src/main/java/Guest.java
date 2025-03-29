public class Guest {
    private final String ssn;
    private String name;
    private String email;

    public Guest(String ssn, String name, String email) {
        this.ssn = ssn;
        setName(name);
        setEmail(email);
    }

    public String getSsn() {
        return ssn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = verifyResponse(name);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = verifyResponse(email);
    }

    private static String verifyResponse(String response) {
        return response == null || response.isBlank() ? "Default" : response;
    }


}
