import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';

@Component({
  selector: 'app-records',
  templateUrl: './records.component.html',
  styleUrls: ['./records.component.scss']
})
export class RecordsComponent implements OnInit {

  records : Object;

  constructor(private data:DataService) { }

  ngOnInit() {
    this.data.getRecords().subscribe(data=>{
      this.records = data
      console.log(this.records)
    })
  }

}
