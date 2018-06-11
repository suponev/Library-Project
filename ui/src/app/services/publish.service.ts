import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {PublicationFilter, PublicationRequest, PublicationResponse, Vote} from "../common/models/publication.model";

@Injectable()
export class PublishService {

  constructor(private http: HttpClient) {
  }

  public save(body: PublicationRequest): Observable<PublicationResponse> {
    return this.http.post<PublicationRequest>('/api/pub/', body).map(res => res['data']);
  }

  public getByFilter(filter: PublicationFilter): Observable<PublicationResponse[]> {
    return this.http.post<PublicationRequest>('/api/pub/filter', filter).map(res => res['data']);
  }

  public getImageById(id: number): Observable<any> {
    return this.http.get<PublicationRequest>('/api/pub/image/' + id).map(res => res['data']);
  }

  public vote(vote: Vote): Observable<any> {
    return this.http.post<PublicationRequest>('/api/pub/vote', vote).map(res => res['data']);
  }

}
