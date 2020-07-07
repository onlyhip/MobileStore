import { Component, OnInit } from '@angular/core';
import { ProductlistService } from './productlist.service';

@Component({
  selector: 'app-productlist',
  templateUrl: './productlist.component.html',
  styleUrls: ['./productlist.component.scss']
})
export class ProductlistComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}
