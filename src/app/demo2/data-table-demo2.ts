import { Component, ViewChild, Input, Output, EventEmitter } from '@angular/core';
import { DataTable, DataTableResource } from '../data-table';
//import { cars } from './data-table-demo2-data';
import {HttpClient} from "@angular/common/http";
import {AppComponent} from "./../app.component";

@Component({
  selector: 'data-table-demo-2',
  templateUrl: './data-table-demo2.html'
})
export class DataTableDemo2 {

    @Input() getSearchStatus: number;
    @Output() getSearchStatusChange new EventEmitter<number>();
    
    cars=Array<any>;
    carResource={};
    carCount=0;
    totalCarCount=0;
    constructor(private http:HttpClient) {
         console.log('constructor');
         this.http.get("http://localhost:8080/getAllProviders").subscribe(res => {
             this.cars=res;
             this.cars.splice(0,0,{index:0,'providerId':'', 'providerIdType':'', 'effectiveDate': new Date(), 'terminationDate': new Date()});
             console.log(res);
             this.carResource = new DataTableResource(this.cars);
             this.carCount=Object.keys(this.cars).length;
             this.getSearchStatusChange.emit(this.carCount);
         });
    }
    
    @ViewChild(DataTable) carsTable: DataTable;

    reloadCars(params) {
        console.log('reload');
       if(this.carResource && this.carResource.query)
        { 
            this.carResource.query(params).then(cars => this.cars = cars);
           }
//        if(this.carResource && this.carResource.query)
//        {
//             this.http.get("http://localhost:8080/getAllProviders").subscribe(res => {
//             this.cars=res;
//             this.cars.splice(0,0,{index:0,'providerId':'', 'providerIdType':'', 'effectiveDate': new Date(), 'terminationDate': new Date()});
//             console.log(res);
//             this.carCount=Object.keys(this.cars).length;
//             this.carResource = new DataTableResource(this.cars);
//         });
//            }
    }
    deleteItems() {
        let tobeDeleted=[];
        for(let i=0; i<this.carsTable.selectedRows.length; i++){
            tobeDeleted.push(this.carsTable.selectedRows[i].item.providerId);
        }
        for(i=0; i<this.cars.length; i++){
            if(tobeDeleted.indexOf(this.cars[i].providerId) !== -1) {
                console.log(this.cars[i].providerId);
                this.cars[i].deleted=true;
            }
        }
         this.http.post("http://localhost:8080/providers/deleteProviders",this.cars).subscribe(res => {
             this.cars=res;
             console.log(res);
             this.carCount=Object.keys(this.cars).length;
             this.getSearchStatusChange.emit(this.carCount);
             this.carResource = new DataTableResource(this.cars);
         });
       console.log(this.cars); 
    }
    getProviderCount() {
        return Object.keys(this.cars).length;
    }

    // custom features:

    addClicked(car) {
        console.log('Add button clicked...');
        this.carResource.query(car).then(cars => {
            console.log(Object.keys(this.cars).length+1);
            this.cars.splice(1, 0, { index: Object.keys(this.cars).length,  providerId:  car.providerId,  effectiveDate: car.effectiveDate, terminationDate: car.terminationDate ,providerIdType:car.providerIdType});
            this.carCount=Object.keys(this.cars).length;
            this.getSearchStatusChange.emit(this.carCount);
        });
    }
    deleteClicked(car) {
        car.isEdit=true;
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
