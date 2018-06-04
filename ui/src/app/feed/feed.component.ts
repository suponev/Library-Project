import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {Publication} from "../common/models/publication.model";
import {MatDialog, MatSnackBar} from "@angular/material";
import {HttpEventType, HttpResponse} from "@angular/common/http";
import {BehaviorSubject} from "rxjs/BehaviorSubject";
import {FileUploadService} from "../services/file-upload.service";
import {FormBuilder, Validators} from "@angular/forms";

@Component({
  selector: 'app-feed',
  templateUrl: './feed.component.html',
  styleUrls: ['./feed.component.scss']
})


export class FeedComponent implements OnInit {

  public list: Publication[] = [{text: 'Exmpale text'}, {text: 'Exmpale text 2'}];


  @ViewChild('fileInput')
  public fileInput: ElementRef;
  public fileLoading$ = new BehaviorSubject<boolean>(false);
  public fileLoadProgress = 0;
  private file: File;

  public pubForm = this.fb.group(
    {
      image_id: null,
      user_id: null,
      user_name: null,
      text: null,
    });

  public filterForm = this.fb.group(
    {
      image_id: null,
      user_id: null,
      user_name: null,
      text: null,
    });

  constructor(public dialog: MatDialog,
              public snackBar: MatSnackBar,
              private fb: FormBuilder,
              public fileService: FileUploadService) {
  }

  ngOnInit() {
  }

  selectFile(selectFileEvent): void {
    console.log('fileSelect', selectFileEvent);
    this.fileLoading$.next(true);
    this.file = selectFileEvent.target.files[0];
    this.fileService.saveImage(this.file).subscribe(
      event => {
        if (event.type === HttpEventType.UploadProgress) {
          this.fileLoadProgress = Math.round(100 * event.loaded / event.total);
        } else if (event instanceof HttpResponse) {
          this.fileLoading$.next(false);
          if (event.body['status'] !== 'ERROR') {
            //this.showMessage('Файл загружен.');
          } else {
            this.file = null;
            this.fileInput.nativeElement.value = null;
            this.showMessage('Ошибка при загрузке.');
          }
        }
      },
      (error) => {
        this.fileLoading$.next(false);
      });
    this.fileLoadProgress = 0;
  }

  showMessage(message: string) {
    this.snackBar.open(message, 'Ок', {
      duration: 5000,
    });
  }

  publish() {

  }
}
