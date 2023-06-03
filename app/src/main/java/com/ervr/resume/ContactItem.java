package com.ervr.resume;

// ContactItem.java
public class ContactItem {
    private String name;
    private int icon;

    public ContactItem(String name, int icon) {
        this.name = name;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public int getIcon() {
        return icon;
    }
}
