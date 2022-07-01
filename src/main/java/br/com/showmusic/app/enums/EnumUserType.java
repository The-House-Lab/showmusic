package br.com.showmusic.app.enums;

public enum EnumUserType {
    USER("01"),

    CREATOR("02");

    private String userCode;
    private EnumUserType(String userCode) {

        this.userCode = userCode;
    }

}
