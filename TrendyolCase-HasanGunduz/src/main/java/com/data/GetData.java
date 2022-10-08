package com.data;

public class GetData {

    public enum TRENDYOL_REGISTER_DATA {

        EMAIL("xxxxx@gmail.com"),
        PASSWORD("PASSWORD");

        public String value;

        TRENDYOL_REGISTER_DATA(String value) {

            this.value = value;
        }
    }
    public enum TRENDYOL_LOGIN_DATA {

        EMAIL("xxxx@gmail.com"),
        PASSWORD("PASSWORD");

        public String value;

        TRENDYOL_LOGIN_DATA(String value) {

            this.value = value;
        }
    }

    public enum TRENDYOL_LOGIN_ROUTE {

        HOMEPAGELOGIN("girisyap"),
        BASKET("sepetim"),
        DISCOUNT("indirimkuponlarım"),
        FAVORITES("favorilerim");

        public String value;

        TRENDYOL_LOGIN_ROUTE(String value) {

            this.value = value;
        }
    }

}


