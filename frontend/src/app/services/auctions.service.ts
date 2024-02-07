import { HttpClient } from "@angular/common/http";
import { Injectable, inject } from "@angular/core";
import { Observable, of } from "rxjs";
import { Auction } from "../model/auction";

@Injectable({ providedIn: "root" })
export class AuctionsService {
  private httpClient: HttpClient = inject(HttpClient);

  public getAll(): Observable<Auction[]> {
    return of([
      {
        title: "Lot 1",
        description:
          "Lorem ipsum dolor sit amet consectetur adipisicing elit. Obcaecati doloribus quod suscipit amet aliquid id officia repellat incidunt culpa consectetur odit deserunt voluptatem, iste veniam, facilis voluptate doloremque necessitatibus assumenda!",
        image: "https://material.angular.io/assets/img/examples/shiba2.jpg",
      },
      {
        title: "Lot 2",
        description:
          "Lorem ipsum dolor sit amet consectetur adipisicing elit. Obcaecati doloribus quod suscipit amet aliquid id officia repellat incidunt culpa consectetur odit deserunt voluptatem, iste veniam, facilis voluptate doloremque necessitatibus assumenda!",
        image: "https://material.angular.io/assets/img/examples/shiba2.jpg",
      },
      {
        title: "Lot 3",
        description:
          "Lorem ipsum dolor sit amet consectetur adipisicing elit. Obcaecati doloribus quod suscipit amet aliquid id officia repellat incidunt culpa consectetur odit deserunt voluptatem, iste veniam, facilis voluptate doloremque necessitatibus assumenda!",
        image: "https://material.angular.io/assets/img/examples/shiba2.jpg",
      },
    ]);
  }

  public getAllByUserId(): void {}

  public getById(): void {}

  public create(): void {}

  public update(): void {}

  public delete(): void {}
}
