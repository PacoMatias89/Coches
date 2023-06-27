package org.example;

import com.google.gson.*;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.example.conecta.Conecta;
import org.example.model.*;
import org.example.util.HibernateUtil;
import org.hibernate.Session;


import javax.persistence.JoinColumn;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

public class Main {

    static final String COCHES_JSON = "src/main/resources/coches.json";
    public static final String COCHES_BD = "src/main/resources/COCHES.sql";


    public static Session session;

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        //resertBBDD();
        //insertJsonSupplier();
        //insertOpeningHours();
        //insertDropOffDetail();
        insertPickupDetails();
        //insertExtraDetails();
        //insertCars();
        //insertSupplierExtra();
        //insertTermsCondition();

    }

    public static void resertBBDD() throws SQLException, IOException, ClassNotFoundException {
        Connection con;

        ScriptRunner run;

        //Creamos la conexión
        con = Conecta.connect();

        //ahora vamos reseteando la BBDD cada vez que se llame a este método
        run = new ScriptRunner(con);
        run.runScript(new FileReader(COCHES_BD));


    }


    public static void insertJsonSupplier() throws FileNotFoundException {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        JsonElement json = JsonParser.parseReader(new FileReader(COCHES_JSON));

        JsonObject objectCarAvailabilityResponse = json.getAsJsonObject().getAsJsonObject("CarAvailabilityResponse");
        JsonObject carAvailabilityResult = objectCarAvailabilityResponse.getAsJsonObject().getAsJsonObject("CarAvailabilityResult");
        JsonObject objectSuppliers = carAvailabilityResult.getAsJsonObject().getAsJsonObject("Suppliers");

        JsonArray arraySuppliers = objectSuppliers.getAsJsonArray("Suppliers");


//        Obtenemos los valores del array supplier
        for (JsonElement jsonElement : arraySuppliers) {
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            String nameSupplier = jsonObject.get("Supplier").getAsString();
            String statusSupplier = jsonObject.get("Status").getAsString();
            int countSuppliers = jsonObject.get("Count").getAsInt();

            Supplier supplier = new Supplier();

            //nos creamos la hora y fecha actual de actualización
            Date date = new Date();
            Timestamp timestampActual = new Timestamp(date.getTime());

            supplier.setName(nameSupplier);
            supplier.setStatus(statusSupplier);
            supplier.setCount(countSuppliers);
            supplier.setUpdt(timestampActual);

            session.save(supplier);

        }


        session.getTransaction().commit();

    }

    public static void insertOpeningHours() throws FileNotFoundException {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        JsonElement json = JsonParser.parseReader(new FileReader(COCHES_JSON));

        JsonObject objectCarAvailabilityResponse = json.getAsJsonObject().getAsJsonObject("CarAvailabilityResponse");
        JsonObject carAvailabilityResult = objectCarAvailabilityResponse.getAsJsonObject().getAsJsonObject("CarAvailabilityResult");

        //Obtenemos los valores de cierre y apertura del renting
        JsonObject objectSupplierInfo = carAvailabilityResult.getAsJsonObject().getAsJsonObject("SupplierInfo");
        JsonArray arrayDetails = objectSupplierInfo.getAsJsonArray("Details");
        for (JsonElement jsonElement : arrayDetails) {
            if (!jsonElement.isJsonNull()) {
                JsonObject jsonObject = jsonElement.getAsJsonObject();
                String jsonObjectSupplier = jsonObject.get("Supplier").getAsString();
                JsonObject jsonObjectPickup = jsonElement.getAsJsonObject().getAsJsonObject("PickUpDetails");
                JsonObject jsonObjectOpenningHours = jsonObjectPickup.getAsJsonObject().getAsJsonObject("OpeningHours");

                Supplier supplier = new Supplier();
                supplier.setName(jsonObjectSupplier);

                //nos creamos la hora y fecha actual de actualización
                Date date = new Date();
                Timestamp timestampActual = new Timestamp(date.getTime());

                /**
                 *
                 * Verificamos que cada elemento del archivo no nos devuelva un null,
                 * para ello hacemos una ternaria para que nos verifique y nos devuelva el
                 * valor que necesitamos
                 *
                 * */

                String monOpen = jsonObjectOpenningHours.has("Mon_Open") ? jsonObjectOpenningHours.get("Mon_Open").getAsString() : null;
                String monClose = jsonObjectOpenningHours.has("Mon_Close") ? jsonObjectOpenningHours.get("Mon_Close").getAsString() : null;
                String tueOpen = jsonObjectOpenningHours.has("Tue_Open") ? jsonObjectOpenningHours.get("Tue_Open").getAsString() : null;
                String tueClose = jsonObjectOpenningHours.has("Tue_Close") ? jsonObjectOpenningHours.get("Tue_Close").getAsString() : null;
                String wedOpen = jsonObjectOpenningHours.has("Wed_Open") ? jsonObjectOpenningHours.get("Wed_Open").getAsString() : null;
                String wedClose = jsonObjectOpenningHours.has("Wed_Close") ? jsonObjectOpenningHours.get("Wed_Close").getAsString() : null;
                String thuOpen = jsonObjectOpenningHours.has("Thu_Open") ? jsonObjectOpenningHours.get("Thu_Open").getAsString() : null;
                String thuClose = jsonObjectOpenningHours.has("Thu_Close") ? jsonObjectOpenningHours.get("Thu_Close").getAsString() : null;
                String friOpen = jsonObjectOpenningHours.has("Fri_Open") ? jsonObjectOpenningHours.get("Fri_Open").getAsString() : null;
                String friClose = jsonObjectOpenningHours.has("Fri_Close") ? jsonObjectOpenningHours.get("Fri_Close").getAsString() : null;
                String satOpen = jsonObjectOpenningHours.has("Sat_Open") ? jsonObjectOpenningHours.get("Sat_Open").getAsString() : null;
                String satClose = jsonObjectOpenningHours.has("Sat_Close") ? jsonObjectOpenningHours.get("Sat_Close").getAsString() : null;
                String suNOpen = jsonObjectOpenningHours.has("Sun_Open") ? jsonObjectOpenningHours.get("Sun_Open").getAsString() : null;
                String sunClose = jsonObjectOpenningHours.has("Sun_Close") ? jsonObjectOpenningHours.get("Sun_Close").getAsString() : null;


                OpeningHour openingHour = new OpeningHour();
                openingHour.setSupplier(supplier);
                openingHour.setMonOpen(monOpen);
                openingHour.setMonClose(monClose);
                openingHour.setTueOpen(tueOpen);
                openingHour.setTueClose(tueClose);
                openingHour.setWedOpen(wedOpen);
                openingHour.setWedClose(wedClose);
                openingHour.setThuOpen(thuOpen);
                openingHour.setThuClose(thuClose);
                openingHour.setFriOpen(friOpen);
                openingHour.setFriClose(friClose);
                openingHour.setSatOpen(satOpen);
                openingHour.setSatClose(satClose);
                openingHour.setSuNOpen(suNOpen);
                openingHour.setSunClose(sunClose);
                openingHour.setUpdt(timestampActual);

                session.save(openingHour);
            } else {
                System.out.println("No se ha podido leer bien el archivo");
            }
        }
        session.getTransaction().commit();

    }


    public static void insertDropOffDetail() throws FileNotFoundException {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        JsonElement json = JsonParser.parseReader(new FileReader(COCHES_JSON));


        JsonObject objectCarAvailabilityResponse = json.getAsJsonObject().getAsJsonObject("CarAvailabilityResponse");
        JsonObject carAvailabilityResult = objectCarAvailabilityResponse.getAsJsonObject().getAsJsonObject("CarAvailabilityResult");

        //Obtenemos los valores de para devolver los vehículos
        JsonObject objectSupplierInfo = carAvailabilityResult.getAsJsonObject().getAsJsonObject("SupplierInfo");
        JsonArray arrayDetails = objectSupplierInfo.getAsJsonArray("Details");

        for (JsonElement jsonElement : arrayDetails) {
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            JsonObject objectDropOffDetails = jsonElement.getAsJsonObject().getAsJsonObject("DropOffDetails");
            String jsonObjectSupplier = jsonObject.get("Supplier").getAsString();

            /**
             *
             * Verificamos que lo que queremos obtener es un objeto con sus respectivos
             * datos primitivos
             * */
            JsonElement gpsElement = objectDropOffDetails.get("GPSCoordinates");
            if (gpsElement.isJsonObject()) {
                JsonObject gpsCoordinates = gpsElement.getAsJsonObject();
                Float longitud = gpsCoordinates.get("Longitude").getAsFloat();
                Float latitud = gpsCoordinates.get("Latitude").getAsFloat();


                String locationType = objectDropOffDetails.get("LocationType").getAsString();
                String address1 = objectDropOffDetails.get("Address1").getAsString();
                String address2 = objectDropOffDetails.get("Address2").getAsString();
                String address3 = objectDropOffDetails.get("Address3").getAsString();
                String city = objectDropOffDetails.get("City").getAsString();
                String phoneNo = objectDropOffDetails.get("PhoneNo").getAsString();
                String zipCode = objectDropOffDetails.get("ZipCode").getAsString();

                //nos creamos la hora y fecha actual de actualización
                Date date = new Date();
                Timestamp timestampActual = new Timestamp(date.getTime());

                //Creamos la unión entre tablas
                Supplier supplier = new Supplier();
                supplier.setName(jsonObjectSupplier);
                DropoffDetail dropoffDetail = new DropoffDetail();

                dropoffDetail.setSupplier(supplier);
                dropoffDetail.setLatitud(latitud);
                dropoffDetail.setLongitud(longitud);
                dropoffDetail.setLocation(locationType);
                dropoffDetail.setAddress1(address1);
                dropoffDetail.setAddress2(address2);
                dropoffDetail.setAddress3(address3);
                dropoffDetail.setCity(city);
                dropoffDetail.setZipCode(zipCode);
                dropoffDetail.setPhone(phoneNo);
                dropoffDetail.setUpdt(timestampActual);

                session.save(dropoffDetail);


            } else {
                System.out.println("GPSCoordinates no es un objeto JSON");
            }


        }
        session.getTransaction().commit();


    }

    public static void insertExtraDetails() throws FileNotFoundException {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        JsonElement json = JsonParser.parseReader(new FileReader(COCHES_JSON));


        JsonObject objectCarAvailabilityResponse = json.getAsJsonObject().getAsJsonObject("CarAvailabilityResponse");
        JsonObject carAvailabilityResult = objectCarAvailabilityResponse.getAsJsonObject().getAsJsonObject("CarAvailabilityResult");

        //Obtenemos los valores de para los extras
        JsonObject objectSupplierInfo = carAvailabilityResult.getAsJsonObject().getAsJsonObject("SupplierInfo");
        JsonArray arrayDetails = objectSupplierInfo.getAsJsonArray("Details");

        /**
         *
         *
         * Cuando sea json tan grandes, es importante verificar cada paso, ya que en la segunda
         * pasada del for puede dar null aunque haya datos.
         *
         * */

        for (JsonElement jsonElement : arrayDetails) {
            JsonObject jsonObject = jsonElement.getAsJsonObject().getAsJsonObject("AvailableExtras");
            if (jsonObject != null) {
                JsonArray arraysExtraDetails = jsonObject.getAsJsonArray("ExtraDetails");
                for (JsonElement jsonElementExtra : arraysExtraDetails) {
                    JsonObject jsonExtra = jsonElementExtra.getAsJsonObject();

                    int id = jsonExtra.get("ExtraID").getAsInt();
                    String name = jsonExtra.get("Name").getAsString();
                    String supplierCod = jsonExtra.get("SupplierCode").getAsString();
                    int price = jsonExtra.get("Price").getAsInt();
                    String period = jsonExtra.get("Period").getAsString();
                    String currency = jsonExtra.get("Currency").getAsString();
                    int maxAumount = jsonExtra.get("MaxAmount").getAsInt();
                    String information = jsonExtra.get("Information").getAsString();

                    //Si el ID no existe se creará
                    ExtraDetail extraDetail = session.get(ExtraDetail.class, id);
                    if (extraDetail == null) {
                        extraDetail = new ExtraDetail();
                        extraDetail.setId(id);
                    }


                    extraDetail.setName(name);
                    extraDetail.setSupplierCode(supplierCod);
                    extraDetail.setPrice(price);
                    extraDetail.setPeriod(period);
                    extraDetail.setCurrency(currency);
                    extraDetail.setMaxAmount(maxAumount);
                    extraDetail.setInformation(information);


                    session.save(extraDetail);


                }
            }
        }
        session.getTransaction().commit();

    }


    public static void insertPickupDetails() throws FileNotFoundException {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        JsonElement json = JsonParser.parseReader(new FileReader(COCHES_JSON));


        JsonObject objectCarAvailabilityResponse = json.getAsJsonObject().getAsJsonObject("CarAvailabilityResponse");
        JsonObject carAvailabilityResult = objectCarAvailabilityResponse.getAsJsonObject().getAsJsonObject("CarAvailabilityResult");

        //Obtenemos los valores de para devolver los vehículos
        JsonObject objectSupplierInfo = carAvailabilityResult.getAsJsonObject().getAsJsonObject("SupplierInfo");
        JsonArray arrayDetails = objectSupplierInfo.getAsJsonArray("Details");

        for (JsonElement jsonElement : arrayDetails) {
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            String jsonObjectSupplier = jsonObject.get("Supplier").getAsString();
            JsonObject objectPickup = jsonElement.getAsJsonObject().getAsJsonObject("PickUpDetails");


            /*
             *
             * Verificamos que lo que queremos obtener es un objeto con sus respectivos
             * datos primitivos
             * */
            JsonElement gpsElement = objectPickup.get("GPSCoordinates");
            if (gpsElement.isJsonObject()) {
                JsonObject gpsCoordinates = gpsElement.getAsJsonObject();
                Float longitud = gpsCoordinates.get("Longitude").getAsFloat();
                Float latitud = gpsCoordinates.get("Latitude").getAsFloat();


                String locationType = objectPickup.get("LocationType").getAsString();
                String address1 = objectPickup.get("Address1").getAsString();
                String address2 = objectPickup.get("Address2").getAsString();
                String address3 = objectPickup.get("Address3").getAsString();
                String city = objectPickup.get("City").getAsString();
                String phoneNo = objectPickup.get("PhoneNo").getAsString();
                String zipCode = objectPickup.get("ZipCode").getAsString();

                //nos creamos la hora y fecha actual de actualización
                Date date = new Date();
                Timestamp timestampActual = new Timestamp(date.getTime());

                //Creamos la unión entre tablas
                Supplier supplier = new Supplier();
                supplier.setName(jsonObjectSupplier);
                PickupDetail pickupDetail = new PickupDetail();

                pickupDetail.setSupplier(supplier);
                pickupDetail.setLatitud(latitud);
                pickupDetail.setLongitud(longitud);
                pickupDetail.setLocation(locationType);
                pickupDetail.setAddress1(address1);
                pickupDetail.setAddress2(address2);
                pickupDetail.setAddress3(address3);
                pickupDetail.setCity(city);
                pickupDetail.setZipCode(zipCode);
                pickupDetail.setPhone(phoneNo);
                pickupDetail.setUpdt(timestampActual);

                session.save(pickupDetail);


            } else {
                System.out.println("GPSCoordinates no es un objeto JSON");
            }


        }
        session.getTransaction().commit();


    }

    public static void insertCars() throws FileNotFoundException {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        JsonElement json = JsonParser.parseReader(new FileReader(COCHES_JSON));


        JsonObject objectCarAvailabilityResponse = json.getAsJsonObject().getAsJsonObject("CarAvailabilityResponse");
        JsonObject carAvailabilityResult = objectCarAvailabilityResponse.getAsJsonObject().getAsJsonObject("CarAvailabilityResult");

        //Obtenemos todos los coches
        JsonObject carSet = carAvailabilityResult.getAsJsonObject().getAsJsonObject("CarSet");
        JsonArray arrayCars = carSet.getAsJsonArray("Car");
        for (JsonElement jsonElement : arrayCars) {
            JsonObject cars = jsonElement.getAsJsonObject();
            JsonObject costs = cars.getAsJsonObject().getAsJsonObject("Costs");
            JsonObject cost = costs.getAsJsonObject().getAsJsonObject("Cost");

            String code = cars.has("Code") ? cars.get("Code").getAsString() : null;
            String status = cars.has("Status") ? cars.get("Status").getAsString() : null;
            int category = cars.has("Category") ? cars.get("Category").getAsInt() : 0;
            int size = cars.has("Size") ? cars.get("Size").getAsInt() : 0;
            String name = cars.has("Name") ? cars.get("Name").getAsString() : null;
            String url = cars.has("URL") ? cars.get("URL").getAsString() : null;
            int luggage = cars.has("Luggage") ? cars.get("Luggage").getAsInt() : 0;
            int passenger = cars.has("Passenger") ? cars.get("Passenger").getAsInt() : 0;

            /*
             *
             *Hago esta verificación para evitar que me salga el valor de string vacio por tener la pila la agota
             *otro tipo de datos, entonces eso provoca un salto de línea hacia otro campo y la legibilidad de nuestros
             *datos se ven afectada
             * */
            int doors = 0;
            JsonElement doorsElement = cars.get("Doors");
            if (doorsElement != null && !doorsElement.isJsonNull() && !doorsElement.getAsString().isEmpty()) {
                doors = doorsElement.getAsInt();
            }

            String currency = cars.has("Currency") ? cars.get("Currency").getAsString() : null;
            Float totalChange = cars.has("TotalChange") ? cars.get("TotalChange").getAsFloat() : 0f;
            Float costCars = cost.has("Price") ? cost.get("Price").getAsFloat() : 0f;
            String rateQualifier = cars.has("RateQualifier") ? cars.get("RateQualifier").getAsString() : null;
            char aircon = cars.has("IsAirCon") ? cars.get("IsAirCon").getAsCharacter() : '\u0000';
            char automatic = cars.has("IsAutomatic") ? cars.get("IsAutomatic").getAsCharacter() : '\u0000';
            String type = cars.has("CarType") ? cars.get("CarType").getAsString() : null;
            String description = cars.has("CarDescription") ? cars.get("CarDescription").getAsString() : null;


            //Foreign keys
            String supplierCar = cars.get("Supplier").getAsString();
            Supplier supplier = new Supplier();
            supplier.setName(supplierCar);

            Float dropCharge = cars.get("DropCharge").getAsFloat();
            Float erp = cars.get("ERP").getAsFloat();


            Car car = session.get(Car.class, code);
            if (car == null) {
                car = new Car();
                car.setCode(code);
            }

            car.setCode(code);
            car.setStatus(status);
            car.setCategory(category);
            car.setSize(size);
            car.setName(name);
            car.setUrl(url);
            car.setLuggage(luggage);
            car.setPassenger(passenger);
            car.setDoors(doors);
            car.setCurrency(currency);
            car.setTotalCharge(totalChange);
            car.setCost(costCars);
            car.setRateQualifier(rateQualifier);
            car.setAircon(aircon);
            car.setAutomatic(automatic);
            car.setType(type);
            car.setDescription(description);
            car.setSupplier(supplier);
            car.setDropChanger(dropCharge);
            car.setErp(erp);

            session.save(car);


        }
        session.getTransaction().commit();


    }

    public static void insertSupplierExtra() throws FileNotFoundException {

        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        JsonElement json = JsonParser.parseReader(new FileReader(COCHES_JSON));


        JsonObject objectCarAvailabilityResponse = json.getAsJsonObject().getAsJsonObject("CarAvailabilityResponse");
        JsonObject carAvailabilityResult = objectCarAvailabilityResponse.getAsJsonObject().getAsJsonObject("CarAvailabilityResult");

        //Obtenemos los valores de todos los nodos y ahora crearemos un for para obtener lo que nosotros queremos
        JsonObject objectSupplierInfo = carAvailabilityResult.getAsJsonObject().getAsJsonObject("SupplierInfo");
        JsonArray arrayDetails = objectSupplierInfo.getAsJsonArray("Details");

        for (JsonElement jsonElement : arrayDetails) {
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            String supplierFk = jsonObject.get("Supplier").getAsString();

            Supplier supplier = new Supplier();
            supplier = new Supplier();
            supplier.setName(supplierFk);


            JsonObject jsonObjectExtra = jsonObject.getAsJsonObject().getAsJsonObject("AvailableExtras");

            if (jsonObjectExtra != null) {
                JsonArray arraysExtraDetails = jsonObjectExtra.getAsJsonArray("ExtraDetails");
                for (JsonElement jsonElementExtra : arraysExtraDetails) {
                    JsonObject jsonExtra = jsonElementExtra.getAsJsonObject();
                    int id = jsonExtra.get("ExtraID").getAsInt();

                    ExtraDetail extraDetail = session.get(ExtraDetail.class, id);
                    if (extraDetail == null) {
                        extraDetail = new ExtraDetail();
                        extraDetail.setId(id);
                    }

                    //nos creamos la hora y fecha actual de actualización
                    Date date = new Date();
                    Timestamp timestampActual = new Timestamp(date.getTime());


                    SupplierExtra extra = new SupplierExtra();
                    extra.setSupplier(supplier);
                    extra.setExtraDetail(extraDetail);
                    extra.setUpdt(timestampActual);
                    session.save(extra);
                }
            }
        }
        session.getTransaction().commit();


    }


    public static void insertTermsCondition() throws FileNotFoundException {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        JsonElement json = JsonParser.parseReader(new FileReader(COCHES_JSON));

        JsonObject objectCarAvailabilityResponse = json.getAsJsonObject().getAsJsonObject("CarAvailabilityResponse");
        JsonObject carAvailabilityResult = objectCarAvailabilityResponse.getAsJsonObject().getAsJsonObject("CarAvailabilityResult");
        JsonObject objectSupplierInfo = carAvailabilityResult.getAsJsonObject().getAsJsonObject("SupplierInfo");
        JsonArray arrayDetails = objectSupplierInfo.getAsJsonArray("Details");

        for (JsonElement jsonElement : arrayDetails) {

            if (!jsonElement.isJsonNull()){
                JsonObject jsonObject = jsonElement.getAsJsonObject();
                String jsonObjectSupplier = jsonObject.get("Supplier").getAsString();

                JsonObject jsonObjectTermsAndCondition = jsonElement.getAsJsonObject().getAsJsonObject("TermsAndConditions");
                if (jsonObjectTermsAndCondition != null){
                    JsonArray tandCs = jsonObjectTermsAndCondition.getAsJsonArray("TandCs");
                    for (JsonElement jsonElementTadCs : tandCs){
                        JsonObject jsonObjectTardCs = jsonElementTadCs.getAsJsonObject();

                        JsonElement headerElement = jsonObjectTardCs.get("Header");
                        String header = headerElement != null ? headerElement.getAsString() : null;

                        JsonElement paragraphElement = jsonObjectTardCs.get("Paragraph");
                        String paragraph = paragraphElement != null ? paragraphElement.getAsString() : null;

                        Date date = new Date();
                        Timestamp timestampActual = new Timestamp(date.getTime());

                        Supplier supplier = new Supplier();
                        supplier.setName(jsonObjectSupplier);


                        TermsCondition termsCondition = new TermsCondition();

                        termsCondition.setSupplier(supplier);
                        termsCondition.setHeader(header);
                        termsCondition.setParagraph(paragraph);
                        termsCondition.setUpdt(timestampActual);


                        session.save(termsCondition);

                    }


                }



            }

        }

        session.getTransaction().commit();



    }


}