import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {PublicationFilter, PublicationRequest, PublicationResponse} from "../common/models/publication.model";

@Injectable()
export class PublishService {

  constructor(private http: HttpClient) {
  }

  public save(body: PublicationRequest): Observable<any> {
    return this.http.put<PublicationRequest>('/api/pub/', body).map(res => res['data']);
  }

  public getByFilter(filter: PublicationFilter): Observable<PublicationResponse[]> {
    return this.http.put<PublicationRequest>('/api/pub/filter', filter).map(res => res['data']);
  }


}
