import { Component, OnInit } from '@angular/core';
import {NgForm} from '@angular/forms';
import {Records} from '../records.model';
import { DataService } from '../data.service';
import {Vehicle} from '../vehicle.model';

@Component({
  selector: 'app-entry',
  templateUrl: './entry.component.html',
  styleUrls: ['./entry.component.scss']
})
export class EntryComponent implements OnInit {

  today: number = Date.now();

  constructor(private dataService : DataService) { }

  ngOnInit() {
  }
  submitted = false;

  saveRecords() {
    let day = (<HTMLInputElement>document.getElementById('day')).value;
    let date = (<HTMLInputElement>document.getElementById('date')).value;
    let timeIn = (<HTMLInputElement>document.getElementById('timeIn')).value;

    let vType = (<HTMLInputElement>document.getElementById('vType')).value;
    let vNumber = (<HTMLInputElement>document.getElementById('vNumber')).value;

    let vehicle = new Vehicle(vNumber,vType);

    let records = new Records(1,day,date,timeIn,"",vehicle);

    this.dataService.createRecords(records);

    console.log(records);

  }

}
