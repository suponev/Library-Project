import {Injectable} from '@angular/core';
import {HttpClient, HttpEvent, HttpRequest} from "@angular/common/http";
import {Observable} from "rxjs/Observable";


@Injectable()
export class FileUploadService {

  constructor(private http: HttpClient) {
  }

  saveImage(file: File): Observable<HttpEvent<{}>> {
    const formdata: FormData = new FormData();
    formdata.append('file', file);
    const req = new HttpRequest('POST', '/api/publish_image', formdata, {
      reportProgress: true,
      responseType: 'json'
    });
    return this.http.request(req);
  }

  public getImageBase64(id: number): Observable<String> {
    return this.http.get('/api/publish_image/' + id)
      .map((res: any) => res['data']);
  }
}
