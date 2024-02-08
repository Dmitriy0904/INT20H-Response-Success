import { Component, inject } from "@angular/core";
import { AuctionCardComponent } from "../../components/auction-card/auction-card.component";
import { Auction } from "../../model/auction";
import { AuctionsService } from "../../services/auctions.service";
import { Observable } from "rxjs";
import { CommonModule } from "@angular/common";

@Component({
  selector: "app-auctions-page",
  standalone: true,
  imports: [CommonModule, AuctionCardComponent],
  templateUrl: "./auctions-page.component.html",
  styleUrl: "./auctions-page.component.scss",
})
export class AuctionsPageComponent {
  private auctionsService: AuctionsService = inject(AuctionsService);

  public auctions$: Observable<Auction[]> = this.auctionsService.getAll();
}
