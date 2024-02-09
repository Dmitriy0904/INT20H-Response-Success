import {HttpClient, HttpHeaders} from "@angular/common/http";
import { Injectable, inject } from "@angular/core";
import { Observable, of } from "rxjs";
import { Auction } from "../model/auction";

@Injectable({ providedIn: "root" })
export class AuctionsService {
  private httpClient: HttpClient = inject(HttpClient);
  apiURL = 'http://localhost:8080/auctions';

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };

  public getAll(): Observable<Auction[]> {
    return this.httpClient.get<Auction[]>(this.apiURL);
  }

  public getAllByUserId(userId: any): Observable<Auction[]> {
    return this.httpClient.get<Auction[]>(this.apiURL + '/user/' + userId);
  }

  public getById(): void {}

  public create(auction: any): Observable<Auction> {
    return this.httpClient
    .post<Auction>(
        this.apiURL,
        JSON.stringify(auction),
        this.httpOptions
    );
  }

  public update(auction: any): Observable<Auction> {
    return this.httpClient
    .put<Auction>(
        this.apiURL,
        JSON.stringify(auction),
        this.httpOptions
    );
  }

  public delete(id: any) {
    return this.httpClient
    .delete<Auction>(this.apiURL + '/remove/' + id, this.httpOptions);
  }
}
