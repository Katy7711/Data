public class Data {

    public static boolean dataValidation(String login, String password, String confirmPassword) {
        boolean loginValue = isLengthValidation(login, 1,20);
        if (!loginValue) {
            throw new WrongLoginException("Неправильный логин");
        }
        boolean passwordValue = isLengthValidation(password, 1,20) && isSymbolValidation(password) && password.equals(confirmPassword);
        if (!passwordValue) {
            throw new WrongPasswordException("Неправильный пароль");
        }
        return true;
    }

    public static boolean isLengthValidation (String value, int min, int max) {
        if (value == null) {
            return false;
        }
        int length = value.length();
        return length >= min && length <= max;
    }

    public static boolean isSymbolValidation (String value) {
        if (value == null || value.isEmpty()) {
            return false;
        }
        for(char c: value.toCharArray()) {
            boolean symbol = (c >= 'a' && c<= 'z') || (c >= 'A' && c <= 'Z') || Character.isDigit(c) || (c== '_');
            if (!symbol){
                return false;
            }
        }
        return true;

    }


}
