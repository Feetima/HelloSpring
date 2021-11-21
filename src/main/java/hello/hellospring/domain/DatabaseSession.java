package hello.hellospring.domain;

public class DatabaseSession {
    private String id;
    private String pw;
    private String address;

    public DatabaseSession(String id, String pw, String address) {
        this.id = id;
        this.pw = pw;
        this.address = address;
    }

    public void connect(){

    }
}
