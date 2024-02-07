import { CommonModule } from "@angular/common";
import { Component, inject } from "@angular/core";
import { AuctionCardComponent } from "../../components/auction-card/auction-card.component";
import { AuctionsService } from "../../services/auctions.service";
import { Auction } from "../../model/auction";
import { Observable } from "rxjs";

@Component({
  selector: "app-my-auctions-page",
  standalone: true,
  imports: [CommonModule, AuctionCardComponent],
  templateUrl: "./my-auctions-page.component.html",
  styleUrl: "./my-auctions-page.component.scss",
})
export class MyAuctionsPageComponent {
  private auctionsService: AuctionsService = inject(AuctionsService);

  public auctions$: Observable<Auction[]> = this.auctionsService.getAll();
}
