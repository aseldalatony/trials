import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {
  x: number = 0;
  y: number = 0;
  res: number = 0;
  disableEqual = true;
  bg = 'width: 50px;height: 50px;background-color:  #ff5733 ;'
  names=[];
  constructor() {

  }

  ngOnInit() {
  }
  enableEquale(event) {
    console.log(event);
    this.disableEqual = false;
  }
  add() {
    let z = Number(this.x) + Number(this.y);
    console.log(`z=${z}`);
    return z;
  }
  add1() {
    this.res = this.x + this.y;
  }
  push(event:Event){
    console.log(event);
    this.names.push((event.form[0]).value);
  }
}
