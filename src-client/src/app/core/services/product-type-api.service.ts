import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProductTypeApiService {

  constructor(private httpClient: HttpClient) { }

  public createProductType(productType: any) {
    return this.httpClient.post<any>(`http://localhost:4200/api/productType`, productType);
  }
}
