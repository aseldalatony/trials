import { Component, OnInit } from '@angular/core';
import { MyServiceService } from '../my-service.service'

@Component({
  selector: 'app-my-component',
  templateUrl: './my-component.component.html',
  styleUrls: ['./my-component.component.css']
})
export class MyComponentComponent implements OnInit {
  private _msg = 'hello, ng';
  colors: string[];
  constructor(myService: MyServiceService) {
    this.colors = myService.getColors();
  }

  ngOnInit() {
  }

  set msg(m: string) {
    this._msg = m;
  }

  get msg(): string {
    return this._msg;
  }

}
