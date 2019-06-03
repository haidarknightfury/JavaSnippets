package com.example.otherpatterns.data_bus_pattern;

public class AbstractDataType implements DataType {

    private DataBus databus;

    @Override
    public DataBus getDataBus() {
        return this.databus;
    }

    @Override
    public void setDataBus(DataBus dataBus) {
        this.databus = dataBus;
    }

}
