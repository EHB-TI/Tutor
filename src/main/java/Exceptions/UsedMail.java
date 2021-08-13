package Exceptions;

public class UsedMail extends Exception {
    public UsedMail() {
        super("Email is already in use, pleas choose another one");
    }
}