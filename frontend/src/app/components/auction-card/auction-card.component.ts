import {Component, inject, Input, OnDestroy} from "@angular/core";
import { MatGridListModule } from "@angular/material/grid-list";
import { MatButtonModule } from "@angular/material/button";
import { Auction } from "../../model/auction";
import {MatIcon} from "@angular/material/icon";
import {MatDialog} from "@angular/material/dialog";
import {Subject, takeUntil} from "rxjs";
import {ModalUpdateAuctionComponent} from "../modal-update-auction/modal-update-auction.component";
import {MatSnackBar} from "@angular/material/snack-bar";
import {ModalDeleteAuctionComponent} from "../modal-delete-auction/modal-delete-auction.component";

@Component({
  selector: "app-auction-card",
  standalone: true,
  imports: [MatButtonModule, MatGridListModule, MatIcon],
  templateUrl: "./auction-card.component.html",
  styleUrl: "./auction-card.component.scss",
})
export class AuctionCardComponent implements OnDestroy {
  @Input({ required: true }) auction!: Auction;

  private dialog: MatDialog = inject(MatDialog);
  private snackBar: MatSnackBar = inject(MatSnackBar);
  private destroy$: Subject<void> = new Subject<void>();

  ngOnDestroy(): void {
    this.destroy$.next();
    this.destroy$.complete();
  }

  public openViewDialog(id: number): void {
    this.snackBar.open('Auction was started!', 'Ok');
  }

  public openEditDialog(auction: Auction): void {
    const dialogRef = this.dialog.open(ModalUpdateAuctionComponent, {
      data: { auction: auction }
    });

    dialogRef
    .afterClosed()
    .pipe(takeUntil(this.destroy$))
    .subscribe((result) => {
      console.log(`Dialog result: ${result}`);
    });
  }

  public openDeleteDialog(id: number): void {
    const dialogRef = this.dialog.open(ModalDeleteAuctionComponent, {
      data: { auctionId: id }
    });

    dialogRef
    .afterClosed()
    .pipe(takeUntil(this.destroy$))
    .subscribe((result) => {
      console.log(`Dialog result: ${result}`);
    });
  }
}
