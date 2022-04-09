package entity;

/**
 * 用户类
 */
public class User {
    private String  userId;
    private String realName;
    private String password;
    private double money;

    public User() {
    }

    public User(String userId, String realName, String password, double money) {
        this.userId = userId;
        this.realName = realName;
        this.password = password;
        this.money = money;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", realName='" + realName + '\'' +
                ", password='" + password + '\'' +
                ", money=" + money +
                '}';
    }
}
