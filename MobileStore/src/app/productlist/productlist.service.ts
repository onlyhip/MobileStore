import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { Product } from './model';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';

@Injectable({
    providedIn: 'root',
})

export class ProductlistService {
    
    private productlistUrl = 'http://localhost:8080/api/v1/product/list';

    constructor(private http: HttpClient) {}
    getProducts(): Observable<Product[]> {
        return this.http.get<Product[]>(this.productlistUrl);
}
}

        
        