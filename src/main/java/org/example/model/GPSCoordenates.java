package org.example.model;

import java.sql.*;

public class GPSCoordenates implements SQLData {

    private static final String SQL_TYPE = "MY_TYPE";
    private double longitude;
    private double latitude;
    private Connection connection;

    public GPSCoordenates(Connection connection) {
        this.connection = connection;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Override
    public String getSQLTypeName() throws SQLException {
        return SQL_TYPE;
    }

    @Override
    public void readSQL(SQLInput stream, String typeName) throws SQLException {
        this.longitude = stream.readDouble();
        this.latitude = stream.readDouble();
    }

    @Override
    public void writeSQL(SQLOutput stream) throws SQLException {
        Object[] attrs = { (double) this.longitude, (double) this.latitude };
        Struct struct = this.connection.createStruct(SQL_TYPE, attrs);
        stream.writeStruct(struct);
    }
}
