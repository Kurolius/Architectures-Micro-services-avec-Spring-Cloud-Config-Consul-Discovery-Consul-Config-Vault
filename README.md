# Architectures-Micro-services-avec-Spring-Cloud-Config-Consul-Discovery-Consul-Config-Vault
## Présentation de l'activité pratique :
 <strong style="color:dark">Créer une application de e-commerce basée sur les micro services :
 
        1. Consul Discovery
        
        2. Spring Cloud Config
        
        3. Spring Cloud Gateway
        
        4. Customer-service
        
        5. Inventory Service
        
        6. Order Service
        
        7. Consul Config (Billing Service)
        
        8. Vault (Billing Service)
        
        9. Frontend Web avec Angular

</span>

## Architecture de l'activité pratique

![image](https://user-images.githubusercontent.com/84138772/208253215-141c606b-3d40-4ed7-8f9f-9b9dd8b31275.png)


## Entités :

### Customer :

```java

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
}

```

### Product :

```java

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private int quantity;
}

```

### Order :

```java

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date createdAt;
    private OrderStatus status;
    private Long customerId;

    @Transient
    private Customer customer;

    @OneToMany(mappedBy = "order")
    private List<ProductItem> productItems;


    public double getTotal(){
        return productItems.stream()
                .mapToDouble(ProductItem::getTotal).sum();
    }

}

```

## Services : 


### customer-service :

![image](https://user-images.githubusercontent.com/84138772/208253278-f0422433-bce1-4e07-a464-8117aa802a83.png)

![image](https://user-images.githubusercontent.com/84138772/208253341-be398513-ef3f-41b2-a654-a2afc9bc4771.png)

![image](https://user-images.githubusercontent.com/84138772/208253357-c3fde3c6-9cf2-45b7-89ec-cf59b405e085.png)

![image](https://user-images.githubusercontent.com/84138772/208253382-4c368cb1-fe5e-442b-86da-b6721198087f.png)


### inventory-service :

![image](https://user-images.githubusercontent.com/84138772/208253455-d929dd2a-c210-459a-b258-e724243c5378.png)

![image](https://user-images.githubusercontent.com/84138772/208253476-91e44c98-9c70-440c-b2d1-37aeb9420014.png)

![image](https://user-images.githubusercontent.com/84138772/208253490-61fd0d7c-8fc6-4084-a8e6-d0ad3e719d65.png)

![image](https://user-images.githubusercontent.com/84138772/208253500-0199c848-f80f-4a6b-88e8-2a9d9a7e814f.png)

### order-service :

![image](https://user-images.githubusercontent.com/84138772/208254022-0cd35867-e50a-4dd1-b6c2-d0d24f923dfb.png)

![image](https://user-images.githubusercontent.com/84138772/208254042-b48ebe5d-0681-4438-a6c2-e8780ba28e05.png)

![image](https://user-images.githubusercontent.com/84138772/208254051-13cf8145-e2ef-4ec4-a9fe-a3127b211a26.png)

![image](https://user-images.githubusercontent.com/84138772/208254071-4d76049f-2b1b-4aec-9521-9370e61c60e6.png)



### gateway-service :

![image](https://user-images.githubusercontent.com/84138772/208253564-06b83626-34ee-407f-bf98-c85abf6c3fbb.png)

![image](https://user-images.githubusercontent.com/84138772/208253574-b34a3fec-6f10-463c-a894-7874d13da9ba.png)

![image](https://user-images.githubusercontent.com/84138772/208253581-a8ca3f58-7f26-4ac2-93f1-3e0c0d2b8db6.png)

![image](https://user-images.githubusercontent.com/84138772/208253592-f9aefeec-95d0-47c0-8d3e-bccb4933be11.png)

### config-service :

![image](https://user-images.githubusercontent.com/84138772/208253626-52248ea5-8522-4617-8836-27209b7e9758.png)

![image](https://user-images.githubusercontent.com/84138772/208253639-799f5b41-d1f6-4908-9444-a407c008466c.png)

![image](https://user-images.githubusercontent.com/84138772/208253653-802caad1-1008-4e06-adf8-23fbe58661c5.png)

![image](https://user-images.githubusercontent.com/84138772/208253670-e63cd8de-b925-4c09-8b0f-bdc4f3fe5dc5.png)

## Application :

![image](https://user-images.githubusercontent.com/84138772/208253691-d486114b-1a2f-41c1-a02f-999d4c170dc0.png)

![image](https://user-images.githubusercontent.com/84138772/208253720-d29b72f8-5553-4c2c-99d2-08f81af05fb3.png)


## Le service de discovery "Consul" :

![image](https://user-images.githubusercontent.com/84138772/208254084-9cb90617-bd4e-4f97-a12b-7798be7ef202.png)


## La configuration avec VAULT :

![image](https://user-images.githubusercontent.com/84138772/208255780-77af40f7-4872-4aa2-96aa-5a95fd9ac48a.png)


![image](https://user-images.githubusercontent.com/84138772/208255758-cc8cb8c0-4508-4026-ac68-2f9a6dc39cdd.png)

![image](https://user-images.githubusercontent.com/84138772/208255806-49f80eda-a56a-402f-bdf1-a0617c70530a.png)

![image](https://user-images.githubusercontent.com/84138772/208255815-441d658b-0a8c-4614-b6b8-472b4264c3b6.png)

![image](https://user-images.githubusercontent.com/84138772/208255825-dc83af2c-c7ae-46c0-89d5-2db1c33b62e7.png)

### Note : Aprés la configuration par consul config et vault config :

![image](https://user-images.githubusercontent.com/84138772/208256207-0be471a2-829e-4d58-ba2c-a808259eeccd.png)



