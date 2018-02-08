package com.hello;

abstract class Distance {
    protected int feet;
    protected float inches;

    abstract public void setFeetAndInches(int feet, float inches);
    abstract public int getFeet();
    abstract public float getInches();
    abstract String getDistanceComparison(Distance dist2);
}

class DistanceImplementation extends Distance {
    @Override
    public void setFeetAndInches(int feet, float inches) {
        this.feet = feet;
        this.inches = inches;
    }

    @Override
    public int getFeet() {
        return feet;
    }

    @Override
    public float getInches() {
        return inches;
    }

    @Override
    String getDistanceComparison(Distance dist2) {
        if (dist2 == null) {
            return null;
        }

        float inches1 = feet * 12 + inches;
        float inches2 = dist2.feet * 12 + dist2.inches;
        if (inches1 > inches2) {
            return "First distance is greater.";
        } else if (inches1 < inches2) {
            return "Second distance is greater.";
        }
        return "Both distances are equal.";
    }
}
