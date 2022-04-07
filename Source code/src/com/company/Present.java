package com.company;

public class Present {
    private String presentName;
    private boolean assigned = false;

    public Present (String presentName){
        this.presentName = presentName;
    }

    public String toString(){
        return this.presentName;
    }

    public String getPresentName() {
        return presentName;
    }

    public void setPresentName(String presentName) {
        this.presentName = presentName;
    }

    public boolean isAssigned() {
        return assigned;
    }

    public void setAssigned(boolean assigned) {
        this.assigned = assigned;
    }
}
