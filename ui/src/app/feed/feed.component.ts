import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {Publication, PublicationFilter, PublicationResponse} from "../common/models/publication.model";
import {MatDialog, MatSnackBar} from "@angular/material";
import {FormBuilder, Validators} from "@angular/forms";
import {PublishService} from "../services/publish.service";

@Component({
  selector: 'app-feed',
  templateUrl: './feed.component.html',
  styleUrls: ['./feed.component.scss']
})


export class FeedComponent implements OnInit {


  throttle = 300;
  scrollDistance = 2;
  scrollUpDistance = 0.5;
  direction = '';

  public list: PublicationResponse[] = [];

  public currFilter: PublicationFilter = {
    count: 3,
    start_time: undefined,
    last_id: undefined
  };

  constructor(public dialog: MatDialog,
              public snackBar: MatSnackBar,
              private fb: FormBuilder,
              public pubService: PublishService) {
  }

  ngOnInit() {
    this.loadPublication();
  }

  public loadPublication() {
    this.pubService.getByFilter(this.currFilter).subscribe((res: PublicationResponse[]) => {
      this.list = this.list.concat(res);
      const lastElem = res[this.currFilter.count - 1];
      this.currFilter.last_id = lastElem ? lastElem.publication_id : 0;
      if (res.length === 0) {
        this.showMessage("Записей больше нет")
      }
    })
  }


  onScrollDown() {
    console.log('scrolled down!!');
    this.loadPublication();
  }

  afterSend(pub: PublicationResponse) {
    console.log('sadsd',pub);
    this.list.unshift(pub);
  }

  showMessage(message: string) {
    this.snackBar.open(message, 'Ок', {
      duration: 5000,
    });
  }
}

