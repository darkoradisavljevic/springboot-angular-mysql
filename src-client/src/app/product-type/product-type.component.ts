import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ProductTypeApiService } from '../core/services/product-type-api.service';

@Component({
  selector: 'app-product-type',
  templateUrl: './product-type.component.html',
  styleUrls: ['./product-type.component.css']
})
export class ProductTypeComponent implements OnInit {
  productTypeForm: FormGroup;

  constructor(private productTypeApi: ProductTypeApiService, private fb: FormBuilder) { }

  ngOnInit(): void {
    this.productTypeForm = this.fb.group({
      productTypeName: ['']
    });
  }
  createProductType() {
    let productType = {
      productTypeName: this.productTypeForm.controls['productTypeName'].value,
    };

    this.productTypeApi.createProductType(productType).subscribe((res) => {
      this.productTypeForm.reset();
      console.log(res);

    }, 
    (err) => {
     console.log(err);
    }
    );
  }
}
