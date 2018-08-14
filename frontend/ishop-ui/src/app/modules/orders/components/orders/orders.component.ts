import { Component, OnInit } from '@angular/core';
import { OrderService } from '../../service/order.service';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {

  orders: Object;

   constructor(private service: OrderService) { }

  ngOnInit() {
    this.service.getOrders().subscribe(
      (data) => {
        this.orders = data
      }, (error) => {
        console.log(error);
      }
    )
  }

}
