import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
        
    private _totalRecords = 0;

    constructor(){
//              alert(DataTableDemo2.getProviderCount());
    }
//    get totalRecords() {
//        return this._totalRecords;
//    }
//
//    set totalRecords(totalRecords) {
//        this._totalRecords= totalRecords;
//    }
    
      ngOnInit() {
//          alert(DataTableDemo2.getProviderCount());
//          this._totalRecords= this._totalRecords= DataTableDemo2.getProviderCount();
  }
}
