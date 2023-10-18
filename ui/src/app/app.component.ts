import { Component } from '@angular/core';
import { Fraud, fraudData } from './app.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  frauds: Array<Fraud>=fraudData;
  message: string="";
  isModalOpen = false;

  flagFraud(id: number) {
    console.log('flagFraud');
    this.message="The message with title '" + this.frauds.find(f=>f.id===id)?.title + " has been flagged";
    this.setModalState(true);
  }

  deleteFraud(id: number) {
    console.log('deleteFraud');
    this.message="The message with title '" + this.frauds.find(f=>f.id===id)?.title + " has been deleted";
    this.setModalState(true);
  }

  editFraud(id: number) {
    this.message="The message with title '" + this.frauds.find + " has been updated";
    this.setModalState(true);
  }

  setModalState(state: boolean){
    this.isModalOpen=state;
  }
}
