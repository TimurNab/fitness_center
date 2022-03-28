package com.timnab.fintess_center;

public class Member {

    char memberType;
    int memberID;
    String name;
    double fees;

    public Member(char pMemberType, int pMemberID, String pName, double pFees) {

        memberType = pMemberType;
        memberID = pMemberID;
        name = pName;
        fees = pFees;
    }

    public void setMemberType(char memberType) {
        this.memberType = memberType;
    }

    public char getMemberType() {
        return memberType;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    public double getFees() {
        return fees;
    }

    @Override
    public String toString() {
        return memberType + ", " + memberID + ", " + name + ", " + fees;
    }
}
