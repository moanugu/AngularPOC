import { Component, ViewChild } from '@angular/core';
import { DataTable, DataTableResource } from '../data-table';
import { cars } from './data-table-demo2-data';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'data-table-demo-2',
  templateUrl: './data-table-demo2.html'
})
export class DataTableDemo2 {

     constructor(private http:HttpClient) {
    }
    carResource = new DataTableResource(cars);
    cars = [];
    carCount = 0;

    @ViewChild(DataTable) carsTable: DataTable;

    constructor() {
        this.rowColors = this.rowColors.bind(this);

        this.carResource.count().then(count => this.carCount = count);
    }

    reloadCars(params) {
        this.carResource.query(params).then(cars => this.cars = cars);
    }

    // custom features:

    addClicked(car) {
        
        this.courses$ = this.http
        .get("http://localhost:8080/providers/1231/deleteProvider", {})
        .do(console.log)
        .map(data => {
        alert(JSON.stringify(data);    
        })
        
        this.carResource.query(car).then(cars => {
            alert(Object.keys(cars).length+1);
            cars.splice(2, 0, { index: Object.keys(cars).length+1,  npi_taxid:  car.npi_taxid,  effectiveDate: car.effectiveDate, terminationDate: car.terminationDate ,idType:car.idType});
            this.cars = cars
        });
    }
    editClicked(car) {
        car.isEdit=true;
    }
    saveClicked(car) {
        car.isEdit=false;
    }

    
    yearLimit = 1999;

    rowColors(car) {
        if (car.year >= this.yearLimit) return 'rgb(255, 255, 197)';
    }
}
