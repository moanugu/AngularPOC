import { Component } from '@angular/core';
import { cars } from './demo2/data-table-demo2-data';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
        
    private _totalRecords = 0;

    get totalRecords() {
        return this._totalRecords;
    }

    set totalRecords(totalRecords) {
        alert();
        this._totalRecords= cars.length;
    }
    
      ngOnInit() {
          this._totalRecords= Object.keys(cars).length;
  }
}
