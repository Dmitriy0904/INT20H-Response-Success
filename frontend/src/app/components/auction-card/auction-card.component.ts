import { Component, Input } from "@angular/core";
import { MatGridListModule } from "@angular/material/grid-list";
import { MatButtonModule } from "@angular/material/button";
import { Auction } from "../../model/auction";

@Component({
  selector: "app-auction-card",
  standalone: true,
  imports: [MatButtonModule, MatGridListModule],
  templateUrl: "./auction-card.component.html",
  styleUrl: "./auction-card.component.scss",
})
export class AuctionCardComponent {
  @Input({ required: true }) auction!: Auction;
}
