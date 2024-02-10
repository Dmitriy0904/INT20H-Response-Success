import { Component, inject, Input } from "@angular/core";
import { MatGridListModule } from "@angular/material/grid-list";
import { MatButtonModule } from "@angular/material/button";
import { Auction } from "../../model/auction";
import { MatIcon } from "@angular/material/icon";
import { MatDialog } from "@angular/material/dialog";
import { ModalUpdateAuctionComponent } from "../modal-update-auction/modal-update-auction.component";
import { MatSnackBar } from "@angular/material/snack-bar";
import { ModalDeleteAuctionComponent } from "../modal-delete-auction/modal-delete-auction.component";

@Component({
  selector: "app-auction-card",
  standalone: true,
  imports: [MatButtonModule, MatGridListModule, MatIcon],
  templateUrl: "./auction-card.component.html",
  styleUrl: "./auction-card.component.scss",
})
export class AuctionCardComponent {
  @Input({ required: true }) auction!: Auction;

  private dialog: MatDialog = inject(MatDialog);
  private snackBar: MatSnackBar = inject(MatSnackBar);

  public openViewDialog(): void {
    this.snackBar.open("Auction was started!", "Ok");
  }

  public openEditDialog(auction: Auction): void {
    this.dialog.open(ModalUpdateAuctionComponent, {
      data: { auction: auction },
    });
  }

  public openDeleteDialog(id: number): void {
    this.dialog.open(ModalDeleteAuctionComponent, {
      data: { auctionId: id },
    });
  }
}
