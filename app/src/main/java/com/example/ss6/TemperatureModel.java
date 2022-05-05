package com.example.ss6;

public class TemperatureModel {
    private String Unit;
    private int UnitType;
    private double Value;

    public TemperatureModel() {
    }

    public TemperatureModel(String unit, int unitType, double value) {
        Unit = unit;
        UnitType = unitType;
        Value = value;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String unit) {
        Unit = unit;
    }

    public int getUnitType() {
        return UnitType;
    }

    public void setUnitType(int unitType) {
        UnitType = unitType;
    }

    public double getValue() {
        return Value;
    }

    public void setValue(double value) {
        Value = value;
    }
}
