package Identities;

public abstract class User {
    private final int userId;
    private final String name;
    private final String userType;

    public User(int userId, String name, String userType) {
        this.userId = userId;
        this.name = name;
        this.userType = userType;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getUserType() {
        return userType;
    }
}