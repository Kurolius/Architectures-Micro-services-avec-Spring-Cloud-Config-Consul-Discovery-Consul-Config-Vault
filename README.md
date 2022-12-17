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

## Frontend :

### Products :

```typescript

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {
  products : any;
  constructor(private http:HttpClient) { }

  ngOnInit(): void {
    this.http.get("http://localhost:9999/inventory-service/products?projection=fullProduct").subscribe({
      next : (data)=>{
        this.products = data;
      },
      error : (err)=>{

      }
    })
  }

}

```
```html
<div class="container">
  <table class="table" *ngIf="products">
    <thead>
     <tr>
       <th>ID</th><th>Name</th><th>Price</th><th>Quantity</th>
     </tr>
    </thead>
    <tbody>
    <tr *ngFor="let p of products._embedded.products">
      <td>{{p.id}}</td>
      <td>{{p.name}}</td>
      <td>{{p.price}}</td>
      <td>{{p.quantity}}</td>
    </tr>
    </tbody>
  </table>
</div>

```

![image](https://user-images.githubusercontent.com/84138772/208257365-31d088ce-bca0-455c-b415-70abe4dc65c4.png)

### Customers

```typescript
@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
  styleUrls: ['./customers.component.css']
})
export class CustomersComponent implements OnInit {
  customers : any;
  constructor(private http: HttpClient, private router:Router) { }

  ngOnInit(): void {
    this.http.get("http://localhost:9999/customer-service/customers?projection=fullCustomer").subscribe({
      next : (data)=>{
        this.customers = data;
      },
      error : (err)=>{

      }
    })
  }

  getOrders(c: any) {
    this.router.navigateByUrl("/orders/"+c.id);
  }
}

```
```html
<div class="container">
  <table class="table" *ngIf="customers">
    <thead>
    <tr>
      <th>ID</th><th>Name</th><th>Email</th><th>Oders</th>
    </tr>
    </thead>
    <tbody>
    <tr *ngFor="let c of customers._embedded.customers">
      <td>{{c.id}}</td>
      <td>{{c.name}}</td>
      <td>{{c.email}}</td>
      <td>
        <button class="btn btn-success" (click)="getOrders(c)">Orders</button>
      </td>
    </tr>
    </tbody>
  </table>
</div>


```

![image](https://user-images.githubusercontent.com/84138772/208257382-58646818-d479-4025-a6f3-bc36d5766cda.png)

### Orders :

```typescript

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {
  orders : any;
  customerId!:number;
  constructor(private http: HttpClient,
              private router:Router,
              private route: ActivatedRoute) {
    this.customerId = route.snapshot.params['customerId'];
  }

  ngOnInit(): void {
    this.http.get("http://localhost:9999/order-service/orders/search/byCustomerId?projection=fullOrder&customerId="+this.customerId)
      .subscribe({
      next : (data)=>{
        this.orders = data;
      },
      error : (err)=>{

      }
    })
  }

  getOrderDetails(o: any) {
    this.router.navigateByUrl("/order-details/"+o.id)
  }
}


```
```html

<div class="container">
  <table class="table" *ngIf="orders">
    <thead>
    <tr>
      <th>ID</th><th>Date</th><th>Status</th><th>CustomerId</th><th>List</th>
    </tr>
    </thead>
    <tbody>
    <tr *ngFor="let o of orders._embedded.orders">
      <td>{{o.id}}</td>
      <td>{{o.createdAt|date:'dd/MM/yyyy'}}</td>
      <td>{{o.status}}</td>
      <td>{{o.customerId}}</td>
      <td>
        <button class="btn btn-success" (click)="getOrderDetails(o)">Order Details</button>
      </td>
    </tr>
    </tbody>
  </table>
</div>

```

![image](https://user-images.githubusercontent.com/84138772/208257421-ffb0374f-b494-4957-aaae-825cb3f961be.png)

### Order details :

```typescript

@Component({
  selector: 'app-order-details',
  templateUrl: './order-details.component.html',
  styleUrls: ['./order-details.component.css']
})
export class OrderDetailsComponent implements OnInit {
  orderDetails : any;
  orderId! : number;
  constructor(private http: HttpClient,
              private router:Router,
              private route: ActivatedRoute) {
    this.orderId = route.snapshot.params['orderId'];
  }

  ngOnInit(): void {
    this.http.get("http://localhost:9999/order-service/fullOrder/"+this.orderId)
      .subscribe({
      next : (data)=>{
        this.orderDetails = data;
      },
      error : (err)=>{

      }
    })
  }

  getOrderDetails(o: any) {
    this.router.navigateByUrl("/order-details/"+o.id)
  }
}


```
```html


<div class="container mt-2" *ngIf="orderDetails">
  <div class="row">
    <div class="col-md-6">
      <div class="card">
        <div class="card-header">Order Id : {{orderId}}</div>
        <div class="card-body text-sm-start">
          <ul class="list-group">
            <li class="list-group-item">Order Id : {{orderId}}</li>
            <li class="list-group-item">Date : {{orderDetails.createdAt | date : 'dd/MM/yyyy'}}</li>
            <li class="list-group-item">Status : {{orderDetails.status}}</li>
            <li class="list-group-item">Customer Id : {{orderDetails.customer.id}}</li>
            <li class="list-group-item">Customer Name : {{orderDetails.customer.name}}</li>
            <li class="list-group-item">Customer Email : {{orderDetails.customer.email}}</li>
          </ul>
        </div>
      </div>
    </div>
    <div class="col-md-6">
      <div class="card"></div>
      <div class="card-header">Products</div>
      <div class="card-body">
        <table class="table table-striped">
          <thead>
            <tr class="bg-dark text-white">
              <th scope>Id</th>
              <th scope>Name</th>
              <th scope>Price</th>
              <th scope>Quantity</th>
              <th>Discount</th>
              <th>Amount</th>
          </tr>
          </thead>
          <tbody>
            <tr *ngFor="let pi of orderDetails.productItems" >
              <td>{{pi.product.id}}</td>
              <td>{{pi.product.name}}</td>
              <td class="text-end">{{pi.price | number : '.2'}}</td>
              <td class="text-end">{{pi.quantity}}</td>
              <td class="text-end">{{pi.discount | number : '.2'}}</td>
              <td class="text-end">{{pi.total | number : '.2'}}</td>
            </tr>
          <tr class="bg-dark text-white">
            <td colspan="5" class="text-end text-white">Total</td>
            <td class="text-end text-white">{{orderDetails.total | number : '.2'}}</td>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</div>


```

![image](https://user-images.githubusercontent.com/84138772/208257468-045c8b58-1fff-4b9a-b406-bcec24042e14.png)

