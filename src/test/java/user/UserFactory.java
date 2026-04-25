package user;

import utils.PropertyReader;

public class UserFactory {
    public static User withAdminPermission() {
        return new User(
                PropertyReader.getProperty("skyrexio.user"),
                PropertyReader.getProperty("skyrexio.password")
        );
    }

    public static User withLockedPermission() {
        return new User(
                PropertyReader.getProperty("skyrexio.locked_out_user"),
                PropertyReader.getProperty("skyrexio.password")
        );
    }

    public static User withIncorrectPermission() {
        return new User(
                PropertyReader.getProperty("skyrexio.incorrect_user"),
                PropertyReader.getProperty("skyrexio.password")
        );
    }
}
