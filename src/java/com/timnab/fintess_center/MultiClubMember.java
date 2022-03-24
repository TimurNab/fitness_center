package com.timnab.fintess_center;

public class MultiClubMember extends Member {
    private int membershipPoints;

    MultiClubMember (char pMemberType, int pMemberID, String pName, double pFees, int pMembershipPoint) {
        super(pMemberType, pMemberID, pName, pFees);
        membershipPoints = pMembershipPoint;
    }

    public int getMembershipPoints() {
        return membershipPoints;
    }

    public void setMembershipPoints(int pMembershipPoints) {
        membershipPoints = pMembershipPoints;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + membershipPoints;
    }
}
