package org.example.Order;

public class OrderGenerator {
    public static Order randomOrder(String firstName, String lastName, String adress, int metroStation, String phone, 
                                    int rentTime, String deliveryDate, String comment, String[] color)
    {
        return new Order()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setAdress(adress)
                .setMetroStation(metroStation)
                .setPhone(phone)
                .setRentTime(rentTime)
                .setDeliveryDate(deliveryDate)
                .setComment(comment)
                .setColor(color);
    }
}
